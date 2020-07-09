package com.company;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class NumberSetSceneController implements Initializable {
    @FXML
    AnchorPane window;
    @FXML
    TextField enterNumberField;
    @FXML
    Label enterNumberLabel;
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    public void submitNumber(){
        if(!Validator.checkOscarsCount(enterNumberField.getText())){
            enterNumberLabel.setText("Ошибка ввода");
            enterNumberLabel.setStyle("-fx-text-inner-color: red;");
            enterNumberField.setStyle("-fx-text-inner-color: red;");
        }else{
            Validator.setCurrentArgument(enterNumberField.getText());
            Stage stage = (Stage) window.getScene().getWindow();
            stage.close();
        }
    }
}
