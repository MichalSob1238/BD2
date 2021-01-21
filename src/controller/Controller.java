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
        //przekazaÄ‡ do modelu view i this
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
    			view.oknoStartoweMenadzer();
    		}
    		else {
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
    	//metoda, ktÃ³ra wstawi do rezerwacje coÅ› po czym rozpoznaje siÄ™ rezerwacje (numery?)
		view.rezerwacje(rezerwacje);

	}
	
	public void wyswietlenieFaktur() {
		String faktury[];
		//metoda, która wstawi do faktury, coœ po czym rozpoznaje siê faktury
		view.faktury(faktury);
	}
    
}
