import model.Model;
import controller.Controller;
import view.View;

import java.awt.EventQueue;

public class SklepZoologiczny {
    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Model model = new Model();
                View viev = new View();
                //Controller controller = new Controller();
            }
        });

    }
}
