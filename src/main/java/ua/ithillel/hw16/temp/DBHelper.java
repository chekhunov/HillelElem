package ua.ithillel.hw16.temp;

import ua.ithillel.hw16.database.ConnectorDB;
import ua.ithillel.hw16.classes.Film;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBHelper {
	private final static String SQL_INSERT = "INSERT INTO Films(titlesOfFilms, releaseDate, releaseCountry) VALUES(?,?,?)";
	private Connection connect;

	public DBHelper() throws SQLException {
		connect = ConnectorDB.getConnection();
	}

	public PreparedStatement getPreparedStatement() {
		PreparedStatement ps = null;
		try {
			ps = connect.prepareStatement(SQL_INSERT);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ps;
	}

	public boolean insertFilm(PreparedStatement ps, Film ab) {
		try {
			ps.setString(1, ab.getTitleOfFilm());
			ps.setInt(2, ab.getReleaseDate());
			ps.setString(3, ab.getReleaseCountry());
			int updatedRowsCount = ps.executeUpdate();
			return updatedRowsCount > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public void closeStatement(PreparedStatement ps) {
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}