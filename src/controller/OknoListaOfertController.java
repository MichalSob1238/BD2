package controller;

import model.Szczegolowe_informacje;

public class OknoListaOfertController {

    public Szczegolowe_informacje pobierzSzczegoly(String nazwa){
        DatabaseController db = new DatabaseController();
        Szczegolowe_informacje szczegoly = db.getDetails(nazwa);
        return szczegoly;
    }

}
