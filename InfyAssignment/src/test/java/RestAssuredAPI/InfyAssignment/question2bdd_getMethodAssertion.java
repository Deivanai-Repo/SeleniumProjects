package RestAssuredAPI.InfyAssignment;
/*
2.	By using BDD approach (use keywords like given, when, and, then)
and above given URL in Q1 and GET method, fetch response body.
Validate below details:
A). Status code is 200
B). Response body has City as Pune
C). Response Body has Temperature as 38.39 Degree Celsius
D). Header has Content-Type as application/json
*/

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import java.util.Scanner;
import org.testng.annotations.Test;
import io.restassured.response.Response;

public class question2bdd_getMethodAssertion {

	String baseURI;
	Response response;

	@Test(priority = 1)
	public void userInput() {

		// User input for City.
		System.out.print("Enter city Name:");
		@SuppressWarnings("resource")
		String inputCity = new Scanner(System.in).nextLine();

		// Url appending with User input.
		String partial_baseUrl = "http://restapi.demoqa.com/utilities/weather/city/";
		baseURI = partial_baseUrl + inputCity;
		System.out.print("Base Url is " + baseURI);
	}

	// testing status code
	@Test(priority = 2)
	public void validateStatusCode() {
		given().get(baseURI).then().statusCode(200);
	}

	@Test(priority = 3)
	public void validateCityName() {
		given().get(baseURI).then().body("City", equalTo("Pune")).log().all();
	}

	@Test(priority = 4)
	public void validateTemperature() {
		given().get(baseURI).then().body("Temperature", equalTo("38.39 Degree celsius")).log().all();
	}

	@Test(priority = 5)
	public void validateContentType() {
		given().get(baseURI).then().contentType("application/json");
	}

}
