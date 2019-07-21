package com.orangehrm.practice;

import org.junit.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ApiGetDemo {

	// get status and print response from Weather API
	@Test
	public void getWeather() {

		// get method will give you back response
		Response response = RestAssured.when().get("http://restapi.demoqa.com/utilities/weather/city/Freetown");

		response.prettyPrint();

		int code = response.getStatusCode();
		System.out.println(code);
	}
	
	// get status and print response from Country API
	@Test
	public void getCountry() {

		Response country = RestAssured.when().get("http://restcountries.eu/rest/v1/name/Sierra Leone");
		
		//country.prettyPrint();
		//getStatusCode();
		
		int countryCode = country.getStatusCode();
		Assert.assertEquals(200, countryCode);
		
		//Retrieve body response as string
		String body = country.asString();
		System.out.println(body);
		Assert.assertTrue(body.contains("Freetown"));
		
		//retrieve body header date as string
		String header = country.getHeader("Date");
		System.out.println(header);
		
		
	}
}
