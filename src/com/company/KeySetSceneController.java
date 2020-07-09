package com.company;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class KeySetSceneController implements Initializable {
    @FXML
    AnchorPane window;

    @FXML
    Label enterKeyLabel;
    @FXML
    TextField enterKeyField;


    public void submitKey(){

            Validator.setCurrentArgument(enterKeyField.getText());
            Stage stage = (Stage) window.getScene().getWindow();
            stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
