package travel.management.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn {
    Connection c;
    Statement s;

    public Conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            // ✅ Correct JDBC URL: host, port, and database name
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/gofly", "root", "9068");

            s = c.createStatement();
        } catch (Exception e) {
            System.out.println("Database Connection Error: " + e.getMessage());
        }
    }
}
