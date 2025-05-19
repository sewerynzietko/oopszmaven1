package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public void connect(String dbUrl){
        try {
            String url = "jdbc:sqlite:" + dbUrl;
            if(connection == null)
                connection = DriverManager.getConnection(url);
            else
                System.out.println("Już jesteś połączony");
        }
        catch(SQLException e){
            System.out.println("Nawiązanie z bazą danych się nie powiodło");
        }
    }

    public void disconnect(String path){

    }
}
