package controller;

public class OknoSzczegolyZamowieniaController {

    public void zmienStatusZamowienia(Integer nrZamowienia){
        DatabaseController db = new DatabaseController();
        db.changeOrderStatus(nrZamowienia);
    }
}
