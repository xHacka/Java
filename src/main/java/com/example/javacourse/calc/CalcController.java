package com.example.javacourse.calc;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class CalcController {
    public VBox vbox;
    public Label firstNum;
    public Label secondNum;
    public TextField firstNumInput;
    public TextField secondNumInput;
    public Button increment;
    public Button decrement;
    public Text outputText;

    public int getFirstInt() {
        String n = firstNumInput.getText();
        if (n.equals("")) return 0;
        else return Integer.parseInt(n);
    }

    public int getSecondInt() {
        String n = secondNumInput.getText();
        if (n.equals("")) return 0;
        else return Integer.parseInt(n);
    }

    public void incrementAction(MouseEvent mouseEvent) {
        outputText.setText(String.valueOf(
                getFirstInt() + getSecondInt()
        ));
    }

    public void decrementAction(MouseEvent mouseEvent) {
        outputText.setText(String.valueOf(
                getFirstInt() - getSecondInt()
        ));
    }


}
