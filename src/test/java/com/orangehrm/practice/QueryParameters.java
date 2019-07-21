package com.orangehrm.practice;

import org.junit.*;	

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;


public class QueryParameters {

	@Test
	public void queryParameters() {

		RestAssured.baseURI = "https://reqres.in/";

		Response response = 
				
				given().
					queryParam("page", "2").
					
				when().
					get("/api/users");
		
		//JUnit
		Assert.assertEquals(200, response.getStatusCode());
		
		Assert.assertTrue(response.asString().contains("Tracey"));

	}
	@Test
	public void pathParameters() {
		
		RestAssured.baseURI="https://reqres.in";
		
		 
		given().pathParam("id", "2").
		when().get("/api/users/{id}").
		then().statusCode(200);
					
	}

}
