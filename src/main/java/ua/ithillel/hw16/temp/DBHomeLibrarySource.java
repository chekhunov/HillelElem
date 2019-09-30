package ua.ithillel.hw16.temp;

import ua.ithillel.hw16.interfaces.HomeLibrarySource;

public class DBHomeLibrarySource implements HomeLibrarySource {

    private DBHelper helper;

    public DBHelper getHelper() {
        return helper;
    }

    public void setHelper(DBHelper helper) {
        this.helper = helper;
    }

}
