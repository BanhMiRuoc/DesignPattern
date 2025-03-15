package validator;

import javax.swing.*;

public class FloatValidator implements IValidator {

    @Override
    public boolean validate(JTextField field) {
        try {
            Float.parseFloat(field.getText());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public String getErrorMessage() {
        return "Not a floating point number";
    }
}
