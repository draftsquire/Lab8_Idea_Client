package com.company;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

public class AutFieldController implements Initializable {
    private boolean isEntering = AuthBlockController.getIsEntering();
    static String login;
    static String password;
    private ResourceBundle currentLanguageBundle;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        currentLanguageBundle=resources;
        labelLogin.setText( FormattedString( currentLanguageBundle.getString("AuthorizationLogin")) );
        labelPassword.setText(FormattedString( currentLanguageBundle.getString("AuthorizationPassword")));
        submitAut.setText(FormattedString( currentLanguageBundle.getString("Submit")));
    }
    @FXML
    private Button submitAut;
    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField loginField;
    @FXML
    private Label labelLogin, labelPassword;
    @FXML
    public void submitAut() {
        login = loginField.getText();
        password = passwordField.getText();
        HashMap<String, String> users = Validator.GetUsers();
        if (users.containsKey(login)) {
            if (users.get(login).equals(SHA256.getHash(password))) {

                //dialogStage.close();
                try {
                    Main.setupMainWindow(ResourceBundle.getBundle("MainSceneBundle"));
                    Main.callReadingCommands("aut");
                    Stage stage = (Stage) submitAut.getScene().getWindow();
                    stage.close();
                    if (isEntering) {
                        Main.showMainWindow();
                    }
                } catch (Exception e) {
                    System.out.println("BIG OOF");
                    e.printStackTrace();
                }

            } else {
                passwordField.setStyle("-fx-text-inner-color: red;");
            }
        } else {
            loginField.setStyle("-fx-text-inner-color: red;");
        }
    }
    public static String getLogin(){
        return login;
    }
    public static String getPassword(){
        return password;
    }
    String FormattedString(String str) {
        try {
            return new String(str.getBytes("ISO-8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return "hemlo";
        }
    }
}
