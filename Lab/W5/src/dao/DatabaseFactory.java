package dao;

import java.sql.*;

public abstract class DatabaseFactory {
    public abstract Connection createConnection(String connStr) throws SQLException;

    public abstract PreparedStatement createCommand(Connection conn, String query) throws SQLException;

    public abstract ResultSet executeQuery(PreparedStatement stmt) throws SQLException;
}