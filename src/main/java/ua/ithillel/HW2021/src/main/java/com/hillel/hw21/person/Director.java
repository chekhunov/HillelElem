package com.hillel.hw21.person;

public class Director extends Person {

    public Director(int id, String fullName, int dateOfBirth) {
        super(id, fullName, dateOfBirth);
    }


    @Override
    public String toString() {
        return "Director{" + getId() + getFullName() + getDateOfBirth() +
                '}';
    }
}
