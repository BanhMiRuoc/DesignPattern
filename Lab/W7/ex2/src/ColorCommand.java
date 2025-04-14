import javax.swing.*;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;

class ColorCommand implements Command {
    private JTextPane textPane;
    private JFrame parent;
    public ColorCommand(JTextPane textPane, JFrame parent) {
        this.textPane = textPane;
        this.parent = parent;
    }
    @Override
    public void execute() {
        Color color = JColorChooser.showDialog(parent, "Choose Text Color", Color.BLACK);
        if (color != null) {
            Style style = textPane.addStyle("ColorStyle", null);
            StyleConstants.setForeground(style, color);
            StyledDocument doc = textPane.getStyledDocument();
            doc.setCharacterAttributes(textPane.getSelectionStart(),
                    textPane.getSelectionEnd() - textPane.getSelectionStart(), style, false);
        }
    }

    @Override
    public boolean isExecuted() {
        return textPane.getSelectionStart() != textPane.getSelectionEnd();
    }
}