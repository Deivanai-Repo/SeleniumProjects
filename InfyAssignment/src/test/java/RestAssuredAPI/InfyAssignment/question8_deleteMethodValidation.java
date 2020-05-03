package RestAssuredAPI.InfyAssignment;
/*8.	By using BDD approach (use keywords like given, when, and, then)
 and above given URL in Q7 and DELETE method, delete the record.
Validate below details:
A). Status code is 200
B).Log all the response.
C). Response Body has status as “success”
D). Response Body has message as “successfully! deleted Records”*/


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.Scanner;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class question8_deleteMethodValidation {
	RestAssured baseURI;
	RestAssured basePath;
	 

@Test(priority=1)
public void getURI()
{
	RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
	 // User input for deleting the resource Id.
	   System.out.print("Enter Resouce Id to deleted:");
	   @SuppressWarnings("resource")
	   String deleteId = new Scanner(System.in).nextLine();
	  RestAssured.basePath="/delete/"+deleteId;
}
@Test(priority=2)
public void validateStatusCode()
{
	given()
	.when()
	.delete()
	.then()
	//Validate Status Code
	.statusCode(200)
	
	//Log all Response
	.log().all()

	// Response Body has status as “success”
	.body("status", equalTo("success"))
	      //.body("status", equalTo("failed"))
	
	//Response Body has message as “successfully! deleted Records”*/
	.body("message", equalTo("successfully! deleted Records"));
         //.body("message", equalTo("Error! Not able to delete record"))
	
}
}