package controller;

public class OknoRemanentController {
    public String[][] dajProduktyZMagazynu() {
        DatabaseController db = new DatabaseController();
        String produkty[][] = db.getProductsFromWarehouse();
        return produkty;
    }
}
