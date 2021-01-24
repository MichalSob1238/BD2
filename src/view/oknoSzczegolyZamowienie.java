package view;

import model.Faktura;
import model.SzczegolyZamowienie;

import java.util.List;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormat;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class oknoSzczegolyZamowienie extends JPanel implements ActionListener{

    private View view;

    private int index;
    private SzczegolyZamowienie[] tab;

    private JLabel name;
    private JLabel tytul;
    private JButton cofnij;

    private JLabel order_id;
    private JLabel is_done;
    private JLabel submission_date;
    private JLabel suspected_realization;
    private JLabel amount;
    private JLabel cost;
    private JLabel productName;
    private JLabel clientName;
    private JLabel clientSurname;

    private JLabel poz1, poz2, poz3, poz0;
    private JLabel naz1, naz2, naz3, naz0;
    private JLabel ilosc1, ilosc2, ilosc3, ilosc0;
    private JLabel cena1, cena2, cena3, cena0;

    private JButton next, prev;
    private JLabel strona;

    private GridBagLayout layout;
    private GridBagConstraints pom;

    public oknoSzczegolyZamowienie(View view){

        this.view = view;
        layout = new GridBagLayout();
        pom = new GridBagConstraints();
        setLayout(layout);

        name = new JLabel();
        cofnij = new JButton("cofnij");
        cofnij.addActionListener(this);
        tytul = new JLabel("Szczegoly Rezerwacji:");


        index = 1;

        order_id = new JLabel();
        is_done = new JLabel();
        submission_date = new JLabel();
        suspected_realization = new JLabel();
        amount = new JLabel();
        cost = new JLabel();
        productName = new JLabel();
        clientName = new JLabel();
        clientSurname = new JLabel();

        next = new JButton("next");
        next.addActionListener(this);
        prev = new JButton("prev");
        prev.addActionListener(this);
        strona = new JLabel();

        naz0 = new JLabel("nazwa");
        naz1 = new JLabel();
        naz2 = new JLabel();
        naz3 = new JLabel();

        poz0 = new JLabel("poz.");
        poz1 = new JLabel();
        poz2 = new JLabel();
        poz3 = new JLabel();

        ilosc0 = new JLabel("ilosc");
        ilosc1 = new JLabel();
        ilosc2 = new JLabel();
        ilosc3 = new JLabel();

        cena0 = new JLabel("cena/szt.");
        cena1 = new JLabel();
        cena2 = new JLabel();
        cena3 = new JLabel();

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
        pom.gridwidth = 1;
        add(poz0, pom);

        pom.gridy = 3;
        add(poz1, pom);

        pom.gridy = 4;
        add(poz2, pom);

        pom.gridy = 5;
        add(poz3, pom);

        pom.gridy = 2;
        pom.gridx = 2;
        pom.gridwidth = 1;
        add(ilosc0, pom);

        pom.gridy = 3;
        add(ilosc1, pom);

        pom.gridy = 4;
        add(ilosc2, pom);

        pom.gridy = 5;
        add(ilosc3, pom);

        pom.gridy = 2;
        pom.gridx = 3;
        pom.gridwidth = 1;
        add(cena0, pom);

        pom.gridy = 3;
        add(cena1, pom);

        pom.gridy = 4;
        add(cena2, pom);

        pom.gridy = 5;
        add(cena3, pom);

        pom.gridy = 2;
        pom.gridx = 4;
        pom.gridwidth = 2;
        add(naz0, pom);

        pom.gridy = 3;
        add(naz1, pom);

        pom.gridy = 4;
        add(naz2, pom);

        pom.gridy = 5;
        add(naz3, pom);


        pom.insets = new Insets(20, 0, 0, 0);
        pom.gridy = 6;

        pom.gridx = 0;
        add(prev, pom);

        pom.gridx = 1;
        add(strona, pom);

        pom.gridx = 3;
        add(next, pom);


    }

    public void show(String nameUser, SzczegolyZamowienie[] tabArg) {
        name.setText(nameUser);
        index = 1;

        tytul.setText("Rezerwacja: " + Integer.toString(tabArg[0].getOrder_id()));
        tab = tabArg;
        int iloscStron = tabArg.length / 3;
        if(tabArg.length % 3 != 0) {
            iloscStron += 1;
        }
        if(tabArg.length == 1) {
            poz1.setText(Integer.toString(index));
            naz1.setText(tabArg[0].getProductName());
            ilosc1.setText(Integer.toString(tabArg[0].getAmount()));
            cena1.setText(Double.toString(tabArg[0].getCost()));

        }else if(tabArg.length == 2) {
            poz1.setText(Integer.toString(index));
            naz1.setText(tabArg[0].getProductName());
            ilosc1.setText(Integer.toString(tabArg[0].getAmount()));
            cena1.setText(Double.toString(tabArg[0].getCost()));
            poz2.setText(Integer.toString(index+1));
            naz2.setText(tabArg[1].getProductName());
            ilosc2.setText(Integer.toString(tabArg[1].getAmount()));
            cena2.setText(Double.toString(tabArg[1].getCost()));

        }else if(tabArg.length >= 3) {
            poz1.setText(Integer.toString(index));
            naz1.setText(tabArg[0].getProductName());
            ilosc1.setText(Integer.toString(tabArg[0].getAmount()));
            cena1.setText(Double.toString(tabArg[0].getCost()));

            poz2.setText(Integer.toString(index+1));
            naz2.setText(tabArg[1].getProductName());
            ilosc2.setText(Integer.toString(tabArg[1].getAmount()));
            cena2.setText(Double.toString(tabArg[1].getCost()));

            poz3.setText(Integer.toString(index+2));
            naz3.setText(tabArg[2].getProductName());
            ilosc3.setText(Integer.toString(tabArg[2].getAmount()));
            cena3.setText(Double.toString(tabArg[2].getCost()));
        }
        strona.setText(index + "/" + iloscStron);
        prev.setVisible(false);
        if(iloscStron == 1) {
            next.setVisible(false);
        }

    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub
        JButton button = (JButton) arg0.getSource();
        if(button == next) {
            index += 1;

            prev.setVisible(true);
            int iloscStron = tab.length / 3;
            if(tab.length % 3 != 0) {
                iloscStron += 1;
            }
            //strona.setText(index + "/" + iloscStron);
            if(iloscStron == index) {
                next.setVisible(false);
            }
            strona.setText(index + "/" + iloscStron);
            int len = tab.length - (index-1)*3;
            if(len == 1) {
                poz1.setText(Integer.toString(index));
                naz1.setText(tab[(index-1)*3].getProductName());
                ilosc1.setText(Integer.toString(tab[(index-1)*3].getAmount()));
                cena1.setText(Double.toString(tab[(index-1)*3].getCost()));

                poz2.setText("");
                naz2.setText("");
                ilosc2.setText("");
                cena2.setText("");

                poz3.setText("");
                naz3.setText("");
                ilosc3.setText("");
                cena3.setText("");
            }else if(len == 2) {
                poz1.setText(Integer.toString(index));
                naz1.setText(tab[(index-1)*3].getProductName());
                ilosc1.setText(Integer.toString(tab[(index-1)*3].getAmount()));
                cena1.setText(Double.toString(tab[(index-1)*3].getCost()));

                poz2.setText(Integer.toString(index+1));
                naz2.setText(tab[(index-1)*3+1].getProductName());
                ilosc2.setText(Integer.toString(tab[(index-1)*3+1].getAmount()));
                cena2.setText(Double.toString(tab[(index-1)*3+1].getCost()));

                poz3.setText("");
                naz3.setText("");
                ilosc3.setText("");
                cena3.setText("");
            }else if(len >= 3) {
                poz1.setText(Integer.toString(index));
                naz1.setText(tab[(index-1)*3].getProductName());
                ilosc1.setText(Integer.toString(tab[(index-1)*3].getAmount()));
                cena1.setText(Double.toString(tab[(index-1)*3].getCost()));

                poz2.setText(Integer.toString(index+1));
                naz2.setText(tab[(index-1)*3+1].getProductName());
                ilosc2.setText(Integer.toString(tab[(index-1)*3+1].getAmount()));
                cena2.setText(Double.toString(tab[(index-1)*3+1].getCost()));

                poz3.setText(Integer.toString(index+2));
                naz3.setText(tab[(index-1)*3+2].getProductName());
                ilosc3.setText(Integer.toString(tab[(index-1)*3+2].getAmount()));
                cena3.setText(Double.toString(tab[(index-1)*3+2].getCost()));
            }

        } else if(button == prev) {
            index -= 1;
            next.setVisible(true);
            if(index == 1) {
                prev.setVisible(false);
            }
            int iloscStron = tab.length / 3;
            if(tab.length % 3 != 0) {
                iloscStron += 1;
            }
            strona.setText(index + "/" + iloscStron);
            poz1.setText(Integer.toString(index));
            naz1.setText(tab[(index-1)*3].getProductName());
            ilosc1.setText(Integer.toString(tab[(index-1)*3].getAmount()));
            cena1.setText(Double.toString(tab[(index-1)*3].getCost()));

            poz2.setText(Integer.toString(index+1));
            naz2.setText(tab[(index-1)*3+1].getProductName());
            ilosc2.setText(Integer.toString(tab[(index-1)*3+1].getAmount()));
            cena2.setText(Double.toString(tab[(index-1)*3+1].getCost()));

            poz3.setText(Integer.toString(index+2));
            naz3.setText(tab[(index-1)*3+2].getProductName());
            ilosc3.setText(Integer.toString(tab[(index-1)*3+2].getAmount()));
            cena3.setText(Double.toString(tab[(index-1)*3+2].getCost()));
        } else if(button == cofnij) {
            view.wybranoRezerwacje();
        }
    }
}

