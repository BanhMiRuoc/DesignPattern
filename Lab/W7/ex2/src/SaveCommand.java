import javax.swing.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.function.Consumer;
import java.util.function.Supplier;

class SaveCommand implements Command {
    private JTextPane textPane;
    private JFileChooser fileChooser;
    private JFrame parent;
    private TextVersionTracker textVersionTracker;
    private Supplier<File> getCurrentFile;
    private Consumer<File> setCurrentFile;

    public SaveCommand(JTextPane textPane, JFileChooser fileChooser, JFrame parent, TextVersionTracker textVersionTracker, Supplier<File> getCurrentFile, Consumer<File> setCurrentFile) {
        this.textPane = textPane;
        this.fileChooser = fileChooser;
        this.parent = parent;
        this.textVersionTracker = textVersionTracker;
        this.getCurrentFile = getCurrentFile;
        this.setCurrentFile = setCurrentFile;
    }
    @Override
    public void execute() {
        File file = getCurrentFile.get();
        if (file == null) {
            if (fileChooser.showSaveDialog(parent) == JFileChooser.APPROVE_OPTION) {
                file = fileChooser.getSelectedFile();
                setCurrentFile.accept(file);
            } else {
                return;
            }
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            textPane.write(writer);
            textVersionTracker.setLastSavedText(textPane.getText());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(parent, "Save failed: " + e.getMessage());
        }
    }
    public boolean isExecuted() {
        return textVersionTracker.isChanged(textPane.getText());
    }

    private void showError(String msg) {
        JOptionPane.showMessageDialog(parent, msg, "Error", JOptionPane.ERROR_MESSAGE);
    }
}