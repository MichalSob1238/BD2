package controller;

import model.Hurtownia;
import model.Szczegolowe_informacje;

import java.math.BigDecimal;

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
        String productName;
        try{
            productName = db.selectProductById(Integer.parseInt(id));
        } catch (Exception e){
            productName = null;
            return productName;
        }

        return productName;
    }

    public BigDecimal getCostOfProducts(String[] products){
        DatabaseController db = new DatabaseController();
        BigDecimal cost = db.sumProducts(products);
        return cost;
    }
}
