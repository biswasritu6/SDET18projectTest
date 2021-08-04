package com.parameters;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
public class PathParameterTest {
	@Test
	public void parameter() {
		given()
		.contentType(ContentType.JSON)
		.pathParam("projectId", "TY_PROJ_814")
		//here projectId is the variable which holds TY_PROJ_814
		.when()
		.get("http://localhost:8084/projects/{projectId}")
		.then()
		.log().all()
		
		.assertThat().statusCode(200);
		
	}

}
