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

public class zamowienieDetaliczne extends JPanel implements ActionListener {
	
	private View view;
	private GridBagLayout layout;
	private GridBagConstraints pom;
	
	private String nazwaProduktu;
	private String kwota;
	
	private JLabel name;
	private JButton cofnij;
	
	private JLabel tytul;
	private JLabel tekst;
	private JLabel tekst2;
	private JTextField ilosc;
	private JButton zamow;
	
	public zamowienieDetaliczne(View view){
		this.view = view;
		layout = new GridBagLayout();
		pom = new GridBagConstraints();
		setLayout(layout);
		
		name = new JLabel();
		cofnij = new JButton("cofnij");
		cofnij.addActionListener(this);
		tytul = new JLabel();
		tekst = new JLabel();
		tekst2 = new JLabel("Podaj iloœæ: ");
		ilosc = new JTextField();
		ilosc.setPreferredSize(new Dimension(70, 20));
		zamow = new JButton("zamów");
		zamow.addActionListener(this);
		
		
		pom.insets = new Insets(0, 0, 20, 50);
		pom.gridx = 0;
		pom.gridy = 0;
		add(cofnij, pom);
		
		pom.insets = new Insets(0, 30, 20, 0);
		pom.gridx = 3;
		add(name, pom);
		
		pom.insets = new Insets(0, 0, 0, 0);
		pom.gridx = 1;
		pom.gridy = 1;
		pom.gridwidth = 2;
		add(tytul, pom);
		
		pom.gridy = 2;
		add(tekst, pom);
		
		pom.gridy = 3;
		pom.gridwidth = 1;
		add(tekst2, pom);
		
		pom.gridx = 2;
		add(ilosc, pom);
		
		pom.gridy = 4;
		pom.gridx = 1;
		pom.gridwidth = 2;
		add(zamow, pom);
		
	}

	public void show(String nameUser, String cena, String produkt) {
		name.setText(nameUser);
		tytul.setText("Produkt: "+produkt);
		tekst.setText("Cena jednostkowa: "+cena);
		nazwaProduktu = produkt;
		kwota = cena;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		JButton button = (JButton) arg0.getSource();
		if(button == cofnij) {
			view.pobierzSzczegoly(nazwaProduktu);
		}else if(button == zamow) {
			String iloscProduktu = ilosc.getText();
			view.formularzZamowienia(nazwaProduktu, iloscProduktu, kwota);
		}
	}

}
