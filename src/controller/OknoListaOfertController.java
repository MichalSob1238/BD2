package controller;

import model.Hurtownia;
import model.Szczegolowe_informacje;

public class OknoListaOfertController {

    public Szczegolowe_informacje pobierzSzczegoly(String nazwa){
        DatabaseController db = new DatabaseController();
        Szczegolowe_informacje szczegoly = db.getDetails(nazwa);
        return szczegoly;
    }
    public Hurtownia getWarehousesDetails(String name){
        DatabaseController db = new DatabaseController();
        Hurtownia warehouse = db.selectWarehouseByName(name);
        return warehouse;
    }
}
