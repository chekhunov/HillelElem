package com.hillel.hw21.runner;

import com.hillel.hw21.dbUtils.DBWork;



public class Runner {

    public static void main(String[] args) {

        DBWork dbWork = new DBWork();
        System.out.println(dbWork.findFilmsForCurrentAndPreviousYear());
        System.out.println(dbWork.findActorForFilm("Avengers"));
        System.out.println(dbWork.findActorsForNFilms(2));
        System.out.println(dbWork.findActorsAsDirector());
       // dbWork.deleteFilmsOlderGivenYears(2010);

    }

}
