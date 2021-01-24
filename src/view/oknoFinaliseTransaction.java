package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class oknoFinaliseTransaction extends JPanel implements ActionListener{

    private View view;
    private JLabel msg;
    private JLabel name;

    private JButton loginButton;
    private JButton returnButton;
    private GridBagLayout layout;
    private GridBagConstraints pom;
    private Integer cena;

    public oknoFinaliseTransaction(View view, Integer cena) {
        this.view = view;
        this.cena = cena;
        layout = new GridBagLayout();
        pom = new GridBagConstraints();

        msg = new JLabel("Ostateczna kwota to: " + cena);
        msg.setForeground(Color.BLACK);

        name = new JLabel("");


        loginButton = new JButton("Op³aæ");
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

        pom.gridx = 1;





        pom.insets = new Insets(20, 0, 0, 0);
        pom.gridx = 0;
        pom.gridy = 3;
        pom.gridwidth = 2;
        add(loginButton, pom);
        pom.gridy = 4;
        add(returnButton,pom);

    }

    public void show(String nameUser, Integer cena) {
        name.setText(nameUser);
        msg.setVisible(true);
        this.cena = cena;
        msg.setText("Ostateczna kwota to: " + cena);
    }



    @Override
    public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub
        JButton button = (JButton) arg0.getSource();
        if(button == returnButton) {
            view.zakup();
        }else if(button == loginButton) {
            //TODO: op³aæ
        }
    }

}
