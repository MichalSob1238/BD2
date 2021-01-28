package controller;

public class oknoRemanentController {
    public String[][] dajProduktyZMagazynu() {
        DatabaseController db = new DatabaseController();
        String produkty[][] = db.getProductsFromWarehouse();
        return produkty;
    }
}
