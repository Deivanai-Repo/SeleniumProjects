package RestAssuredAPI.InfyAssignment;

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
 
 public class question4 {
	@Test
	public void putmethod()
	{
		// Create a reference for Response interface
		Response response;

		// Path from where the excel file has to be read
		String path = "C:\\Selenium Codes_LT Drive\\InfyAssignment\\DataSet\\postDataFile.xlsx";

		// File input stream which needs the input as the file location
		FileInputStream fis = new FileInputStream(path);

		// Workbook reference of the excel file
		XSSFWorkbook wb = new XSSFWorkbook(fis);

		// Sheet which needs to be accessed from within the workbook
		XSSFSheet sheet = wb.getSheetAt(0);

		// Count the number of rows
		int rowCount = sheet.getLastRowNum();

		// Iterate the AccountNumber
		for (int i = 0; i <= rowCount; i++) {

			// Pass the row number and the cell number from where the value has to be
			// fetched
			DataFormatter formatter = new DataFormatter();
			//to solve the issue cannot get a string value from a numeric cell, DataFormatter is used
			
			String id = formatter.formatCellValue(sheet.getRow(i).getCell(0));
			// Make a request to the server by specifying the method Type and the method
			// URL.
			// This will return the Response from the server. Store the response in a
			// reference variable created above.
			
			RestAssured.baseURI="http://restapi.demoqa.com/customer";
			RestAssured.basePath="/register";
			
			
			response = given()
					.contentType("application/json")
					.log().all().body(json).post();
			response.prettyPrint();
	}

} 