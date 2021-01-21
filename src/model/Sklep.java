package model;

public class Sklep {

    int amount;
    int product_id;

    public Sklep(int amount, int product_id) {
        this.amount = amount;
        this.product_id = product_id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }
}
