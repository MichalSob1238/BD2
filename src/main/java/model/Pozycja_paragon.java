package model;

public class Pozycja_paragon {

    int amount;
    float unit_price;
    int transaction_id;
    int product_id;

    public Pozycja_paragon(int amount, float unit_price, int transaction_id, int product_id) {
        this.amount = amount;
        this.unit_price = unit_price;
        this.transaction_id = transaction_id;
        this.product_id = product_id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public float getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(float unit_price) {
        this.unit_price = unit_price;
    }

    public int getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(int transaction_id) {
        this.transaction_id = transaction_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }
}
