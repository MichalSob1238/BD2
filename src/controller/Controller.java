package controller;

import model.Model;
import model.Pracownik;
import model.Produkt;
import model.Szczegolowe_informacje;
import view.View;

import java.util.List;

public  class Controller {
    private Model model;
    private View view;
    
    private OknoLogowaniaController logowanie;
    private OknoStartoweController startoweController;
    private OknoListaOfertController ofertaController;

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
		String rezerwacje[] = new String[0];
    	//metoda, która wstawi do rezerwacje coś po czym rozpoznaje się rezerwacje (numery?)
		view.rezerwacje(rezerwacje);

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
		//view.dostawy(dostawy);
	}
	
	public void wybranoZwrot(String paragon) {
		List<Produkt> products = startoweController.getProductsFromTransaction(paragon);
		if(products.size()!= 0){
			//Tutaj cos się dzieje bo paragon istnieje
		} else{
			//Tutaj nie ma nic na liście
		}
		//sprawdzenie czy jest odpowiedni paragon, je�eli tak wywo�a� view.zwrotListaProduktow podajac jaki paragon i liste produktow z paragonu
		//jezeli nie ma, to wywolac view.zwrotPonownie
	}
	
	public void wybranoProduktDoZwrotu(String paragon, String produkt) {
		//ustalic ile produktu jest na danym paragonie
		//wywo�a� view.ileProduktuZwrot(String ilosc, String paragon, String produkt)
	}
	
	public void zwrotIlosc(int ilosc, String paragon, String produkt) {
		//ustalic jak� kwot� trzeba zwr�ci�, jeszcze nie akceptowa� zwrotu!
		//wywo�a� view.kwotaDoZwrotu(String kwota, String paragon, String produkt)
	}

    
}
