package org.example;

import auth.Account;
import auth.AccountManager;
import database.DatabaseConnection;

import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        DatabaseConnection dbs = new DatabaseConnection();
        dbs.connect("site.sqlite");

        AccountManager am = new AccountManager(dbs);
        if(am.register("user1", "pass1")){
            System.out.println("Użytkownik zarejestrowany.");}

        if(am.authenticate("user1", "pass1")){
        System.out.println("Logowanie poprawne.");}
        else{
        System.out.println("Logowanie niepoprawne.");}

        Account account1 = am.getAccount("user1");
        if (account1 != null) {
            System.out.println("Znaleziono konto: " + account1.id() + " " + account1.accountName());
        }
    }
}
