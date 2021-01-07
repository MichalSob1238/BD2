package model;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Transakcja {
    public enum transactionType{
        PARAGON,
        FAKTURA
    }

    int id;
    Date date;
    double amount;
    int employeeId;
    transactionType type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public static transactionType randomTransactionType(){
        List<transactionType> values = Arrays.asList(transactionType.values());
        int random = ThreadLocalRandom.current().nextInt(0, values.size());
        return values.get(random);
    }
    public void setType(transactionType type) {
        this.type = type;
    }

    public Transakcja(int id, Date date, double amount, int employeeId, transactionType type) {
        this.id = id;
        this.date = date;
        this.amount = amount;
        this.employeeId = employeeId;
        this.type = type;
    }

}
