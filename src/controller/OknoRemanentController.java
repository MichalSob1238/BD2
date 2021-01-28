package controller;

import java.util.List;

public class OknoRemanentController {
    public List<List<String>> dajProduktyZMagazynu() {
        DatabaseController db = new DatabaseController();
        return db.getProductsFromWarehouse();
    }

    public void aktualizujProduktyMagazynu(int ilosc, String idProduktu) {
        DatabaseController db = new DatabaseController();
        db.updateProductsFromWarehouse(ilosc, idProduktu);
    }
}
