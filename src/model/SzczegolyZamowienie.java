package model;

import java.util.Date;

public class SzczegolyZamowienie {

    int order_id;
    Boolean is_done;
    Date submission_date;
    Date suspected_realization;
    int amount;
    double cost;
    String productName;
    String clientName;
    String clientSurname;

    public SzczegolyZamowienie(int order_id, Boolean is_done, Date submission_date, Date suspected_realization, int amount, double cost, String productName, String clientName, String clientSurname) {
        this.order_id = order_id;
        this.is_done = is_done;
        this.submission_date = submission_date;
        this.suspected_realization = suspected_realization;
        this.amount = amount;
        this.cost = cost;
        this.productName = productName;
        this.clientName = clientName;
        this.clientSurname = clientSurname;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public Boolean getIs_done() {
        return is_done;
    }

    public void setIs_done(Boolean is_done) {
        this.is_done = is_done;
    }

    public Date getSubmission_date() {
        return submission_date;
    }

    public void setSubmission_date(Date submission_date) {
        this.submission_date = submission_date;
    }

    public Date getSuspected_realization() {
        return suspected_realization;
    }

    public void setSuspected_realization(Date suspected_realization) {
        this.suspected_realization = suspected_realization;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientSurname() {
        return clientSurname;
    }

    public void setClientSurname(String clientSurname) {
        this.clientSurname = clientSurname;
    }
}
