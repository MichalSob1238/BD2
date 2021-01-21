package model;

public class Pozycja_dostawa {

    int amount;
    int dostawa_id;
    int product_id;

    public Pozycja_dostawa(int amount, int dostawa_id, int product_id) {
        this.amount = amount;
        this.dostawa_id = dostawa_id;
        this.product_id = product_id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getDostawa_id() {
        return dostawa_id;
    }

    public void setDostawa_id(int dostawa_id) {
        this.dostawa_id = dostawa_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }
}
