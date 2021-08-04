package Assignment_RMG_API;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import java.util.List;

public class ValidateDynamicResponseFromListUsersTest {
	@Test
	public void dynamicResponse() {
		baseURI="https://reqres.in";
		String expectedData = "george.edwards@reqres.in";
		String actualData = null;
		Response response = when().get("/api/users?page=2");
		response.then().log().all().statusCode(200);
		List<String> list = response.jsonPath().get("data.email");
		boolean flag = false;
		for(String data:list) {
			if(data.equals(expectedData)) {
				actualData=data;
				flag=true;
				break;
			}
		}
		Assert.assertEquals(flag, true);
	//	Assert.assertEquals(actualData, expectedData);
	}
}