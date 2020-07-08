package com.company;

class MovieMaker {



    static MovieGenre MovieGenreMaker(String genre){

        switch (genre){
            case "Экшн":

                return MovieGenre.ACTION;
            case "Драмма":

                return MovieGenre.DRAMA;
            case "Триллер":

                return MovieGenre.THRILLER;
            case "Хоррор":

                return MovieGenre.HORROR;
            case "Научная фантастика":

                return MovieGenre.SCIENCE_FICTION;
            default:

                return MovieGenre.ACTION;
        }
    }
    static MpaaRating MpaaRatingMaker(String rating){

        switch (rating){
            case "G":
                return MpaaRating.G;
            case "PG":
                return MpaaRating.PG;
            case "R":
                return MpaaRating.R;
            case "NC 17":

                return MpaaRating.NC_17;
            default:

                return MpaaRating.G;
        }
    }

    static Color ColorMaker(String color){

        switch (color){
            case "Зелёный":

                return Color.GREEN;
            case "Чёрный":
                return  Color.BLACK;
            case "Голубой":
                return Color.BLUE;
            case "Жёлтый":
                return Color.YELLOW;
            case "Оранжевый":
                return Color.ORANGE;
            case "Белый":
                return Color.WHITE;
            case "Коричневый":
                return Color.BROWN;
            default:
                return Color.WHITE;
        }
    }
}

