package ml.salesail.jdbc;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
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
        try(Statement statement = connectionJDBC.createStatement();
            BufferedReader bufferedReader = new BufferedReader( new FileReader("src/main/resources/sql/CreateTableCartridges.sql"));) {
            StringBuilder sql = new StringBuilder();
            while (bufferedReader.ready()){
                sql.append(bufferedReader.readLine());
            }
            statement.executeUpdate(sql.toString());
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
