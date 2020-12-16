package ml.salesail.jdbc;

public class Main {
    public static void main(String[] args) {
        JDBCHelper jdbcHelper = JDBCHelper.getJDBCHelper();
        jdbcHelper.addHospital("test","test","test","test");
    }
}
