package ua.ithillel.hw16.temp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SingletonEngine {

	private Connection connectionTo;
	private Connection connectionFrom;
	private static SingletonEngine instance = null;

	public synchronized static SingletonEngine getInstance() {
		if (instance == null) {
			instance = new SingletonEngine();
			instance.getConnectionTo();
			instance.getConnectionFrom();
		}
		return instance;
	}

	private Connection getConnectionFrom() {
		try {
			connectionFrom = DriverManager.getConnection("jdbc:mysql://localhost:3306/homelibrary", "root", "12345678");
			connectionFrom.setAutoCommit(false);
		} catch (SQLException e) {
			System.err.println("SQLException: " + e.getMessage() + "SQLState: " + e.getSQLState());
		}
		return connectionFrom;
	}

	private Connection getConnectionTo() {
		final String connectToAdress = "jdbc:mysql://10.162.4.151:3306/testTo";
		try {
			connectionTo = DriverManager.getConnection(connectToAdress, "root", "12345678");
			connectionTo.setAutoCommit(false);
		} catch (SQLException e) {
			System.err.println("SQLException: " + e.getMessage() + "SQLState: " + e.getSQLState());
		}
		return connectionTo;
	}

	public void transfer(String summa) throws SQLException {
		Statement stFrom = null;
		Statement stTo = null;
		try {
			int sum = Integer.parseInt(summa);
			if (sum <= 0) {
				throw new NumberFormatException("less or equals zero");
			}
			stFrom = connectionFrom.createStatement();
			stTo = connectionTo.createStatement();

			ResultSet rsFrom = stFrom.executeQuery("SELECT balance from table_from");
			ResultSet rsTo = stTo.executeQuery("SELECT balance from table_to");
			int accountFrom = 0;
			while (rsFrom.next()) {
				accountFrom = rsFrom.getInt(1);
			}
			int resultFrom = 0;
			if (accountFrom >= sum) {
				resultFrom = accountFrom - sum;
			} else {
				throw new SQLException("Invalid balance");
			}
			int accountTo = 0;
			while (rsTo.next()) {
				accountTo = rsTo.getInt(1);
			}
			int resultTo = accountTo + sum;
			stFrom.executeUpdate("UPDATE table_from SET balance=" + resultFrom);
			stTo.executeUpdate("UPDATE table_to SET balance=" + resultTo);

			connectionFrom.commit();
			connectionTo.commit();
			System.out.println("remaining on :" + resultFrom + " rub");
		} catch (SQLException e) {
			System.err.println("SQLState: " + e.getSQLState() + "Error Message: " + e.getMessage());

			connectionFrom.rollback();
			connectionTo.rollback();
		} catch (NumberFormatException e) {
			System.err.println("Invalid summa: " + summa);
		} finally {
			if (stFrom != null) {
				try {
					stFrom.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
			if (stTo != null) {
				try {
					stTo.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		}
	}
	
}