package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class oknoRaport extends JPanel implements ActionListener {

    private View view;

    private JLabel name;
    private JLabel zarobek;
    private JButton cofnij, zarobekOkresMiesiąc, zarobekOkresRok, getZarobekOkres5,zarobekOkresKwartał ;

    private JLabel tytul, wynik, sum;
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
        wynik = new JLabel("Wynik:");
        sum = new JLabel("");
        zarobekOkresMiesiąc = new JButton("Sprawdz zarobek za ostatni miesiąc");
        zarobekOkresKwartał = new JButton("Sprawdz zarobek za ostatni kwartał");
        zarobekOkresRok = new JButton("Sprawdz zarobek za ostatni rok");
        getZarobekOkres5 = new JButton("Sprawdz zarobek za ostatnie pięć lat");

        cofnij.addActionListener(this);
        zarobekOkresMiesiąc.addActionListener(this);
        zarobekOkresRok.addActionListener(this);
        getZarobekOkres5.addActionListener(this);
        zarobekOkresKwartał.addActionListener(this);

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
        pom.gridy =3;
        add(zarobekOkresKwartał,pom);
        pom.gridy =4;
        add(zarobekOkresRok, pom);
        pom.gridy =5;
        add(getZarobekOkres5, pom);

        pom.gridx=2;
        pom.gridy =6;
        add(wynik, pom);
        pom.gridx =3;
        add(sum,pom);
    }

    public void show(String nameUser, String sum1){
        name.setText(nameUser);
        sum.setText(sum1);
    }


    @Override
    public void actionPerformed(ActionEvent arg0) {
        try{
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        JButton button = (JButton) arg0.getSource();
        if (button == cofnij) {
            view.oknoStartowe();
        } else if (button == zarobekOkresMiesiąc) {
            Calendar c = Calendar.getInstance();
            c.setTime(new Date());
            c.add(Calendar.MONTH, -1);
            view.getIncomeFromPeriod(formatter.format(c.getTime()).toString(),
                    formatter.format(new Date()).toString());
        }else if (button == zarobekOkresKwartał) {
            Calendar c = Calendar.getInstance();
            c.setTime(new Date());
            c.add(Calendar.MONTH, -3);
            view.getIncomeFromPeriod(formatter.format(c.getTime()).toString(),
                    formatter.format(new Date()).toString());
        } else if (button == zarobekOkresRok) {
            Calendar c = Calendar.getInstance();
            c.setTime(new Date());
            c.add(Calendar.YEAR, -1);
            view.getIncomeFromPeriod(formatter.format(c.getTime()).toString(),
                    formatter.format(new Date()).toString());
        }else if (button == getZarobekOkres5) {
            Calendar c = Calendar.getInstance();
            c.setTime(new Date());
            c.add(Calendar.YEAR, -5);
            view.getIncomeFromPeriod(formatter.format(c.getTime()).toString(),
                    formatter.format(new Date()).toString());
        }
        }catch(Exception e){
            e.printStackTrace();
        }
    }


}
