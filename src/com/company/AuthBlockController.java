package com.company;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class AuthBlockController implements Initializable {
    private Stage dialogStage;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
    @FXML public void callAuth(){
        System.out.println("Authorization");
        Main.callReadingCommands("aut");
        dialogStage.close();

    }
    @FXML public void callReg(){
        System.out.println("Registration");
        Main.callReadingCommands("reg");
        dialogStage.close();

    }
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
}
