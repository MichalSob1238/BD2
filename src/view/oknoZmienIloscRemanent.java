package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Integer.parseInt;

public class oknoZmienIloscRemanent extends JPanel implements ActionListener {

    private View view;
    private JLabel msg;
    private JLabel nameLabel;
    private JTextField idField;
    private JLabel name;

    private JButton zatwierdzButton;
    private JButton returnButton;
    private GridBagLayout layout;
    private GridBagConstraints pom;
    private int index;
    private String idProduktu;

    public oknoZmienIloscRemanent(View view) {
        this.view = view;

        layout = new GridBagLayout();
        pom = new GridBagConstraints();

        msg = new JLabel("To nie jest liczba!");
        msg.setForeground(Color.RED);

        name = new JLabel("");

        nameLabel = new JLabel("Podaj rzeczywista ilosc: ");

        idField = new JTextField();
        idField.setPreferredSize(new Dimension(70, 20));

        zatwierdzButton = new JButton("Zatwierdz");
        zatwierdzButton.addActionListener(this);

        returnButton = new JButton("cofnij");
        returnButton.addActionListener(this);


        setLayout(layout);

        pom.insets = new Insets(0, 40, 60, 0);
        pom.gridx = 1;
        add(name,pom);

        pom.insets = new Insets(0, 0, 0, 0);
        pom.gridx = 0;

        pom.gridwidth = 1;
        pom.gridy = 1;
        add(msg,pom);
        msg.setVisible(false);
        pom.gridy = 2;
        add(nameLabel, pom);

        pom.gridx = 1;
        add(idField, pom);




        pom.insets = new Insets(20, 0, 0, 0);
        pom.gridx = 0;
        pom.gridy = 3;
        pom.gridwidth = 2;
        add(zatwierdzButton, pom);
        pom.gridy = 4;
        add(returnButton,pom);

    }

    public void show(String nameUser, int index, String idProduktu) {
        name.setText(nameUser);
        this.index = index;
        this.idProduktu = idProduktu;
    }



    @Override
    public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub
        JButton button = (JButton) arg0.getSource();
        if(button == returnButton) {
            view.wybranyRemanent();
        }else if(button == zatwierdzButton) {
            String text = idField.getText();
            int ilosc = parseInt(text);
            view.wybranyRemanent(ilosc, index, this.idProduktu);
        }
    }

}
