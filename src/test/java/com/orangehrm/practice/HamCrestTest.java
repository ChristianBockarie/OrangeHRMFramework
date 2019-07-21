package com.orangehrm.practice;

import static io.restassured.RestAssured.*;		
import org.junit.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;


public class HamCrestTest {

	@Test
	public void getSpecificStudentId() {
		
		RestAssured.baseURI="http://pure-ravine-92491.herokuapp.com/syntax/";//base uri
				
		Response res = 
				given().
					pathParam("studentId", "123").//path/query parameter
				
				when().
					get("api/getStudentProfile/{studentId}");//end point
					
				res.then().
					assertThat().statusCode(200).
				and().
					body("firstName", equalTo("Vladimir"));
				System.out.println(res.prettyPrint());
	}
	
	@Test
	public void getQuoteBySpecificCharacter() {
		
		RestAssured.baseURI = "https://got-quotes.herokuapp.com/";
		
		Response response = 
				
				given().
					queryParam("char", "Varys").//query parameter
					
				when().
					get("quotes");//end point
		
		Assert.assertEquals(200, response.getStatusCode());
		
		Assert.assertTrue(response.asString().contains("Varys"));
		
		System.out.println(response.prettyPrint());
		
	}
	
	
	@Test
	public void getQuoteBy() {
		
		RestAssured.baseURI = "https://got-quotes.herokuapp.com/";
		
				given().
					queryParam("char", "Varys").
		
				when().
					get("quotes"). //resonse
				
				then().
					assertThat().statusCode(200).
				and().
					assertThat().body("character", equalTo("Varys"));
	}
	
}
