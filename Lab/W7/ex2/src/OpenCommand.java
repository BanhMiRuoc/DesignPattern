import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.function.Consumer;

class OpenCommand implements Command {
    private JTextPane textPane;
    private JFileChooser fileChooser;
    private JFrame parent;
    private TextVersionTracker textVersionTracker;
    private Consumer<File> setCurrentFile;
    public OpenCommand(JTextPane textPane, JFileChooser fileChooser, JFrame parent, TextVersionTracker textVersionTracker, Consumer<File> setCurrentFile) {
        this.textPane = textPane;
        this.fileChooser = fileChooser;
        this.parent = parent;
        this.textVersionTracker = textVersionTracker;
        this.setCurrentFile = setCurrentFile;
    }
    @Override
    public void execute() {
        if (fileChooser.showOpenDialog(parent) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                textPane.read(br, null);
                textVersionTracker.setLastSavedText(textPane.getText());
                setCurrentFile.accept(file);
            } catch (IOException e) {
                showError("Open failed: " + e.getMessage());
            }
        }
    }

    @Override
    public boolean isExecuted() {
        return true;
    }

    private void showError(String msg) {
        JOptionPane.showMessageDialog(parent, msg, "Error", JOptionPane.ERROR_MESSAGE);
    }
}