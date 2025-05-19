package auth;

import database.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AccountManager {
    private DatabaseConnection dbc;

    public boolean register(String login, String password) {
        PreparedStatement ps = dbc.getConnection().prepareStatement("");
        return false;
    }
    public boolean authenticate(Account account){

        return false;
    }

    public Account getAccount(){

        return new Account(1,"");
    }
}
