package ua.ithillel.hw16.temp;

import ua.ithillel.hw16.classes.Film;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PreparedJDBCRunner {
	public static void main(String[] args) {
		List<Film> list = new ArrayList<>();
//		list.add(new Film("Куку", 2019, "Kharkov"));
//		list.add(new Film("GBGB", 2018, "Lviv"));

		DBHelper helper = null;
		PreparedStatement statement = null;
		try {
			helper = new DBHelper();
			statement = helper.getPreparedStatement();
			for (Film film : list) {
				helper.insertFilm(statement, film);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			helper.closeStatement(statement);
		}
	}
}
