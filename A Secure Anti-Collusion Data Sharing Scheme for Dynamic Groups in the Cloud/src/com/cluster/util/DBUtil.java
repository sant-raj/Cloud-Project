package com.cluster.util;

/**
 * @ Cluster Info Solution Solution, Author (SHARANABAU)
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	static Connection con = null;

	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager
					.getConnection(
							"jdbc:mysql://localhost/CI16CC029",
							"root", "root123");

		} catch (ClassNotFoundException e) {
			System.err.println("Connection Class Loading Failed");
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.println("Error occured while getting database connection");
			e.printStackTrace();
		}
		return con;
	}

}
