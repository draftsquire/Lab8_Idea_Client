package com.company;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.ResourceBundle;

public class MainSceneController implements Initializable {
    @FXML
    AnchorPane canvasPane;

    @FXML
    Canvas canvas;

    GraphicsContext context;

    double xCanvasCenter;

    public double getxCanvasCenter() {
        return xCanvasCenter;
    }

    public double getyCanvasCenter() {
        return yCanvasCenter;
    }

    double yCanvasCenter;
    ResourceBundle currentLanguageBundle;
    @FXML
    Menu commandsChoice;
    @FXML
    Menu languageChoice;
    @FXML
    Label replyLabel;
    @FXML
    Label userLabel;
    @FXML
    MenuItem Russian;
    @FXML
    MenuItem Turkish;
    @FXML
    MenuItem French;
    @FXML
    MenuItem Spanish;

    @FXML
    public void changeLanguage(){

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        currentLanguageBundle = resources;
        commandsChoice.setText(FormattedString( currentLanguageBundle.getString("CommandsChoice")));
        languageChoice.setText(FormattedString( currentLanguageBundle.getString("LanguageChoice")));
        Russian.setText(FormattedString( currentLanguageBundle.getString("Russian")));
        Turkish.setText(FormattedString( currentLanguageBundle.getString("Turkish")));
        French.setText(FormattedString( currentLanguageBundle.getString("French")));
        Spanish.setText(FormattedString( currentLanguageBundle.getString("Spanish")));
        table.setItems(movieList);
        replyLabel.setText("");
        id.setCellValueFactory(cellData -> cellData.getValue().getID());
        movieName.setCellValueFactory(cellData -> cellData.getValue().getName());
        xCoordinate.setCellValueFactory(cellData -> cellData.getValue().getCoordinates().get_x());
        yCoordinate.setCellValueFactory(cellData -> cellData.getValue().getCoordinates().get_y());
        oscarsCount.setCellValueFactory(cellData -> cellData.getValue().getOscarsCount());
        goldenPalmCount.setCellValueFactory(cellData -> cellData.getValue().getGoldenPalmCount());
        genre.setCellValueFactory(cellData -> cellData.getValue().getGenre());
        mpaaRating.setCellValueFactory(cellData -> cellData.getValue().getMpaaRating());
        screenwriterName.setCellValueFactory(cellData -> cellData.getValue().getScreenwriter().nameProperty());
        passportID.setCellValueFactory(cellData -> cellData.getValue().getScreenwriter().passportIDProperty());
        eyeColor.setCellValueFactory(cellData -> cellData.getValue().getScreenwriter().eyeColorProperty());
        hairColor.setCellValueFactory(cellData -> cellData.getValue().getScreenwriter().hairColorProperty());
        owner.setCellValueFactory(cellData -> cellData.getValue().ownerProperty());


        TableViewL10N(new Locale("ru", "RU"));
    }
    public void updateCurrentWindowUser(){
        try {
            userLabel.setText(Main.session.getSessionUser().username);
        }catch (Exception e){

        }
    }

    public void callExit(ActionEvent actionEvent) {
        System.out.println("Command called: "+ "exit");
        Main.callReadingCommands("exit");
        replyLabel.setText("\n"+Main.getCurrentReply().getStringOutput());

    }

    public void callPrintFieldDescendingOscarsCount(ActionEvent actionEvent) {
        System.out.println("Command called: "+ "print_field_descending_oscars_count");
        Main.callReadingCommands("print_field_descending_oscars_count");
        replyLabel.setText("\n"+Main.getCurrentReply().getStringOutput());
    }

    public void callAuth(ActionEvent actionEvent) {
        System.out.println("Command called: "+ "auth");
        try {
            Main.showAuthWindow(false);
        } catch (IOException e){
            e.printStackTrace();
        }
        updateCurrentWindowUser();
    }

    public void callInfo(ActionEvent actionEvent) {
        System.out.println("Command called: "+ "info");
        Main.callReadingCommands("info");
        replyLabel.setText("\n"+Main.getCurrentReply().getStringOutput());
    }

    public void callShow(ActionEvent actionEvent) {
        System.out.println("Command called: "+ "show");
        Main.callReadingCommands("show");
        replyLabel.setText("\n"+Main.getCurrentReply().getStringOutput());
    }

    public void callInsert(ActionEvent actionEvent) {
        System.out.println("Command called: "+ "insert");
        Main.callReadingCommands("insert");
        replyLabel.setText("\n"+Main.getCurrentReply().getStringOutput());
    }

    public void callRemoveKey(ActionEvent actionEvent) {
        System.out.println("Command called: "+ "");
        Main.callReadingCommands("remove_key");
        replyLabel.setText("\n"+Main.getCurrentReply().getStringOutput());
    }

    public void callClear(ActionEvent actionEvent) {
        System.out.println("Command called: "+ "clear");
        Main.callReadingCommands("clear");
        replyLabel.setText("\n"+Main.getCurrentReply().getStringOutput());
    }

   /* public void callExecuteScript(ActionEvent actionEvent) {
        System.out.println("Command called: "+ "execute_script");
        Main.callReadingCommands("execute_script");
    }*/

    public void callRemoveGreater(ActionEvent actionEvent) {
        System.out.println("Command called: "+ "remove_greater");
        Main.callReadingCommands("remove_greater");
        replyLabel.setText("\n"+Main.getCurrentReply().getStringOutput());
    }

    public void callReplaceIfLower(ActionEvent actionEvent) {
        System.out.println("Command called: "+ "replace_if_lower");
        Main.callReadingCommands("replace_if_lower");
        replyLabel.setText("\n"+Main.getCurrentReply().getStringOutput());
    }

    public void callRemoveGreaterKey(ActionEvent actionEvent) {
        System.out.println("Command called: "+ "remove_greater_key");
        Main.callReadingCommands("remove_greater_key");
        replyLabel.setText("\n"+Main.getCurrentReply().getStringOutput());
    }

    public void callCountLessThanOscarsCount(ActionEvent actionEvent) {
        System.out.println("Command called: "+ "count_less_than_oscars_count");
        Main.callReadingCommands("count_less_than_oscars_count");
        replyLabel.setText("\n"+Main.getCurrentReply().getStringOutput());
    }

    public void callPrintDescending(ActionEvent actionEvent) {
        System.out.println("Command called: "+ "print_descending");
        Main.callReadingCommands("print_descending");
        replyLabel.setText("\n"+Main.getCurrentReply().getStringOutput());
    }


    //========================================================================TableView===================================================



    @FXML
    javafx.scene.control.TableView<MovieProperties> table;
    private final static ObservableList<MovieProperties> movieList = FXCollections.observableArrayList();
    private final HashMap<String, MovieProperties> moviePropertiesMap = new HashMap<>();

    public HashMap<String, MovieProperties> getMoviePropertiesMap() {
        return moviePropertiesMap;
    }

    @FXML
    TableColumn<MovieProperties, Number> id;

    @FXML
    TableColumn<MovieProperties, String> movieName;

    @FXML
    TableColumn coordinates;

    @FXML
    TableColumn<MovieProperties, Number> xCoordinate;

    @FXML
    TableColumn<MovieProperties, Number> yCoordinate;

    @FXML
    TableColumn<MovieProperties, String> creationDate;

    @FXML
    TableColumn<MovieProperties, Number> oscarsCount;

    @FXML
    TableColumn<MovieProperties, Number> goldenPalmCount;

    @FXML
    TableColumn<MovieProperties, MovieGenre> genre;

    @FXML
    TableColumn<MovieProperties, MpaaRating> mpaaRating;

    @FXML
    TableColumn screenwriter;

    @FXML
    TableColumn<MovieProperties, String> screenwriterName;

    @FXML
    TableColumn<MovieProperties, String> passportID;

    @FXML
    TableColumn<MovieProperties, Color> eyeColor;

    @FXML
    TableColumn<MovieProperties, Color> hairColor;

    @FXML
    TableColumn<MovieProperties, String> owner;


    public void TableViewL10N(Locale loc){
        xCanvasCenter = canvasPane.getPrefWidth()/2;
        yCanvasCenter = canvasPane.getPrefHeight()/2;

        context = canvas.getGraphicsContext2D();
        ResourceBundle movieBundle = ResourceBundle.getBundle("MovieBundle", loc);
        id.setText(FormattedString(movieBundle.getString("id")));
        movieName.setText(FormattedString(movieBundle.getString("Name")));
        coordinates.setText(FormattedString(movieBundle.getString("Coordinates")));
        creationDate.setText(FormattedString(movieBundle.getString("CreationDate")));
        oscarsCount.setText(FormattedString(movieBundle.getString("OscarsCount")));
        goldenPalmCount.setText(FormattedString(movieBundle.getString("GoldenPalmCount")));
        genre.setText(FormattedString(movieBundle.getString("Genre")));
        mpaaRating.setText(FormattedString(movieBundle.getString("MPAARating")));
        screenwriter.setText(FormattedString(movieBundle.getString("Screenwriter")));

        ResourceBundle personBundle = ResourceBundle.getBundle("PersonBundle", loc);
        screenwriterName.setText(FormattedString(personBundle.getString("personName")));
        passportID.setText(FormattedString(personBundle.getString("passportID")));
        eyeColor.setText(FormattedString(personBundle.getString("eyeColor")));
        hairColor.setText(FormattedString(personBundle.getString("hairColor")));

        DateTimeFormatter pattern = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL).withLocale(loc);
        creationDate.setCellValueFactory(cellData -> cellData.getValue().getCreationDateFormated(pattern));
    }

    String FormattedString(String str){
        try {
            return new String(str.getBytes("ISO-8859-1"), "UTF-8");
        }
        catch (UnsupportedEncodingException e){
            return "hemlo";
        }
    }

    public TableView<MovieProperties> getTable() {
        return table;
    }

    public void setMovieList(LinkedHashMap<String, Movie> movieMap){
        movieList.clear();
        for (Movie movie : movieMap.values()){
            MovieProperties movieProperties = new MovieProperties(movie);
            movieList.add(movieProperties);
            moviePropertiesMap.put(movie.getName(), movieProperties);
        }
        System.out.println(movieList);
    }

    //guygigog
    public void DrawMovie(Ellipse ellipse){
        canvasPane.getChildren().add(ellipse);
        Animation.onStartAnimation(ellipse);
    }
}
