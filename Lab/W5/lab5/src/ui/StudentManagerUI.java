package ui;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

import models.Student;
import service.StudentService;

public class StudentManagerUI extends JFrame {
    private final StudentService service;
    private JTable table;
    private DefaultTableModel tableModel;

    public StudentManagerUI(StudentService service) {
        this.service = service;
        initUI();
        loadData();
    }

    private void initUI() {
        setTitle("Quản lý sinh viên");
        setSize(800, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(220, 230, 250));

        // Table
        tableModel = new DefaultTableModel(new String[] { "MSSV", "Họ Tên", "Ngày Sinh", "Lớp" }, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);

        // ✨ Tùy chỉnh bảng
        table.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        table.setRowHeight(28);
        table.setBackground(new Color(245, 245, 255));
        table.setForeground(Color.BLACK);
        table.setSelectionBackground(new Color(200, 220, 255));
        table.setSelectionForeground(Color.BLACK);

        JTableHeader header = table.getTableHeader();
        header.setBackground(new Color(180, 200, 240));
        header.setForeground(Color.BLACK);
        header.setFont(new Font("Segoe UI", Font.BOLD, 14));

        // Căn giữa nội dung bảng
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

        add(scrollPane, BorderLayout.CENTER);

        // Form
        JPanel form = new JPanel(new GridBagLayout());
        form.setBackground(new Color(230, 240, 255));
        form.setBorder(new EmptyBorder(15, 15, 15, 15));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel lblMSSV = new JLabel("MSSV:", SwingConstants.RIGHT);
        JLabel lblHoTen = new JLabel("Họ tên:", SwingConstants.RIGHT);
        JLabel lblNgaySinh = new JLabel("Ngày sinh:", SwingConstants.RIGHT);
        JLabel lblLop = new JLabel("Lớp:", SwingConstants.RIGHT);

        JTextField tfMSSV = new JTextField(15);
        JTextField tfHoTen = new JTextField(15);
        JTextField tfNgaySinh = new JTextField(15);
        JTextField tfLop = new JTextField(15);

        JButton btnAdd = new JButton("Thêm");
        JButton btnDelete = new JButton("Xóa");
        JButton btnUpdate = new JButton("Sửa");

        // Left side (labels + textfields)
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        form.add(lblMSSV, gbc);
        gbc.gridy++;
        form.add(lblHoTen, gbc);
        gbc.gridy++;
        form.add(lblNgaySinh, gbc);
        gbc.gridy++;
        form.add(lblLop, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        form.add(tfMSSV, gbc);
        gbc.gridy++;
        form.add(tfHoTen, gbc);
        gbc.gridy++;
        form.add(tfNgaySinh, gbc);
        gbc.gridy++;
        form.add(tfLop, gbc);

        // Right side (buttons)
        JPanel buttonPanel = new JPanel(new GridLayout(3, 1, 5, 5));
        buttonPanel.setBackground(new Color(230, 240, 255));
        buttonPanel.add(btnAdd);
        buttonPanel.add(btnDelete);
        buttonPanel.add(btnUpdate);

        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.gridheight = 4;
        gbc.anchor = GridBagConstraints.CENTER;
        form.add(buttonPanel, gbc);

        add(form, BorderLayout.SOUTH);

        // Actions
        btnAdd.addActionListener(e -> {
            Student s = new Student(tfMSSV.getText(), tfHoTen.getText(), tfNgaySinh.getText(), tfLop.getText());
            service.addStudent(s);
            loadData();
            tfMSSV.setEnabled(true);

            tfMSSV.setText("");
            tfHoTen.setText("");
            tfNgaySinh.setText("");
            tfLop.setText("");
        });

        btnDelete.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row != -1) {
                String mssv = tableModel.getValueAt(row, 0).toString();
                service.deleteStudent(mssv);
                loadData();
                tfMSSV.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(this, "Chọn một sinh viên để xóa.");
            }
        });

        btnUpdate.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row != -1) {
                Student s = new Student(tfMSSV.getText(), tfHoTen.getText(), tfNgaySinh.getText(), tfLop.getText());
                service.updateStudent(s);
                loadData();
                tfMSSV.setEnabled(true);
            } else {
                JOptionPane.showMessageDialog(this, "Chọn một sinh viên để sửa.");
            }
        });

        table.getSelectionModel().addListSelectionListener(e -> {
            int row = table.getSelectedRow();
            if (row != -1) {
                tfMSSV.setText(tableModel.getValueAt(row, 0).toString());
                tfHoTen.setText(tableModel.getValueAt(row, 1).toString());
                tfNgaySinh.setText(tableModel.getValueAt(row, 2).toString());
                tfLop.setText(tableModel.getValueAt(row, 3).toString());
                tfMSSV.setEnabled(false);
            } else {
                tfMSSV.setEnabled(true);
            }
        });
    }

    private void loadData() {
        tableModel.setRowCount(0);
        for (Student s : service.getAllStudents()) {
            tableModel.addRow(new Object[] { s.getMssv(), s.getHoTen(), s.getNgaySinh(), s.getLop() });
        }
    }
}