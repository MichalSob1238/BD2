package view;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class glowneOkno extends JFrame{
	private View view;
	
	private String name;
	private boolean menedzer;
	
	private oknoLogowania logowanie;
	private oknoStartowe start;
	private oknoLista lista;
	private oknoZwrotu zwrot;
	

	
	public glowneOkno(View view) {
		super("Baza danych - Sklep");
		this.view = view;
		setSize(400, 300);
		setResizable(true);
		setLocation(450, 200);
		
		logowanie = new oknoLogowania(view);
		start = new oknoStartowe(view);
		lista = new oknoLista(view);
		zwrot = new oknoZwrotu(view);
	}
	public void oknoLogowania(boolean badMsg) {
		remove(logowanie);
		remove(start);
		remove(lista);
		remove(zwrot);
		logowanie.show(badMsg);
		add(logowanie);
	}
	public void oknoStartowe(boolean manager) {
		remove(logowanie);
		remove(start);
		remove(lista);
		remove(zwrot);
		start.show(manager, name);
		add(start);
	}
	public void oknoZwrotu() {
		remove(logowanie);
		remove(start);
		remove(lista);
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
	public void oknoLista(String tytul, String tab[], String buttonText) {
		remove(logowanie);
		remove(start);
		remove(lista);
		remove(zwrot);
		lista.show(name, tytul, tab, buttonText);
		add(lista);
	}
	public void showZwrot()
	{
		remove(logowanie);
		remove(start);
		remove(lista);
		remove(zwrot);
	}
}
