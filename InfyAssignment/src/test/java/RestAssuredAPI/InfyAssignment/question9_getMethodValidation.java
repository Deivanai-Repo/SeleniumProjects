package RestAssuredAPI.InfyAssignment;


/*9.	By using BDD approach (use keywords like given, when, and, then)
 and URL(https://reqres.in/api/users/2) and GET method.
Validate below details:
A). Status code is 200
B). Log the Response body
C). Response Body has first_name as “Janet”
D). Response Body has company as “StatusCode Weekly”
E). Header has Content-Type as application/json

Note : Run all the above validations (A to E) in Q9 as different test through testng framework having A has highest priority then B,C,D,E respectively.
*/

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import com.aventstack.extentreports.gherkin.model.Given;

public class question9_getMethodValidation {
	// Status code is 200
	@Test(priority=1)
	public void validateStatusCode()
	{
		given()
		.get("https://reqres.in/api/users/2")
		.then()
		.statusCode(200);
		
	}
	//Log the Response body
	@Test(priority=2)
	public void logResponseBody()
	{
		given()
		.get("https://reqres.in/api/users/2")
		.then()
		.log().body();		
	}
	//Response Body has first_name as “Janet”
	@Test(priority=3)
	public void validateFirstName()
	{
		given()
		.get("https://reqres.in/api/users/2")
		.then()
		.body("data.first_name",equalTo("Janet"));
	}
	// Response Body has company as “StatusCode Weekly”
	@Test(priority=4)
	public void validateHasStatusCode_Weekly()
	{
		given()
		.get("https://reqres.in/api/users/2")
		.then()
		.body("ad.company",equalTo("StatusCode Weekly"));
	}
	//Header has Content-Type as application/json
	@Test(priority=5)
	public void validateHeader()
	{
		given()
		.get("https://reqres.in/api/users/2")
		.then()  
	 	.header("Content-Type", containsString("application/json"));  
		//application/json; charset=utf-8 
	}
	

}
