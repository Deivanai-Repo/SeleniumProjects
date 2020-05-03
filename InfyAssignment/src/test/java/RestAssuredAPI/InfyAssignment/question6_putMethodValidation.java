package RestAssuredAPI.InfyAssignment;

import java.util.Scanner;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import Utilities.putDataFile;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

/*
6.	By using BDD approach (use keywords like given, when, and, then) and above given URL in Q5 and PUT method, to edit name, salary and age of the employee 
Validate below details:
A). Status code is 200
B).Log all the response.
C). Response Body has status as “success”
D). Response Body has employee_name as “your name”

Note : Please do not hard code put Data in test case, keep it in separate utility class. And please make use of collection framework to store put data.

*/
public class question6_putMethodValidation {

	JSONObject requestParams;
	String empid;
	RestAssured baseURI;
	RestAssured basePath;
	String name = putDataFile.getName();

	@Test(priority = 1)
	public void putData() {
		// User input for updating record.
		System.out.print("Enter Emp Id to update:");
		@SuppressWarnings("resource")
		String eid = new Scanner(System.in).nextLine();
		empid = eid;

		requestParams = new JSONObject();
		requestParams.put("name", name);
		requestParams.put("salary", putDataFile.getSalary());
		requestParams.put("age", putDataFile.getAge());
		System.out.println(requestParams);
	}

	@Test(priority = 2)
	public void setURI() {
		System.out.println("EMPID" + empid);
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		RestAssured.basePath = "/update/" + empid;

	}

	@Test(priority = 3)
	public void validateResponse() {
		given().contentType("application/json").body(requestParams.toString()).when().put().then()
				// Validate Status code is 200
				.statusCode(200)
				// Log all the response.
				.log().body()
				// Response Body has status as “success”
				// .body("status",containsString("success"));
				.body("status", equalTo("success"));
		// Response Body has employee_name as “your name”
	}

	@Test(priority = 4)
	public void empNameValidation() {
		System.out.println("EMPID" + empid);
		// RestAssured.baseURI="http://dummy.restapiexample.com/api/v1/employee/"+empid;
		given().get("http://dummy.restapiexample.com/api/v1/employee/" + empid).then().body("employee_name",
				equalTo(name));

	}
}
