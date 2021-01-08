package model;

import model.Kategoria.category;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static java.util.Map.entry;

public class Produkt {
    public static enum animal{
        PIES, KOT, KAWIA_DOMOWA, MYSZ, CHOMIK, KRÓLIK, SZYNSZYLA, SZCZUR, FRETKA, KOSZATNICZKA
    }
    public static enum productType{
        KARMA_MOKRA, KARMA_SUCHA, PRZYSMAK, MISKA, TRANSPORTER, ŻWIREK, KUWETA, DRAPAK, LEGOWISKO, SZCZOTKA, SZAMPON,
        SZELKI, UBRANKO, KOJEC, ZABAWKA
    }

    public static Map<productType, category> mappedProductTypes =  Map.ofEntries(
            entry(productType.KARMA_MOKRA, category.POŻYWIENIE),
            entry(productType.KARMA_SUCHA, category.POŻYWIENIE),
            entry(productType.PRZYSMAK, category.POŻYWIENIE),
            entry(productType.MISKA, category.AKCESORIA),
            entry(productType.TRANSPORTER, category.AKCESORIA),
            entry(productType.ŻWIREK, category.HIGIENA),
            entry(productType.KUWETA, category.HIGIENA),
            entry(productType.DRAPAK, category.AKCESORIA),
            entry(productType.LEGOWISKO, category.AKCESORIA),
            entry(productType.SZCZOTKA, category.HIGIENA),
            entry(productType.SZAMPON, category.HIGIENA),
            entry(productType.SZELKI, category.AKCESORIA),
            entry(productType.UBRANKO, category.AKCESORIA),
            entry(productType.KOJEC, category.AKCESORIA),
            entry(productType.ZABAWKA, category.ZABAWKI)
    );

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

    public static List<animal> getAnimals(){
        List<animal> values = Arrays.asList(animal.values());
        return values;
    }
    public static List<productType> getProductTypes(){
        List<productType> values = Arrays.asList(productType.values());
        return values;
    }

    public static Map<productType, category> getMappedProductTypes(){
        return mappedProductTypes;
    }
}
