package model;

public class Produkt_hurtownia {

    int product_id;
    int wholesaler_id;

    public Produkt_hurtownia(int product_id, int wholesaler_id) {
        this.product_id = product_id;
        this.wholesaler_id = wholesaler_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getWholesaler_id() {
        return wholesaler_id;
    }

    public void setWholesaler_id(int wholesaler_id) {
        this.wholesaler_id = wholesaler_id;
    }
}
