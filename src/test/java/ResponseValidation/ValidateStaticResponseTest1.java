package ResponseValidation;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class ValidateStaticResponseTest1 {
	@Test
	public void staticResponse() {
    //  Expected data Initialization
		int expectedData=777;
	//  Getting the resource from the server
		Response response = when().get("http://localhost:8084/projects");
	//  verification of status code
		response.then().statusCode(200).log().all();
    //  Capture the specific data from response body
		int actualData = response.jsonPath().get("[1].teamSize");
		System.out.println("Expected data is :"+expectedData);
		System.out.println("Actual data is :"+actualData);
	//  testNG Assertion for Actual and Expected Data
		Assert.assertEquals(actualData, expectedData);
	}
}