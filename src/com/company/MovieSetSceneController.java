package com.company;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;

public class MovieSetSceneController implements Initializable {
    ObservableList<String> genreList =  FXCollections.observableArrayList(MovieGenre.ACTION.toString(),MovieGenre.DRAMA.toString(),MovieGenre.THRILLER.toString(),
            MovieGenre.HORROR.toString(),MovieGenre.SCIENCE_FICTION.toString());
    ObservableList<String> ratingList =  FXCollections.observableArrayList(MpaaRating.G.toString(),MpaaRating.PG.toString(),
            MpaaRating.R.toString(),MpaaRating.NC_17.toString());
    ObservableList<String> colorList =  FXCollections.observableArrayList(Color.GREEN.toString(),Color.BLACK.toString(),Color.BLUE.toString(),
            Color.YELLOW.toString(),Color.ORANGE.toString(),Color.WHITE.toString(),Color.BROWN.toString());
    ResourceBundle currentLanguageBundle;
    @FXML
    AnchorPane window;

    @FXML
    TextField nameField;
    @FXML
    TextField coordinateXField;
    @FXML
    TextField coordinateYField;
    @FXML
    TextField oscarsCountField;
    @FXML
    TextField goldenPalmCountField;
    @FXML
    TextField screenwriterNameField;
    @FXML
    TextField screenwriterIDField;

    @FXML
    Label creationInvitationLabel;
    @FXML
    Label nameLabel;
    @FXML
    Label coordinateXLabel;
    @FXML
    Label coordinateYLabel;
    @FXML
    Label oscarsCountLabel;
    @FXML
    Label goldenPalmCountLabel;
    @FXML
    Label genreLabel;
    @FXML
    Label raitingLabel;
    @FXML
    Label screenwriterNameLabel;
    @FXML
    Label screenwriterIDLabel;
    @FXML
    Label eyeColorLabel;
    @FXML
    Label hairColorLabel;



    @FXML
    ChoiceBox<String> ratingChoiceBox;
    @FXML
    ChoiceBox<String> genreChoiceBox;
    @FXML
    ChoiceBox<String> eyeColorChoiceBox;
    @FXML
    ChoiceBox<String> hairColorChoiceBox;

    @FXML
    Button submitButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        currentLanguageBundle=resources;
        creationInvitationLabel.setText(FormattedString( currentLanguageBundle.getString("creationInvitationLabel")));
        coordinateXLabel.setText(FormattedString( currentLanguageBundle.getString("coordinateXLabel")));
        coordinateYLabel.setText(FormattedString( currentLanguageBundle.getString("coordinateYLabel")));
        oscarsCountLabel.setText(FormattedString( currentLanguageBundle.getString("oscarsCountLabel")));
        goldenPalmCountLabel.setText(FormattedString( currentLanguageBundle.getString("goldenPalmCountLabel")));;
        genreLabel.setText(FormattedString( currentLanguageBundle.getString("genreLabel")));;
        raitingLabel.setText(FormattedString( currentLanguageBundle.getString("raitingLabel")));;
        genreLabel.setText(FormattedString( currentLanguageBundle.getString("genreLabel")));;
        screenwriterNameLabel.setText(FormattedString( currentLanguageBundle.getString("screenwriterNameLabel")));;
        screenwriterIDLabel.setText(FormattedString( currentLanguageBundle.getString("screenwriterIDLabel")));;
        eyeColorLabel.setText(FormattedString( currentLanguageBundle.getString("eyeColorLabel")));;
        hairColorLabel.setText(FormattedString( currentLanguageBundle.getString("hairColorLabel")));;
        submitButton.setText(FormattedString( currentLanguageBundle.getString("submitButton")));;
        ratingChoiceBox.setItems(ratingList);
        ratingChoiceBox.setValue(MpaaRating.G.toString());
        genreChoiceBox.setItems(genreList);
        genreChoiceBox.setValue(MovieGenre.ACTION.toString());
        eyeColorChoiceBox.setItems(colorList);
        eyeColorChoiceBox.setValue(Color.WHITE.toString());
        hairColorChoiceBox.setItems(colorList);
        hairColorChoiceBox.setValue(Color.WHITE.toString());

    }
    String FormattedString(String str){
        try {
            return new String(str.getBytes("ISO-8859-1"), "UTF-8");
        }
        catch (UnsupportedEncodingException e){
            return "hemlo";
        }
    }
    @FXML public void submitMovie() {
        boolean validated = true;
        String name = nameField.getText();
        String coordinateX = coordinateXField.getText();
        String coordinateY = coordinateYField.getText();
        String oscarsCount = oscarsCountField.getText();
        String goldenPalmCount = goldenPalmCountField.getText();
        String screenwriterName = screenwriterNameField.getText();
        String screenwriterID = screenwriterIDField.getText();
        Color screenwriterEyeColor = MovieMaker.ColorMaker(eyeColorChoiceBox.getValue());
        Color screenwriterHairColor = MovieMaker.ColorMaker(hairColorChoiceBox.getValue());
        MpaaRating mpaaRating = MovieMaker.MpaaRatingMaker(ratingChoiceBox.getValue());
        MovieGenre movieGenre = MovieMaker.MovieGenreMaker(genreChoiceBox.getValue());
        if (!Validator.checkName(name)) {
        //Имя уже занято
            nameField.setStyle("-fx-text-inner-color: red;");
            validated=false;
        }
        if (!Validator.checkCoordinateX(coordinateX)) {
            //Что то не так с координатами
            coordinateXField.setStyle("-fx-text-inner-color: red;");
            validated=false;
        }
        if (!Validator.checkCoordinateY(coordinateY)) {
            //Что то не так с координатами
            coordinateYField.setStyle("-fx-text-inner-color: red;");
            validated=false;
        }
        if (!Validator.checkOscarsCount(oscarsCount)) {
            //Что то не так с  оскарами
            oscarsCountField.setStyle("-fx-text-inner-color: red;");
            validated=false;
        }
        if (!Validator.checkGoldenPalmCount(goldenPalmCount)) {
            //Что то не так с пальмами
            goldenPalmCountField.setStyle("-fx-text-inner-color: red;");
            validated=false;
        }
        if (!Validator.checkScreenwriterName(screenwriterName)) {
            //Что то не так с именем скринрайтера (ЗАБЫЛ КАК ПО-РУССКИ БЛИН)
            screenwriterNameField.setStyle("-fx-text-inner-color: red;");
            validated=false;
        }

        if (!Validator.checkScreenwriterId(screenwriterID)) {
            //Что то не так с именем скринрайтера (ЗАБЫЛ КАК ПО-РУССКИ БЛИН)
            screenwriterIDField.setStyle("-fx-text-inner-color: red;");
            validated=false;
        }
        if (validated){
            try {
                Person screenwriter = new Person(screenwriterName, screenwriterID, screenwriterEyeColor, screenwriterHairColor );
               Movie newMovie = new Movie(name,new Coordinates(coordinateX+"; "+ coordinateY), Long.parseLong(oscarsCount), Integer.parseInt(goldenPalmCount),movieGenre, mpaaRating,screenwriter);
               Validator.setCurrentMovie(newMovie);
                Stage stage = (Stage) window.getScene().getWindow();
                stage.close();

            }catch (Exception e){
                e.printStackTrace();
            }
        }


    }
}
