package ex2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame implements ProgressObserver {
    private final JTextField inputField;
    private final JButton startButton;
    private final JProgressBar progressBar;
    private final JLabel statusLabel;

    public MainFrame() {
        setTitle("Progress App");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        add(new JLabel("Nhập N:"));
        inputField = new JTextField(10);
        add(inputField);

        startButton = new JButton("Bắt đầu");
        add(startButton);

        statusLabel = new JLabel(" ");
        add(statusLabel);

        progressBar = new JProgressBar(0, 100);
        progressBar.setStringPainted(true);
        add(progressBar);
        progressBar.setVisible(false);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int n = Integer.parseInt(inputField.getText());
                    startButton.setEnabled(false);
                    progressBar.setValue(0);
                    progressBar.setMaximum(n);
                    progressBar.setVisible(true);
                    statusLabel.setText("Đang xử lý: 0/" + n);

                    ProcessingTask task = new ProcessingTask(n);
                    task.addObserver(MainFrame.this);

                    Thread thread = new Thread(task);
                    thread.start();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Nhập số nguyên hợp lệ!");
                }
            }
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void onProgressUpdate(int current, int total) {
        SwingUtilities.invokeLater(() -> {
            progressBar.setValue(current);
            statusLabel.setText("Đang xử lý: " + current + "/" + total);
        });
    }

    @Override
    public void onComplete() {
        SwingUtilities.invokeLater(() -> {
            startButton.setEnabled(true);
            progressBar.setVisible(false);
            statusLabel.setText("Hoàn tất!");
        });
    }

    public static void main(String[] args) {
        new MainFrame();
    }
}
