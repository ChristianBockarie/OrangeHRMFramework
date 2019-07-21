package com.orangehrm.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class JdbcDemo {

	String dbUrl = "jdbc:oracle:thin:@syntaxdatabase.cdjflmucstpo.us-east-1.rds.amazonaws.com:1521:ORCL";

	String dnUsername = "Syntax";

	String dbPassword = "syntax123";

	@Test
	public void dbConnection() throws SQLException {
		// Creating connection
		Connection connection = DriverManager.getConnection(dbUrl, dnUsername, dbPassword);

		// create a statement
		Statement statement = connection.createStatement();

		// execute Query and store results from database in ResultSet object
		ResultSet resultSet = statement.executeQuery("select * from countries");

		// get values from resultSet
		resultSet.next();
		String columnData = resultSet.getString("country_name");
		System.out.println(columnData);
		// Printing single column
		resultSet.next();
		columnData = resultSet.getString("country_name");
		System.out.println(columnData);

		// Printing all data from column using loops
		System.out.println("---Printing values using loops---");
		while (resultSet.next()) {
			columnData = resultSet.getString("country_name");
			System.out.println(columnData);
		}

		// close all dataBase connections
		resultSet.close();
		statement.close();
		connection.close();

		//display in console department id & department name in 1 row

	}

}
