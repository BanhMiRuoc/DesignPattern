import javax.swing.*;

class NewCommand implements Command {
    private JTextPane textPane;
    public NewCommand(JTextPane textPane) {
        this.textPane = textPane;
    }
    @Override
    public void execute() { textPane.setText(""); }

    @Override
    public boolean isExecuted() {
        return true;
    }
}