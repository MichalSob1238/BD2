package controller;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class OknoZwrotController {

    public  String ileNaParagonie(String paragon, String produkt){
        DatabaseController db = new DatabaseController();
        int id = db.selectProductByName(produkt);
        String  amount = db.ileProduktuNaParagonie(paragon,id);
        return amount;
    }
    public String kwotaDoZwrotu (int ilosc, String paragon, String produkt){
        DatabaseController db = new DatabaseController();
        int id = db.selectProductByName(produkt);
        String tab[] = {produkt};
        BigDecimal kwota =db.sumProducts(tab);
        String kwotaToString = kwota.setScale(2, RoundingMode.HALF_UP).toString();
        return kwotaToString;

    }

    public void wykonajZwrot(String iloscZwrot, String paragon, String maxIlosc, String produkt) {
        DatabaseController db = new DatabaseController();
        db.wykonajZwrot(iloscZwrot,paragon,maxIlosc, produkt);
    }
}
