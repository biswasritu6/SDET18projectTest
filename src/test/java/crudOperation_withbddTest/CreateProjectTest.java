package crudOperation_withbddTest;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
public class CreateProjectTest {
@Test
public void create() {
	JSONObject jobj=new JSONObject();
	jobj.put("createdBy", "online batch");
	jobj.put("projectName", "Ritu700");
	jobj.put("status", "on_going");
	jobj.put("teamsize", 100);
	
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
