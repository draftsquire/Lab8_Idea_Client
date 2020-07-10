package com.company;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ResourceBundle;

public class KeySetSceneController implements Initializable {
    @FXML
    AnchorPane window;

    @FXML
    Label enterKeyLabel;
    @FXML
    TextField enterKeyField;
    @FXML
    Button submitKeyButton;
    ResourceBundle currentLanguageBundle;


    public void submitKey(){

            Validator.setCurrentArgument(enterKeyField.getText());
            Stage stage = (Stage) window.getScene().getWindow();
            stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        currentLanguageBundle=resources;
        enterKeyLabel.setText(FormattedString( currentLanguageBundle.getString("enterKeyLabel")));
        submitKeyButton.setText(FormattedString( currentLanguageBundle.getString("submitKeyButton")));

    }
    String FormattedString(String str){
        try {
            return new String(str.getBytes("ISO-8859-1"), "UTF-8");
        }
        catch (UnsupportedEncodingException e){
            return "hemlo";
        }
    }
}
