package com.rmgyantra.fourWaysToPostRequest;

import static io.restassured.RestAssured.given;

import java.util.Random;

import org.testng.annotations.Test;

import com.projectpojolibrary.ProjectLib;

import io.restassured.http.ContentType;

public class CreateUsingpojotest {
@Test
public void createpojo() {
	Random random = new Random();
	int randomNumber=random.nextInt(2000);
	ProjectLib pojoObject = new ProjectLib("testyantra", "testyantra_onlines","completed",800);
	given()
	.contentType(ContentType.JSON)
	.body(pojoObject)
	.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat().statusCode(201)
		.log().all()
		.and()
		.assertThat().contentType("application/json");
}
}
