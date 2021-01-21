package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class oknoStartowe extends JPanel implements ActionListener {
	private View view;
	
	private JLabel name;
	private JButton cofnij;
	private JPanel przyciski;
	private JButton zakup;
	private JButton rezerwacje;
	private JButton oferta;
	private JButton zwrot;
	private JButton faktury;
	private JButton hurtownie;
	private JButton raporty;
	private JButton dostawy;
	private JButton remanent;
	
	private GridBagLayout layout;
	private GridBagConstraints pom;
	
	public oknoStartowe(View view) {
		this.view = view;
		layout = new GridBagLayout();
		pom = new GridBagConstraints();
		setLayout(layout);
		
		name = new JLabel();
		przyciski = new JPanel();
		przyciski.setLayout(new GridLayout( 6, 2, 5, 5));
		
		cofnij = new JButton("wyloguj");
		przyciski.add(zakup = new JButton("zakup"));
		przyciski.add(rezerwacje = new JButton("rezerwacje"));
		przyciski.add(oferta = new JButton("oferta"));
		przyciski.add(zwrot = new JButton("zwrot"));
		przyciski.add(faktury = new JButton("faktury"));
		
		hurtownie = new JButton("hurtownie");
		raporty = new JButton("raporty");
		dostawy = new JButton("dostawy");
		remanent = new JButton("remanent");
		
		cofnij.addActionListener(this);
		zakup.addActionListener(this);
		rezerwacje.addActionListener(this);
		oferta.addActionListener(this);
		zwrot.addActionListener(this);
		faktury.addActionListener(this);
		hurtownie.addActionListener(this);
		raporty.addActionListener(this);
		dostawy.addActionListener(this);
		remanent.addActionListener(this);
		
		pom.insets = new Insets(0, 0, 20, 50);
		pom.gridx = 0;
		pom.gridy = 0;
		add(cofnij, pom);
		
		pom.insets = new Insets(0, 30, 20, 0);
		pom.gridx = 1;
		add(name, pom);
		
		pom.insets = new Insets(0, 0, 0, 0);
		pom.gridx = 0;
		pom.gridy = 1;
		pom.gridwidth = 2;
		add(przyciski, pom);
			
	}
	
	public void show(boolean manager, String nameUser) {
		name.setText(nameUser);
		if(manager) {
			przyciski.add(hurtownie);
			przyciski.add(dostawy);
			przyciski.add(raporty);
			przyciski.add(remanent);
		} else {
			przyciski.remove(hurtownie);
			przyciski.remove(dostawy);
			przyciski.remove(raporty);
			przyciski.remove(remanent);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		JButton button =(JButton) arg0.getSource();
		if (button == oferta)
		{
			view.wybranoOferte();
		} else if(button == rezerwacje) {
			view.wybranoRezerwacje();
		}
		
	}

}
