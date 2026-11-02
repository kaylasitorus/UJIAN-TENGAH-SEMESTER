package koneksi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Koneksi {

    public static Connection getKoneksi() {
        Connection conn = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/db_inventori",
                "root",
                ""
            );

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Koneksi gagal: " + e.getMessage());
        }

        return conn;
    }
}