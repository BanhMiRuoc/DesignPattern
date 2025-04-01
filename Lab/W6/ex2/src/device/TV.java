package device;

import javax.swing.*;

public class TV implements Device {
    public void on() {
        JOptionPane.showMessageDialog(null, "TV is ON");
    }
    public void off() {
        JOptionPane.showMessageDialog(null, "TV is OFF");
    }
}
