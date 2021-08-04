package com.rmgyantra.fourWaysToPostRequest;

import static io.restassured.RestAssured.given;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateProjectTest {
@Test
	public void create() {
	
	Random random = new Random();
	int randomNumber=random.nextInt(2000);
	
	System.out.println(randomNumber);
	JSONObject jobj=new JSONObject();
	jobj.put("createdBy", "online batch");
	jobj.put("projectName", "RituParna"+randomNumber+"");
	jobj.put("status", "on_going");
	jobj.put("teamsize", 900);
	
	given()
	.contentType(ContentType.JSON)
	.body(jobj)
	.when()
		.post("http://localhost:8084/addProject")
		.then()
		.log().all()
		.and()
		.assertThat().contentType("application/json");
}
}
