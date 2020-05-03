package RestAssuredAPI.InfyAssignment;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

/*4.	By using BDD approach (use keywords like given, when, and, then) 
and above given URL in Q3 and POST method, fetch response body.
Validate below details:
A). Status code is 201
B). Response Body has SuccessCode as “OPERATION_SUCCESS”
C). Response Body has Message as “Operation completed successfully”

Note : Please do not hard code post Data in test case, 
keep it in separate utility class. And please make use of collection
 framework to store post data.
*/

public class question4_postMethodValidation {
	Response response;
	File json;

	@Test(priority = 1)
	public void loadURI() {
		RestAssured.baseURI = "http://restapi.demoqa.com/customer";
		RestAssured.basePath = "/register";
		json = new File("C:\\Selenium Codes_LT Drive\\InfyAssignment\\DataSet\\putMethodJsonFile.txt");
	}

	@Test(priority = 2)
	public void postAndValidateResponse() {

		given().contentType("application/json").log().all().body(json).post().then()
				// Status code is 201
				.statusCode(201)
				// Response Body has SuccessCode as “OPERATION_SUCCESS”
				.body("SuccessCode", equalTo("OPERATION_SUCCESS"))
				// Response Body has Message as “Operation completed successfully”
				.body("Message", equalTo("Operation completed successfully"));

	}
}