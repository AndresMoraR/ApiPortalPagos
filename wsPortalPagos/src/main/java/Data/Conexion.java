package Data;

import java.sql.*;
import javax.sql.DataSource;
import oracle.jdbc.pool.OracleDataSource;

/**
 * Class conexion to oracle database.
 * @author Andres Mora
 */
public class Conexion {
    private static final String JDBC_URL = "jdbc:oracle:thin:@srvprebd-scan.colsanitas.com:1521/PSINU";
    private static final String JDBC_USER = "bamoraro";
    private static final String JDBC_PASSWORD = "PresInu2020";
    
    private static OracleDataSource dataSource;

    public static DataSource getDataSource() throws SQLException {
        if (dataSource == null) {
            dataSource = new OracleDataSource();
            dataSource.setURL(JDBC_URL);
            dataSource.setUser(JDBC_USER);
            dataSource.setPassword(JDBC_PASSWORD);
        }
        return dataSource;
    }
    
    public static Connection getConnection() throws SQLException {
        return getDataSource().getConnection();
    } 
    
    public static void close(ResultSet rs) {
        try {
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public static void close(PreparedStatement stmt) {
        try {
            stmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public static void close(Connection conn) {
        try {
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }      
}
