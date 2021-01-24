package model;

import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public class SzczegolyFaktura {

    int invoiceId;
    String invoiceNr;
    Date dueDate;
    Boolean ifPayed;
    String companyName;
    String companyAddress;
    String NIP;
    int transactionId;
    Date date;
    double price;
    int employeeId;

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getInvoiceNr() {
        return invoiceNr;
    }

    public void setInvoiceNr(String invoiceNr) {
        this.invoiceNr = invoiceNr;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Boolean getIfPayed() {
        return ifPayed;
    }

    public void setIfPayed(Boolean ifPayed) {
        this.ifPayed = ifPayed;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getNIP() {
        return NIP;
    }

    public void setNIP(String NIP) {
        this.NIP = NIP;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public SzczegolyFaktura(int invoiceId, String invoiceNr, Date dueDate, Boolean ifPayed, String companyName, String companyAddress, String NIP, int transactionId, Date date, double price, int employeeId) {
        this.invoiceId = invoiceId;
        this.invoiceNr = invoiceNr;
        this.dueDate = dueDate;
        this.ifPayed = ifPayed;
        this.companyName = companyName;
        this.companyAddress = companyAddress;
        this.NIP = NIP;
        this.transactionId = transactionId;
        this.date = date;
        this.price = price;
        this.employeeId = employeeId;
    }
}
