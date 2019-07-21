package com.orangehrm.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class DeptNameAndDeptID {

	String dbUrl = "jdbc:oracle:thin:@syntaxdatabase.cdjflmucstpo.us-east-1.rds.amazonaws.com:1521:ORCL";

	String dnUsername = "Syntax";

	String dbPassword = "syntax123";

	// display in console department id & department name in 1 row
	@Test
	public void dbConnections() throws SQLException {

		Connection conn = DriverManager.getConnection(dbUrl, dnUsername, dbPassword);
		Statement statement = conn.createStatement();
		ResultSet resultSet = statement.executeQuery("select department_id, department_name from departments");

		while (resultSet.next()) {
			int dept_id = resultSet.getInt("department_id");
			String dept_name = resultSet.getString("department_name");
			System.out.println(dept_id + " " + dept_name);
		}
		resultSet.close();
		statement.close();
		conn.close();
	}

}
