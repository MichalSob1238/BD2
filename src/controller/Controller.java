package controller;

import model.Model;
import model.Pracownik;
import view.View;

public class Controller {
    private Model model;
    private View view;

    public Controller (Model model, View view)
    {
        this.model = model; this.view = view;
        view.setControllerAndModel(this, model);
        //przekazaæ do modelu view i this
        start();
    }

    public void start(){
        view.oknoLogowania();
    }
    
    public void probaLogowania(String name, String surname) {
    	if(checkIfEmployeeExists(name, surname)) {
    		//sprawdz czy menedzer
    	}
    	view.oknoLogowaniePonowne();
    }
    
    private boolean checkIfEmployeeExists(String name, String surname){
        DatabaseController db = new DatabaseController();
        Pracownik employee = db.selectPracownik(name, surname);
        if(employee != null)
            return true;
        return false;
    }
}
