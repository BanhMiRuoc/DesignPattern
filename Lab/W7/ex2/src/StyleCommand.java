import javax.swing.*;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

class StyleCommand implements Command {
    private JTextPane textPane;
    private Object attribute;

    public StyleCommand(JTextPane textPane ,Object attr) {
        this.textPane = textPane;
        this.attribute = attr;
    }

    public void execute() {
        StyledDocument doc = textPane.getStyledDocument();
        Style style = textPane.addStyle("Style", null);
        if (attribute == StyleConstants.Bold)
            StyleConstants.setBold(style, true);
        else if (attribute == StyleConstants.Italic)
            StyleConstants.setItalic(style, true);
        else if (attribute == StyleConstants.Underline)
            StyleConstants.setUnderline(style, true);

        doc.setCharacterAttributes(textPane.getSelectionStart(),
                textPane.getSelectionEnd() - textPane.getSelectionStart(),
                style, false);
    }

    @Override
    public boolean isExecuted() {
        return textPane.getSelectionStart() != textPane.getSelectionEnd();
    }
}