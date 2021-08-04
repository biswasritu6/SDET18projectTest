package Assignment_RMG_API;

import static io.restassured.RestAssured.given;


import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateProjectWithSameDataTest2 {
	@Test
	public void create() {
	

	JSONObject jobj=new JSONObject();
	jobj.put("createdBy", "rmg");
	jobj.put("projectName", "RituParnaAssign430");
	jobj.put("status", "created");
	jobj.put("teamsize", 10);
	
	given()
	.contentType(ContentType.JSON)
	.body(jobj)
	.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat().statusCode(409)
		.log().all()
		.and()
		.assertThat().contentType("application/json");
}
}
