import javax.swing.*;

class DeleteCommand implements Command {
    private JTextPane textPane;
    public DeleteCommand(JTextPane textPane) {
        this.textPane = textPane;
    }
    @Override
    public void execute() {
        textPane.replaceSelection("");
    }

    @Override
    public boolean isExecuted() {
        return textPane.getSelectedText() != null;
    }
}