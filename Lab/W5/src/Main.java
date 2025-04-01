import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.swing.SwingUtilities;

import dao.AccessFactory;
import dao.DatabaseFactory;
import dao.SqlServerFactory;

import service.StudentService;

import ui.StudentManagerUI;

public class Main {
    public static void main(String[] args) {
        try {
            // Gọi hàm load cấu hình
            Object[] result = loadConfig("config.txt");
            DatabaseFactory factory = (DatabaseFactory) result[0];
            String connStr = (String) result[1];

            StudentService service = new StudentService(factory, connStr);
            SwingUtilities.invokeLater(() -> new StudentManagerUI(service).setVisible(true));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Object[] loadConfig(String filename) throws IOException {
        Properties props = new Properties();
        FileInputStream fis = new FileInputStream(filename);
        props.load(fis);
        fis.close();

        String dbType = props.getProperty("dbtype");
        DatabaseFactory factory;
        String connStr;

        if ("access".equalsIgnoreCase(dbType)) {
            factory = new AccessFactory();
            connStr = "jdbc:ucanaccess://" + props.getProperty("access_path");
        } else if ("sqlserver".equalsIgnoreCase(dbType)) {
            factory = new SqlServerFactory();
            connStr = props.getProperty("sqlserver_path");
        } else {
            throw new RuntimeException("Không nhận diện được loại database: " + dbType);
        }

        return new Object[] { factory, connStr };
    }
}
