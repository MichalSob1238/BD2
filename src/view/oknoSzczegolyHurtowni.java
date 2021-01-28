package view;

import model.Hurtownia;
import model.Szczegolowe_informacje;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class oknoSzczegolyHurtowni extends JPanel implements ActionListener {

    private View view;

    private JLabel name;
    private JButton cofnij;

    private JLabel tytul;
    private JLabel id;
    private JLabel nazwa;
    private JLabel kontakt;


    private GridBagLayout layout;
    private GridBagConstraints pom;

    public oknoSzczegolyHurtowni(View view) {

        this.view = view;
        layout = new GridBagLayout();
        pom = new GridBagConstraints();
        setLayout(layout);

        name = new JLabel();
        cofnij = new JButton("cofnij");
        cofnij.addActionListener(this);
        tytul = new JLabel("Szczegolowe informacje:");

        id = new JLabel();
        nazwa = new JLabel();
        kontakt = new JLabel();



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
        add(id, pom);

        pom.gridy = 3;
        add(nazwa, pom);

        pom.gridy = 4;
        add(kontakt, pom);

    }

    public void show(String nameUser, Hurtownia szczegol) {
        name.setText(nameUser);

        id.setText("id: " + szczegol.getId());
        nazwa.setText("nazwa: " + szczegol.getName());
        kontakt.setText("kontakt: " + szczegol.getContactString());

    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub
        JButton button = (JButton) arg0.getSource();
        if (button == cofnij) {
            view.wybranoHurtownia();
        }
    }
}

