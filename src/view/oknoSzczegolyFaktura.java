package view;

import model.Faktura;
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

public class oknoSzczegolyFaktura extends JPanel implements ActionListener{

    private View view;

    private JLabel name;
    private JLabel tytul;
    private JButton cofnij;

    private JLabel id_faktura;
    private JLabel nr_faktury;
    private JLabel termin_platnosci;
    private JLabel czy_oplacono;
    private JLabel nazwa;
    private JLabel adres;
    private JLabel nip;

    private GridBagLayout layout;
    private GridBagConstraints pom;

    public oknoSzczegolyFaktura(View view){
        this.view = view;
        layout = new GridBagLayout();
        pom = new GridBagConstraints();
        setLayout(layout);

        name = new JLabel();
        cofnij = new JButton("cofnij");
        cofnij.addActionListener(this);
        tytul = new JLabel("Szczegoly Faktury:");

        id_faktura = new JLabel();
        nr_faktury = new JLabel();
        termin_platnosci = new JLabel();
        czy_oplacono = new JLabel();
        nazwa = new JLabel();
        adres = new JLabel();
        nip = new JLabel();

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
        add(id_faktura, pom);

        pom.gridy = 3;
        add(nr_faktury, pom);

        pom.gridy = 4;
        add(termin_platnosci, pom);

        pom.gridy = 5;
        add(czy_oplacono, pom);

        pom.gridy = 6;
        add(nazwa, pom);

        pom.gridy = 7;
        add(adres, pom);

        pom.gridy = 8;
        add(nip, pom);
    }

    public void show(String nameUser, Faktura szczegolyFaktura){
        name.setText(nameUser);

        id_faktura.setText("id_faktura: " + szczegolyFaktura.getId());
        nr_faktury.setText("nr_faktury: " + szczegolyFaktura.getInvoiceNr());
//        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        //termin_platnosci.getText("termin platnosci: " + dateFormat.format(szczegolyFaktura.getDueDate()));
        czy_oplacono.setText("czy oplacono: " + szczegolyFaktura.getIfPayed());
        nazwa.setText("nazwa firmy: " + szczegolyFaktura.getCompanyName());
        adres.setText("adres firmy: " + szczegolyFaktura.getCompanyAddress());
        nip.setText("NIP: " + szczegolyFaktura.getNIP());

    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub
        JButton button = (JButton) arg0.getSource();
        if (button == cofnij) {
            view.wybranoPrzegladFaktur();
        }
    }
}
