package controller;

import model.SzczegolyFaktura;

public class OknoListaFakturController {

    public SzczegolyFaktura pobierzSzczegolyFaktura(String nrFaktura){
        DatabaseController db = new DatabaseController();
        SzczegolyFaktura szczegoly = db.getInvoiceDetails(nrFaktura);
        return szczegoly;
    }
}
