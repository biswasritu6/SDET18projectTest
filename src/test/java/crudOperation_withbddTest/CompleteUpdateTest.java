package crudOperation_withbddTest;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CompleteUpdateTest {
@Test
public void update() {
	JSONObject jobj=new JSONObject();
	jobj.put("createdBy", "online batch");
	jobj.put("projectName", "Ritu7001615923");
	jobj.put("status", "on_going");
	jobj.put("teamsize", 600);
	
	given()
	.contentType(ContentType.JSON)
	.body(jobj)
	.when()
		.put("http://localhost:8084/projects/TY_PROJ_1404")
		.then().log().all();
		
		
}
}
