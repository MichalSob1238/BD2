package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

public class oknoRaport extends JPanel implements ActionListener {

    private View view;

    private JLabel name;
    private JLabel zarobek;
    private JButton cofnij, zarobekOkresMiesiąc, zarobekOkresRok, getZarobekOkres5 ;

    private JLabel tytul, okresOd, okresDo;
    private GridBagLayout layout;
    private GridBagConstraints pom;

    public oknoRaport(View view) {
        this.view = view;

        layout = new GridBagLayout();
        pom = new GridBagConstraints();
        setLayout(layout);

        zarobek = new JLabel("zarobek: ");
        name = new JLabel();
        cofnij = new JButton("cofnij");
        tytul = new JLabel("Raportowanie");
        okresOd = new JLabel("okres od:");
        okresDo = new JLabel("okres do:");
        zarobekOkresMiesiąc = new JButton("Sprawdz zarobek za ostatni miesiąc");
        zarobekOkresRok = new JButton("Sprawdz zarobek za ostatni rok");
        getZarobekOkres5 = new JButton("Sprawdz zarobek za ostatnie pięć lat");

        cofnij.addActionListener(this);
        zarobekOkresMiesiąc.addActionListener(this);
        zarobekOkresRok.addActionListener(this);
        getZarobekOkres5.addActionListener(this);

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
        add(zarobekOkresMiesiąc, pom);
        add(zarobekOkresRok);
        add(getZarobekOkres5);

        pom.gridx = 2;
        add(okresOd, pom);

        pom.gridx = 4;
        add(okresDo, pom);
    }

    public void show(String nameUser){
        name.setText(nameUser);
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        JButton button = (JButton) arg0.getSource();
        if (button == cofnij) {
            view.oknoStartowe();
        } else if (button == zarobekOkresMiesiąc) {
            Calendar c = Calendar.getInstance();
            c.setTime(new Date());
            c.add(Calendar.MONTH, -1);
            System.out.println(view.getIncomeFromPeriod(new Date().toString(), c.getTime().toString()));
        } else if (button == zarobekOkresRok) {
            Calendar c = Calendar.getInstance();
            c.setTime(new Date());
            c.add(Calendar.YEAR, -1);
            System.out.println(view.getIncomeFromPeriod(new Date().toString(), c.getTime().toString()));
        }else if (button == getZarobekOkres5) {
            Calendar c = Calendar.getInstance();
            c.setTime(new Date());
            c.add(Calendar.YEAR, -5);
            System.out.println(view.getIncomeFromPeriod(new Date().toString(), c.getTime().toString()));
        }
    }




}
