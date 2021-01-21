package model;

public class Magazyn {

    int amount;
    int shelf_id;
    int aisle_id;
    int product_id;

    public Magazyn(int amount, int shelf_id, int aisle_id, int product_id) {
        this.amount = amount;
        this.shelf_id = shelf_id;
        this.aisle_id = aisle_id;
        this.product_id = product_id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getShelf_id() {
        return shelf_id;
    }

    public void setShelf_id(int shelf_id) {
        this.shelf_id = shelf_id;
    }

    public int getAisle_id() {
        return aisle_id;
    }

    public void setAisle_id(int aisle_id) {
        this.aisle_id = aisle_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }
}
