package com.orangehrm.practice;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class JsonPathTest {
	
	@Test
	public void jsonPath() {
		System.out.println("-----------FIRST AND LAST NAME----------");
		RestAssured.baseURI="http://pure-ravine-92491.herokuapp.com/syntax/";
		
		Response res = 
				given().
					pathParam("studentId", "123").
				when().
					get("api/getStudentProfile/{studentId}");
					
				res.then().
					assertThat().statusCode(200).
				and().
					body("firstName", equalTo("Vladimir"));
				
			JsonPath jPath = res.jsonPath();
			
			String firstName = jPath.get("firstName");
			System.out.println(firstName);
			
			String lastName = jPath.get("lastName");
			System.out.println(lastName);
			
			//System.out.println(res.prettyPrint());
	}

	@Test
	public void getAllStudent() {
		System.out.println("-----------ALL STUDENTS LAST NAME----------");
		RestAssured.baseURI="http://pure-ravine-92491.herokuapp.com/syntax/";
		
		Response res = 
				given().
				when().
					get("api/getAllStudentProfiles");
	
		//res.prettyPrint();
		
		JsonPath jPath = res.jsonPath();
	
		String name = jPath.get("lastName[2]");
		System.out.println(name);	
		
		List<String> allfirstNames = jPath.get("firstName");
		
		for(String names : allfirstNames) {
			System.out.println(names);
		}
		
	}
	
	/*Retrieve all  students and verify that GET response code is 200
	 * and retrieve first name of a second student 
	 * retrieve all students last name 
	 */
	@Test
	public void allStudents() {
		System.out.println("-----------LAST NAME OF ALL STUDENTS----------");
		RestAssured.baseURI="http://pure-ravine-92491.herokuapp.com/syntax/";
		
		Response res = 
				given().
				when().
					get("api/getAllStudentProfiles");
				res.then()
					.assertThat().statusCode(200);
				
		System.out.println(res.statusCode());		
		
		//res.prettyPrint();
		
		JsonPath jPath = res.jsonPath();
		String fName = jPath.get("firstName[1]");
		System.out.println("------------------FirstName of the second student is  --> " + fName);
		
		List<String> allLastNames = jPath.get("lastName");
		for(String lNames : allLastNames) {
			System.out.println(lNames);
		}
	}
	
	
}
