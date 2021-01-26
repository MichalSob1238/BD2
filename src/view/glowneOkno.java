package view;

import model.Faktura;
import model.Szczegolowe_informacje;
import model.SzczegolyFaktura;
import model.SzczegolyZamowienie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.math.BigDecimal;
import java.util.List;

public class glowneOkno extends JFrame{
	private View view;
	
	private String name;
	private boolean menedzer;
	
	private oknoLogowania logowanie;
	private oknoStartowe start;
	private oknoListaOfert listaOferta;
	private oknoListaRezerwacji listaRezerwacje;
	private oknoFaktur faktury;
	private oknoListaFaktur listaFaktur;
	private oknoListaDostaw listaDostaw;
	private oknoZwrotu zwrot;
	private oknoZwrotLista zwrotLista;
	private oknoSzczegolyProdukt szczegoly;
	private oknoWyboruIlosciProduktuZwrot iloscZwrot;
	private oknoWyborZwrotuKwota sposobZwrotu;
	private oknoZakupu zakup;
	private oknoHurtownia hurtownia;
	private oknoSzczegolyFaktura szczegolyFaktura;
	private oknoSzczegolyZamowienie szczegolyZamowienie;
	private oknoSzczegolyProduktZakup szczegolyZakup;
	private oknoFinaliseTransaction finaliseTransaction;
	private oknoRemanent oknoRemanent;
	private oknoPodaniaKonta kontoNumerZwrot;
	private fakturaFormularz formularzFaktura;
	private oknoZmienIloscRemanent oknoZmienIloscRemanent;
	private zamowienieDetaliczne zamowienieDetaliczne;
	private formularzZamowienia formularzZamowienia;
	
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
		szczegoly = new oknoSzczegolyProdukt(view);
		iloscZwrot = new oknoWyboruIlosciProduktuZwrot(view);
		sposobZwrotu = new oknoWyborZwrotuKwota(view);
		zakup = new oknoZakupu(view);
		hurtownia = new oknoHurtownia(view);
		szczegolyFaktura = new oknoSzczegolyFaktura(view);
		szczegolyZamowienie = new oknoSzczegolyZamowienie(view);
		szczegolyZakup = new oknoSzczegolyProduktZakup(view);
		finaliseTransaction = new oknoFinaliseTransaction(view,new BigDecimal(0.0));
		faktury = new oknoFaktur(view);
		oknoRemanent = new oknoRemanent(view);
		kontoNumerZwrot = new oknoPodaniaKonta(view);
		formularzFaktura = new fakturaFormularz(view);
		oknoZmienIloscRemanent = new oknoZmienIloscRemanent(view);
		zamowienieDetaliczne = new zamowienieDetaliczne(view);
		formularzZamowienia = new formularzZamowienia(view);

	}

	public void oknoRemanent(String produkty[][]) {

		getContentPane().removeAll();
		oknoRemanent.show(name, produkty);
		add(oknoRemanent);
		validate();
		repaint();

	}

	public void zmienIloscRemanent(String name, int index) {

		getContentPane().removeAll();
		oknoZmienIloscRemanent.show(name, index);
		add(oknoZmienIloscRemanent);
		validate();
		repaint();

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
	public void oknoZwrotu(Boolean flag) {
		getContentPane().removeAll();
		zwrot.show(name,flag);
		add(zwrot);
		validate();
		repaint();
	}
	public void oknoFinaliseTransaction(BigDecimal cena){
		getContentPane().removeAll();
		BigDecimal cenna = cena;
		finaliseTransaction.show(name,cenna);
		add(finaliseTransaction);
		validate();
		repaint();
	}
	public void oknoZakupu() {
		getContentPane().removeAll();
		zakup.show(name);
		add(zakup);
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
	public void oknoListaRezerwacje(Integer tab[]) {
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

	public void oknoSzczegoly(Szczegolowe_informacje szczegol) {
		oknoSzczegoly(szczegol, true);
	}


	public void oknoSzczegoly(Szczegolowe_informacje szczegol, Boolean flag) {
		getContentPane().removeAll();
		if (flag) {
			szczegoly.show(name, szczegol);
			add(szczegoly);
		} else {
			szczegolyZakup.show(name,szczegol);
			add(szczegolyZakup);
		}

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

	public void oknoHurtownia(String[] list) {
		getContentPane().removeAll();
		hurtownia.show(name, list);
		add(hurtownia);
		validate();
		repaint();
	}

	public void oknoSzczegolyFaktura(SzczegolyFaktura szczegoly){
		getContentPane().removeAll();
		szczegolyFaktura.show(name, szczegoly);
		add(szczegolyFaktura);
		validate();
		repaint();
	}

	public void oknoSzczegolyZamowienie(SzczegolyZamowienie[] szczegoly){
		getContentPane().removeAll();
		szczegolyZamowienie.show(name, szczegoly);
		add(szczegolyZamowienie);
		validate();
		repaint();
	}
	
	public void oknoFaktur() {
		getContentPane().removeAll();
		faktury.show(name);
		add(faktury);
		validate();
		repaint();
	}
	
	public void oknoPodaniaNumeruKontaZwrot() {
		getContentPane().removeAll();
		kontoNumerZwrot.show(name);
		add(kontoNumerZwrot);
		validate();
		repaint();
	}
	
	public void oknoFormularzaFaktury() {
		getContentPane().removeAll();
		formularzFaktura.show(name);
		add(formularzFaktura);
		validate();
		repaint();
	}

	public void zamowienieDetaliczne(String kwota, String produkt) {
		getContentPane().removeAll();
		zamowienieDetaliczne.show(name, kwota, produkt);
		add(zamowienieDetaliczne);
		validate();
		repaint();
	}

	public void formularzZamowienia(String produkt, String ilosc, String kwota) {
		getContentPane().removeAll();
		formularzZamowienia.show(name, produkt, ilosc, kwota);
		add(formularzZamowienia);
		validate();
		repaint();
	}
}
