package ua.ithillel.hw16.temp;


import ua.ithillel.hw16.classes.Film;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

public class SimpleJDBCRunner {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/homelibrary";

		Properties prop = new Properties();
		prop.put("user", "root");
		prop.put("password", "12345678");
		prop.put("useSSL", "false");
		prop.put("serverTimezone", "UTC");
		prop.put("characterEncoding", "UTF-8");
		Connection cn = null;
		int id = 0;

		try {
			cn = DriverManager.getConnection(url, prop);
			Statement st = null;
			try {
				st = cn.createStatement();
				ResultSet rs = null;
				try {
					rs = st.executeQuery("SELECT titleOfFilm,releaseDate,releaseCountry " +
							"FROM Film");
//					rs = st.executeQuery("select titleOfFilm, fullName\n" +
//							"from film f\n" +
//							"join movie m on m.FilmID = f.id\n" +
//							"join actor a on a.id = m.ActorID");
					ArrayList<Film> lst = new ArrayList<>();
					while (rs.next()) {

						id = rs.getInt(1);
						String titleOfFilm = rs.getString(2);
						int releaseDate = rs.getInt(3);
						String releaseCountry = rs.getString(4);
						//lst.add(new Film(id, titleOfFilm, releaseDate, releaseCountry));
					}
					if (lst.size() > 0) {
						lst.stream().forEach(System.out::println);
					} else {
						System.out.println("Not found");
					}
				} finally {
					if (rs != null) {
						rs.close();
					} else {
						System.err.println("error while reading DB");
					}
				}
			} finally {
				if (st != null) {
					st.close();
				} else {
					System.err.println("Statement was not created");
				}
			}
		} catch (SQLException e) {
			System.err.println("DB connection error: " + e);
		} finally {
			if (cn != null) {
				try {
					cn.close();
				} catch (SQLException e) {
					System.err.println("�onnection close error: " + e);
				}
			}
		}
	}
}