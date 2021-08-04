package com.parameters;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class FormParameterTest {
@Test
public void parameter() {
	given()
		.contentType(ContentType.JSON)
		.formParam("createdBy", "MS_Dhoni")
		.formParam("projectName", "CSK")
		.formParam("status", "Completed")
		.formParam("teamSize", 20)
		.when()
			.post("http://localhost:8084/addProject")
			.then()
			.log().all();

}
}




