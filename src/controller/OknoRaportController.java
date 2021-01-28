package controller;

import java.math.BigDecimal;

public class OknoRaportController {

    public BigDecimal getDataFromPeriodOfTime(String begin, String end){
        DatabaseController db = new DatabaseController();
        BigDecimal sum = db.getIncomeFromPeriod(begin, end);
        return sum;
    }
}
