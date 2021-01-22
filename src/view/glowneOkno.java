package view;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class glowneOkno extends JFrame{
	private View view;
	
	private String name;
	private boolean menedzer;
	
	private oknoLogowania logowanie;
	private oknoStartowe start;
	private oknoListaOfert listaOferta;
	private oknoListaRezerwacji listaRezerwacje;
	private oknoListaFaktur listaFaktur;
	private oknoListaDostaw listaDostaw;
	private oknoZwrotu zwrot;
	private oknoZwrotLista zwrotLista;
	private oknoWyboruIlosciProduktuZwrot iloscZwrot;
	private oknoWyborZwrotuKwota sposobZwrotu;
	

	
	public glowneOkno(View view) {
		super("Baza danych - Sklep");
		this.view = view;
		setSize(400, 300);
		setResizable(true);
		setLocation(450, 200);
		
		logowanie = new oknoLogowania(view);
		start = new oknoStartowe(view);
		listaOferta = new oknoListaOfert(view);
		listaRezerwacje = new oknoListaRezerwacji(view);
		listaFaktur = new oknoListaFaktur(view);
		listaDostaw = new oknoListaDostaw(view);
		zwrot = new oknoZwrotu(view);	
		zwrotLista = new oknoZwrotLista(view);
		iloscZwrot = new oknoWyboruIlosciProduktuZwrot(view);
		sposobZwrotu = new oknoWyborZwrotuKwota(view);
	}
	public void oknoLogowania(boolean badMsg) {
		
		getContentPane().removeAll();
		logowanie.show(badMsg);
		add(logowanie);
		validate();
		repaint();

	}
	public void oknoStartowe(boolean manager) {
		getContentPane().removeAll();
		start.show(manager, name);
		add(start);
		validate();
		repaint();
	}
	public void oknoZwrotu() {
		getContentPane().removeAll();
		add(zwrot);
		validate();
		repaint();
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setMenedzer(boolean menedzer) {
		this.menedzer = menedzer;
	}
	public boolean getMenedzer() {
		return menedzer;
	}
	public void oknoListaOferta(String tab[]) {
		getContentPane().removeAll();
		listaOferta.show(name, tab);
		add(listaOferta);
		validate();
		repaint();

	}
	public void oknoListaRezerwacje(String tab[]) {
		getContentPane().removeAll();
		listaRezerwacje.show(name, tab);
		add(listaRezerwacje);
		validate();
		repaint();
	}	
	public void showZwrot()
	{
		getContentPane().removeAll();
		//dodaj
		validate();
		repaint();
		
	}
	public void oknoListaFaktur(String[] tab) {
		getContentPane().removeAll();
		listaFaktur.show(name, tab);
		add(listaFaktur);
		validate();	
		repaint();
	}
	public void oknoListaDostaw(String[] tab) {
		getContentPane().removeAll();
		listaDostaw.show(name, tab);
		add(listaDostaw);
		validate();
		repaint();

	}
	
	public void oknoZwrotListaProduktow(String[] tab, String paragon) {
		getContentPane().removeAll();
		zwrotLista.show(name, tab, paragon);
		add(zwrotLista);
		validate();
		repaint();
	}
	
	public void oknoWyboruIlosciProduktuZwrot(String ilosc, String paragon, String produkt) {
		getContentPane().removeAll();
		iloscZwrot.show(name, ilosc, paragon, produkt);
		add(iloscZwrot);
		validate();
		repaint();
	}
	
	public void oknoWyboruSposobuOddaniaKwoty(String kwota) {
		getContentPane().removeAll();
		sposobZwrotu.show(name, kwota);
		add(sposobZwrotu);
		validate();
		repaint();
	}
}
