package controller;

import model.Model;
import model.Pracownik;
import view.View;

public class Controller {
    private Model model;
    private View view;
    
    private OknoLogowaniaController logowanie;

    public Controller (Model model, View view)
    {
        this.model = model; this.view = view;
        view.setControllerAndModel(this, model);
        //przekazaï¿½ do modelu view i this
        logowanie = new OknoLogowaniaController();
        start();
    }

    public void start(){
        view.oknoLogowania();
    }
    
    public void probaLogowania(String name, String surname) {
    	if(logowanie.checkIfEmployeeExists(name, surname)) {
    		//stwórz pracownika
    		Pracownik employee /*= */;
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
    	String oferta[];
    	//metoda, która wstawi do oferta nazwy produktów
    	view.oferta(oferta);
    }
    
}
