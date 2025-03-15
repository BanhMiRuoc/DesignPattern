package validator;

import javax.swing.*;

public class StringValidator implements IValidator {

    @Override
    public boolean validate(JTextField field) {
        return !field.getText().trim().isEmpty();
    }

    @Override
    public String getErrorMessage() {
        return "String is empty";
    }
}
