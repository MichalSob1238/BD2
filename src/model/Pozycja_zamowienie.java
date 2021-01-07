package model;

public class Pozycja_zamowienia {

    int amount;
    float cost;
    int order_id;
    int product_id;

    public Pozycja_zamowienia(int amount, float cost, int order_id, int product_id) {
        this.amount = amount;
        this.cost = cost;
        this.order_id = order_id;
        this.product_id = product_id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }
}
