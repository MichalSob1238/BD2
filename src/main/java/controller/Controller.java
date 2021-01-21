package controller;

import model.Model;
import model.Pracownik;
import view.View;

public class Controller {
    private Model model;
    private View view;
    
    private OknoLogowaniaController logowanie;
    private OknoStartoweController startoweController;

    public Controller (Model model, View view)
    {
        this.model = model; this.view = view;
        view.setControllerAndModel(this, model);
        //przekaza? do modelu view i this
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
    	String oferta[] = startoweController.getProductNames().toArray(new String[0]);
    	view.oferta(oferta);
    }

	public void wyswietlenieRezerwacji() {
		String rezerwacje[] = new String[0];
    	//metoda, ktora wstawi do rezerwacje co? po czym rozpoznaje si? rezerwacje (numery?)
		//view.rezerwacje(rezerwacje);

	}
	
	public void wyswietlenieFaktur() {
		String faktury[];
		//metoda, kt?ra wstawi do faktury, co? po czym rozpoznaje si? faktury
		//view.faktury(faktury);
	}
	
	public void wyswietlenieDostaw() {
		String dostawy[];
		//metoda, kt?ra wstawi do dostawy, co? po czym rozpoznaje si? dostawy
		//view.dostawy(dostawy);
	}
	
	public void wybranoZwrot(String paragon) {
		//sprawdzenie czy jest odpowiedni paragon, je?eli tak wywo?a? view.zwrotListaProduktow podajac jaki paragon i liste produktow z paragonu
		//jezeli nie ma, to wywolac view.zwrotPonownie
	}
    
}
