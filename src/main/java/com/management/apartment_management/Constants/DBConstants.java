package com.management.apartment_management.Constants;

public class DBConstants {
    public DBConstants() {}

    public static final String DATABASE = "jdbc:mysql://localhost:3306/itss";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "03062002";

    public static final int ROWS_PER_PAGE = 10;
    private static Connection con;

    public static Connection getConnected() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        String dbName = "RRMSDataBase.db";
        if (con == null) {
            // if (createDB(dbName) && con == null) {
            Class.forName("org.sqlite.JDBC").newInstance();
            con = DriverManager.getConnection("jdbc:sqlite:" + dbName);

        }
        return con;
    }

    private static boolean createDB(String name) {
        File dbFile = new File(name);
        if (!dbFile.exists()) {
            try {
                return dbFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        } else {
            return true;
        }
    }
}
