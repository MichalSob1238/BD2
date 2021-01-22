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

public class oknoWyborZwrotuKwota extends JPanel implements ActionListener {
	
	private View view;
		
	private JLabel jakaKwota;
	private JLabel name;
	private JButton wybierzGotowka;
	private JButton wybierzPrzelew;
	private JButton cofnij;
	private GridBagLayout layout;
	private GridBagConstraints pom;
	
	public oknoWyborZwrotuKwota(View view) {
		this.view = view;
		
		layout = new GridBagLayout();
		pom = new GridBagConstraints();
		setLayout(layout);
		
		cofnij = new JButton("cofnij");
		jakaKwota = new JLabel();
		name = new JLabel();
		
		wybierzGotowka = new JButton("gotówka");
		wybierzPrzelew = new JButton("przelew");
		
		cofnij.addActionListener(this);
		wybierzGotowka.addActionListener(this);
		wybierzPrzelew.addActionListener(this);
		
		pom.insets = new Insets(0, 0, 20, 50);
		pom.gridx = 0;
		pom.gridy = 0;
		add(cofnij, pom);
		
		pom.insets = new Insets(0, 30, 20, 0);
		pom.gridx = 1;
		add(name, pom);
		
		pom.insets = new Insets(0, 0, 0, 0);
		pom.gridy = 1;
		pom.gridx = 0;
		pom.gridwidth = 2;
		add(jakaKwota, pom);
		
		pom.gridwidth = 1;
		pom.gridy = 2;
		add(wybierzGotowka, pom);
		
		pom.gridx = 1;
		add(wybierzPrzelew, pom);
		
	}
	
	public void show(String name, String kwota) {
		this.name.setText(name);
		this.jakaKwota.setText("Kwota do zwrotu:  "+kwota);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton button = (JButton) e.getSource();
		if(button == cofnij) {
			view.ileProduktuZwrot();
		}else if(button == wybierzGotowka) {
			view.wybranoGotowkeZwrot();
		} else if(button == wybierzPrzelew) {
			view.oknoPodaniaNrKonta();
		}
		
	}

}