package controller;

import java.math.BigDecimal;

public class OknoRaportyController {

    public BigDecimal pobierzZarobek(String data_od, String data_do){
        DatabaseController db = new DatabaseController();
        BigDecimal zarobek = db.getIncomeFromPeriod(data_od, data_do);
        return  zarobek;
    }
}
