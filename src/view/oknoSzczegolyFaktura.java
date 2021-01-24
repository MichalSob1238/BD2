package view;

import model.Faktura;
import model.SzczegolyFaktura;

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
    private JLabel id_transakcji;
    private JLabel data;
    private JLabel cena;
    private JLabel id_pracownika;

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
        id_transakcji = new JLabel();
        data = new JLabel();
        cena = new JLabel();
        id_pracownika = new JLabel();

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

        pom.gridy = 9;
        add(id_transakcji, pom);

        pom.gridy = 10;
        add(data, pom);

        pom.gridy = 11;
        add(cena, pom);

        pom.gridy = 12;
        add(id_pracownika, pom);

    }

    public void show(String nameUser, SzczegolyFaktura szczegolyFaktura){
        name.setText(nameUser);

        id_faktura.setText("id_faktura: " + szczegolyFaktura.getInvoiceId());
        nr_faktury.setText("nr_faktury: " + szczegolyFaktura.getInvoiceNr());
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        termin_platnosci.setText("termin platnosci: " + dateFormat.format(szczegolyFaktura.getDueDate()));
        czy_oplacono.setText("czy oplacono: " + szczegolyFaktura.getIfPayed());
        nazwa.setText("nazwa firmy: " + szczegolyFaktura.getCompanyName());
        adres.setText("adres firmy: " + szczegolyFaktura.getCompanyAddress());
        nip.setText("NIP: " + szczegolyFaktura.getNIP());
        id_transakcji.setText("ID transakcji: " + szczegolyFaktura.getTransactionId());
        data.setText("Data zlecenia: " + dateFormat.format(szczegolyFaktura.getDate()));
        cena.setText("Cena: " + szczegolyFaktura.getPrice());
        id_pracownika.setText("Id pracownika: " + szczegolyFaktura.getEmployeeId());
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
