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

    public String getProductById(String id){
        DatabaseController db = new DatabaseController();
        String productName = db.selectProductById(Integer.parseInt(id));
        return productName;
    }

    public double getCostOfProducts(String[] products){
        DatabaseController db = new DatabaseController();
        double cost = db.sumProducts(products);
        return cost;
    }
}
