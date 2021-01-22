package view;

import controller.Controller;
import model.Model;

import javax.swing.*;
import java.awt.*;

public class View {
	Controller controller;
	Model model;
    private glowneOkno wsk;
    
    public View(){
    	wsk = new glowneOkno(this);
        wsk.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        wsk.setVisible(true);
    }
    
    public void setUser(String name, String surname, boolean menedzer) {
    	wsk.setName(surname + " " + name);
    	wsk.setMenedzer(menedzer);
    }

	public void setControllerAndModel(Controller controller, Model model) {
		this.controller = controller;
		this.model = model;
	}

	public void oknoLogowania() {
		wsk.setName("");
		wsk.setMenedzer(false);
		wsk.oknoLogowania(false);
	}
	
	public void oknoLogowaniePonowne() {
		wsk.oknoLogowania(true);
	}
	
	public void oknoStartoweZwyklegoPracownika() {
		wsk.oknoStartowe(false);
	}
	
	public void oknoStartoweMenadzer() {
		wsk.oknoStartowe(true);
	}
	
	public void probaLogowania(String name, String surname) {
		controller.probaLogowania(name, surname);
	}

	public void oferta(String[] oferta) {
		wsk.oknoListaOferta(oferta);
	}
	
	public void wybranoOferte() {
		controller.wyswietlenieOfertySklepu();
	}
	
	public void wybranoRezerwacje() {
		controller.wyswietlenieRezerwacji();
	}

	public void rezerwacje(String[] rezerwacje) {
		wsk.oknoListaRezerwacje(rezerwacje);
		
	}

	public void oknoStartowe() {
		wsk.oknoStartowe(wsk.getMenedzer());
	}

	public void faktury(String[] faktury) {
		wsk.oknoListaFaktur(faktury);
	}
	
	public void dostawy(String[] dostawy) {
		wsk.oknoListaDostaw(dostawy);
	}

	public void wybranoPrzegladFaktur() {
		controller.wyswietlenieFaktur();		
	}
	
	public void utworzFakture() {
		
	}
	
	public void zwrot() {
		wsk.oknoZwrotu();
	}
	
	public void zwrotPonownie() {
		
	}
	
	public void podanoPargonZwrot(String paragon) {
		controller.wybranoZwrot(paragon);
	}
	
	public void zwrotListaProduktow(String paragon, String produkty[]) {
		wsk.oknoZwrotListaProduktow(produkty, paragon);
	}
	
	public void podanoIloscProduktuZwrot(int ilosc) {
		
	}
}

