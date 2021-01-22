package view;

import controller.Controller;
import model.Model;
import model.Szczegolowe_informacje;

import javax.swing.*;
import java.awt.*;

public class View {
	Controller controller;
	Model model;
    private glowneOkno wsk;
    
    private String paragonZwrot;
    private String produktZwrot;
    private String kwotaZwrot;
    private String maxIloscZwrot;
    
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

	public void pobierzSzczegoly(String nazwa){ controller.pobierzSzczegoly(nazwa); }

	public void szczegoly(Szczegolowe_informacje szczegoly){wsk.oknoSzczegoly(szczegoly);}

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
		paragonZwrot = paragon;
		wsk.oknoZwrotListaProduktow(produkty, paragon);
	}
	
	public void wybranoProduktDoZwrotu(String produkt) {
		controller.wybranoProduktDoZwrotu(paragonZwrot, produkt);
	}
	
	public void ileProduktuZwrot(String ilosc, String paragon, String produkt) {
		paragonZwrot = paragon;
		produktZwrot = produkt;
		maxIloscZwrot = ilosc;
		wsk.oknoWyboruIlosciProduktuZwrot(ilosc, paragon, produkt);
	}
	
	public void ileProduktuZwrot() {
		wsk.oknoWyboruIlosciProduktuZwrot(maxIloscZwrot, paragonZwrot, produktZwrot);
	}
	
	public void podanoIloscProduktuZwrot(int ilosc) {
		controller.zwrotIlosc(ilosc, paragonZwrot, produktZwrot);
	}
	
	public void kwotaDoZwrotu(String kwota) {
		kwotaZwrot = kwota;
		wsk.oknoWyboruSposobuOddaniaKwoty(kwota);
	}
	
	public void wybranoGotowkeZwrot() {
		//wywo³aæ kontrolera
	}
	
	public void oknoPodaniaNrKonta() {
		//wyœwietliæ okno do podania numeru konta
	}
	
	public void wybranoPrzelewZwrot(String nrKonta) {
		//wywo³aæ kontrolera
	}
}

