package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class oknoZmienIloscRemanent extends JPanel implements ActionListener {

    private View view;
    private JLabel msg;
    private JLabel nameLabel;
    private JTextField idField;
    private JLabel name;

    private JButton loginButton;
    private JButton returnButton;
    private GridBagLayout layout;
    private GridBagConstraints pom;

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

        loginButton = new JButton("Zatwierdz");
        loginButton.addActionListener(this);

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
        add(loginButton, pom);
        pom.gridy = 4;
        add(returnButton,pom);

    }

    public void show(String nameUser, Boolean flag) {
        name.setText(nameUser);
        msg.setVisible(flag);
    }



    @Override
    public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub
        JButton button = (JButton) arg0.getSource();
        if(button == returnButton) {
//            view.remanent();
        }else if(button == loginButton) {
//            int ilosc = idField.getText();
            //TODO zmien ilosc w bazie danych
//            view.remanent();

        }
    }

}
