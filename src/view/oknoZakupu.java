package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

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
    private JButton usun1, usun2, usun3;
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
        usun1 = new JButton("usun");
        usun2 = new JButton("usun");
        usun3 = new JButton("usun");
        tab = new String[]{};

        next = new JButton("next");
        prev = new JButton("prev");
        strona = new JLabel();

        idField = new JTextField();
        idField.setPreferredSize(new Dimension(70, 20));
        addToCartButton = new JButton("Dodaj do koszyka");
        finaliseTransactionButton = new JButton("Zakoncz i zaplac");

        finaliseTransactionButton.addActionListener(this);
        addToCartButton.addActionListener(this);
        returnButton.addActionListener(this);
        wybierz1.addActionListener(this);
        wybierz2.addActionListener(this);
        wybierz3.addActionListener(this);
        usun1.addActionListener(this);
        usun2.addActionListener(this);
        usun3.addActionListener(this);
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
        pom.gridx = 3;
        add(finaliseTransactionButton,pom);

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

        pom.gridx = 3;
        add(usun3,pom);

        pom.gridy = 3;
        add(usun2,pom);

        pom.gridy = 2;
        add(usun1,pom);

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
                usun2.setVisible(false);
                usun3.setVisible(false);
            }else if(len == 2) {
                produkt1.setText(tab[(index-1)*3]);
                produkt2.setText(tab[(index-1)*3+1]);
                produkt3.setText("");
                wybierz3.setVisible(false);
                usun3.setVisible(false);
            }else if(len >= 3) {
                produkt1.setText(tab[(index-1)*3]);
                produkt2.setText(tab[(index-1)*3+1]);
                produkt3.setText(tab[(index-1)*3+2]);
            }

        } else if(button == prev)
        {
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
            usun1.setVisible(true);
            usun2.setVisible(true);
            usun3.setVisible(true);
        } else if(button == returnButton)
        {
            view.oknoStartowe();
        } else if(button == wybierz1)
        {
            view.pobierzSzczegolyZakup(tab[(index-1)*3]);
        } else if(button == wybierz2)
        {
            view.pobierzSzczegolyZakup(tab[(index-1)*3+1]);
        } else if(button == wybierz3)
        {
            view.pobierzSzczegolyZakup(tab[(index-1)*3+2]);
        }else if(button == usun1)
        {
            int toRemove = (index-1)*3;
            // create an array to hold elements after deletion
            String[] copyArray = new String[tab.length - 1];
            // copy elements from original array from beginning till index into copyArray
            System.arraycopy(tab, 0, copyArray, 0, toRemove);
            // copy elements from original array from index+1 till end into copyArray
            System.arraycopy(tab, toRemove + 1, copyArray, toRemove, tab.length - toRemove - 1);
            tab = copyArray;
            if(tab.length%3==0&&tab.length!=0)
            {
                prev.doClick();
            }
            reload();
        } else if(button == usun2)
        {
            int toRemove = (index-1)*3+1;
            // create an array to hold elements after deletion
            String[] copyArray = new String[tab.length - 1];
            // copy elements from original array from beginning till index into copyArray
            System.arraycopy(tab, 0, copyArray, 0, toRemove);
            // copy elements from original array from index+1 till end into copyArray
            System.arraycopy(tab, toRemove + 1, copyArray, toRemove, tab.length - toRemove - 1);
            tab = copyArray;
            reload();

        } else if(button == usun3)
        {
            int toRemove = (index-2)*3+2;
            // create an array to hold elements after deletion
            String[] copyArray = new String[tab.length - 1];
            // copy elements from original array from beginning till index into copyArray
            System.arraycopy(tab, 0, copyArray, 0, toRemove);
            // copy elements from original array from index+1 till end into copyArray
            System.arraycopy(tab, toRemove + 1, copyArray, toRemove, tab.length - toRemove - 1);
            tab = copyArray;
            reload();
        }else if (button == addToCartButton)
        {
            String id = idField.getText();
            id = view.addToCart(id);
            tab  = Arrays.copyOf(tab, tab.length + 1); //create new array from old array and allocate one more element
            tab[tab.length - 1] = id;
            int iloscStron = tab.length / 3;
            if(tab.length % 3 != 0) {
                iloscStron += 1;
            }
            int len = tab.length - (index-1)*3;
            if(len == 1) {
                produkt1.setText(tab[(index-1)*3]);
                wybierz1.setVisible(true);
                usun1.setVisible(true);
            }else if(len == 2) {
                produkt1.setText(tab[(index-1)*3]);
                produkt2.setText(tab[(index-1)*3+1]);
                wybierz1.setVisible(true);
                usun1.setVisible(true);
                wybierz2.setVisible(true);
                usun2.setVisible(true);
            }else if(len >= 3) {
                produkt1.setText(tab[(index-1)*3]);
                produkt2.setText(tab[(index-1)*3+1]);
                produkt3.setText(tab[(index-1)*3+2]);
                wybierz1.setVisible(true);
                usun1.setVisible(true);
                wybierz2.setVisible(true);
                usun2.setVisible(true);
                wybierz3.setVisible(true);
                usun3.setVisible(true);
            }

            strona.setText(index + "/" + iloscStron);

            prev.setVisible(false);
            if(iloscStron == 1) {
                next.setVisible(false);
            } else {
                next.setVisible(true);
                prev.setVisible(true);
            }
        }else if (button == finaliseTransactionButton)
        {
            view.finaliseTransaction(tab);
        }
    }

    public void show(String name) {
        this.name.setText(name);
        this.reload();
    }
    
    public void reload(){

        int iloscStron = tab.length / 3;
        if(tab.length % 3 != 0) {
            iloscStron += 1;
        }
        int len = tab.length - (index-1)*3;
        if(len == 0){
            strona.setText("");
            produkt1.setText("");
            produkt2.setText("");
            produkt3.setText("");
            wybierz1.setVisible(false);
            wybierz2.setVisible(false);
            wybierz3.setVisible(false);
            usun1.setVisible(false);
            usun2.setVisible(false);
            usun3.setVisible(false);
            if(iloscStron <= 1)
            {
                prev.setVisible(false);
                next.setVisible(false);
            }else {
                prev.setVisible(true);
            }
        }
        if(len == 1) {
            produkt1.setText(tab[(index-1)*3]);
            produkt2.setText("");
            produkt3.setText("");
            wybierz2.setVisible(false);
            wybierz3.setVisible(false);
            usun2.setVisible(false);
            usun3.setVisible(false);
            if(index <= 1)
            {
                prev.setVisible(false);
                next.setVisible(false);
            }else {
                prev.setVisible(true);
            }
        }else if(len == 2) {
            produkt1.setText(tab[(index-1)*3]);
            produkt2.setText(tab[(index-1)*3+1]);
            produkt3.setText("");
            wybierz3.setVisible(false);
            usun3.setVisible(false);
            if(iloscStron <= 1)
            {
                prev.setVisible(false);
                next.setVisible(false);
            }else {
                prev.setVisible(true);
            }
        }else if(len >= 3) {
            produkt1.setText(tab[(index-1)*3]);
            produkt2.setText(tab[(index-1)*3+1]);
            produkt3.setText(tab[(index-1)*3+2]);
        }
        if (!(iloscStron == 0)){
            strona.setText(index + "/" + iloscStron);
        }

        if(iloscStron == 1) {
            next.setVisible(false);
            prev.setVisible(false);
        }
    }

}
