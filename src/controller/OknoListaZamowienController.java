package controller;
import java.util.List;
import model.SzczegolyZamowienie;

public class OknoListaZamowienController {

    public List<SzczegolyZamowienie> pobierzSzczegolyZamowienie(Integer nrFaktura){
        DatabaseController db = new DatabaseController();
        List<SzczegolyZamowienie> szczegoly = db.selectOrderDetails(nrFaktura);
        return szczegoly;
    }
}