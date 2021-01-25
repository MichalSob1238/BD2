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

public class oknoPodaniaKonta extends JPanel implements ActionListener {
	
	private View view;
	
	private JLabel name;
	private JButton cofnij;
	private GridBagLayout layout;
	private GridBagConstraints pom;
	
	private JLabel tytul;
	private JTextField konto;
	private JButton zatwierdz;
	
	public oknoPodaniaKonta(View view) {
		this.view = view;
		
		layout = new GridBagLayout();
		pom = new GridBagConstraints();
		setLayout(layout);
		
		name = new JLabel();
		cofnij = new JButton("cofnij");
		tytul = new JLabel("Podaj numer konta:");
		konto = new JTextField();
		zatwierdz = new JButton("zatwierdz");
		
		cofnij.addActionListener(this);
		zatwierdz.addActionListener(this);
		konto.setPreferredSize(new Dimension(70, 20));
		
		pom.insets = new Insets(0, 0, 20, 50);
		pom.gridx = 0;
		pom.gridy = 0;
		add(cofnij, pom);
		
		pom.insets = new Insets(0, 30, 20, 0);
		pom.gridx = 2;
		add(name, pom);
		
		pom.insets = new Insets(0, 0, 0, 0);
		pom.gridy = 1;
		pom.gridx = 1;
		add(tytul, pom);
		
		pom.gridy = 2;
		add(konto, pom);
		
		pom.gridy = 3;
		add(zatwierdz, pom);
	}
	
	public void show(String nameUser) {
		name.setText(nameUser);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton button =(JButton) e.getSource();
		if(button == cofnij) {
			view.kwotaDoZwrotu();
		}else if(button == zatwierdz) {
			String kontoNumer = konto.getText();
			view.wybranoPrzelewZwrot(kontoNumer);
		}
		
	}

}
