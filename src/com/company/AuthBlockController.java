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
        dialogStage.close();
        Main.callReadingCommands("aut");


    }
    @FXML public void callReg(){
        System.out.println("Registration");
        dialogStage.close();
        Main.callReadingCommands("reg");
    }
    @FXML public void submit(){

    }


    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
}
