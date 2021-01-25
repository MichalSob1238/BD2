package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class oknoListaRezerwacji extends JPanel implements ActionListener {

	private View view;
	private int index;
	private Integer tab[];
	
	private JLabel name;
	private JButton cofnij;
	
	private JLabel tytul;
	private JLabel produkt1, produkt2, produkt3;
	private JButton wybierz1, wybierz2, wybierz3;
	
	private JButton next, prev;
	private JLabel strona;
	
	private GridBagLayout layout;
	private GridBagConstraints pom;
	
	public oknoListaRezerwacji(View view) {
		this.view = view;
		index = 1;
		
		layout = new GridBagLayout();
		pom = new GridBagConstraints();
		setLayout(layout);
		
		name = new JLabel();
		cofnij = new JButton("cofnij");
		
		tytul = new JLabel("Zamowienia:");
		produkt1 = new JLabel();
		produkt2 = new JLabel();
		produkt3 = new JLabel();
		wybierz1 = new JButton("szczegoly");
		wybierz2 = new JButton("szczegoly");
		wybierz3 = new JButton("szczegoly");
		
		next = new JButton("next");
		prev = new JButton("prev");
		strona = new JLabel();
		
		cofnij.addActionListener(this);
		wybierz1.addActionListener(this);
		wybierz2.addActionListener(this);
		wybierz3.addActionListener(this);
		next.addActionListener(this);
		prev.addActionListener(this);
		
		pom.insets = new Insets(0, 0, 20, 50);
		pom.gridx = 0;
		pom.gridy = 0;
		add(cofnij, pom);
		
		pom.insets = new Insets(0, 30, 20, 0);
		pom.gridx = 2;
		add(name, pom);
		
		pom.insets = new Insets(0, 0, 10, 0);
		pom.gridy = 1;
		pom.gridx = 0;
		pom.gridwidth = 3;
		add(tytul, pom);
		
		pom.insets = new Insets(0, 0, 0, 0);
		pom.gridy = 2;
		pom.gridwidth = 2;
		add(produkt1, pom);
		
		pom.gridy = 3;
		add(produkt2, pom);

		pom.gridy = 4;
		add(produkt3, pom);
		
		pom.gridy = 2;
		pom.gridx = 2;
		pom.gridwidth = 1;
		add(wybierz1, pom);
		
		pom.gridy = 3;
		add(wybierz2, pom);

		pom.gridy = 4;
		add(wybierz3, pom);
		
		pom.insets = new Insets(20, 0, 0, 0);
		pom.gridy = 5;
		
		pom.gridx = 0;
		add(prev, pom);
		
		pom.gridx = 1;
		add(strona, pom);
		
		pom.gridx = 2;
		add(next, pom);
		
		
		
	}

	public void show(String nameUser, Integer tabArg[]) {
		name.setText(nameUser);
		index = 1;
		
		tab = tabArg;
		int iloscStron = tabArg.length / 3;
		if(tabArg.length % 3 != 0) {
			iloscStron += 1;
		}
		if(tabArg.length == 1) {
			produkt1.setText(Integer.toString(tabArg[0]));
			wybierz2.setVisible(false);
			wybierz3.setVisible(false);
		}else if(tabArg.length == 2) {
			produkt1.setText(Integer.toString(tabArg[0]));
			produkt2.setText(Integer.toString(tabArg[1]));
			wybierz3.setVisible(false);
		}else if(tabArg.length >= 3) {
			produkt1.setText(Integer.toString(tabArg[0]));
			produkt2.setText(Integer.toString(tabArg[1]));
			produkt3.setText(Integer.toString(tabArg[2]));
		}
		strona.setText(index + "/" + iloscStron);
		prev.setVisible(false);
		if(iloscStron == 1) {
			next.setVisible(false);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		JButton button = (JButton) arg0.getSource();
		if(button == next) {
			index += 1;
			
			prev.setVisible(true);
			int iloscStron = tab.length / 3;
			if(tab.length % 3 != 0) {
				iloscStron += 1;
			}
			//strona.setText(index + "/" + iloscStron);
			if(iloscStron == index) {
				next.setVisible(false);
			}
			strona.setText(index + "/" + iloscStron);
			int len = tab.length - (index-1)*3;
			if(len == 1) {
				produkt1.setText(Integer.toString(tab[(index-1)*3]));
				produkt2.setText("");
				produkt3.setText("");
				wybierz2.setVisible(false);
				wybierz3.setVisible(false);
			}else if(len == 2) {
				produkt1.setText(Integer.toString(tab[(index-1)*3]));
				produkt2.setText(Integer.toString(tab[(index-1)*3+1]));
				produkt3.setText("");
				wybierz3.setVisible(false);
			}else if(len >= 3) {
				produkt1.setText(Integer.toString(tab[(index-1)*3]));
				produkt2.setText(Integer.toString(tab[(index-1)*3+1]));
				produkt3.setText(Integer.toString(tab[(index-1)*3+2]));
			}
			
		} else if(button == prev) {
			index -= 1;
			next.setVisible(true);
			if(index == 1) {
				prev.setVisible(false);
			}
			int iloscStron = tab.length / 3;
			if(tab.length % 3 != 0) {
				iloscStron += 1;
			}
			strona.setText(index + "/" + iloscStron);
			produkt1.setText(Integer.toString(tab[(index-1)*3]));
			produkt2.setText(Integer.toString(tab[(index-1)*3+1]));
			produkt3.setText(Integer.toString(tab[(index-1)*3+2]));
			wybierz1.setVisible(true);
			wybierz2.setVisible(true);
			wybierz3.setVisible(true);
		} else if(button == cofnij) {
			view.oknoStartowe();
		} else if(button == wybierz1) {
			view.pobierzSzczegolyZamowienie(tab[(index-1)*3]);
		} else if(button == wybierz2) {
			view.pobierzSzczegolyZamowienie(tab[(index-1)*3 + 1]);
		} else if(button == wybierz3) {
			view.pobierzSzczegolyZamowienie(tab[(index-1)*3 + 1]);
		}
	}
}
