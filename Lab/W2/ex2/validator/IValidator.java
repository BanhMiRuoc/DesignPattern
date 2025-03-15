package validator;

import javax.swing.*;

public interface IValidator {
    boolean validate(JTextField field);
    String getErrorMessage();
}
