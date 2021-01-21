package controller;

import model.Pracownik;

public class oknoLogowaniaController {

    boolean checkIfEmployeeExists(String name, String surname){
        DatabaseController db = new DatabaseController();
        Pracownik employee = db.selectPracownik(name, surname);
        if(employee != null)
            return true;
        return false;
    }
}
