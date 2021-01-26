package controller;

public class OknoZwrotController {

    public  String ileNaParagonie(String paragon, String produkt){
        DatabaseController db = new DatabaseController();
        int id = db.selectProductByName(produkt);
        String  amount = db.ileProduktuNaParagonie(paragon,id);
        return amount;
    }
}
