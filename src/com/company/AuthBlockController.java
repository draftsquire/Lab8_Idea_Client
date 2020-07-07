package com.company;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class AuthBlockController implements Initializable {
    private Stage dialogStage;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
    @FXML
    private Button submitButton;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField loginField;

    @FXML
    private Label labelLogin, labelPassword;
    @FXML public void callAuth(){
        System.out.println("Authorization");
        dialogStage.close();
        Main.callReadingCommands("aut");


    }
    @FXML public void callReg(){
        System.out.println("Registration");
        dialogStage.close();
        Main.callReadingCommands("reg");
    }
    @FXML public void submitAut(){

    }
    @FXML public void submitReg(){

    }



    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
}
