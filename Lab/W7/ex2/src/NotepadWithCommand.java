import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.io.File;
import java.util.*;

public class NotepadWithCommand extends JFrame {
    private JTextPane textPane;
    private JFileChooser fileChooser = new JFileChooser();
    private Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    private Map<String, Command> commands = new HashMap<>();
    // Disable and Enable
    private Map<String, AbstractButton> buttons = new HashMap<>();
    private Map<String, JMenuItem> menuItems = new HashMap<>();
    // Tracking text
    private TextVersionTracker textVersionTracker = new TextVersionTracker();
    // Save As -> Save
    private File currentFile = null;

    public NotepadWithCommand() {
        setTitle("Notepad With Command Pattern");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        textPane = new JTextPane();
        textPane.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        JScrollPane scrollPane = new JScrollPane(textPane);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(scrollPane, BorderLayout.CENTER);

        setupCommands();
        setupButtons();
        setupMenus();
        setupListeners();

        getContentPane().setBackground(Color.decode("#f5f7fa"));
        setVisible(true);
    }

    private void setupCommands() {
        commands.put("New", new NewCommand(textPane));
        commands.put("Open", new OpenCommand(textPane, fileChooser, this, textVersionTracker, f -> currentFile = f));
        commands.put("Save", new SaveCommand(textPane, fileChooser, this, textVersionTracker, () -> currentFile, f -> currentFile = f));
        commands.put("Copy", new CopyCommand(textPane, clipboard));
        commands.put("Paste", new PasteCommand(textPane, clipboard));
        commands.put("Delete", new DeleteCommand(textPane));
        commands.put("Bold", new StyleCommand(textPane ,StyleConstants.Bold));
        commands.put("Italic", new StyleCommand(textPane ,StyleConstants.Italic));
        commands.put("Underline", new StyleCommand(textPane ,StyleConstants.Underline));
        commands.put("Color", new ColorCommand(textPane, this));
    }

    private void setupButtons() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 2, 6));
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.LIGHT_GRAY));

        String[] btns = {"New", "Open", "Save", "Copy", "Paste", "Delete", "Bold", "Italic", "Underline", "Color"};
        for (String name : btns) {
            JButton btn = new JButton(name);
            btn.setFocusPainted(false);
            btn.setFont(new Font("Segoe UI", Font.PLAIN, 11));
            btn.setContentAreaFilled(false);
            btn.setBorderPainted(false);
            btn.setMargin(new Insets(2, 6, 2, 6));
            btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            btn.setForeground(Color.DARK_GRAY);
            btn.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    btn.setForeground(new Color(0, 120, 215));
                }
                public void mouseExited(java.awt.event.MouseEvent evt) {
                    btn.setForeground(Color.DARK_GRAY);
                }
            });
            btn.addActionListener(e -> executeCommand(name));
            buttons.put(name, btn);
            panel.add(btn);
        }
        add(panel, BorderLayout.NORTH);
    }

    private void setupMenus() {
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(Color.WHITE);
        menuBar.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

        JMenu fileMenu = new JMenu("File");
        for (String name : new String[]{"New", "Open", "Save", "Exit"}) {
            JMenuItem item = new JMenuItem(name);
            item.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            item.addActionListener(e -> {
                if (name.equals("Exit")) System.exit(0);
                else executeCommand(name);
            });
            menuItems.put(name, item);
            fileMenu.add(item);
        }
        menuBar.add(fileMenu);

        JMenu editMenu = new JMenu("Edit");
        for (String name : new String[]{"Copy", "Paste", "Delete"}) {
            JMenuItem item = new JMenuItem(name);
            item.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            item.addActionListener(e -> executeCommand(name));
            menuItems.put(name, item);
            editMenu.add(item);
        }
        menuBar.add(editMenu);

        JMenu formatMenu = new JMenu("Format");
        for (String name : new String[]{"Bold", "Italic", "Underline", "Color"}) {
            JMenuItem item = new JMenuItem(name);
            item.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            item.addActionListener(e -> executeCommand(name));
            menuItems.put(name, item);
            formatMenu.add(item);
        }
        menuBar.add(formatMenu);

        setJMenuBar(menuBar);
    }

    private void setupListeners() {
        textPane.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) { updateUIState(); }
            public void removeUpdate(DocumentEvent e) { updateUIState(); }
            public void insertUpdate(DocumentEvent e) { updateUIState(); }
        });
        textPane.addCaretListener(e -> updateUIState());
    }

    private void updateUIState() {
        for (String name: commands.keySet()) {
            Command cmd = commands.get(name);
            boolean enabled = cmd.isExecuted();

            if (buttons.containsKey(name)) {
                buttons.get(name).setEnabled(enabled);
            }

            if (menuItems.containsKey(name)) {
                menuItems.get(name).setEnabled(enabled);
            }
        }
    }

    private void executeCommand(String name) {
        Command cmd = commands.get(name);
        if (cmd != null && cmd.isExecuted()) cmd.execute();
    }

    private void showError(String msg) {
        JOptionPane.showMessageDialog(this, msg, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(NotepadWithCommand::new);
    }
}