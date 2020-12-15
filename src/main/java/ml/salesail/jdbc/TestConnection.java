package ml.salesail.jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class TestConnection {
    static Properties property = new Properties();
    static Connection connectionJDBC;

    public static void main(String[] args) {
        try (FileInputStream fileInputStream = new FileInputStream("src/main/resources/JDBC.properties")) {
            property.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            connectionJDBC = DriverManager.getConnection(
                    property.getProperty("db.host"),
                    property.getProperty("db.login"),
                    property.getProperty("db.password")
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
