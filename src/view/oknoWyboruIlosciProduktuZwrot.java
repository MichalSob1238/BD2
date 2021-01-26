package view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class oknoWyboruIlosciProduktuZwrot extends JPanel implements ActionListener {
	
	private View view;
	
	private String paragon;
	private int iloscMaksymalna;
	
	private JLabel tytul1;
	private JLabel tytul2;
	private JLabel name;
	private JLabel tekst;
	private JLabel maksymalnaIlosc;
	private JTextField ilosc;
	private JButton wybierz;
	private JButton cofnij;
	private GridBagLayout layout;
	private GridBagConstraints pom;
	
	public oknoWyboruIlosciProduktuZwrot(View view) {
		this.view = view;
		
		layout = new GridBagLayout();
		pom = new GridBagConstraints();
		setLayout(layout);
		
		name = new JLabel();
		cofnij = new JButton("cofnij");
		
		tytul1 = new JLabel();
		tytul2 = new JLabel();
		tekst = new JLabel("Podaj iloœæ: ");
		maksymalnaIlosc = new JLabel();
		ilosc = new JTextField();
		ilosc.setPreferredSize(new Dimension(70, 20));
		wybierz = new JButton("Zwróæ");
		
		cofnij.addActionListener(this);
		wybierz.addActionListener(this);
		
		pom.insets = new Insets(0, 0, 20, 50);
		pom.gridx = 0;
		pom.gridy = 0;
		add(cofnij, pom);
		
		pom.insets = new Insets(0, 30, 20, 0);
		pom.gridx = 2;
		add(name, pom);
		
		pom.insets = new Insets(0, 0, 0, 0);
		pom.gridy = 1;
		pom.gridx = 0;
		pom.gridwidth = 3;
		add(tytul1, pom);
		
		pom.gridy = 2;
		add(tytul2, pom);
		
		pom.gridy = 3;
		pom.gridwidth = 1;
		add(tekst, pom);
		
		pom.gridx = 1;
		add(ilosc, pom);
		
		pom.gridx = 2;
		add(maksymalnaIlosc, pom);
		
		pom.gridy = 4;
		pom.gridx = 1;
		add(wybierz, pom);
		
	}
	
	public void show(String name, String ilosc, String paragon, String produkt) {
		iloscMaksymalna = Integer.parseInt(ilosc);
		this.paragon = paragon;
		tytul1.setText("Paragon: "+paragon);
		tytul2.setText("Produkt: "+produkt);
		this.name.setText(name);
		this.ilosc.setText("/ "+ilosc);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton button = (JButton) e.getSource();
		if(button == cofnij) {
			view.podanoPargonZwrot(paragon);
		}else if(button == wybierz) {
			String podanaIlosc = ilosc.getText();
			int podanaIloscInt = Integer.parseInt(podanaIlosc);
			if(podanaIloscInt <= iloscMaksymalna) {
				view.podanoIloscProduktuZwrot(podanaIloscInt);
			} else {
				ilosc.setText("");
			}
		}
		
	}

}
