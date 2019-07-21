package com.orangehrm.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class ProcessResultSet {
	String dbUrl = "jdbc:oracle:thin:@syntaxdatabase.cdjflmucstpo.us-east-1.rds.amazonaws.com:1521:ORCL";
	String dnUsername = "Syntax";
	String dbPassword = "syntax123";

	@Test
	public void getResultSetData() throws SQLException {

		Connection conn = DriverManager.getConnection(dbUrl, dnUsername, dbPassword);
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select first_name, last_name from employees where job_id='IT_PROG'");

		List<Map<String, String>> rsList = new ArrayList<>();
		while (rs.next()) {
			Map<String, String> rsMap = new HashMap<>();
			rsMap.put("first_name", rs.getString("first_name"));
			rsMap.put("last_name", rs.getString("last_name"));
			rsList.add(rsMap);
		}
		System.out.println(rsList);

		rs.close();
		st.close();
		conn.close();
	}
}
