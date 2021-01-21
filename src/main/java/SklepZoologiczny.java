import com.mysql.cj.x.protobuf.Mysqlx;
import controller.*;
import model.Model;
import model.Pracownik;
import view.View;

import java.awt.EventQueue;
import java.io.IOException;
import java.util.List;

public class SklepZoologiczny {
    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Model model = new Model();
//               try {
//                    //DatabaseController.initialize();
//                    DataGeneratorController gen = new DataGeneratorController();
//                    //gen.generateDaneKlienta(100);
//                    //gen.generateStanowisko();
//                    //gen.generatePracownik(40);
//                    //gen.generateTransport(67);
//                    //gen.generateTransakcja(1000);
//                    //gen.generateHurtownia(17);
//                    //gen.generateFaktura();
//                    //gen.generateDostawa(100);
//                    //gen.generateZamowienie(370);
//                    //gen.generateKategoria();
//                    //gen.generateProdukt();
//                    //gen.generateProduktHurtownia();
//                    //gen.generateMagazyn();
//                    //gen.generateSklep();
//                    //gen.generateSzczegoloweInformacje();
//                    DatabaseController db = new DatabaseController();
//                   OknoLogowaniaController controler = new OknoLogowaniaController();
//                    Pracownik employee = null;
//                    employee = db.selectPracownik("Olimpia", "Szczepaniak");
//                    System.out.println(controler.checkIfEmployeeIsManager(employee));
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
                View view = new View();
                Controller controller = new Controller(model, view);
            }
        });

    }
}
