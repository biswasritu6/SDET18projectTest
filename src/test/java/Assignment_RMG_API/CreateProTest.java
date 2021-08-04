package Assignment_RMG_API;

import static io.restassured.RestAssured.given;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateProTest {
	@Test
	public void create() {
	
	Random random = new Random();
	int randomNumber=random.nextInt(1000);
	
	System.out.println(randomNumber);
	JSONObject jobj=new JSONObject();
	jobj.put("createdBy", "rmg");
	jobj.put("projectName", "RituParnaAssign"+randomNumber+"");
	jobj.put("status", "created");
	jobj.put("teamsize", 10);
	
	given()
	.contentType(ContentType.JSON)
	.body(jobj)
	.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat().statusCode(201)
		.log().all()
		.and()
		.assertThat().contentType("application/json");
}
}
