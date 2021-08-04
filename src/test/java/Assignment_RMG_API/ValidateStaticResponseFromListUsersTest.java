package Assignment_RMG_API;

	import org.testng.Assert;
	import org.testng.annotations.Test;
	import io.restassured.response.Response;
	import static io.restassured.RestAssured.*;

	public class ValidateStaticResponseFromListUsersTest {

		@Test
		public void staticResponse() {
		//  Expected data Initialization
			String expectedData = "Michael";
		//  Getting the resource from the server
			Response response = when().get("https://reqres.in/api/users?page=2");
		//  verification of status code
			response.then().statusCode(200).log().all();
		//  Capture the specific data from response body
			String actualData = response.jsonPath().get("data[0].first_name");
			System.out.println(expectedData);
			System.out.println(actualData);
		//  testNG Assertion for Actual and Expected Data
			Assert.assertEquals(actualData, expectedData);
		}
	}

