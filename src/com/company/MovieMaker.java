package com.company;

class MovieMaker {
    protected InputReader reader;
     Movie MovieFactory(InputReader outReader){
        reader = outReader;
        return new Movie(NameMaker("название фильма"), CoordinateMaker(), OscarsCountMaker(), GoldenPalmCountMaker(), MovieGenreMaker(), MpaaRatingMaker(), PersonFactory());
    }
    String NameMaker(String mode){
         if (Validator.isAboutToSetAMovie == true){
             Validator.isAboutToSetAMovie = false;
             return Validator.LastName;
         }
         if (reader.ConsoleInputCheck()) {
             System.out.print("Введите " + mode + ": ");
         }
        String name = reader.read();
        if (name != null && !name.equals("")){
            reader.setSolvingMistakesMode(false);
            return name;
        }
        else{
            System.out.println("Поле " + mode + " является обязательным для заполнения.");
            reader.setSolvingMistakesMode(true);
            return NameMaker(mode);
        }
    }
    Coordinates CoordinateMaker(){
        if (reader.ConsoleInputCheck()) {
            System.out.print("Введите координаты фильма X и Y через точку с запятой и пробел: ");
        }
        try {
            Coordinates coordinates = new Coordinates(reader.read());
            reader.setSolvingMistakesMode(false);
            return coordinates;
        }
        catch (NumberFormatException e){
            System.out.println("Координаты фильма не распознаны. ");
            reader.setSolvingMistakesMode(true);
            return CoordinateMaker();
        }
    }
    Long OscarsCountMaker(){
        if (reader.ConsoleInputCheck()) {
            System.out.print("Введите количество оскаров фильма: ");
        }
        Long oscarsCount = Validator.LongArg(reader.read());
        if (oscarsCount > 0){
            reader.setSolvingMistakesMode(false);
            return oscarsCount;
        }
        else{
            System.out.println("Количество оскаров должно быть положительным.");
            reader.setSolvingMistakesMode(true);
            return OscarsCountMaker();
        }
    }
    Integer GoldenPalmCountMaker(){
        if (reader.ConsoleInputCheck()) {
            System.out.print("Введите количество золотых пальмовых ветвей фильма: ");
        }
        Integer goldenPalmCount = Validator.IntArg(reader.read());
        if (goldenPalmCount > 0){
            reader.setSolvingMistakesMode(false);
            return goldenPalmCount;
        }
        else{
            System.out.println("Количество золотых пальмовых ветвей должно быть положительным.");
            reader.setSolvingMistakesMode(true);
            return GoldenPalmCountMaker();
        }
    }
    MovieGenre MovieGenreMaker(){
        if (reader.ConsoleInputCheck()) {
            System.out.print("Введите один из предложенных ниже жанров фильма:\nЭкшн, Драмма, Триллер, Хоррор или Научная фантастика: ");
        }
        switch (reader.read()){
            case "Экшн":
                reader.setSolvingMistakesMode(false);
                return MovieGenre.ACTION;
            case "Драмма":
                reader.setSolvingMistakesMode(false);
                return MovieGenre.DRAMA;
            case "Триллер":
                reader.setSolvingMistakesMode(false);
                return MovieGenre.THRILLER;
            case "Хоррор":
                reader.setSolvingMistakesMode(false);
                return MovieGenre.HORROR;
            case "Научная фантастика":
                reader.setSolvingMistakesMode(false);
                return MovieGenre.SCIENCE_FICTION;
            default:
                System.out.println("Жанр фильма не распознан.");
                reader.setSolvingMistakesMode(true);
                return MovieGenreMaker();
        }
    }
    MpaaRating MpaaRatingMaker(){
        if (reader.ConsoleInputCheck()) {
            System.out.print("Введите один из предложенных ниже рейтингов фильма:\nG, PG, R или NC 17: ");
        }
        switch (reader.read()){
            case "G":
                reader.setSolvingMistakesMode(false);
                return MpaaRating.G;
            case "PG":
                reader.setSolvingMistakesMode(false);
                return MpaaRating.PG;
            case "R":
                reader.setSolvingMistakesMode(false);
                return MpaaRating.R;
            case "NC 17":
                reader.setSolvingMistakesMode(false);
                return MpaaRating.NC_17;
            default:
                System.out.println("Рейтинг фильма не распознан.");
                reader.setSolvingMistakesMode(true);
                return MpaaRatingMaker();
        }
    }
    Person PersonFactory(){
         return new Person(NameMaker("имя сценариста"), PassportIDMaker(), ColorMaker("цвета глаз"), ColorMaker("цвета волос"));
    }
    String PassportIDMaker() {
        if (reader.ConsoleInputCheck()) {
            System.out.print("Введите номер паспорта сценариста: ");
        }
        String passportID = reader.read();
        if (passportID.length() >= 9 && passportID.length() <= 26 ){
            reader.setSolvingMistakesMode(false);
            return passportID;
        }
        else {
            System.out.println("Номер пасспорта сценариста должен быть длинной не более 26 и не менее 9.");
            reader.setSolvingMistakesMode(true);
            return PassportIDMaker();
        }
    }
    Color ColorMaker(String mode){
        if (reader.ConsoleInputCheck()) {
            System.out.print("Введите один из предложенных ниже " + mode + " сценариста:\nЗелёный, Чёрный, Голубой, Жёлтый, Оранжевый, Белый или Коричневый: ");
        }
        String color = reader.read();
        switch (color){
            case "Зелёный":
                reader.setSolvingMistakesMode(false);
                return Color.GREEN;
            case "Чёрный":
                reader.setSolvingMistakesMode(false);
                return  Color.BLACK;
            case "Голубой":
                reader.setSolvingMistakesMode(false);
                return Color.BLUE;
            case "Жёлтый":
                reader.setSolvingMistakesMode(false);
                return Color.YELLOW;
            case "Оранжевый":
                reader.setSolvingMistakesMode(false);
                return Color.ORANGE;
            case "Белый":
                reader.setSolvingMistakesMode(false);
                return Color.WHITE;
            case "Коричневый":
                reader.setSolvingMistakesMode(false);
                return Color.BROWN;
            default:
                System.out.println("Ошибка распознания" + mode + " сценариста.");
                reader.setSolvingMistakesMode(true);
                return ColorMaker(mode);
        }
    }
}

