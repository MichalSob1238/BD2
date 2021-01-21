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
	}
	public void oknoLogowania(boolean badMsg) {
		remove(logowanie);
		remove(start);
		remove(listaOferta);
		remove(listaRezerwacje);
		remove(listaFaktur);
		remove(listaDostaw);
		remove(zwrot);
		add(logowanie);
		logowanie.show(badMsg);

	}
	public void oknoStartowe(boolean manager) {
		remove(logowanie);
		remove(start);
		remove(listaOferta);
		remove(listaRezerwacje);
		remove(listaFaktur);
		remove(listaDostaw);
		remove(zwrot);
		add(start);
		start.show(manager, name);

	}
	public void oknoZwrotu() {
		remove(logowanie);
		remove(start);
		remove(listaOferta);
		remove(listaRezerwacje);
		remove(listaFaktur);
		remove(listaDostaw);
		remove(zwrot);
		add(zwrot);
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
		remove(logowanie);
		remove(start);
		remove(listaOferta);
		remove(listaRezerwacje);
		remove(listaFaktur);
		remove(listaDostaw);
		remove(zwrot);
		add(listaOferta);
		listaOferta.show(name, tab);

	}
	public void oknoListaRezerwacje(String tab[]) {
		remove(logowanie);
		remove(start);
		remove(listaOferta);
		remove(listaRezerwacje);
		remove(listaFaktur);
		remove(listaDostaw);
		remove(zwrot);
		add(listaRezerwacje);
		listaOferta.show(name, tab);

	}	
	public void showZwrot()
	{
		remove(logowanie);
		remove(start);
		remove(listaOferta);
		remove(listaRezerwacje);
		remove(listaFaktur);
		remove(listaDostaw);
		remove(zwrot);
		
	}
	public void oknoListaFaktur(String[] tab) {
		remove(logowanie);
		remove(start);
		remove(listaOferta);
		remove(listaRezerwacje);
		remove(listaFaktur);
		remove(listaDostaw);
		remove(zwrot);
		add(listaFaktur);
		listaFaktur.show(name, tab);

		
	}
	public void oknoListaDostaw(String[] tab) {
		remove(logowanie);
		remove(start);
		remove(listaOferta);
		remove(listaRezerwacje);
		remove(listaFaktur);
		remove(listaDostaw);
		remove(zwrot);
		add(listaDostaw);
		listaDostaw.show(name, tab);

	}
}
