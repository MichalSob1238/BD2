package model;

import java.util.Date;

public class Dostawa {

    int id;
    Date delivery_date;
    float price;
    int wholesaler_id;
    int worker_id;

    public Dostawa(int id, Date delivery_date, float price, int wholesaler_id, int worker_id) {
        this.id = id;
        this.delivery_date = delivery_date;
        this.price = price;
        this.wholesaler_id = wholesaler_id;
        this.worker_id = worker_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDelivery_date() {
        return delivery_date;
    }

    public void setDelivery_date(Date delivery_date) {
        this.delivery_date = delivery_date;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getWholesaler_id() {
        return wholesaler_id;
    }

    public void setWholesaler_id(int wholesaler_id) {
        this.wholesaler_id = wholesaler_id;
    }

    public int getWorker_id() {
        return worker_id;
    }

    public void setWorker_id(int worker_id) {
        this.worker_id = worker_id;
    }
}

