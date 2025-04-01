package service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import dao.DatabaseFactory;
import models.Student;

public class StudentService {
    private final DatabaseFactory factory;
    private final String connStr;

    public StudentService(DatabaseFactory factory, String connStr) {
        this.factory = factory;
        this.connStr = connStr;
    }

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        try (Connection conn = factory.createConnection(connStr)) {
            String query = "SELECT * FROM Students";
            try (PreparedStatement stmt = factory.createCommand(conn, query)) {
                try (ResultSet rs = factory.executeQuery(stmt)) {
                    while (rs.next()) {
                        String mssv = rs.getString("MSSV");
                        String hoTen = rs.getString("HoTen");
                        String ngaySinh = rs.getString("NgaySinh");
                        String lop = rs.getString("Lop");
                        students.add(new Student(mssv, hoTen, ngaySinh, lop));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    public void addStudent(Student s) {
        try (Connection conn = factory.createConnection(connStr)) {
            String query = "INSERT INTO Students (MSSV, HoTen, NgaySinh, Lop) VALUES (?, ?, ?, ?)";
            try (PreparedStatement stmt = factory.createCommand(conn, query)) {
                stmt.setString(1, s.getMssv());
                stmt.setString(2, s.getHoTen());
                stmt.setString(3, s.getNgaySinh());
                stmt.setString(4, s.getLop());
                stmt.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent(String mssv) {
        try (Connection conn = factory.createConnection(connStr)) {
            String query = "DELETE FROM Students WHERE MSSV = ?";
            try (PreparedStatement stmt = factory.createCommand(conn, query)) {
                stmt.setString(1, mssv);
                stmt.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateStudent(Student s) {
        try (Connection conn = factory.createConnection(connStr)) {
            String query = "UPDATE Students SET HoTen = ?, NgaySinh = ?, Lop = ? WHERE MSSV = ?";
            try (PreparedStatement stmt = factory.createCommand(conn, query)) {
                stmt.setString(1, s.getHoTen());
                stmt.setString(2, s.getNgaySinh());
                stmt.setString(3, s.getLop());
                stmt.setString(4, s.getMssv());
                stmt.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}