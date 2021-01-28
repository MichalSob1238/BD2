package controller;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import model.*;

public class OknoListaZamowienController {

    public List<SzczegolyZamowienie> pobierzSzczegolyZamowienie(Integer nrFaktura){
        DatabaseController db = new DatabaseController();
        List<SzczegolyZamowienie> szczegoly = db.selectOrderDetails(nrFaktura);
        return szczegoly;
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
        Produkt prod = products.get(0);
        int i = 0;
        for(Produkt product : products){
            if (prod.getId() == product.getId()) {
                i++;
            } else {
                db.insertIntoPozycjaParagon(i, prod.getCost(), transactionId, prod.getId());
                i=0;
            }
            prod = product;
        }
        db.insertIntoPozycjaParagon(i+1, prod.getCost(), transactionId, prod.getId());
    }

    public void createNewOrder(String produkt, String iloscProduktu,
                               String imieZamawiajacego, String nazwiskoZamawiajacego){
        int clientId;
        DatabaseController db = new DatabaseController();
        DaneKlienta client = db.selectDaneKlienta(imieZamawiajacego, nazwiskoZamawiajacego);
        if(client == null){
            clientId = db.insertIntoDaneKlienta(imieZamawiajacego, nazwiskoZamawiajacego);
        }else{
            clientId = client.getId();
        }
        Date currentDate = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(currentDate);
        c.add(Calendar.DATE,14);
        int orderId = db.insertIntoZamowienie(false, currentDate, c.getTime(),clientId);
        Produkt product = db.selectWholeProductByName(produkt);
        db.insertIntoPozycjaZamowienie(Integer.parseInt(iloscProduktu), product.getCost(), orderId,product.getId());
    }
}