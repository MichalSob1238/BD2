package model;

public class Pozycja_transport {

    int amount;
    int transport_id;
    int product_id;

    public Pozycja_transport(int amount, int transport_id, int product_id) {
        this.amount = amount;
        this.transport_id = transport_id;
        this.product_id = product_id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getTransport_id() {
        return transport_id;
    }

    public void setTransport_id(int transport_id) {
        this.transport_id = transport_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }
}
