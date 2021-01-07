package controller;
import controller.DatabaseController;

import com.github.javafaker.Faker;
import model.Stanowisko;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

public class DataGenerator {
    final double warehouseEmployeesRatio = 2/3;

    public void generateDaneKlienta(int clientNum){
        DatabaseController db = new DatabaseController();
        Faker faker = new Faker(new Locale("pl"));
        for (int i = 0; i < clientNum; i++){
            db.insertIntoDaneKlienta( faker.name().firstName(), faker.name().lastName(), Integer.parseInt((faker.phoneNumber().subscriberNumber(9))));
        }
    }

    public void generateStanowisko(){
        DatabaseController db = new DatabaseController();
        List<String> positions = Arrays.asList("Menedżer","Pracownik", "Pracownik Magazynier");
        for(String positon : positions){
            db.insertIntoStanowisko(positon);
        }
    }

    public void generatePracownik(int employeesNum){
        DatabaseController db = new DatabaseController();
        Faker faker = new Faker(new Locale("pl"));
        List<Stanowisko> positions = db.selectAllFromStanowisko();
        for (int i =0; i< employeesNum * warehouseEmployeesRatio; i++){
            if(!positions.isEmpty()){
            }
        }
    }
}
