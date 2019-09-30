package ua.ithillel.hw16;

import ua.ithillel.hw16.database.DBWork;

public class Main {
    public static void main(String[] args) {
        DBWork dbWork = new DBWork();
        System.out.println(dbWork.findFilmsForCurrentAndPreviousYear());
        System.out.println(dbWork.findActorForFilm("Poroshok"));
        System.out.println(dbWork.findActorsForNFilms(2));
        dbWork.deleteFilmsOlderGivenYears(2020);
    }
}
