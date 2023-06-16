package util;

import java.sql.Connection;
import java.sql.SQLException;

public class DML_DAO { //zum ausführen der SQL Statements
    public static void executeDML (String sql) {
        Connection con;
        
        try {
            con = DBConnector.connect();
            con.createStatement().executeUpdate(sql);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
