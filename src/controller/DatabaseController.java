package controller;

import model.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DatabaseController {

    private static final String url = "jdbc:mysql://localhost:8889/deliveryEarn";
    private static final String user = "bd2_projekt";
    private static final String password = "BD2haslo";

    public static void initialize() throws IOException {
        Path fileName = Path.of("./src/res/tableCreation.txt");
        String InitialCreation = Files.readString(fileName);
        System.out.println(InitialCreation);

        try
        {
            Connection conMySql = DriverManager.getConnection("jdbc:mysql://pma.janowski.xyz:3306/bd2_projekt?allowMultiQueries=true", user, password);

            Statement st2;
            st2 = conMySql.createStatement();
            st2.executeUpdate(InitialCreation);

        }
        catch(SQLException ex)
        {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://pma.janowski.xyz:3306/bd2_projekt?allowMultiQueries=true", user, password);
    }

    void insertIntoDaneKlienta(String name, String lastName, int phoneNumber){
        try{
            Connection conn = getConnection();
            PreparedStatement insert = conn.prepareStatement("INSERT INTO dane_klienta VALUES(default,?,?,?)");
            insert.setString(1, name);
            insert.setString(2,  lastName);
            insert.setInt(3, phoneNumber);
            insert.execute();
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    void insertIntoStanowisko(String position){
        try{
            Connection conn = getConnection();
            PreparedStatement insert = conn.prepareStatement("INSERT INTO stanowisko VALUES(default,?)");
            insert.setString(1, position);
            insert.execute();
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    void insertIntoPracownik(String name, String lastName, int positionId){
        try{
            Connection conn = getConnection();
            PreparedStatement insert = conn.prepareStatement("INSERT INTO pracownik VALUES(default,?,?,?)");
            insert.setString(1, name);
            insert.setString(2, lastName);
            insert.setInt(3, positionId);
            insert.execute();
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    int insertIntoTransport(Date date, int employeeId){
        try{
            Connection conn = getConnection();
            PreparedStatement insert = conn.prepareStatement("INSERT INTO transport VALUES(default,?,?)", Statement.RETURN_GENERATED_KEYS);
            insert.setDate(1, new java.sql.Date(date.getTime()));
            insert.setInt(2, employeeId);
            insert.execute();
            ResultSet keys = insert.getGeneratedKeys();
            if (keys.next()) {
                return keys.getInt(1);
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return -1;
    }

    int insertIntoTransakcja(Date date, double value, int employeeId, Transakcja.transactionType type){
        try{
            Connection conn = getConnection();
            PreparedStatement insert = conn.prepareStatement("INSERT INTO transakcja VALUES(default,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            insert.setDate(1, new java.sql.Date(date.getTime()));
            insert.setDouble(2, value);
            insert.setInt(3, employeeId);
            insert.setString(4, type.name());
            insert.execute();
            ResultSet keys = insert.getGeneratedKeys();
            if (keys.next()) {
                return keys.getInt(1);
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return -1;
    }

    void insertIntoHurtownia(String name, String contact){
        try{
            Connection conn = getConnection();
            PreparedStatement insert = conn.prepareStatement("INSERT INTO hurtownia VALUES(default,?,?)");
            insert.setString(1, name);
            insert.setString(2, contact);
            insert.execute();
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    void insertIntoFaktura(String invoiceNr, Date dueDate, boolean ifPayed, String name, String address, String NIP, int transactionId){
        try{
            Connection conn = getConnection();
            PreparedStatement insert = conn.prepareStatement("INSERT INTO faktura VALUES(default,?,?,?,?,?,?,?)");
            insert.setString(1, invoiceNr);
            insert.setDate(2, new java.sql.Date(dueDate.getTime()));
            insert.setBoolean(3,ifPayed);
            insert.setString(4, name);
            insert.setString(5, address);
            insert.setString(6,NIP);
            insert.setInt(7, transactionId);
            insert.execute();
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    int insertIntoDostawa( Date dueDate, double value, int warehouseId, int employeeId){
        try{
            Connection conn = getConnection();
            PreparedStatement insert = conn.prepareStatement("INSERT INTO dostawa VALUES(default,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
            insert.setDate(1,new java.sql.Date(dueDate.getTime()));
            insert.setDouble(2, value);
            insert.setInt(3, warehouseId);
            insert.setInt(4, employeeId);
            insert.executeUpdate();
            ResultSet keys = insert.getGeneratedKeys();
            if (keys.next()) {
                return keys.getInt(1);
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return -1;
    }

    int  insertIntoZamowienie(boolean ifCompleted, Date orderDate, Date realisationDate, int clientId){
        try{
            Connection conn = getConnection();
            PreparedStatement insert = conn.prepareStatement("INSERT INTO zamowienie VALUES(default,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            insert.setBoolean(1,ifCompleted);
            insert.setDate(2, new java.sql.Date(orderDate.getTime()));
            insert.setDate(3, new java.sql.Date(realisationDate.getTime()));
            insert.setInt(4, clientId);
            insert.execute();
            ResultSet keys = insert.getGeneratedKeys();
            if (keys.next()) {
                return keys.getInt(1);
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        return -1;
    }

    void insertIntoKategoria(String category){
        try{
            Connection conn = getConnection();
            PreparedStatement insert = conn.prepareStatement("INSERT INTO kategoria VALUES(default,?)");
            insert.setString(1, category);
            insert.execute();
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    void insertIntoProdukt(String name,double cost, int categoryId){
        try{
            Connection conn = getConnection();
            PreparedStatement insert = conn.prepareStatement("INSERT INTO produkt VALUES(default,?,?,?)");
            insert.setString(1, name);
            insert.setDouble(2, cost);
            insert.setInt(3, categoryId);
            insert.execute();
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    void insertIntoProduktHurtownia(int productId, int warehouseId){
        try{
            Connection conn = getConnection();
            PreparedStatement insert = conn.prepareStatement("INSERT INTO produkt_hurtownia VALUES(?,?)");
            insert.setInt(1, productId);
            insert.setInt(2, warehouseId);
            insert.execute();
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    void insertIntoMagazyn(int quantity, int shelfId, int alleyId, int productId){
        try{
            Connection conn = getConnection();
            PreparedStatement insert = conn.prepareStatement("INSERT INTO magazyn VALUES(?,?,?,?)");
            insert.setInt(1, quantity);
            insert.setInt(2, shelfId);
            insert.setInt(3, alleyId);
            insert.setInt(4, productId);
            insert.execute();
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    void insertIntoSklep(int quantity, int productId){
        try{
            Connection conn = getConnection();
            PreparedStatement insert = conn.prepareStatement("INSERT INTO sklep VALUES(?,?)");
            insert.setInt(1, quantity);
            insert.setInt(2, productId);
            insert.execute();
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    void insertIntoPozycjaDostawa(int quantity, int deliveryId, int productId){
        try{
            Connection conn = getConnection();
            PreparedStatement insert = conn.prepareStatement("INSERT INTO pozycja_dostawa VALUES(?,?,?)");
            insert.setInt(1, quantity);
            insert.setInt(2, deliveryId);
            insert.setInt(3, productId);
            insert.execute();
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    void insertIntoPozycjaParagon(int quantity, double cost, int transactionId, int productId){
        try{
            Connection conn = getConnection();
            PreparedStatement insert = conn.prepareStatement("INSERT INTO pozycja_paragon VALUES(?,?,?,?)");
            insert.setInt(1, quantity);
            insert.setDouble(2, cost);
            insert.setInt(3, transactionId);
            insert.setInt(4, productId);
            insert.execute();
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    void insertIntoPozycjaTransport(int quantity, int transportId, int productId){
        try{
            Connection conn = getConnection();
            PreparedStatement insert = conn.prepareStatement("INSERT INTO pozycja_transport VALUES(?,?,?)");
            insert.setInt(1, quantity);
            insert.setInt(2, transportId);
            insert.setInt(3, productId);
            insert.execute();
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    void insertIntoPozycjaZamowienie(int quantity, double cost, int orderId, int productId){
        try{
            Connection conn = getConnection();
            PreparedStatement insert = conn.prepareStatement("INSERT INTO pozycja_zamowienie VALUES(?,?,?,?)");
            insert.setInt(1, quantity);
            insert.setDouble(2,cost);
            insert.setInt(3, orderId);
            insert.setInt(4, productId);
            insert.execute();
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    void insertIntoSzczegoloweInformacje(String color, int weight, String additional_informations, String allergens, String dimensions, int product_id){
        try{
            Connection conn = getConnection();
            PreparedStatement insert = conn.prepareStatement("INSERT INTO szczegolowe_informacje VALUES(?,?,?,?,?,?)");
            insert.setString(1, color);
            insert.setInt(2, weight);
            insert.setString(3, additional_informations);
            insert.setString(4, allergens);
            insert.setString(5, dimensions);
            insert.setInt(6, product_id);
            insert.execute();
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }


    List<Stanowisko> selectAllFromStanowisko(){
        List<Stanowisko> positions = new ArrayList<>();
        try {
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * from stanowisko");

            while (rs.next()) {
                positions.add(new Stanowisko(rs.getInt("id_stanowisko"), rs.getString("nazwa")));
            }
            st.close();
        } catch(SQLException ex){
           ex.printStackTrace();
        }
        return positions;
    }

    List<Pracownik> selectAllFromPracownik(){
        List<Pracownik> employees = new ArrayList<>();
        try {
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * from pracownik");

            while (rs.next()) {
                employees.add(new Pracownik(rs.getInt("id_pracownik"), rs.getString("imie"),
                        rs.getString("nazwisko"), rs.getInt("stanowisko_id_stanowisko")));
            }
            st.close();
        } catch(SQLException ex){
            ex.printStackTrace();
        }
        return employees;
    }

    List<Transakcja> selectAllFromTransakcja(){
        List<Transakcja> transactions = new ArrayList<>();
        try {
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * from transakcja");

            while (rs.next()) {
                transactions.add(new Transakcja(rs.getInt("id_transakcja"), rs.getDate("data"),
                        rs.getDouble("kwota"), rs.getInt("pracownik_id_pracownik"),
                        Transakcja.transactionType.valueOf(rs.getString("typ"))));
            }
            st.close();
        } catch(SQLException ex){
            ex.printStackTrace();
        }
        return transactions;
    }

    public List<Produkt> selectProductFromTransaction(Integer idTransaction){
        List<Produkt> products = new ArrayList<>();
        try {
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            PreparedStatement getEmployee = conn.prepareStatement("SELECT * from produkt WHERE id_produkt IN (Select produkt_id_produkt from pozycja_paragon where transakcja_id_transakcja = ?)")  ;
            getEmployee.setInt(1, idTransaction);
            ResultSet rs = getEmployee.executeQuery();
            while (rs.next()) {
                products.add(new Produkt(rs.getInt("id_produkt"),
                        rs.getString("nazwa"), rs.getDouble("koszt"),
                        rs.getInt("kategoria_id_kategoria")));
            }
            st.close();
        } catch(SQLException ex){
            ex.printStackTrace();
        }
        return products;
    }

    List<Transakcja> selectFakturaOnlyFromTransakcja(){
        List<Transakcja> transactions = new ArrayList<>();
        try {
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * from transakcja WHERE typ ='FAKTURA'");

            while (rs.next()) {
                transactions.add(new Transakcja(rs.getInt("id_transakcja"), rs.getDate("data"),
                        rs.getDouble("kwota"), rs.getInt("pracownik_id_pracownik"),
                        Transakcja.transactionType.valueOf(rs.getString("typ"))));
            }
            st.close();
        } catch(SQLException ex){
            ex.printStackTrace();
        }
        return transactions;
    }

    List<Hurtownia> selectAllFromHurtownia(){
        List<Hurtownia> warehouses = new ArrayList<>();
        try {
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * from hurtownia");

            while (rs.next()) {
                warehouses.add(new Hurtownia(rs.getInt("id_hurtownia"), rs.getString("nazwa"),
                        rs.getString("kontakt")));
            }
            st.close();
        } catch(SQLException ex){
            ex.printStackTrace();
        }
        return warehouses;
    }

    List<String> selectWarehousesNames(){
        List<String> warehouses = new ArrayList<>();
        try {
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT nazwa from hurtownia");

            while (rs.next()) {
                warehouses.add(rs.getString(1));
            }
            st.close();
        } catch(SQLException ex){
            ex.printStackTrace();
        }
        return warehouses;
    }

    Hurtownia selectWarehouseByName(String name){
        Hurtownia warehouse = null;
        try {
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            PreparedStatement getWarehouse = conn.prepareStatement("SELECT * from hurtownia WHERE nazwa = ? LIMIT 1");
            getWarehouse.setString(1, name);
            ResultSet rs = getWarehouse.executeQuery();

            while (rs.next()) {
                warehouse = new Hurtownia(rs.getInt(1), rs.getString(2), rs.getString(3));
            }
            st.close();
        } catch(SQLException ex){
            ex.printStackTrace();
        }
        return warehouse;
    }

    List<DaneKlienta> selectAllFromDaneKlienta(){
        List<DaneKlienta> clients = new ArrayList<>();
        try {
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * from dane_klienta");

            while (rs.next()) {
                clients.add(new DaneKlienta(rs.getInt("id_klient"), rs.getString("imie"),
                        rs.getString("nazwisko"),String.valueOf(rs.getInt("telefon_kontaktowy"))));
            }
            st.close();
        } catch(SQLException ex){
            ex.printStackTrace();
        }
        return clients;
    }

    List<Kategoria> selectAllFromKategoria(){
        List<Kategoria> categories = new ArrayList<>();
        try {
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * from kategoria");

            while (rs.next()) {
                categories.add(new Kategoria(rs.getInt("id_kategoria"),
                        Kategoria.category.valueOf(rs.getString("nazwa"))));
            }
            st.close();
        } catch(SQLException ex){
            ex.printStackTrace();
        }
        return categories;
    }

    List<Produkt> selectAllFromProdukt(){
        List<Produkt> products = new ArrayList<>();
        try {
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * from produkt");

            while (rs.next()) {
                products.add(new Produkt(rs.getInt("id_produkt"),
                        rs.getString("nazwa"), rs.getDouble("koszt"),
                        rs.getInt("kategoria_id_kategoria")));
            }
            st.close();
        } catch(SQLException ex){
            ex.printStackTrace();
        }
        return products;
    }

    List<String> selectProductNameProdukt(){
        List<String> products = new ArrayList<>();
        try {
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT nazwa from produkt");

            while (rs.next()) {
                products.add(rs.getString(1));
            }
            st.close();
        } catch(SQLException ex){
            ex.printStackTrace();
        }
        return products;
    }
    String selectProductById(Integer id){
        String product = null;
        try {
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            PreparedStatement getProductName = conn.prepareStatement("SELECT nazwa from produkt WHERE id_produkt = ? LIMIT 1");
            getProductName.setInt(1, id);
            ResultSet rs = getProductName.executeQuery();
            if(rs.next()) {
                product = rs.getString(1);
            }
            st.close();
        } catch(SQLException ex){
            ex.printStackTrace();
        }
        return product;
    }

    BigDecimal sumProducts(String[] products){
        BigDecimal sum = new BigDecimal(0.0);
        try {
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            for (String product: products) {
                PreparedStatement getProductCost = conn.prepareStatement("SELECT koszt from produkt WHERE nazwa = ? LIMIT 1");
                getProductCost.setString(1, product);
                ResultSet rs = getProductCost.executeQuery();
                if(rs.next()) {

                    sum = sum.add(new BigDecimal(rs.getDouble(1)));

                }
            }

            st.close();
        } catch(SQLException ex){
            ex.printStackTrace();
        }
        sum = sum.setScale(2, RoundingMode.HALF_UP);
        return sum;
    }

    List<Dostawa> selectAllFromDostawa(){
        List<Dostawa> deliveries = new ArrayList<>();
        try {
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * from dostawa");

            while (rs.next()) {
                deliveries.add(new Dostawa(rs.getInt("id_dostawa"),
                        rs.getDate("data_dostawy"), rs.getFloat("koszt"),
                        rs.getInt("hurtownia_id_hurtownia"),rs.getInt("pracownik_id_odbierajacego")));
            }
            st.close();
        } catch(SQLException ex){
            ex.printStackTrace();
        }
        return deliveries;
    }

    List<String> selectDataFromDostawa(){
        List<String> deliveries = new ArrayList<>();
        try {
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(
                    "SELECT dostawa.data_dostawy, dostawa.koszt, hurtownia.nazwa FROM dostawa INNER JOIN hurtownia ON dostawa.hurtownia_id_hurtownia=hurtownia.id_hurtownia");

            while (rs.next()) {
                deliveries.add(rs.getDate(1).toString() + " " + rs.getDouble(2) + " " + rs.getString(3));
            }
            st.close();
        } catch(SQLException ex){
            ex.printStackTrace();
        }
        return deliveries;
    }

    List<Magazyn> selectAllFromMagazyn(){
        List<Magazyn> warehouses = new ArrayList<>();
        try {
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * from magazyn");

            while (rs.next()) {
                warehouses.add(new Magazyn(rs.getInt("ilosc"),
                        rs.getInt("nr_polki"), rs.getInt("nr_alejki"),
                        rs.getInt("produkt_id_produkt")));
            }
            st.close();
        } catch(SQLException ex){
            ex.printStackTrace();
        }
        return warehouses;
    }

    List<Pozycja_dostawa> selectAllFromPozycjaDostawa(){
        List<Pozycja_dostawa> positions_deliveries = new ArrayList<>();
        try {
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * from pozycja_dostawa");

            while (rs.next()) {
                positions_deliveries.add(new Pozycja_dostawa(rs.getInt("ilosc_produktu"),
                        rs.getInt("dostawa_id_dostawa"), rs.getInt("produkt_id_produkt")));
            }
            st.close();
        } catch(SQLException ex){
            ex.printStackTrace();
        }
        return positions_deliveries;
    }

    List<Pozycja_paragon> selectAllFromPozycjaParagon(){
        List<Pozycja_paragon> positions_receipts = new ArrayList<>();
        try {
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * from pozycja_paragon");

            while (rs.next()) {
                positions_receipts.add(new Pozycja_paragon(rs.getInt("ilosc"),
                        rs.getFloat("cena_jednostkowa"), rs.getInt("transakcja_id_transakcja"),
                        rs.getInt("produkt_id_produkt")));
            }
            st.close();
        } catch(SQLException ex){
            ex.printStackTrace();
        }
        return positions_receipts;
    }

    List<Pozycja_transport> selectAllFromPozycjaTransport(){
        List<Pozycja_transport> positions_transports = new ArrayList<>();
        try {
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * from pozycja_transport");

            while (rs.next()) {
                positions_transports.add(new Pozycja_transport(rs.getInt("ilosc"),
                        rs.getInt("transport_id_transport"),
                        rs.getInt("produkt_id_produkt")));
            }
            st.close();
        } catch(SQLException ex){
            ex.printStackTrace();
        }
        return positions_transports;
    }

    List<Pozycja_zamowienie> selectAllFromPozycjaZamowienie(){
        List<Pozycja_zamowienie> positions_orders = new ArrayList<>();
        try {
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * from pozycja_zamowienie");

            while (rs.next()) {
                positions_orders.add(new Pozycja_zamowienie(rs.getInt("ilosc"),
                        rs.getFloat("koszt"),
                        rs.getInt("zamowienie_id_zamowienie"),
                        rs.getInt("produkt_id_produkt")));
            }
            st.close();
        } catch(SQLException ex){
            ex.printStackTrace();
        }
        return positions_orders;
    }

    List<Produkt_hurtownia> selectAllFromProduktHurtownia(){
        List<Produkt_hurtownia> products_warehouses = new ArrayList<>();
        try {
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * from produkt_hurtownia");

            while (rs.next()) {
                products_warehouses.add(new Produkt_hurtownia(rs.getInt("produkt_id_produkt"),
                        rs.getInt("hurtownia_id_hurtownia")));
            }
            st.close();
        } catch(SQLException ex){
            ex.printStackTrace();
        }
        return products_warehouses;
    }

    List<Sklep> selectAllFromSklep(){
        List<Sklep> shops = new ArrayList<>();
        try {
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * from sklep");

            while (rs.next()) {
                shops.add(new Sklep(rs.getInt("ilosc"),
                        rs.getInt("produkt_id_produkt")));
            }
            st.close();
        } catch(SQLException ex){
            ex.printStackTrace();
        }
        return shops;
    }

    List<Faktura> selectAllFromFaktura(){
        List<Faktura> invoices = new ArrayList<>();
        try {
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * from faktura");

            while (rs.next()) {
                invoices.add(new Faktura(rs.getInt(1), rs.getString(2),
                        rs.getDate(3), rs.getBoolean(4), rs.getString(5),
                        rs.getString(6), rs.getString(7), rs.getInt(8)));
            }
            st.close();
        } catch(SQLException ex){
            ex.printStackTrace();
        }
        return invoices;
    }

    List<String> selectInvoceNumberFromFaktura(){
        List<String> invoiceNumbers = new ArrayList<>();
        try {
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT nr_faktury from faktura");

            while (rs.next()) {
                invoiceNumbers.add(rs.getString(1));
            }
            st.close();
        } catch(SQLException ex){
            ex.printStackTrace();
        }
        return invoiceNumbers;
    }

    List<Szczegolowe_informacje> selectAllFromSzczegoloweInformacje(){
        List<Szczegolowe_informacje> detail_informations = new ArrayList<>();
        try {
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * from szczegolowe_informacje");

            while (rs.next()) {
                detail_informations.add(new Szczegolowe_informacje(rs.getString("kolor"),
                        rs.getInt("waga"),
                        rs.getString("dodatkowe_informacje"),
                        rs.getString("alergeny"),
                        rs.getString("wymiary"),
                        rs.getInt("produkt_id_produkt")));
            }
            st.close();
        } catch(SQLException ex){
            ex.printStackTrace();
        }
        return detail_informations;
    }

    List<Transport> selectAllFromTransport(){
        List<Transport> transports = new ArrayList<>();
        try {
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * from transport");

            while (rs.next()) {
                transports.add(new Transport(rs.getInt("id_transport"),
                        rs.getDate("data"),
                        rs.getInt("pracownik_id_pracownik")));
            }
            st.close();
        } catch(SQLException ex){
            ex.printStackTrace();
        }
        return transports;
    }

    List<Zamowienie> selectAllFromZamowienie(){
        List<Zamowienie> orders = new ArrayList<>();
        try {
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * from zamowienie");

            while (rs.next()) {
                orders.add(new Zamowienie(rs.getInt("id_zamowienie"),
                        rs.getString("czy_zrealizowano"),
                        rs.getDate("termin_zlozenia"),
                        rs.getDate("przewidywany_termin_realizacji"),
                        rs.getInt("dane_klienta_id_klient")));
            }
            st.close();
        } catch(SQLException ex){
            ex.printStackTrace();
        }
        return orders;
    }

    public Pracownik selectPracownik(String name, String surname) {
        Pracownik employee = null;
        try {
            Connection conn = getConnection();
            PreparedStatement getEmployee = conn.prepareStatement("SELECT * from pracownik WHERE imie = ? AND nazwisko = ? LIMIT 1");
            getEmployee.setString(1, name);
            getEmployee.setString(2, surname);
            ResultSet rs = getEmployee.executeQuery();
            if (rs.next()) {
                employee = new Pracownik(rs.getInt(1),rs.getString(2),rs.getString(3),
                        rs.getInt(4));
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return employee;
    }

    public Szczegolowe_informacje getDetails(String productName){
        Szczegolowe_informacje szczegoly=null;
        try {
            Connection conn = getConnection();
            PreparedStatement getDetail = conn.prepareStatement("SELECT * from szczegolowe_informacje JOIN produkt " +
                    "ON szczegolowe_informacje.produkt_id_produkt = produkt.id_produkt " +
                    "WHERE produkt.nazwa = ?");
            getDetail.setString(1, productName);
            ResultSet rs = getDetail.executeQuery();
            if(rs.next()){
                szczegoly =  new Szczegolowe_informacje(rs.getString(1), rs.getInt(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getInt(6));
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return szczegoly;
    }

    public SzczegolyFaktura getInvoiceDetails(String nrFaktura){
        SzczegolyFaktura szczegoly=null;
        try{
            Connection conn = getConnection();
            PreparedStatement getDetail = conn.prepareStatement("select * from faktura join transakcja " +
                    "on faktura.transakcja_id_transakcja = transakcja.id_transakcja " +
                    "where faktura.nr_faktury = ?");
            getDetail.setString(1, nrFaktura);
            ResultSet rs = getDetail.executeQuery();
            if(rs.next()){
                szczegoly =  new SzczegolyFaktura(rs.getInt(1), rs.getString(2), rs.getDate(3),
                        rs.getBoolean(4), rs.getString(5), rs.getString(6), rs.getString(7),
                        rs.getInt(8), rs.getDate(10), rs.getDouble(11), rs.getInt(12));
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return szczegoly;
    }

    List<Integer> selectOrderNames(){
        List<Integer> orderNames = new ArrayList<>();
        try {
            Connection conn = getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT id_zamowienie from zamowienie order by id_zamowienie");

            while (rs.next()) {
                orderNames.add(rs.getInt(1));
            }
            st.close();
        } catch(SQLException ex){
            ex.printStackTrace();
        }
        return orderNames;
    }

    List<SzczegolyZamowienie> selectOrderDetails(Integer nrFaktura){
        List<SzczegolyZamowienie> orderDetails = new ArrayList<>();
        try {
            Connection conn = getConnection();
            PreparedStatement getOrderDetails = conn.prepareStatement("select * from zamowienie join pozycja_zamowienie " +
                    "on zamowienie.id_zamowienie = pozycja_zamowienie.zamowienie_id_zamowienie join produkt " +
                    "on produkt.id_produkt = pozycja_zamowienie.produkt_id_produkt join dane_klienta " +
                    "on dane_klienta.id_klient = zamowienie.dane_klienta_id_klient " +
                    "where zamowienie.id_zamowienie = ?");
            getOrderDetails.setInt(1,nrFaktura);
            ResultSet rs = getOrderDetails.executeQuery();

            while (rs.next()) {
                orderDetails.add(new SzczegolyZamowienie(rs.getInt(1), rs.getBoolean(2),
                        rs.getDate(3), rs.getDate(4), rs.getInt(6), rs.getDouble(7),
                        rs.getString(11), rs.getString(15), rs.getString(16)));
            }
            rs.close();
        } catch(SQLException ex){
            ex.printStackTrace();
        }
        return orderDetails;
    }

}