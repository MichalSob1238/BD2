package view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.util.ArrayList;
import java.util.List;

public class oknoRemanent extends JPanel implements ActionListener {

    private View view;
    private int index;
    private String produkty[][];
//    private List<String>

    private JLabel name;
    private  String userName;
    private JButton cofnij;

    private JLabel produktNazwa, alejkaNazwa, polkaNazwa, iloscNazwa;
    private JLabel tytul;
    private JLabel produkt[];
    private JLabel alejka[];
    private JLabel polka[];
    private JLabel ilosc[];
    private JButton wybierz1, wybierz2, wybierz3;

    private JButton next, prev;
    private JLabel strona;

    private GridBagLayout layout;
    private GridBagConstraints pom;

    public oknoRemanent(View view) {
        this.view = view;
        index = 1;

        layout = new GridBagLayout();
        pom = new GridBagConstraints();
        setLayout(layout);

        name = new JLabel();
        cofnij = new JButton("cofnij");

        tytul = new JLabel("Remanent:");
        produktNazwa = new JLabel("Produkt");
        produkt = new JLabel[3];
        produkt[0] = new JLabel();
        produkt[1] = new JLabel();
        produkt[2] = new JLabel();

        alejkaNazwa = new JLabel(" Alejka ");
        alejka = new JLabel[3];
        alejka[0] = new JLabel();
        alejka[1] = new JLabel();
        alejka[2] = new JLabel();

        polkaNazwa = new JLabel(" Polka ");
        polka = new JLabel[3];
        polka[0] = new JLabel();
        polka[1] = new JLabel();
        polka[2] = new JLabel();

        iloscNazwa = new JLabel("Ilosc");
        ilosc = new JLabel[3];
        ilosc[0] = new JLabel();
        ilosc[1] = new JLabel();
        ilosc[2] = new JLabel();
        wybierz1 = new JButton("zmien");
        wybierz2 = new JButton("zmien");
        wybierz3 = new JButton("zmien");

        next = new JButton("next");
        prev = new JButton("prev");
        strona = new JLabel();

        cofnij.addActionListener(this);
        wybierz1.addActionListener(this);
        wybierz2.addActionListener(this);
        wybierz3.addActionListener(this);
        next.addActionListener(this);
        prev.addActionListener(this);
    }

    private void showButtons(){
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
        add(produktNazwa, pom);

        pom.gridy = 3;
        add(produkt[0], pom);

        pom.gridy = 4;
        add(produkt[1], pom);

        pom.gridy = 5;
        add(produkt[2], pom);

        pom.gridy = 2;
        pom.gridx = 2;
        pom.gridwidth = 1;
        add(alejkaNazwa, pom);

        pom.gridy = 3;
        add(alejka[0], pom);

        pom.gridy = 4;
        add(alejka[1], pom);

        pom.gridy = 5;
        add(alejka[2], pom);


        pom.gridy = 2;
        pom.gridx = 3;
        pom.gridwidth = 1;
        add(polkaNazwa, pom);

        pom.gridy = 3;
        add(polka[0], pom);

        pom.gridy = 4;
        add(polka[1], pom);

        pom.gridy = 5;
        add(polka[2], pom);


        pom.gridy = 2;
        pom.gridx = 4;
        pom.gridwidth = 2;
        add(iloscNazwa, pom);

        pom.gridy = 3;
        add(ilosc[0], pom);

        pom.gridy = 4;
        add(ilosc[1], pom);

        pom.gridy = 5;
        add(ilosc[2], pom);




        pom.gridy = 3;
        pom.gridx = 6;
        pom.gridwidth = 2;
        add(wybierz1, pom);

        pom.gridy = 4;
        add(wybierz2, pom);

        pom.gridy = 5;
        add(wybierz3, pom);


        pom.insets = new Insets(20, 0, 0, 0);
        pom.gridy = 6;

        pom.gridx = 0;
        add(prev, pom);

        pom.gridx = 1;
        add(strona, pom);

        pom.gridx = 3;
        add(next, pom);

        wybierz1.setVisible(true);
        wybierz2.setVisible(true);
        wybierz3.setVisible(true);
        prev.setVisible(true);
        next.setVisible(true);
    }

    private void showProdukt(String produktInfo[], int i) {
        produkt[i].setText(produktInfo[0]);
        alejka[i].setText(produktInfo[1]);
        polka[i].setText(produktInfo[2]);
        ilosc[i].setText(produktInfo[3]);
    }

    //kolejne Atrybuty listy "produkt", "alejka", "polka", "ilosc"
    public void show(String nameUser, String produkty[][]) {
//        System.out.println(nameUser);
//        System.out.println(produkty[0][0]);

        name.setText(nameUser);
        this.userName = userName;
        index = 1;

        showButtons();
        this.produkty = produkty;
        int iloscStron = produkty.length / 3;
        if(produkty.length % 3 != 0) {
            iloscStron += 1;
        }
        if(produkty.length == 1) {
            showProdukt(produkty[0], 0);
            wybierz2.setVisible(false);
            wybierz3.setVisible(false);
        }else if(produkty.length == 2) {
            showProdukt(produkty[0], 0);
            showProdukt(produkty[1], 1);
            wybierz3.setVisible(false);
        }else if(produkty.length >= 3) {
            showProdukt(produkty[0], 0);
            showProdukt(produkty[1], 1);
            showProdukt(produkty[2], 2);
        }
        strona.setText(index + "/" + iloscStron);
        prev.setVisible(false);
        if(iloscStron == 1) {
            next.setVisible(false);
        }
    }

    private void hideProdukt(int i) {
        produkt[i].setText("");
        alejka[i].setText("");
        polka[i].setText("");
        ilosc[i].setText("");
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub
        JButton button = (JButton) arg0.getSource();
        if(button == next) {
            index += 1;

            prev.setVisible(true);
            int iloscStron = produkty.length / 3;
            if(produkty.length % 3 != 0) {
                iloscStron += 1;
            }
            //strona.setText(index + "/" + iloscStron);
            if(iloscStron == index) {
                next.setVisible(false);
            }
            strona.setText(index + "/" + iloscStron);
            int len = produkty.length - (index-1)*3;
            if(len == 1) {
                showProdukt(produkty[(index-1)*3], 0);
                hideProdukt(1);
                hideProdukt(2);
                wybierz2.setVisible(false);
                wybierz3.setVisible(false);
            }else if(len == 2) {
                showProdukt(produkty[(index-1)*3], 0);
                showProdukt(produkty[(index-1)*3+1], 1);
                hideProdukt(2);
                wybierz3.setVisible(false);
            }else if(len >= 3) {
                showProdukt(produkty[(index-1)*3], 0);
                showProdukt(produkty[(index-1)*3+1], 1);
                showProdukt(produkty[(index-1)*3+2], 2);
            }

        } else if(button == prev) {
            if(index>0)
                index -= 1;
            next.setVisible(true);
            if(index == 1) {
                prev.setVisible(false);
            }
            int iloscStron = produkty.length / 3;
            if(produkty.length % 3 != 0) {
                iloscStron += 1;
            }
            strona.setText(index + "/" + iloscStron);
            showProdukt(produkty[(index-1)*3], 0);
            showProdukt(produkty[(index-1)*3+1], 1);
            showProdukt(produkty[(index-1)*3+2], 2);
            wybierz1.setVisible(true);
            wybierz2.setVisible(true);
            wybierz3.setVisible(true);
        } else if(button == cofnij) {
            view.oknoStartowe();
        } else if(button == wybierz1){
            view.zmienIloscRemanent(this.userName, (index-1)*3);
        } else if(button == wybierz2){
            view.zmienIloscRemanent(this.userName, (index-1)*3+1);
        } else if(button == wybierz3){
            view.zmienIloscRemanent(this.userName, (index-1)*3+2);
        }
    }


}
