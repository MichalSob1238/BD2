package controller;

import model.Faktura;
import model.Produkt;

import java.util.ArrayList;
import java.util.List;

public class OknoStartoweController{

    public List<String> getProductNames(){
        DatabaseController db = new DatabaseController();
        List<String> names = db.selectProductNameProdukt();
        return names;
    }

    public List<String> getInvoiceNumbers(){
        DatabaseController db = new DatabaseController();
        List<String> invoices = db.selectInvoceNumberFromFaktura();
        return invoices;
    }

    public List<String> getDeliveryNames(){
        DatabaseController db = new DatabaseController();
        List<String> deliveriesData = db.selectDataFromDostawa();
        return deliveriesData;
    }
    public List<Produkt> getProductsFromTransaction(String transactionId){
        DatabaseController db = new DatabaseController();
        List<Produkt> products = db.selectProductFromTransaction(Integer.parseInt(transactionId));
        return products;
    }

    public List<String> getWarehousesNames(){
        DatabaseController db = new DatabaseController();
        List<String> warehouses = db.selectWarehousesNames();
        return warehouses;
    }

    public  List<Integer> getOrderNames(){
        DatabaseController db = new DatabaseController();
        List<Integer> orderNames = db.selectOrderNames();
        return orderNames;
    }
}
