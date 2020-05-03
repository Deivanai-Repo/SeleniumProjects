package RestAssuredAPI.InfyAssignment;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.apache.commons.lang3.RandomStringUtils;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

/*3.	Use baseURI as (http://restapi.demoqa.com/customer) and 
  basePath as (/register) and POST method to register yourself as a customer.

Use JSON payload :
{
    "FirstName": "{parameterize your first name}",
    "LastName": "{parameterize your last name}",
    "UserName": "{parameterize your username}",
    "Password": "{parameterize your password}",
    "Email": "{parameterize your email}"
}

*/

public class question3_postCustomerDetails {

	JSONObject requestParams = new JSONObject();

	@BeforeClass
	void postData() {

		RestAssured.baseURI = "http://restapi.demoqa.com/customer";
		RestAssured.basePath = "/register";

		requestParams.put("FirstName", RandomStringUtils.randomAlphabetic(5));
		requestParams.put("LastName", RandomStringUtils.randomAlphabetic(5));
		requestParams.put("UserName", RandomStringUtils.randomAlphabetic(8));
		requestParams.put("Password", RandomStringUtils.randomAlphabetic(6));
		requestParams.put("Email", RandomStringUtils.randomAlphabetic(10));

	}

	@Test
	void registerCustomer() {
		given().contentType("application/json").body(requestParams.toJSONString()).when().post().then().statusCode(201)
				.log().body();

	}

}