package controller;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Pracownik;
import model.Produkt;
import model.SzczegolyZamowienie;
import model.Transakcja;

public class OknoListaZamowienController {

    public List<SzczegolyZamowienie> pobierzSzczegolyZamowienie(Integer nrFaktura){
        DatabaseController db = new DatabaseController();
        List<SzczegolyZamowienie> szczegoly = db.selectOrderDetails(nrFaktura);
        return szczegoly;
    }

    public void createNewZamowienie(String produkt, String iloscProduktu, String imieZamawiajacego,
                                    String nazwiskoZamawiajacego) {

    }

    public void createNewTransaction(String[] boughtProducts, String name, String surname){
        double sum =0.0;
        DatabaseController db = new DatabaseController();
        List<Produkt> products = new ArrayList<>();
        for(String product : boughtProducts) {
            Produkt databaseProduct = db.selectWholeProductByName(product);
            products.add(databaseProduct);
            sum += databaseProduct.getCost();
        }
        Pracownik employee = db.selectPracownik(name, surname);
        int transactionId = db.insertIntoTransakcja(new Date(), sum, employee.getId(), Transakcja.transactionType.PARAGON);
        for(Produkt product : products){
            db.insertIntoPozycjaParagon(1, product.getCost(), transactionId, product.getId());
        }
    }
}