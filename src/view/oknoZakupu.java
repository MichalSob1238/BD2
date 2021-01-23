package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class oknoZakupu extends JPanel implements ActionListener {

    private View view;
    private JLabel name;
    private JLabel idProd;
    private JLabel tytul;
    private JButton addToCartButton;
    private JButton returnButton;
    private JButton finaliseTransactionButton;
    private String tab[];
    private JLabel produkt1, produkt2, produkt3;
    private JButton wybierz1, wybierz2, wybierz3;
    private JButton next, prev;
    private JLabel strona;
    private GridBagLayout layout;
    private GridBagConstraints pom;
    private JTextField idField;
    private int index;

    public oknoZakupu(View view) {
        this.view = view;
        index = 1;

        layout = new GridBagLayout();
        pom = new GridBagConstraints();
        setLayout(layout);

        name = new JLabel("Joanna Takczyk");
        returnButton = new JButton("cofnij");

        tytul = new JLabel("Koszyk:");
        produkt1 = new JLabel();
        produkt2 = new JLabel();
        produkt3 = new JLabel();
        wybierz1 = new JButton("szczegoly");
        wybierz2 = new JButton("szczegoly");
        wybierz3 = new JButton("szczegoly");

        next = new JButton("next");
        prev = new JButton("prev");
        strona = new JLabel();

        idField = new JTextField();
        idField.setPreferredSize(new Dimension(70, 20));
        addToCartButton = new JButton("Dodaj do koszyka");

        addToCartButton.addActionListener(this);
        returnButton.addActionListener(this);
        wybierz1.addActionListener(this);
        wybierz2.addActionListener(this);
        wybierz3.addActionListener(this);
        next.addActionListener(this);
        prev.addActionListener(this);

        pom.insets = new Insets(0, 0, 20, 50);
        pom.gridx = 0;
        pom.gridy = 0;
        add(returnButton, pom);

        pom.insets = new Insets(0, 30, 20, 0);
        pom.gridx = 2;
        add(name, pom);

        pom.insets = new Insets(0,0,0,0);
        pom.gridx=0;
        pom.gridy=1;
        add(addToCartButton,pom);
        pom.gridx = 1;
        pom.gridwidth = 2;
        add(idField,pom);

        pom.insets = new Insets(60, 0, 0, 0);
        pom.gridy = 1;
        pom.gridx = 0;
        pom.gridwidth = 3;
        add(tytul, pom);

        pom.insets = new Insets(0, 0, 0, 0);
        pom.gridy = 2;
        pom.gridwidth = 2;
        add(produkt1, pom);

        pom.gridy = 3;
        add(produkt2, pom);

        pom.gridy = 4;
        add(produkt3, pom);

        pom.gridy = 2;
        pom.gridx = 2;
        pom.gridwidth = 1;
        add(wybierz1, pom);

        pom.gridy = 3;
        add(wybierz2, pom);

        pom.gridy = 4;
        add(wybierz3, pom);

        pom.insets = new Insets(20, 0, 0, 0);
        pom.gridy = 5;

        pom.gridx = 0;
        add(prev, pom);

        pom.gridx = 1;
        add(strona, pom);

        pom.gridx = 2;
        add(next, pom);
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
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
                produkt1.setText(tab[(index-1)*3]);
                produkt2.setText("");
                produkt3.setText("");
                wybierz2.setVisible(false);
                wybierz3.setVisible(false);
            }else if(len == 2) {
                produkt1.setText(tab[(index-1)*3]);
                produkt2.setText(tab[(index-1)*3+1]);
                produkt3.setText("");
                wybierz3.setVisible(false);
            }else if(len >= 3) {
                produkt1.setText(tab[(index-1)*3]);
                produkt2.setText(tab[(index-1)*3+1]);
                produkt3.setText(tab[(index-1)*3+2]);
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
            produkt1.setText(tab[(index-1)*3]);
            produkt2.setText(tab[(index-1)*3+1]);
            produkt3.setText(tab[(index-1)*3+2]);
            wybierz1.setVisible(true);
            wybierz2.setVisible(true);
            wybierz3.setVisible(true);
        } else if(button == returnButton) {
            view.oknoStartowe();
        } else if(button == wybierz1){
            view.pobierzSzczegoly(tab[index*3]);
        } else if(button == wybierz2){
            view.pobierzSzczegoly(tab[index*3+1]);
        } else if(button == wybierz3){
            view.pobierzSzczegoly(tab[index*3+2]);
        }
    }

    public void show(String name) {
        this.name.setText(name);
    }
}
