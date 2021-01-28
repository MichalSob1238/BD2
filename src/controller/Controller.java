package controller;

import model.*;
import view.View;

import java.math.BigDecimal;
import java.util.*;

public  class Controller {
    private Model model;
    private View view;

    private OknoLogowaniaController logowanie;
    private OknoStartoweController startoweController;
    private OknoListaOfertController ofertaController;
    private OknoListaFakturController fakturaController;
    private OknoListaZamowienController zamowienieController;
    private OknoSzczegolyZamowieniaController szczegolyZamowienieController;
    private OknoZwrotController zwrotController;
    private OknoRemanentController oknoRemanentController;
    private String userName;
    private String userSurname;

    public Controller (Model model, View view)
    {
        this.model = model; this.view = view;
        view.setControllerAndModel(this, model);
        //przekazać do modelu view i this
        logowanie = new OknoLogowaniaController();
        start();
    }

    public void start(){
        view.oknoLogowania();
		this.oknoRemanentController = new OknoRemanentController();
		List<List<String>> produkty = oknoRemanentController.dajProduktyZMagazynu();

//		view.remanent(produkty);
		//view.transactionConfirmation(new BigDecimal("304.25"));
    }

    public void probaLogowania(String name, String surname) {
        Pracownik employee = logowanie.checkIfEmployeeExists(name, surname);
    	if(employee != null) {
    		if(logowanie.checkIfEmployeeIsManager(employee)) {
    			view.setUser(name, surname, true);
    			view.oknoStartoweMenadzer();
    			userName = name;
    			userSurname = surname;
    		}
    		else {
    			view.setUser(name, surname, false);
    			view.oknoStartoweZwyklegoPracownika();
				userName = name;
				userSurname = surname;
    		}
    	} else {
    	view.oknoLogowaniePonowne();
    	}
    }

    public void wyswietlenieOfertySklepu() {
		startoweController  = new  OknoStartoweController();
		String oferta[] = startoweController.getProductNames().toArray(new String[0]);
    	view.oferta(oferta);
    }

    public void pobierzSzczegoly(String nazwa){
    	ofertaController = new OknoListaOfertController();
    	Szczegolowe_informacje szczegoly = ofertaController.pobierzSzczegoly(nazwa);
    	view.szczegoly(szczegoly);
	}

	public void pobierzSzczegolyZakup(String nazwa){
		ofertaController = new OknoListaOfertController();
		Szczegolowe_informacje szczegoly = ofertaController.pobierzSzczegoly(nazwa);
		view.szczegolyZakup(szczegoly);
	}

	public void wyswietlenieRezerwacji() {
		startoweController  = new  OknoStartoweController();
		Integer rezerwacje[] = startoweController.getOrderNames().toArray(new Integer[0]);
		view.rezerwacje(rezerwacje);

	}
	public void oknoZakupu(){
    	view.zakup();
	}
	public void wyswietlenieFaktur() {
		startoweController  = new  OknoStartoweController();
		String faktury[] = startoweController.getInvoiceNumbers().toArray(new String[0]);
		System.out.println(faktury);
		view.faktury(faktury);
	}

	public void wyswietlenieDostaw() {
		startoweController  = new  OknoStartoweController();
		String dostawy[] = startoweController.getDeliveryNames().toArray(new String[0]);
		view.dostawy(dostawy);
	}

	public void wybranoZwrot(String paragon) {
		startoweController  = new  OknoStartoweController();
		List<Produkt> products = startoweController.getProductsFromTransaction(paragon);
		ArrayList<String> nazwyProd = new ArrayList<String>();
		for (Produkt prod : products)
		{
			nazwyProd.add(prod.getName());
		}
		String productsString[] = nazwyProd.toArray(new String[0]);
    	if(products.size()!= 0){
			view.zwrotListaProduktow(paragon,productsString);
		} else{
			view.zwrotPonownie();
		}
		//sprawdzenie czy jest odpowiedni paragon, je�eli tak wywo�a� view.zwrotListaProduktow podajac jaki paragon i liste produktow z paragonu
		//jezeli nie ma, to wywolac view.zwrotPonownie
	}

	public void wyswietlenieZwrot(){
    	view.zwrot();
	}
	public void wybranoProduktDoZwrotu(String paragon, String produkt) {
		//ustalic ile produktu jest na danym paragonie
		zwrotController = new OknoZwrotController();
		String ilosc = zwrotController.ileNaParagonie(paragon,produkt);
		view.ileProduktuZwrot( ilosc,  paragon,  produkt);
	}

	public void zwrotIlosc(int ilosc, String paragon, String produkt) {
    	zwrotController = new OknoZwrotController();
    	String kwota = zwrotController.kwotaDoZwrotu(ilosc, paragon, produkt);
		//ustalic jak� kwot� trzeba zwr�ci�, jeszcze nie akceptowa� zwrotu!
		view.kwotaDoZwrotu(kwota);
	}


	public void wyswietlanieHurtownia() {
		startoweController  = new  OknoStartoweController();
		String[] list = startoweController.getWarehousesNames().toArray(new String[0]);
		view.hurtownie(list);
	}


	public void pobierzSzczegolyHurtowni(String name) {
		ofertaController = new OknoListaOfertController();
		Hurtownia warehouse = ofertaController.getWarehousesDetails(name);
		//Tutaj trzeba użyć czegoś innego bo inne są szczegóły na temat hurtowni a inne na temat produktu
		// W sensie musi być metoda która po prostu bierze Hurtownię
//		view.szczegoly(szczegoly);
	}

	public void pobierzSzczegolyFaktura(String nrFaktura){
		fakturaController = new OknoListaFakturController();
		SzczegolyFaktura szczegolyFaktura = fakturaController.pobierzSzczegolyFaktura(nrFaktura);
		view.szczegolyFaktura(szczegolyFaktura);
	}

	public void pobierzSzczegolyZamowienie(Integer nrZamowienie){
		zamowienieController = new OknoListaZamowienController();
		SzczegolyZamowienie[] szczegolyZamowienie = zamowienieController.pobierzSzczegolyZamowienie(nrZamowienie).toArray(new SzczegolyZamowienie[0]);
		view.szczegolyZamowienie(szczegolyZamowienie);
	}

	public String getProductByID(String id) {
		ofertaController = new OknoListaOfertController();
		String prodByID = ofertaController.getProductById(id);
		return prodByID;
	}

	public void finaliseTransaction(String[] tab) {
    	BigDecimal price = ofertaController.getCostOfProducts(tab);
		view.transactionConfirmation(price);
	}

	public void wyswietlenieRemanentu() {
    	this.oknoRemanentController = new OknoRemanentController();
		List<List<String>> produkty = oknoRemanentController.dajProduktyZMagazynu();
    	view.remanent(produkty);
	}

	public void wyswietlenieRemanentu(int ilosc, int index, String idProduktu) {
		this.oknoRemanentController = new OknoRemanentController();
		List<List<String>> produkty = oknoRemanentController.dajProduktyZMagazynu();
		produkty.get(index).set(3, String.valueOf(ilosc));
		oknoRemanentController.aktualizujProduktyMagazynu(ilosc, idProduktu);
		view.remanent(produkty);
	}

	public void zmienStatusZamowienia(Integer nrZamowienia){
		szczegolyZamowienieController = new OknoSzczegolyZamowieniaController();
    	szczegolyZamowienieController.zmienStatusZamowienia(nrZamowienia);
    }

	public void wypelnionoFormularzFaktury(String daneNazwa, String daneAdres, String daneNIP, String daneParagon) {
		fakturaController.addInvoice(daneNazwa, daneAdres, daneNIP,daneParagon);
		
	}

	public void wystawParagon(String tresc[]) {
    	zamowienieController = new OknoListaZamowienController();
    	zamowienieController.createNewTransaction(tresc, userName, userSurname);

	}

	public void noweZamowienie(String produkt, String iloscProduktu,
							   String imieZamawiajacego, String nazwiskoZamawiajacego)
	{
		zamowienieController = new OknoListaZamowienController();
		zamowienieController.createNewOrder(produkt, iloscProduktu, imieZamawiajacego, nazwiskoZamawiajacego);
	}

	public void clearZakup() {
    	view.doClearZakup();
	}

	public void wykonajZwrot(String iloscZwrot, String paragon, String maxIlosc) {
		zwrotController = new OknoZwrotController();
		zwrotController.wykonajZwrot(iloscZwrot, paragon, maxIlosc);
	}
}
