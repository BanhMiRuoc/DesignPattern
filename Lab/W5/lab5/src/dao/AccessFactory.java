package dao;

import java.sql.*;

public class AccessFactory extends DatabaseFactory {
    static {
        try {
            Class.forName("net.ucanaccess.jdbc.ucanaccessDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection createConnection(String connStr) throws SQLException {
        return DriverManager.getConnection(connStr);
    }

    public PreparedStatement createCommand(Connection conn, String query) throws SQLException {
        return conn.prepareStatement(query);
    }

    public ResultSet executeQuery(PreparedStatement stmt) throws SQLException {
        return stmt.executeQuery();
    }
}