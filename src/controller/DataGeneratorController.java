package controller;

import com.github.javafaker.Faker;
import model.*;
import org.apache.commons.lang3.Pair;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class DataGeneratorController {
        final int MAXIMUMTRANSACTION = 15;
        final int MAXIMUMDETAILQUANTITY = 3;
        //
        final double EMAILONLY = 0.6;
        final double PHONENUMBERONLY = 0.3;
        final double NOTPAYED = 0.9;
        //
        final int MINIMUMDELIVERYPRODUCTS = 10;
        final int MAXIMUMDELIVERYPRODUCTS = 20;
        final int MAXIMUMQUANTITYDELIVERY = 10;
        //
        final double ORDERCOMPLETION = 0.8;
        //
        final double MINIMUMPRODUCTCOST = 10;
        final double MAXIMUMPRODUCTCOST = 500;
        //
        final int MAXIMUMQUANTITY = 10;
        final int MAXIMUMPRODUCTSTOREHOUSE = 50;
        //
        final int ALLEYSNUMBER = 8;
        final int SHELVESNUMBER = 20;

    public void generateDaneKlienta(int clientNum){
        DatabaseController db = new DatabaseController();
        Faker faker = new Faker(new Locale("pl"));
        for (int i = 0; i < clientNum; i++){
            db.insertIntoDaneKlienta( faker.name().firstName(), faker.name().lastName(), Integer.parseInt((faker.phoneNumber().subscriberNumber(9))));
        }
    }

    public void generateStanowisko(){
        DatabaseController db = new DatabaseController();
        List<String> positions = Arrays.asList("Menadżer","Pracownik", "Pracownik Magazynier");
        for(String positon : positions){
            db.insertIntoStanowisko(positon);
        }
    }

    public void generatePracownik(int employeesNum) throws Exception {
        DatabaseController db = new DatabaseController();
        Faker faker = new Faker(new Locale("pl"));
        List<Stanowisko> positions = db.selectAllFromStanowisko();
        if(!positions.isEmpty()){
            for(int i = 0; i< employeesNum; i++){
                Stanowisko nextPosition = positions.get(ThreadLocalRandom.current().nextInt(0, positions.size()));
                while(nextPosition.getId() == 1)
                    nextPosition = positions.get(ThreadLocalRandom.current().nextInt(0, positions.size()));
                db.insertIntoPracownik(faker.name().firstName(), faker.name().lastName(), nextPosition.getId());
            }
            db.insertIntoPracownik(faker.name().firstName(), faker.name().lastName(),1);
        } else {
            throw new Exception("No positions in database!");
        }

    }

    public void generateTransport(int transportsNum){
        DatabaseController db = new DatabaseController();
        List<Pracownik> employees = db.selectAllFromPracownik();
        List<Produkt> products = db.selectAllFromProdukt();
        Faker faker = new Faker(new Locale("pl"));
        for(int i = 0; i < transportsNum; i++){
            Pracownik employee = employees.get(ThreadLocalRandom.current().nextInt(0, employees.size()));
            int transportId = db.insertIntoTransport(faker.date().past(1000, TimeUnit.DAYS), employee.getId());
            int quantity = ThreadLocalRandom.current().nextInt(MINIMUMDELIVERYPRODUCTS, MAXIMUMDELIVERYPRODUCTS);
            for (int j = 0; j<quantity; j++){
                int productQuantity = ThreadLocalRandom.current().nextInt(1, MAXIMUMQUANTITYDELIVERY);
                db.insertIntoPozycjaTransport(productQuantity,
                        transportId, products.get(ThreadLocalRandom.current().nextInt(1, products.size())).getId());
            }
        }
    }

    public void generateTransakcja(int transactionNum){
        DatabaseController db = new DatabaseController();
        List<Pracownik> employees = db.selectAllFromPracownik();
        List<Produkt> products = db.selectAllFromProdukt();
        Faker faker = new Faker(new Locale("pl"));
        for(int i = 0; i < transactionNum; i++){
            double sum =0;
            int quantity = ThreadLocalRandom.current().nextInt(1, MAXIMUMTRANSACTION);
            Map<Integer, Pair<Integer,Double>> productIds = new TreeMap<>();
            for(int j =0; j < quantity; j++){
                int productQuantity = ThreadLocalRandom.current().nextInt(1, MAXIMUMDETAILQUANTITY);
                Produkt product = products.get(ThreadLocalRandom.current().nextInt(1, products.size()));
                sum += productQuantity * product.getCost();
                productIds.put(product.getId(), new Pair<>(productQuantity, product.getCost()));
            }
            Pracownik employee = employees.get(ThreadLocalRandom.current().nextInt(0, employees.size()));
            Transakcja.transactionType type = Transakcja.randomTransactionType();
            Date transactionDate = faker.date().past(1000, TimeUnit.DAYS);
            int transactionId = db.insertIntoTransakcja(transactionDate, sum, employee.getId(), type);
            System.out.println(transactionId);
            for(Integer product: productIds.keySet()){
                db.insertIntoPozycjaParagon(productIds.get(product).left, productIds.get(product).right, transactionId, product);
            }
            if(type == Transakcja.transactionType.FAKTURA){
                generateFaktura(transactionId, transactionDate);
            }
        }
    }

    public void generateHurtownia(int warehouseNum){
        DatabaseController db = new DatabaseController();
        Faker faker = new Faker(new Locale("pl"));
        String contact;
        for (int i=0; i< warehouseNum; i++){
            double random = ThreadLocalRandom.current().nextDouble(0, 1);
            if(random < PHONENUMBERONLY)
                contact = faker.phoneNumber().subscriberNumber(9);
            else if(random > EMAILONLY)
                contact = faker.internet().safeEmailAddress();
            else
                contact = faker.phoneNumber().subscriberNumber(9) + " " + faker.internet().safeEmailAddress();
            db.insertIntoHurtownia(faker.company().name(), contact);
        }
    }

    public void generateFaktura(int transactionId, Date transactionDate){
        DatabaseController db = new DatabaseController();
        Faker faker = new Faker(new Locale("pl"));
        List<Transakcja> transactions = db.selectFakturaOnlyFromTransakcja();
        Calendar calendar = Calendar.getInstance();
            calendar.setTime(transactionDate);
            double random = ThreadLocalRandom.current().nextDouble(0, 1);
            boolean ifPayed;
            if(random >= NOTPAYED)
                ifPayed = false;
            else
                ifPayed = true;
            String invoiceNr = transactionId + "/" + (calendar.get(Calendar.MONTH)+1) + "/" + calendar.get(Calendar.YEAR);
            db.insertIntoFaktura(invoiceNr, faker.date().between(transactionDate, new Date()), ifPayed,
                    faker.company().name(), faker.address().fullAddress(), Faktura.generateNIP(), transactionId);
    }

    public void generateDostawa(int deliveriesNum) throws SQLException {
        DatabaseController db = new DatabaseController();
        Faker faker = new Faker(new Locale("pl"));
        List<Pracownik> employees= db.selectAllFromPracownik();
        List<Hurtownia> warehouses = db.selectAllFromHurtownia();
        List<Produkt> products = db.selectAllFromProdukt();
        for(int i=0; i< deliveriesNum; i++){
            int quantity = ThreadLocalRandom.current().nextInt(MINIMUMDELIVERYPRODUCTS, MAXIMUMDELIVERYPRODUCTS);
            double sum = 0;
            Map<Integer, Integer> productIds = new TreeMap<>();
            for(int j = 0; j< quantity; j++){
                int productQuantity = ThreadLocalRandom.current().nextInt(1, MAXIMUMQUANTITYDELIVERY);
                Produkt product  = products.get(ThreadLocalRandom.current().nextInt(0, products.size()));
                sum += product.getCost() * productQuantity;
                productIds.put(product.getId(),productQuantity);
            }
            int deliveryId = db.insertIntoDostawa(faker.date().past(1000, TimeUnit.DAYS), sum,
                    warehouses.get(ThreadLocalRandom.current().nextInt(0, warehouses.size())).getId(),
                    employees.get(ThreadLocalRandom.current().nextInt(0, employees.size())).getId());
            for (int productId: productIds.keySet()) {
                db.insertIntoPozycjaDostawa(productIds.get(productId), deliveryId, productId);
            }
        }
    }
    public void generateZamowienie(int ordersNum){
        DatabaseController db = new DatabaseController();
        Faker faker = new Faker(new Locale("pl"));
        List<DaneKlienta> clients = db.selectAllFromDaneKlienta();
        List<Transakcja> transactions = db.selectAllFromTransakcja();
        for (int i =0; i< ordersNum; i++){
            double random = ThreadLocalRandom.current().nextDouble(0, 1);
            int transactionRandom = ThreadLocalRandom.current().nextInt(0, transactions.size());
            boolean ifCompleted;
            if(random < ORDERCOMPLETION)
                ifCompleted = true;
            else
                ifCompleted = false;
            db.insertIntoZamowienie(ifCompleted, transactions.get(transactionRandom).getDate(),
                    faker.date().between(transactions.get(transactionRandom).getDate(), new Date()),
                    clients.get( ThreadLocalRandom.current().nextInt(0, clients.size())).getId());
        }
    }

    public void generateKategoria(){
        DatabaseController db = new DatabaseController();
        List<Kategoria.category> categories = Kategoria.getCategory();
        for (Kategoria.category category : categories) {
            db.insertIntoKategoria(category.toString());
        }
    }

    public void generateProdukt(){
        DatabaseController db = new DatabaseController();
        List<Produkt.animal> animals = Produkt.getAnimals();
        List<Produkt.productType> products = Produkt.getProductTypes();
        Map<Produkt.productType, Kategoria.category> mappedProducts = Produkt.getMappedProductTypes();
        List<Kategoria> categories = db.selectAllFromKategoria();
        for (Produkt.productType product : products) {
            Kategoria.category cat = mappedProducts.get(product);
            int categoryId = categories.stream()
                    .filter(item -> item.getName().toString().equals(cat.toString()))
                    .findAny()
                    .orElse(null).getId();
            for(Produkt.animal animal : animals){
                int quantity = ThreadLocalRandom.current().nextInt(3, MAXIMUMQUANTITY);
                for(int i =1; i < quantity+1; i++){
                    String name = String.valueOf(product).replaceAll("_", " ") + " "
                            + String.valueOf(animal).replaceAll("_", " ") + " " + i;
                    db.insertIntoProdukt(name,
                            ThreadLocalRandom.current().nextDouble(MINIMUMPRODUCTCOST,MAXIMUMPRODUCTCOST),
                            categoryId);
                }
            }
        }
    }

    public void generateProduktHurtownia(){
        DatabaseController db = new DatabaseController();
        List<Produkt> products = db.selectAllFromProdukt();
        List<Hurtownia> warehouses = db.selectAllFromHurtownia();
        for (Produkt product: products) {
            int randomIndex = ThreadLocalRandom.current().nextInt(0, warehouses.size());
            db.insertIntoProduktHurtownia(product.getId(), warehouses.get(randomIndex).getId());
        }
    }

    public void generateMagazyn(){
        DatabaseController db = new DatabaseController();
        List<Produkt> products = db.selectAllFromProdukt();
        for (Produkt product: products) {
            int quantity = ThreadLocalRandom.current().nextInt(0, MAXIMUMPRODUCTSTOREHOUSE);
            db.insertIntoMagazyn(quantity, ThreadLocalRandom.current().nextInt(0, ALLEYSNUMBER),
                    ThreadLocalRandom.current().nextInt(0, SHELVESNUMBER), product.getId());
        }
    }

    public void generateSklep(){
        DatabaseController db = new DatabaseController();
        List<Produkt> products = db.selectAllFromProdukt();
        for (Produkt product: products) {
            int quantity = ThreadLocalRandom.current().nextInt(0, 5);
            db.insertIntoSklep(quantity,product.getId());
        }
    }

}

