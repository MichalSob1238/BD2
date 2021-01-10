package model;

public class Szczegolowe_informacje {

    String color;
    int weight;
    String additional_informations;
    String allergens;
    String dimensions;
    int product_id;

    public Szczegolowe_informacje(String color, int weight, String additional_informations, String allergens, String dimensions, int product_id) {
        this.color = color;
        this.weight = weight;
        this.additional_informations = additional_informations;
        this.allergens = allergens;
        this.dimensions = dimensions;
        this.product_id = product_id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getAdditional_informations() {
        return additional_informations;
    }

    public void setAdditional_informations(String additional_informations) {
        this.additional_informations = additional_informations;
    }

    public String getAllergens() {
        return allergens;
    }

    public void setAllergens(String allergens) {
        this.allergens = allergens;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }
}
