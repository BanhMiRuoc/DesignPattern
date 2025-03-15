import validator.IValidator;

import javax.swing.*;

public class MyTextBox {
    private JTextField textField;
    private IValidator validatorStrategy;

    public MyTextBox(IValidator validatorStrategy) {
        this.textField = new JTextField();
        this.validatorStrategy = validatorStrategy;
    }
    public JTextField getTextField() {
        return textField;
    }
    public void setTextField(JTextField textField) {
        this.textField = textField;
    }
    public boolean valid() {
        return validatorStrategy.validate(textField);
    }
    public String getErrorMessage() {
        return validatorStrategy.getErrorMessage();
    }
}
