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
		wsk.repaint();
	}
	
	public void oknoLogowaniePonowne() {
		wsk.oknoLogowania(true);
		wsk.repaint();
	}
	
	public void oknoStartoweZwyklegoPracownika() {
		wsk.oknoStartowe(false);
		wsk.repaint();
	}
	
	public void oknoStartoweMenadzer() {
		wsk.oknoStartowe(true);
		wsk.repaint();
	}
	
	public void probaLogowania(String name, String surname) {
		controller.probaLogowania(name, surname);
	}

	public void oferta(String[] oferta) {
		wsk.oknoLista("Oferta", oferta, "szczegï¿½y");
		wsk.repaint();
	}
	
	public void wybranoOferte() {
		controller.wyswietlenieOfertySklepu();
	}
	
	public void wybranoRezerwacje() {
		controller.wyswietlenieRezerwacji();
	}

	public void rezerwacje(String[] rezerwacje) {
		wsk.oknoLista("Rezrwacje", rezerwacje, "szczegï¿½y");
		wsk.repaint();
		
	}

	public void oknoStartowe() {
		wsk.oknoStartowe(wsk.getMenedzer());
		wsk.repaint();
	}

	public void faktury(String[] faktury) {
		wsk.oknoLista("Faktury", faktury, "szczegó³y");
		wsk.repaint();
	}

	public void wybranoPrzegladFaktur() {
		controller.wyswietlenieFaktur();		
	}
	
	public void utworzFakture() {
		
	}
	
	public void zwrot() {
		wsk.oknoZwrotu();
		wsk.repaint();
	}
	
	public void zwrotPonownie() {
		
	}
	
	public void zwrotListaProduktow(String produkty[]) {
		
	}
}

