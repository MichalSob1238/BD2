package controller;

import model.SzczegolyFaktura;
import model.Transakcja;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

public class OknoListaFakturController {

    public SzczegolyFaktura pobierzSzczegolyFaktura(String nrFaktura){
        DatabaseController db = new DatabaseController();
        SzczegolyFaktura szczegoly = db.getInvoiceDetails(nrFaktura);
        return szczegoly;
    }

    public void addInvoice(String daneNazwa, String daneAdres, String daneNIP, String daneParagon){
        DatabaseController db = new DatabaseController();
        Transakcja transaction = db.selectTransactionById(Integer.parseInt(daneParagon));
        LocalDate localDate = transaction.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        String invoiceNr = transaction.getId() + "/" + localDate.getMonth() + "/" + localDate.getYear();
        db.insertIntoFaktura(invoiceNr, Date.from(localDate.plusDays(14).atStartOfDay(ZoneId.systemDefault()).toInstant()),
                false, daneNazwa, daneAdres, daneNIP, transaction.getId());
        db.updateTransactionStatus(transaction.getId(), Transakcja.transactionType.FAKTURA.toString());
    }
}
