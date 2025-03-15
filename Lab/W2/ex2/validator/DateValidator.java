package validator;

import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateValidator implements IValidator {

    @Override
    public boolean validate(JTextField field) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            sdf.setLenient(false);
            sdf.parse(field.getText());
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    @Override
    public String getErrorMessage() {
        return "Date not valid";
    }
}
