package RestAssuredAPI.InfyAssignment;
import org.apache.commons.lang3.RandomStringUtils;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
 

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class PutDemo {
	//public static HashMap map2 = new HashMap();
	JSONObject requestParams;
	int empid = 21;
	@BeforeClass
	void putData()
	{
		/*map2.put("name",PutRandomData.getName());
		map2.put("salary",PutRandomData.getSalary());
		map2.put("age",PutRandomData.getAge());
		System.out.println(map2);*/
		 requestParams = new JSONObject();
		 requestParams.put("name", RandomStringUtils.randomAlphabetic(2));
		 requestParams.put("salary", RandomStringUtils.randomAlphabetic(2));
		 requestParams.put("age", RandomStringUtils.randomAlphabetic(2));
		 System.out.println(requestParams);
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		RestAssured.basePath="/update/"+empid;
		
	}

	@Test
	void putDemoMethod()
	{
		given()
		.contentType("application/json")
		.body(requestParams.toString())
		.when()
		.put()
		.then()
		.statusCode(200)
		.body("status", equalTo("success"))
		.log().all();
	

}

}
