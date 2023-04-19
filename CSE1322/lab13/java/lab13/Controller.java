package lab13;

import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import lab13.Calc;

public class Controller {
    @FXML
    private Label sum;
    @FXML
    private TextField firstNumber;
    @FXML
    private TextField secondNumber;
    @FXML
    protected void onClearButtonClick() {
        sum.setText("");
        firstNumber.setText("");
        secondNumber.setText("");
    }
    @FXML
    protected void onPlusButtonClick() {
        sum.setText(Calc.add(firstNumber.getText(), secondNumber.getText()));
    }
}