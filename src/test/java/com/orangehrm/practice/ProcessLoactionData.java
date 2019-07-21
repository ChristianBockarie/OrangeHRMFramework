package com.orangehrm.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class ProcessLoactionData {
	String dbUrl = "jdbc:oracle:thin:@syntaxdatabase.cdjflmucstpo.us-east-1.rds.amazonaws.com:1521:ORCL";
	String dnUsername = "Syntax";
	String dbPassword = "syntax123";

	// process query that will give result of street address, city and country name
	// and store results inside the list
	@Test
	public void getLocationDate() throws SQLException {
		Connection conn = DriverManager.getConnection(dbUrl, dnUsername, dbPassword);

		String query = "select street_address, city, country_name from locations l join countries c on l.country_id = c.country_id";
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(query);
		ResultSetMetaData rsMetaData = rs.getMetaData();

		List<Map<String, String>> rsList = new ArrayList<>();
		while (rs.next()) {
			Map<String, String> rsMap = new HashMap<>();

			
		/**	@author Christian hard coding for retrieving data using map
		   	 rsMap.put("street_address", rs.getString("street_address"));
			 rsMap.put("city", rs.getString("city"));
			 rsMap.put("country_name", rs.getString("country_name"));
		*/
			//Using for loop 
			for (int i = 1; i <= rsMetaData.getColumnCount(); i++) {
				rsMap.put(rsMetaData.getColumnName(i), rs.getObject(i).toString());
			}
			rsList.add(rsMap);
		}

		System.out.println(rsList);

		rs.close();
		st.close();
		conn.close();
	}
}
