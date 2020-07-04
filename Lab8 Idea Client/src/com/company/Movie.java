package com.company;

import java.io.Serializable;
import java.sql.Date;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Класс фильмов (элементов обрабатываемой коллекции коллекции)
 * @see Comparable
 */
public class Movie implements Comparable<Movie>, Serializable {
    private static final long serialVersionUID = 2L;
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Long oscarsCount; //Значение поля должно быть больше 0, Поле может быть null
    private Integer goldenPalmCount; //Значение поля должно быть больше 0, Поле может быть null
    private MovieGenre genre; //Поле может быть null
    private MpaaRating mpaaRating; //Поле не может быть null
    private Person screenwriter;
    /** Конструктор для случая, когда id должен генерироваться автоматически
     * @param name
     * @param coordinates
     * @param oscarsCount
     * @param goldenPalmCount
     * @param genre
     * @param mpaaRating
     * @param screenwriter
     */
    public Movie(String name, Coordinates coordinates , Long oscarsCount, Integer goldenPalmCount, MovieGenre genre, MpaaRating mpaaRating, Person screenwriter ){
        this.id = (int) (Math.random() * 100000);
        this.name = name;
        this.coordinates=coordinates;
        this.creationDate= ZonedDateTime.now(ZoneId.of("Europe/Moscow"));
        this.oscarsCount=oscarsCount;
        this.goldenPalmCount=goldenPalmCount;
        this.genre = genre;
        this.mpaaRating=mpaaRating;
        this.screenwriter=screenwriter;
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
    public Movie(int id, String name, Coordinates coordinates , Long oscarsCount, Integer goldenPalmCount, MovieGenre genre, MpaaRating mpaaRating, Person screenwriter ){

        this.id = id;
        this.name = name;
        this.coordinates=coordinates;
        this.creationDate= ZonedDateTime.now(ZoneId.of("Europe/Moscow"));
        this.oscarsCount=oscarsCount;
        this.goldenPalmCount=goldenPalmCount;
        if (genre!=null) {
            this.genre = genre;
        }
        this.mpaaRating=mpaaRating;
        this.screenwriter=screenwriter;
    }

    /**Геттер для поля name
     *
     * @return
     */
    public String getName(){return this.name;}
    public long getOscarsCount(){
        return this.oscarsCount.longValue();
    }
    /**Геттер для поля getGoldenPalmCount
     *
     * @return
     */
    public int getGoldenPalmCount(){
        return this.goldenPalmCount.intValue();
    }
    /**Геттер для поля id
     *
     * @return
     */
    public int getID(){
        return this.id;
    }

    /**Возвращает строковое представление объекта Movie в формате для записи в CSV-файл
     *
     * @return
     */
    public String stringForSQL(){ //Строковое представление для отправки запрооса в БД
        return  "'"+this.name+"','"+
                this.coordinates.stringToBeWritten()+"','"+
                this.creationDate.format(DateTimeFormatter.ISO_LOCAL_DATE)+"','"+
                this.oscarsCount+"','"+
                this.goldenPalmCount+"','"+
                this.genre+"','"+
                this.mpaaRating+"','"+
                this.screenwriter.stringToBeWritten()+"'";
    }
    public String stringToUpdateDB(){
        return  "name='"+this.name+"',coordinate_x="+
                this.coordinates.get_x()+", coordinate_y="+this.coordinates.get_y()+
                "creationdate='"+this.creationDate.format(DateTimeFormatter.ISO_LOCAL_DATE)+"',oscarscount="+
                this.oscarsCount+",goldenpalmcount="+
                this.goldenPalmCount+",genre='"+
                this.genre+"',mpaarating='"+
                this.mpaaRating+"',screenwriter='"+
                this.screenwriter.stringToBeWritten()+"'";
    }


    /**Возвращает строковое представление объекта Movie, удобное для пользователя
     *
     * @return
     */
    @Override
    public String toString(){
        return "\n"+ "id: "+ this.id+"\n"+
                "Название: "+ this.name+"\n"+
                this.coordinates.showCoordinates()+"\n"+
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
    public int compareTo(Movie movie) {
        if (this.name.compareTo(movie.getName())<0){
            return -1;
        }
        else if (this.name.compareTo(movie.getName())>0){
            return 1;
        }
        else if (this.name.compareTo(movie.getName())==0){
            return 0;

        }

        return 666;
    }
}


