package ua.ithillel.hw16.database;

import ua.ithillel.hw16.classes.Film;
import ua.ithillel.hw16.classes.humans.Actor;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import static ua.ithillel.hw16.database.DBConnector.getConnection;

public class DBWork {

    public List<Film> findFilmsForCurrentAndPreviousYear() {
        String query = "SELECT id, titleOfFilm, releaseDate, releaseCountry FROM homeLibrary.Film\n " +
                "WHERE releaseDate >= 2019 AND releaseDate <= 2020";
        List<Film> films = new ArrayList<Film>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                films.add(addFilmToList(resultSet));
            }
        } catch (SQLException | IOException error) {
            error.printStackTrace();
        }

        close(resultSet, preparedStatement, connection);
        return films;
    }

    private Film addFilmToList(ResultSet resultSet) {
        if (resultSet == null) {
            throw new UnsupportedOperationException("ResultSet is required");
        }

        int id = 0;
        String titleOfFilm = "";
        int releaseDate = 0;
        String releaseCountry = "";

        try {
            id = resultSet.getInt(1);
            titleOfFilm = resultSet.getString(2);
            releaseDate = resultSet.getInt(3);
            releaseCountry = resultSet.getString(4);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new Film(id, titleOfFilm, releaseDate, releaseCountry);
    }

    public List<Actor> findActorForFilm(String filmName) {
        List<Actor> actorList = new ArrayList<>();

        String query = "SELECT fullName FROM Actor WHERE id IN\n" +
                "(SELECT ActorID FROM movie WHERE FilmID =\n" +
                "(SELECT id FROM Film WHERE titleOfFilm = '" + filmName + "'))";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;


        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                actorList.add(addActorToList(resultSet));
            }
        } catch (SQLException | IOException error) {
            error.printStackTrace();
        }

        close(resultSet, preparedStatement, connection);
        return actorList;
    }

    public List<Actor> findActorsForNFilms(int filmsCount) {
        List<Actor> actorList = new ArrayList<>();

        String query = "SELECT fullName FROM Actor WHERE id = EXISTS\n" +
                "(SELECT ActorID, COUNT(*) c FROM Movie GROUP BY ActorID HAVING c =" + filmsCount + ")";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;


        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                actorList.add(addActorToList(resultSet));
            }
        } catch (SQLException | IOException error) {
            error.printStackTrace();
        }

        close(resultSet, preparedStatement, connection);
        return actorList;
        //
    }

    private Actor addActorToList(ResultSet resultSet) {
        if (resultSet == null) {
            throw new UnsupportedOperationException("ResultSet is required");
        }

        String fullName = "";


        try {
            fullName = resultSet.getString(1);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new Actor(fullName);
    }

    //    public List<Actor> findActorsAsDirector() {
//        List<Actor> actorList = new ArrayList<>();
//
//        String query = "SELECT fullName FROM Actor WHERE id = EXISTS\n" +
//                "(SELECT ActorID, COUNT(*) c FROM Movie GROUP BY ActorID HAVING c ="+ filmsCount + ")"
//
//        Connection connection = null;
//        PreparedStatement preparedStatement = null;
//        ResultSet resultSet = null;
//
//
//        try {
//            connection = getConnection();
//            preparedStatement = connection.prepareStatement(query);
//            resultSet = preparedStatement.executeQuery();
//
//            while (resultSet.next()) {
//                actorList.add(addActorToList(resultSet));
//            }
//        } catch (SQLException | IOException error) {
//            error.printStackTrace();
//        }
//
//        close(resultSet, preparedStatement, connection);
//        return actorList;
//        //
//    }
    public int deleteFilmsOlderGivenYears(int givenYears) {
        int affected = 0;
        String query = "DELETE FROM Film\n " +
                 "WHERE releaseDate = " + givenYears;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(query);
            affected = preparedStatement.executeUpdate();

        } catch (SQLException error) {
            error.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        close(resultSet, preparedStatement, connection);
        return affected;
    }

    private void close(ResultSet resultSet, PreparedStatement preparedStatement, Connection connection) {
        closeResultSet(resultSet);
        closePreparedStatement(preparedStatement);
        closeConnection(connection);
    }

    private void closeResultSet(ResultSet resultSet) {
        if (resultSet == null) {
            return;
        }

        try {
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void closePreparedStatement(PreparedStatement preparedStatement) {
        if (preparedStatement == null) {
            return;
        }

        try {
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void closeConnection(Connection connection) {
        if (connection == null) {
            return;
        }

        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
