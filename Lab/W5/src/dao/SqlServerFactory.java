package dao;

import java.sql.*;

public class SqlServerFactory extends DatabaseFactory {
    static {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Connection createConnection(String connStr) throws SQLException {
        return DriverManager.getConnection(connStr);
    }

    @Override
    public PreparedStatement createCommand(Connection conn, String query) throws SQLException {
        return conn.prepareStatement(query);
    }

    @Override
    public ResultSet executeQuery(PreparedStatement stmt) throws SQLException {
        return stmt.executeQuery();
    }
}
