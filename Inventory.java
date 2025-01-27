package edu.ucalgary.ensf409;

/**
 * the Registration program implements an application that edits the INVENTORY database in mySQL
 *
 * @author Adam Abouelhassan
 * @version 1.1
 * @since 1.0
 */

import java.sql.*;
import java.io.*;

class Inventory {
    public final String DBURL = "jdbc:mysql://localhost/inventory";       // store the database url information
    public final String USERNAME = "adam";         // store the user's account username
    public final String PASSWORD = "ensf409";       // store the user's account password

    private Connection dbConnect;
    private ResultSet results;

    private String category;
    private String type;
    private int amount;

    public static void main(String[] args) {
        Inventory test = new Inventory();
        test.initializeConnection();

        BufferedReader reader = new BufferedReader(         // for reading input
                new InputStreamReader(System.in));
        String entry = null;
        try {
            System.out.print("User request:");
            entry = reader.readLine();                     // read input line
        } catch (IOException e) {
            e.printStackTrace();
        }
        test.AnalyzeEntry(entry);
    }

    public Inventory() {
        String DBURL = "jdbc:mysql://localhost/inventory";
        String USERNAME = "adam";
        String PASSWORD = "ensf409";
    }

    // getter
    public String getDBURL() {
        return DBURL;
    }

    // getter
    public String getUSERNAME() {
        return USERNAME;
    }

    // getter
    public String getPASSWORD() {
        return PASSWORD;
    }

    // Initialize connection to mysql
    public void initializeConnection() {
        try {
            dbConnect = DriverManager.getConnection(this.DBURL, this.USERNAME, this.PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void AnalyzeEntry(String entry) {

    }

    class Furniture {
        int ID;
        String type;
        String price;
        String manufacturerID;
        boolean usableCondition;
    }

    class Desk extends Furniture {
        boolean legs;
        boolean top;
        boolean drawer;
    }

    class Chair extends Furniture {
        boolean legs;
        boolean arms;
        boolean seat;
        boolean cushion;
    }

    class Lamp extends Furniture {
        boolean base;
        boolean bulb;
    }

    class Filing extends Furniture {
        boolean rails;
        boolean drawer;
        boolean cabinet;
    }
}
