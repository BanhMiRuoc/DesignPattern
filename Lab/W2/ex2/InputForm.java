import validator.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;



public class InputForm extends JFrame {
//    private JTextField integerField, floatField, stringField, emailField, dateField;
    private JButton submitButton;
    private List<MyTextBox> inputFields = new ArrayList<>();

    public InputForm() {
        setTitle("Input Form");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 2));

        addField("Integer:", new IntegerValidator());
        addField("Float:", new FloatValidator());
        addField("String:", new StringValidator());
        addField("Email:", new EmailValidator());
        addField("Date (dd/MM/yyyy):", new DateValidator());

        submitButton = new JButton("Gửi");
        add(submitButton);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validateAndSubmit();
            }
        });
        setVisible(true);

    }
    private void addField(String label, IValidator validator) {
        add(new JLabel(label));
        MyTextBox box = new MyTextBox(validator);
        add(box.getTextField());
        inputFields.add(box);
    }
    private void validateAndSubmit() {
        for (MyTextBox box : inputFields) {
            if(!box.valid()) {
                JOptionPane.showMessageDialog(this, box.getErrorMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "Success", "Info", JOptionPane.INFORMATION_MESSAGE);
    }
    public static void main(String[] args) {
        new InputForm();
    }
}