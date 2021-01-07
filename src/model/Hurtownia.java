package model;

public class Hurtownia {

    int id;
    String name;
    String contactString;

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

    public String getContactString() {
        return contactString;
    }

    public void setContactString(String contactString) {
        this.contactString = contactString;
    }

    public Hurtownia(int id, String name, String contactString) {
        this.id = id;
        this.name = name;
        this.contactString = contactString;
    }
}
