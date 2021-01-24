package view;

import controller.Controller;
import model.Model;
import model.Szczegolowe_informacje;
import model.Faktura;
import model.SzczegolyFaktura;
import model.SzczegolyZamowienie;

import javax.swing.*;
import java.awt.*;
import java.util.List;

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
//	public void pobierzSzczegolyHurtowni(String s) {
//		controller.pobierzSzczegolyHurtowni(s);
//	}

	public void szczegoly(Szczegolowe_informacje szczegoly){wsk.oknoSzczegoly(szczegoly);}

	public void pobierzSzczegolyFaktura(String nrFaktura){controller.pobierzSzczegolyFaktura(nrFaktura);}

	public void szczegolyFaktura(SzczegolyFaktura szczegolyFaktura){wsk.oknoSzczegolyFaktura(szczegolyFaktura);}

	public void pobierzSzczegolyZamowienie(Integer nrZamowienie){controller.pobierzSzczegolyZamowienie(nrZamowienie);}
	public void szczegolyZamowienie(SzczegolyZamowienie[] szczegoly){wsk.oknoSzczegolyZamowienie(szczegoly);}

	public void wybranoRezerwacje() {
		controller.wyswietlenieRezerwacji();
	}

	public void rezerwacje(Integer[] rezerwacje) {
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
		wsk.oknoZwrotu(false);
	}

	public void wybranoZwrot()
	{
		controller.wyswietlenieZwrot();
	}

	public void wybranoZakup(){
    	controller.oknoZakupu();
	}

	public void sprawdzZwrot(String receipt)
	{
		controller.wybranoZwrot(receipt);
	}
	
	public void zwrotPonownie() {
		wsk.oknoZwrotu(true);
	}

	public void zakup(){
    	wsk.oknoZakupu();
	}
	public void hurtownie(String list[]){
    	wsk.oknoHurtownia(list);

	}
	public String addToCart(String id){
    	//TODO: check if id matches any from database
		return id;
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
		//wywo�a� kontrolera
	}
	
	public void oknoPodaniaNrKonta() {
		//wy�wietli� okno do podania numeru konta
	}
	
	public void wybranoPrzelewZwrot(String nrKonta) {
		//wywo�a� kontrolera
	}

	public void wybranoHurtownia() {
    	controller.wyswietlanieHurtownia();
	}
	public void wybranoDostawy() {
    	controller.wyswietlenieDostaw();
	}
}

