package model;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Kategoria {

    public enum category{
        POŻYWIENIE,
        AKCESORIA,
        ZABAWKI,
        HIGIENA,
        INNE;

    }

    int id;
    category name;

    public category getName() {
        return name;
    }

    public void setName(category name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Kategoria(int id, category name) {
        this.id = id;
        this.name = name;
    }

    public static List<Kategoria.category> getCategory(){
        List<Kategoria.category> values = Arrays.asList(Kategoria.category.values());
        return values;
    }
}
