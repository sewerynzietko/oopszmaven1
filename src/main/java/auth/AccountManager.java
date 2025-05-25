package auth;

import database.DatabaseConnection;
import org.mindrot.jbcrypt.BCrypt;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountManager {
    private DatabaseConnection dbc;

    public AccountManager(DatabaseConnection dbc) {
        this.dbc = dbc;
    }

    public boolean register(String login, String password) {
        String hashed_password = BCrypt.hashpw(password, BCrypt.gensalt());
        try {
            PreparedStatement ps = dbc.getConnection().prepareStatement("INSERT INTO accounts (name, password) VALUES (?, ?)");
            ps.setString(1, login);
            ps.setString(2, hashed_password);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("Błąd przy rejestracji: " + e.getMessage());
        }
        return false;
    }
    public boolean authenticate(String login, String password){
        try {
            PreparedStatement ps = dbc.getConnection().prepareStatement("SELECT password FROM accounts WHERE name = ?");
            ps.setString(1,login);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                String hashed_password = rs.getString("password");
                return BCrypt.checkpw(password, hashed_password);
            }
        } catch (SQLException e) {
            System.out.println("Błąd przy weryfikacji: " + e.getMessage());
        }
        return false;
    }

    public Account getAccount(String login) {
        try {
            PreparedStatement ps = dbc.getConnection().prepareStatement("SELECT id, name FROM accounts WHERE name = ?");
            ps.setString(1, login);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Account(rs.getInt("id"), rs.getString("name"));
            }
        } catch (SQLException e) {
            System.out.println("Błąd przy weryfikacji: " + e.getMessage());
        }
        return null;
    }
}
