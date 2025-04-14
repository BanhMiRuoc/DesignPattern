import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.event.*;
import java.io.*;

public class SimpleNotepad extends JFrame {
    private JTextArea textArea;
    private JFileChooser fileChooser;
    private Clipboard clipboard;

    public SimpleNotepad() {
        setTitle("Simple Notepad");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Text area
        textArea = new JTextArea();
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        // Clipboard
        clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

        // File chooser
        fileChooser = new JFileChooser();

        // Create Menu
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        // File Menu
        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);
        addMenuItem(fileMenu, "New", e -> newFile());
        addMenuItem(fileMenu, "Open", e -> openFile());
        addMenuItem(fileMenu, "Save", e -> saveFile());
        fileMenu.addSeparator();
        addMenuItem(fileMenu, "Exit", e -> System.exit(0));

        // Edit Menu
        JMenu editMenu = new JMenu("Edit");
        menuBar.add(editMenu);
        addMenuItem(editMenu, "Copy", e -> copyText());
        addMenuItem(editMenu, "Paste", e -> pasteText());
        addMenuItem(editMenu, "Delete", e -> textArea.replaceSelection(""));

        // Buttons Panel
        JPanel buttonPanel = new JPanel();
        add(buttonPanel, BorderLayout.NORTH);

        addButton(buttonPanel, "New", e -> newFile());
        addButton(buttonPanel, "Open", e -> openFile());
        addButton(buttonPanel, "Save", e -> saveFile());
        addButton(buttonPanel, "Copy", e -> copyText());
        addButton(buttonPanel, "Paste", e -> pasteText());

        setVisible(true);
    }

    private void addButton(JPanel panel, String name, ActionListener action) {
        JButton button = new JButton(name);
        button.addActionListener(action);
        panel.add(button);
    }

    private void addMenuItem(JMenu menu, String name, ActionListener action) {
        JMenuItem item = new JMenuItem(name);
        item.addActionListener(action);
        menu.add(item);
    }

    private void newFile() {
        textArea.setText("");
    }

    private void openFile() {
        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                textArea.read(reader, null);
            } catch (IOException ex) {
                showError("Could not open file: " + ex.getMessage());
            }
        }
    }

    private void saveFile() {
        if (fileChooser.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                textArea.write(writer);
            } catch (IOException ex) {
                showError("Could not save file: " + ex.getMessage());
            }
        }
    }

    private void copyText() {
        String selectedText = textArea.getSelectedText();
        if (selectedText != null) {
            StringSelection selection = new StringSelection(selectedText);
            clipboard.setContents(selection, null);
        }
    }

    private void pasteText() {
        try {
            Transferable content = clipboard.getContents(null);
            if (content != null && content.isDataFlavorSupported(DataFlavor.stringFlavor)) {
                textArea.insert((String) content.getTransferData(DataFlavor.stringFlavor), textArea.getCaretPosition());
            }
        } catch (Exception ex) {
            showError("Paste failed: " + ex.getMessage());
        }
    }

    private void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SimpleNotepad::new);
    }
}
