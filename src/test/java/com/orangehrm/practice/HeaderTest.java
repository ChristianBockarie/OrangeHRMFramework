package com.orangehrm.practice;

import static io.restassured.RestAssured.*;

import org.junit.*;
import static org.hamcrest.Matchers.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class HeaderTest {

	/* 
	 * When I send GET request to the "/api/getAllStudentProfiles"
	 * Then response status code is 200
	 * And response header "Content-Type" contains "application/json";
	 */
	@Test
	public void headerTest() { 
	RestAssured.baseURI="http://pure-ravine-92491.herokuapp.com/syntax/";
	
	Response res = 
			given().
			when().
				get("api/getAllStudentProfiles");
	res.then().assertThat().statusCode(200).
	and().header("Content-Type", equalTo("application/json;charset=UTF-8"));
	
	
	
	}
}
