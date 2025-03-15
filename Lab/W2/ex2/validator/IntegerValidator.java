package validator;

import javax.swing.*;

public class IntegerValidator implements IValidator {


    @Override
    public boolean validate(JTextField field) {
        try {
            Integer.parseInt(field.getText());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }

    }

    @Override
    public String getErrorMessage() {
        return "Not a integer number";
    }

}
