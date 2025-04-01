import command.RemoteControl;
import command.TurnOffCommand;
import command.TurnOnCommand;
import device.Device;
import device.Fan;
import device.Light;
import device.TV;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainFrame extends JFrame {
    private final int SLOT_COUNT = 4;
    private JPanel[] slotPanels = new JPanel[SLOT_COUNT];
    private JLabel[] deviceLabels = new JLabel[SLOT_COUNT];
    private JButton[] onButtons = new JButton[SLOT_COUNT];
    private JButton[] offButtons = new JButton[SLOT_COUNT];
    private RemoteControl remote = new RemoteControl(SLOT_COUNT);

    public MainFrame() {
        setTitle("Remote Control");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 2, 10, 10));
        setSize(600, 400);

        for (int i = 0; i < SLOT_COUNT; i++) {
            JPanel panel = new JPanel();
            panel.setLayout(new FlowLayout());
            panel.setBorder(BorderFactory.createTitledBorder("Slot " + (i + 1)));

            JLabel label = new JLabel("No Device");
            JButton btnOn = new JButton("ON");
            JButton btnOff = new JButton("OFF");

            btnOn.setEnabled(false);
            btnOff.setEnabled(false);

            int index = i;

            btnOn.addActionListener(e -> {
                remote.pressOn(index);
                panel.setBackground(Color.GREEN);
            });

            btnOff.addActionListener(e -> {
                remote.pressOff(index);
                panel.setBackground(Color.LIGHT_GRAY);
            });

            JPopupMenu menu = new JPopupMenu();
            JMenuItem lightItem = new JMenuItem("Light");
            JMenuItem fanItem = new JMenuItem("Fan");
            JMenuItem tvItem = new JMenuItem("TV");
            JMenuItem removeItem = new JMenuItem("Gỡ bỏ");

            lightItem.addActionListener(e -> attachDevice(index, new Light(), panel, label, btnOn, btnOff));
            fanItem.addActionListener(e -> attachDevice(index, new Fan(), panel, label, btnOn, btnOff));
            tvItem.addActionListener(e -> attachDevice(index, new TV(), panel, label, btnOn, btnOff));
            removeItem.addActionListener(e -> removeDevice(index, panel, label, btnOn, btnOff));

            menu.add(lightItem);
            menu.add(fanItem);
            menu.add(tvItem);
            menu.addSeparator();
            menu.add(removeItem);

            panel.setComponentPopupMenu(menu);
            panel.add(label);
            panel.add(btnOn);
            panel.add(btnOff);

            slotPanels[i] = panel;
            deviceLabels[i] = label;
            onButtons[i] = btnOn;
            offButtons[i] = btnOff;

            add(panel);
        }

        setVisible(true);
    }

    private void attachDevice(int slot, Device device, JPanel panel, JLabel label, JButton btnOn, JButton btnOff) {
        remote.setCommand(slot, new TurnOnCommand(device), new TurnOffCommand(device));
        label.setText(device.getClass().getSimpleName());
        btnOn.setEnabled(true);
        btnOff.setEnabled(true);
        panel.setBackground(Color.LIGHT_GRAY);
    }

    private void removeDevice(int slot, JPanel panel, JLabel label, JButton btnOn, JButton btnOff) {
        remote.removeCommand(slot);
        label.setText("No Device");
        btnOn.setEnabled(false);
        btnOff.setEnabled(false);
        panel.setBackground(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainFrame::new);
    }
}
