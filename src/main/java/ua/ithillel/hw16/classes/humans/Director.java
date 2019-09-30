package ua.ithillel.hw16.classes.humans;


public class Director extends FamousMan {

    private int filmedMovies;

    public Director() {
    }

    public Director(int id, String fullName, int dateOfBirth, int filmedMovies) {
        super(id, fullName, dateOfBirth);
        this.filmedMovies = filmedMovies;
    }

    public int getCountMovies() {
        return filmedMovies;
    }

    public void setCountMovies(int filmedMovies) {
        this.filmedMovies = filmedMovies;
    }

    @Override
    public String toString() {
        return "Director{" +
                "filmedMovies=" + filmedMovies +
                '}';
    }
}
