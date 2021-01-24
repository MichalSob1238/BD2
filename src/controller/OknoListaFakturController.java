package controller;

import model.Faktura;

public class OknoListaFakturController {

    public Faktura pobierzSzczegolyFaktura(String nrFaktura){
        DatabaseController db = new DatabaseController();
        Faktura szczegolyFaktura = db.getInvoiceDetails(nrFaktura);
        return szczegolyFaktura;
    }
}
