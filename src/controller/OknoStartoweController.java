package controller;

import model.Produkt;

import java.util.ArrayList;
import java.util.List;

public class OknoStartoweController{

    public List<String> getProductNames(){
        DatabaseController db = new DatabaseController();
        List<Produkt> products = db.selectAllFromProdukt();
        List<String> names = new ArrayList<>();
        for (Produkt product: products) {
            names.add(product.getName());
        }
        return names;
    }
}
