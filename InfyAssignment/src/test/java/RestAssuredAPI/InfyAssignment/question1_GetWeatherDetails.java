package RestAssuredAPI.InfyAssignment;
//1.	Use request URL (http://restapi.demoqa.com/utilities/weather/city/Pune) 

// and GET method to fetch weather details of Pune city as response.

import java.util.Scanner;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class question1_GetWeatherDetails {
	@Test
	public void getCityWeather() {
		// User input for City.
		System.out.print("Enter city Name:");
		@SuppressWarnings("resource")
		String inputCity = new Scanner(System.in).nextLine();

		// Url appending with User input.
		String partial_baseUri = "http://restapi.demoqa.com/utilities/weather/city/";
		String baseUri = partial_baseUri + inputCity;
		System.out.print("Base Uri is " + baseUri);

		// Getting Response.
		Response response = RestAssured.get(baseUri);
		// Print the response body as string
		System.out.println("response body is" + response.getBody().asString());

	}
}
