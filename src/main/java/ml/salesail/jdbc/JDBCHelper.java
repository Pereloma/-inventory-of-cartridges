package ml.salesail.jdbc;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCHelper {
    private static JDBCHelper jdbcHelper;
    private static Properties property = new Properties();
    private static Connection connectionJDBC;

    private JDBCHelper() {
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
        executeSQLRequestFromFile("src/main/resources/sql/CreateTableHospital.sql");
        executeSQLRequestFromFile("src/main/resources/sql/CreateTableStatus.sql");
        executeSQLRequestFromFile("src/main/resources/sql/CreateTableCartridges.sql");
        executeSQLRequestFromFile("src/main/resources/sql/CreateTableSendingForFueling.sql");
    }

    public static JDBCHelper getJDBCHelper() {
        if (jdbcHelper == null)
            return new JDBCHelper();
        else
            return jdbcHelper;
    }


    private static boolean executeSQLRequestFromFile (String sqlFile){
        try(Statement statement = connectionJDBC.createStatement();
            BufferedReader bufferedReader = new BufferedReader( new FileReader(sqlFile))) {
            StringBuilder sql = new StringBuilder();
            while (bufferedReader.ready()){
                sql.append(bufferedReader.readLine());
            }
            statement.executeUpdate(sql.toString());
        } catch (SQLException | IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean addHospital(String abbreviation,String name,String address,String comment){
        try(Statement statement = connectionJDBC.createStatement()){
            String sql = String.format(
                    "INSERT INTO Hospital (abbreviation, name, address, comment)" +
                    "VALUES ('%s', '%s', '%s', '%s')"
                    ,abbreviation,name,address,comment);
            statement.executeUpdate(sql);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
