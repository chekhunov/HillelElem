package ua.ithillel.hw16.classes.humans;

public class FamousMan extends Entity {
    private String fullName;
    private int dateOfBirth;

    public FamousMan() {
    }

    public FamousMan(String fullName) {
        this.fullName = fullName;
    }

    public FamousMan(int id, String fullName, int dateOfBirth) {
        super(id);
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(int dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "FamousMan{fullName=" + fullName +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}

