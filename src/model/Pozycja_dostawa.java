package model;

public class Pozycja_dostawa {

    int amound;
    int dostawa_id;
    int product_id;

    public Pozycja_dostawa(int amound, int dostawa_id, int product_id) {
        this.amound = amound;
        this.dostawa_id = dostawa_id;
        this.product_id = product_id;
    }

    public int getAmound() {
        return amound;
    }

    public void setAmound(int amound) {
        this.amound = amound;
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
