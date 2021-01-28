package view;

import model.Szczegolowe_informacje;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class oknoSzczegolyProdukt extends JPanel implements ActionListener {

    private View view;

    private JLabel name;
    private JButton cofnij;

    private JLabel tytul;
    private JLabel kolor;
    private JLabel waga;
    private JLabel dodatkowe_informacje;
    private JLabel alergeny;
    private JLabel wymiary;
    private JButton zamowienie;

    private GridBagLayout layout;
    private GridBagConstraints pom;
    private int id;

    public oknoSzczegolyProdukt(View view) {

        this.view = view;
        layout = new GridBagLayout();
        pom = new GridBagConstraints();
        setLayout(layout);

        name = new JLabel();
        cofnij = new JButton("cofnij");
        cofnij.addActionListener(this);
        tytul = new JLabel("Szczegolowe informacje:");

        kolor = new JLabel();
        waga = new JLabel();
        dodatkowe_informacje = new JLabel();
        alergeny = new JLabel();
        wymiary = new JLabel();
        zamowienie = new JButton("Zamow");
        zamowienie.addActionListener(this);

        pom.insets = new Insets(0, 0, 20, 50);
        pom.gridx = 0;
        pom.gridy = 0;
        add(cofnij, pom);

        pom.insets = new Insets(0, 30, 20, 0);
        pom.gridx = 2;
        add(name, pom);

        pom.insets = new Insets(0, 0, 10, 0);
        pom.gridy = 1;
        pom.gridx = 0;
        pom.gridwidth = 3;
        add(tytul, pom);

        pom.insets = new Insets(0, 0, 0, 0);
        pom.gridy = 2;
        pom.gridwidth = 2;
        add(kolor, pom);

        pom.gridy = 3;
        add(waga, pom);

        pom.gridy = 4;
        add(dodatkowe_informacje, pom);

        pom.gridy = 5;
        add(alergeny, pom);

        pom.gridy = 6;
        add(wymiary, pom);
        
        pom.gridx = 2;
        pom.gridy = 5;
        add(zamowienie, pom);
        
    }

    public void show(String nameUser, Szczegolowe_informacje szczegol) {
        name.setText(nameUser);
        id = szczegol.getProduct_id();
        kolor.setText("kolor: " + szczegol.getColor());
        waga.setText("waga: " + Integer.toString(szczegol.getWeight()));
        dodatkowe_informacje.setText("dodatkowy opis: " + szczegol.getAdditional_informations());
        alergeny.setText("alergeny: " + szczegol.getAllergens());
        wymiary.setText("wymiary: " + szczegol.getDimensions());
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub
        JButton button = (JButton) arg0.getSource();
        if (button == cofnij) {
            view.wybranoOferte();
        }else if(button == zamowienie) {
        	view.wybranoZamowienieDetaliczne(id);
        }
    }
}

