package device;

import javax.swing.*;

public class Fan implements Device {
    public void on() {
        JOptionPane.showMessageDialog(null, "Fan is ON");
    }
    public void off() {
        JOptionPane.showMessageDialog(null, "Fan is OFF");
    }
}
