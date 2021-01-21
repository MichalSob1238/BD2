import controller.Controller;
import controller.DataGeneratorController;
import controller.DatabaseController;
import model.Model;
import model.Pracownik;
import view.View;

import java.awt.EventQueue;
import java.io.IOException;

public class SklepZoologiczny {
    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Model model = new Model();
               /* try {
                    //DatabaseController.initialize();
                    DataGeneratorController gen = new DataGeneratorController();
                    //gen.generateDaneKlienta(100);
                    //gen.generateStanowisko();
                    //gen.generatePracownik(40);
                    //gen.generateTransport(67);
                    //gen.generateTransakcja(1000);
                    //gen.generateHurtownia(17);
                    //gen.generateFaktura();
                    //gen.generateDostawa(100);
                    //gen.generateZamowienie(370);
                    //gen.generateKategoria();
                    //gen.generateProdukt();
                    //gen.generateProduktHurtownia();
                    //gen.generateMagazyn();
                    //gen.generateSklep();
                    //gen.generateSzczegoloweInformacje();
                    DatabaseController db = new DatabaseController();
                    Pracownik employee = db.selectPracownik("Magdalena", "Majkowska");
                    System.out.println(employee!= null);
                    employee = db.selectPracownik("IZABELA", "TKACZYK");
                    System.out.println(employee!= null);
                    employee = db.selectPracownik("IzABeLa", "TkACzYk");
                    System.out.println(employee!= null);
                    employee = db.selectPracownik("izabela", "tkaczyk");
                    System.out.println(employee!= null);
                } catch (Exception e) {
                    e.printStackTrace();
                }*/
                View view = new View();
                Controller controller = new Controller(model, view);
            }
        });

    }
}
