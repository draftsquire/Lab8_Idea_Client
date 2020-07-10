package com.company;

import javafx.beans.property.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Locale;

public class MovieProperties implements Comparable<MovieProperties> {
        private static HashMap<String, Color> coloredUsers = new HashMap<>();
        //private static final long serialVersionUID = 2L;
        private IntegerProperty id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
        private StringProperty name; //Поле не может быть null, Строка не может быть пустой
        private CoordinatesProperties coordinates; //Поле не может быть null
        private ObjectProperty<ZonedDateTime> creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
        private LongProperty oscarsCount; //Значение поля должно быть больше 0, Поле может быть null
        private IntegerProperty goldenPalmCount; //Значение поля должно быть больше 0, Поле может быть null
        private ObjectProperty<MovieGenre> genre; //Поле может быть null
        private ObjectProperty<MpaaRating> mpaaRating; //Поле не может быть null
        private PersonProperties screenwriter;
        private StringProperty owner;
        private Ellipse ellipse;


    public PersonProperties getScreenwriter() {
        return screenwriter;
    }

    public MovieProperties (Movie movie){
        this.id = new SimpleIntegerProperty( (movie.getID()));
        this.name = new SimpleStringProperty(movie.getName());
        this.coordinates= new CoordinatesProperties(movie.getCoordinates());
        this.creationDate= new SimpleObjectProperty<>(movie.getCreationDate());
        this.oscarsCount=new SimpleLongProperty(movie.getOscarsCount());
        this.goldenPalmCount=new SimpleIntegerProperty(movie.getGoldenPalmCount());
        this.genre = new SimpleObjectProperty<>(movie.getGenre());
        this.mpaaRating=new SimpleObjectProperty<>(movie.getMpaaRating());
        this.screenwriter=new PersonProperties(movie.getScreenwriter());
        this.owner=new SimpleStringProperty(movie.getOwner());

        ellipse = new Ellipse(
                Main.mainSceneController.getxCanvasCenter() + coordinates.get_x().get(),
                Main.getMainSceneController().getyCanvasCenter() - coordinates.get_y().get(),
                oscarsCount.get()*5,
                goldenPalmCount.get()*5
        );
        ellipse.setFill(getUserColor(owner.get()));
        ellipse.addEventHandler(MouseEvent.MOUSE_CLICKED, (mouseEvent -> {
            Main.getMainSceneController().getTable().getSelectionModel().select(this);
            Animation.startAnimationClicked(ellipse);
        }));
        Main.getMainSceneController().DrawMovie(ellipse);
//        double xCenter = Main.getController().canvasPane.getWidth()/2;
//        double yCenter = Main.getController().canvasPane.getWidth()/2;
//
//
//        circle = new MovieCircle(xCenter+coordinates.get_x().get(),
//                yCenter+coordinates.get_y().get(),
//                (oscarsCount.get()+goldenPalmCount.get())*10,
//                getUserColor(owner.get()),
//                Main.getController().canvas);
//        circle.draw();
//        Main.getController().canvasPane.getChildren().add(circle);
    }

    Color getUserColor(String user){
        System.out.println("USER: " + user);
        System.out.println("ColoredUsers: " + coloredUsers);
        if(coloredUsers.containsKey(user)){
            return coloredUsers.get(user);
        }
        else{
            Color color = new Color(Math.random(), Math.random(),Math.random(), 1);
            coloredUsers.put(user, color);
            return color;
        }
    }

        /** Конструктор для случая, когда id должен генерироваться автоматически
         * @param name
         * @param coordinates
         * @param oscarsCount
         * @param goldenPalmCount
         * @param genre
         * @param mpaaRating
         * @param screenwriter
         */
        public MovieProperties(String name, Coordinates coordinates , Long oscarsCount, Integer goldenPalmCount, MovieGenre genre, MpaaRating mpaaRating, Person screenwriter, String owner ){
            this.id = new SimpleIntegerProperty((int) (Math.random() * 100000));
            this.name = new SimpleStringProperty(name);
            this.coordinates= new CoordinatesProperties(coordinates);
            this.creationDate=new SimpleObjectProperty<>(ZonedDateTime.now(ZoneId.of("Europe/Moscow")));
            this.oscarsCount=new SimpleLongProperty(oscarsCount);
            this.goldenPalmCount=new SimpleIntegerProperty(goldenPalmCount);
            this.genre = new SimpleObjectProperty<>(genre);
            this.mpaaRating=new SimpleObjectProperty<>(mpaaRating);
            this.screenwriter=new PersonProperties(screenwriter);
            this.owner=new SimpleStringProperty(owner);
        }

        /** Конструктор для случая, когда пользователь задаёт id вручную
         * @param id
         * @param name
         * @param coordinates
         * @param oscarsCount
         * @param goldenPalmCount
         * @param genre
         * @param mpaaRating
         * @param screenwriter
         */
        public MovieProperties(int id, String name, Coordinates coordinates , Long oscarsCount, Integer goldenPalmCount, MovieGenre genre, MpaaRating mpaaRating, Person screenwriter, String owner ){


            this.id = new SimpleIntegerProperty((int) (id));
            this.name = new SimpleStringProperty(name);
            this.coordinates= new CoordinatesProperties(coordinates);
            this.creationDate=new SimpleObjectProperty<>(ZonedDateTime.now(ZoneId.of("Europe/Moscow")));
            this.oscarsCount=new SimpleLongProperty(oscarsCount);
            this.goldenPalmCount=new SimpleIntegerProperty(goldenPalmCount);
            if (genre != null) {
                this.genre = new SimpleObjectProperty<>(genre);
            }
            this.mpaaRating=new SimpleObjectProperty<>(mpaaRating);
            this.screenwriter=new PersonProperties(screenwriter);
            this.owner=new SimpleStringProperty(owner);
        }


    /**Геттер для поля name
         *
         * @return
         */



        public StringProperty getName(){return this.name;}
        public CoordinatesProperties getCoordinates() {return this.coordinates;}

    public ZonedDateTime getCreationDate() {return creationDate.get();}

    public StringProperty getCreationDateFormated(DateTimeFormatter pattern){
            return new SimpleStringProperty(creationDate.get().format(pattern));
        }

    public LongProperty getOscarsCount(){return this.oscarsCount;}
        /**Геттер для поля getGoldenPalmCount
         *
         * @return
         */
        public IntegerProperty getGoldenPalmCount(){return this.goldenPalmCount;}

    public ObjectProperty<MovieGenre> getGenre() {
        return genre;
    }

    public ObjectProperty<MpaaRating> getMpaaRating() {
        return mpaaRating;
    }

    /**Геттер для поля id
         *
         * @return
         */
        public IntegerProperty getID(){
            return this.id;
        }

    public String getOwner() {
        return owner.get();
    }

    public StringProperty ownerProperty() {
        return owner;
    }
/**Возвращает строковое представление объекта Movie в формате для записи в CSV-файл
         *
         * @return
         */


        /**Возвращает строковое представление объекта Movie, удобное для пользователя
         *
         * @return
         */
        @Override
        public String toString(){
            return "\n"+ "id: "+ this.id+"\n"+
                    "Название: "+ this.name+"\n"+
                    this.coordinates.getCoordinates().showCoordinates()+"\n"+
                    "Дата создания: "+this.creationDate+"\n"+
                    "Количество оскаров: "+ this.oscarsCount+"\n"+
                    "Колтчество золотых пальмовых ветвей: "+ this.goldenPalmCount+"\n"+
                    "Жанр: "+ this.genre+"\n"+
                    "Рейтинг MPAA: "+ this.mpaaRating+"\n"+
                    this.screenwriter+"\n";
        }

        /**Сравнивает два объекта Movie
         * @param movie
         * @return 1, если имя фильма, с которым происходит сравнение стоит раньше в алфавитном порядке;
         * -1, если имя фильма, с которым происходит сравнение стоит позже в алфавитном порядке;
         * 0,если имена равны
         */
        @Override
        public int compareTo(com.company.MovieProperties movie) {
            if (this.name.get().compareTo(movie.getName().get())<0){
                return -1;
            }
            else if (this.name.get().compareTo(movie.getName().get())>0){
                return 1;
            }
            else if (this.name.get().compareTo(movie.getName().get())==0){
                return 0;

            }

            return 666;
        }

    public Ellipse getEllipse() {
        return ellipse;
    }
}
