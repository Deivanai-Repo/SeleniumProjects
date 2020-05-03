package RestAssuredAPI.InfyAssignment;
/*
5.	Use baseURI as (http://dummy.restapiexample.com/api/v1)
	and basePath as (/update/{id}/) and PUT method to edit name,
	salary and age of the employee

Use JSON payload:
{
            
        "name": "your name",
        "salary": "your salary",
        "age": "your age"
  
}*/

import java.io.File;
import java.util.Scanner;

import org.testng.annotations.Test;

import com.aventstack.extentreports.gherkin.model.Then;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
/*5.	Use baseURI as (http://dummy.restapiexample.com/api/v1) and
 *  basePath as (/update/{id}/) and
	PUT method to edit name, salary and age of the employee*/

public class question5_putMethodJsonFile {
	@Test(priority = 1)
	public void putData() {
		// User input for updating record.
		System.out.print("Enter Emp Id to update:");
		@SuppressWarnings("resource")
		String empid = new Scanner(System.in).nextLine();
	 

		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
		RestAssured.basePath = "/update/" + empid;
		File json = new File("C:\\Selenium Codes_LT Drive\\InfyAssignment\\DataSet\\putMethodJsonFile.txt");
		// Response response =
		given().contentType("application/json").log().all().body(json).put().then().statusCode(200);
	}
}
