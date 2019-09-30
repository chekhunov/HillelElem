package ua.ithillel.hw16.temp;

import ua.ithillel.hw16.classes.humans.Actor;
import ua.ithillel.hw16.database.DBWork;
import ua.ithillel.hw16.interfaces.HomeLibrarySource;

import java.util.List;

public class HomeLibrary {

    private HomeLibrarySource source;

//    public List<Film> findFilmsForCurrentAndPreviousYear() {
//
//        return getSource().findFilmsForCurrentAndPreviousYear();
//    }

    public List<Actor> findActorsForFilm(String filmName) {


        return null;//...
    }

    public List<Actor> findActorsForNFilms(int filmsCount) {
        return null;//...
    }

    public List<Actor> findActorsAsDirector() {
        return null;//...
    }

    public void deleteFilmsOlderGivenYears(int givenYears) {
      //...
    }

    public HomeLibrarySource getSource() {
        return source;
    }

    public void setSource(HomeLibrarySource source) {
        this.source = source;
    }

}
