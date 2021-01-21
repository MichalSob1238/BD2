package model;

public class Stanowisko {
    public static enum positions{
        Menadżer,Pracownik, Pracownik_Magazynier
    }
    int id;
    String name;

    public Stanowisko(int id, String name) {
        this.id = id;
        this.name = name;
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
}