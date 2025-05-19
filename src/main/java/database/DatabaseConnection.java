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
        if(connection == null){
            String url = "jdbc:sqlite:" + dbUrl;
        try {
            connection = DriverManager.getConnection(url);
        }
        catch(SQLException e){
            System.out.println("Nawiązanie z bazą danych się nie powiodło");
        }}
        else
            System.out.println("Już jesteś połączony");
    }

    public void disconnect(String path){
        if(connection != null){
            try{
                connection.close();
            } catch (SQLException e) {
                System.out.println("Próba rozłączenia nie powiodła się");
            }
        }
    }
}
