package view;

import javax.swing.*;
import java.awt.*;

public class View {
    static glowneOkno wsk = new glowneOkno();
    public static void main(){
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run(){



                //tu wstawiæ funkcjê, która tworzy odpowiednie okno

                //wsk.view.oknoLogowania(true);
                wsk.setName("Nazwisko i Imie");
                wsk.oknoStartowe(true);
                String tab[] = {"produkt1", "produkt2", "produkt3", "produkt4", "produkt5", "produkt6", "produkt7", "produkt8"};
                String tab1[] = {"produkt1", "produkt2"};
                //wsk.view.oknoLista("oferta", tab, "szczegoly");
                //wsk.view.oknoZwrotu();

                wsk.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                wsk.setVisible(true);
            }
        });
    }

}
