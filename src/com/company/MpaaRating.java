package com.company;


import java.io.Serializable;

public enum MpaaRating implements Serializable { //enum №2
    G,
    PG,
    R,
    NC_17;

    public static MpaaRating getMpaaRating(String mpaaRating){
        switch (mpaaRating){
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
    private static final long serialVersionUID = 5L;
}
