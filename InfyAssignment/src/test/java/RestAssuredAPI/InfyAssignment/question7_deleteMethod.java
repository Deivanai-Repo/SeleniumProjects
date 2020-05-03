package RestAssuredAPI.InfyAssignment;

import static io.restassured.RestAssured.given;

import java.util.Scanner;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

/*7.	Use baseURI as (http://dummy.restapiexample.com/api/v1) 
	and basePath as (/delete/{id}/)
	and DELETE method to delete record.*/
public class question7_deleteMethod {
	RestAssured baseURI;
	RestAssured basePath;
	 

@Test 
public void deleteRecord()
{
	RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
	 // User input for deleting the resource Id.
	   System.out.print("Enter Resouce Id to deleted:");
	   @SuppressWarnings("resource")
	   String deleteId = new Scanner(System.in).nextLine();
	  RestAssured.basePath="/delete/"+deleteId;
	  given()
	  .when()
	  .delete()
	  .then()
	  .log().body();	  
	  
} 
}
