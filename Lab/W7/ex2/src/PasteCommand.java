import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;

class PasteCommand extends Component implements Command {
    private JTextPane textPane;
    private Clipboard clipboard;
    public PasteCommand(JTextPane textPane, Clipboard clipboard) {
        this.textPane = textPane;
        this.clipboard = clipboard;
    }
    @Override
    public void execute() {
        try {
            Transferable content = clipboard.getContents(null);
            if (content.isDataFlavorSupported(DataFlavor.stringFlavor)) {
                textPane.replaceSelection((String) content.getTransferData(DataFlavor.stringFlavor));
            }
        } catch (Exception e) {
            showError("Paste failed: " + e.getMessage());
        }
    }

    @Override
    public boolean isExecuted() {
        try {
            return clipboard.isDataFlavorAvailable(DataFlavor.stringFlavor);
        } catch (Exception e) {
            return false;
        }
    }

    private void showError(String msg) {
        JOptionPane.showMessageDialog(this, msg, "Error", JOptionPane.ERROR_MESSAGE);
    }
}