package controller;

import model.*;
import view.View;

import java.util.*;

public  class Controller {
    private Model model;
    private View view;

    private OknoLogowaniaController logowanie;
    private OknoStartoweController startoweController;
    private OknoListaOfertController ofertaController;
    private OknoListaFakturController fakturaController;
    private OknoListaZamowienController zamowienieController;

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
		//view.zwrotPonownie();
    }

    public void probaLogowania(String name, String surname) {
        Pracownik employee = logowanie.checkIfEmployeeExists(name, surname);
    	if(employee != null) {
    		if(logowanie.checkIfEmployeeIsManager(employee)) {
    			view.setUser(name, surname, true);
    			view.oknoStartoweMenadzer();
    		}
    		else {
    			view.setUser(name, surname, false);
    			view.oknoStartoweZwyklegoPracownika();
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
    	if(products.size()!= 0){
			//Tutaj cos się dzieje bo paragon istnieje
		} else{
			//Tutaj nie ma nic na liście
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
		//wywo�a� view.ileProduktuZwrot(String ilosc, String paragon, String produkt)
	}

	public void zwrotIlosc(int ilosc, String paragon, String produkt) {
		//ustalic jak� kwot� trzeba zwr�ci�, jeszcze nie akceptowa� zwrotu!
		//wywo�a� view.kwotaDoZwrotu(String kwota, String paragon, String produkt)
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
}
