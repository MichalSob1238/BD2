package controller;

import model.Pracownik;

public class oknoLogowaniaController {

    boolean checkIfEmployeeExists(String name, String surname){
        name = name.toLowerCase();
        name = name.substring(0,1).toUpperCase() + name.substring(1);
        surname = surname.toLowerCase();
        surname = surname.substring(0,1).toUpperCase() + surname.substring(1);
    public boolean checkIfEmployeeExists(String name, String surname){
        DatabaseController db = new DatabaseController();
        Pracownik employee = db.selectPracownik(name, surname);
        if(employee != null)
            return true;
        return false;
    }
}
