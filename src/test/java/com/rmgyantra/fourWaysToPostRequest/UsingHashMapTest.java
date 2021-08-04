package com.rmgyantra.fourWaysToPostRequest;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class UsingHashMapTest {
	@Test
	public void createUsingmap() {
		HashMap map= new HashMap();
		map.put("createdBy", "online batch");
		map.put("projectName", "BiswasRitu");
		map.put("status", "on_going");
		map.put("teamsize", 1999999);
		given()
		.contentType(ContentType.JSON)
		.body(map)
		.when()
			.post("http://localhost:8084/addProject")
			.then()
			.log().all()
			.and()
			.assertThat().contentType("application/json");
	
	}

}
