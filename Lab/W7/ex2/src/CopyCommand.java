import javax.swing.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

class CopyCommand implements Command {
    private JTextPane textPane;
    private Clipboard clipboard;
    public CopyCommand(JTextPane textPane, Clipboard clipboard) {
        this.textPane = textPane;
        this.clipboard = clipboard;
    }
    @Override
    public void execute() {
        StringSelection selection = new StringSelection(textPane.getSelectedText());
        clipboard.setContents(selection, null);
    }

    @Override
    public boolean isExecuted() {
        return textPane.getSelectedText() != null;
    }
}