package validator;

import javax.swing.*;

public class EmailValidator implements IValidator {
    @Override
    public boolean validate(JTextField field) {
        return field.getText().matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    }

    @Override
    public String getErrorMessage() {
        return "Invalid email address";
    }
}
