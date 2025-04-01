package device;

import javax.swing.*;

public class Light implements Device {
    public void on() {
        JOptionPane.showMessageDialog(null, "Light is ON");
    }
    public void off() {
        JOptionPane.showMessageDialog(null, "Light is OFF");
    }
}
