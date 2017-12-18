package utils;

import com.jfoenix.validation.base.ValidatorBase;
import javafx.scene.control.TextInputControl;

public class InputFieldValidation extends ValidatorBase {
    @Override
    protected void eval() {
        if (srcControl.get() instanceof TextInputControl) {
            evalTextInputField();
        }
    }

    private void evalTextInputField() {
        TextInputControl textField = (TextInputControl) srcControl.get();

        try {
            MathUtils.eval(textField.getText());
            hasErrors.set(false);
        } catch (Exception e) {
            hasErrors.set(true);
        }
    }
}
