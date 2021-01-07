import controller.DataGenerator;
import controller.DatabaseController;
import model.Model;
import controller.DatabaseController;
import view.View;

import java.awt.EventQueue;
import java.io.IOException;

public class SklepZoologiczny {
    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Model model = new Model();
                try {
                    DatabaseController.initialize();
                    DataGenerator gen = new DataGenerator();
                    gen.generateDaneKlienta(100);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
