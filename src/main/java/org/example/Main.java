package org.example;

import database.DatabaseConnection;

public class Main {
    public static void main(String[] args) {
        DatabaseConnection dbs = new DatabaseConnection();
        dbs.connect("university.sqlite");
    }
}