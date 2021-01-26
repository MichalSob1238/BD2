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

public class formularzZamowienia extends JPanel implements ActionListener{
	private View view;
	
	private String produkt;
	private String kwota;
	private String iloscProduktu;
	
	private GridBagLayout layout;
	private GridBagConstraints pom;
	
	private JLabel name;
	private JButton cofnij;
	
	private JLabel nazwaProduktu;
	private JLabel ilosc;
	private JLabel koszt;
	private JLabel podajImie;
	private JTextField imie;
	private JLabel podajNazwisko;
	private JTextField nazwisko;
	
	private JButton zamow;
	
	
	public formularzZamowienia(View view) {
		this.view = view;
		layout = new GridBagLayout();
		pom = new GridBagConstraints();
		setLayout(layout);
		
		name = new JLabel();
		cofnij = new JButton("cofnij");
		cofnij.addActionListener(this);
		
		nazwaProduktu = new JLabel();
		ilosc = new JLabel();
		koszt = new JLabel();
		podajImie = new JLabel("Podaj imiê: ");
		imie = new JTextField();
		imie.setPreferredSize(new Dimension(70, 20));
		podajNazwisko = new JLabel("Podaj nazwisko: ");
		nazwisko = new JTextField();
		nazwisko.setPreferredSize(new Dimension(70, 20));
		zamow = new JButton("op³aæ i zamów");
		zamow.addActionListener(this);
		
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
	     add(nazwaProduktu, pom);
	     
	     pom.gridy = 2;
	     add(ilosc, pom);
	     
	     pom.gridy = 3;
	     add(koszt, pom);
	     
	     pom.gridy = 4;
	     pom.gridwidth = 0;
	     add(podajImie, pom);
	     
	     pom.gridx = 1;
	     add(imie, pom);
	     
	     pom.gridy = 5;
	     add(nazwisko, pom);
	     
	     pom.gridx = 0;
	     add(podajNazwisko, pom);
	     
	     pom.gridy = 6;
	     pom.gridwidth = 2;
	     add(zamow, pom);
		
		
	}
	
	public void show(String nameUser, String produkt, String ilosc, String kwota) {
		name.setText(nameUser);
		this.produkt = produkt;
		this.kwota = kwota;
		iloscProduktu = ilosc;
		nazwaProduktu.setText("Produkt: "+produkt);
		this.ilosc.setText("Iloœæ produktu: "+ilosc);
		koszt.setText("Cena jednostkowa: "+kwota);
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		JButton button = (JButton) arg0.getSource();
		if(button == cofnij) {
			view.zamowienieDetaliczne(produkt, kwota);
		}else if(button == zamow) {
			String imieZamawiajacego = imie.getText();
			String nazwiskoZamawiajacego = nazwisko.getText();
			view.noweZamowienie(produkt, iloscProduktu, imieZamawiajacego, nazwiskoZamawiajacego);
		}
	}
}
