package model;

public class Produkt {

    int id;
    String name;
    float cost;
    int category_id;

    public Produkt(int id, String name, float cost, int category_id) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.category_id = category_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }
}
