package crudOperation_withoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class CreateProjectTest {
	@Test
	public void createProject() {
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "online batch");
		jobj.put("projectName", "Ritu");
		jobj.put("status", "on_going");
		jobj.put("teamsize", 17);
		
		RequestSpecification reqspec = RestAssured.given();
		reqspec.contentType(ContentType.JSON);
		reqspec.body(jobj);
		Response response = reqspec.post("http://localhost:8084/addProject");
		ValidatableResponse vres =response.then();
		vres.assertThat().statusCode(201);
		vres.assertThat().contentType("appliction/json");
		vres.log().all();
}
}
