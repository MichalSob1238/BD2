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

public class DataGeneratorController {

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

}

