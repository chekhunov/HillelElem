package ua.ithillel.hw16.classes;

import ua.ithillel.hw16.classes.humans.Entity;

import java.util.List;

public class Film extends Entity {
    private String titleOfFilm;
    private int releaseDate;
    private String releaseCountry;
    private List<String> actorList;

    public Film(String titleOfFilm, List<String> actor) {
    }

    public Film(int id, String titleOfFilm, List <String> actorList) {
        super(id);
        this.titleOfFilm = titleOfFilm;
        this.actorList = actorList;
    }

    public Film(int id, String titleOfFilm, int releaseDate, String releaseCountry) {
        super(id);
        this.titleOfFilm = titleOfFilm;
        this.releaseDate = releaseDate;
        this.releaseCountry = releaseCountry;
    }

    public Film(int id, String titleOfFilm,List <String> actorList, int releaseDate, String releaseCountry) {
        super(id);
        this.titleOfFilm = titleOfFilm;
        this.releaseDate = releaseDate;
        this.releaseCountry = releaseCountry;
        this.actorList = actorList;

    }

    public String getTitleOfFilm() {
        return titleOfFilm;
    }

    public void setTitleOfFilm(String titleOfFilm) {
        this.titleOfFilm = titleOfFilm;
    }

    public int getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(int releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getReleaseCountry() {
        return releaseCountry;
    }

    public void setReleaseCountry(String releaseCountry) {
        this.releaseCountry = releaseCountry;
    }

    @Override
    public String toString() {
        return "Film{" +
                "titlesOfFilms='" + titleOfFilm + '\'' +
                ", releaseDate=" + releaseDate +
                ", releaseCountry='" + releaseCountry + '\'' +
                '}';
    }
}
