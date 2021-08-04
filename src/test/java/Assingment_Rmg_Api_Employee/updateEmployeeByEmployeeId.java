package Assingment_Rmg_Api_Employee;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class updateEmployeeByEmployeeId {
	@Test
	public void update() {
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "online batch");
		jobj.put("projectName", "Ritu75016491270");
		jobj.put("status", "on_going");
		jobj.put("teamsize", 600);
		
		given()
		.contentType(ContentType.JSON)
		.body(jobj)
		.when()
			.put("http://localhost:8084/employees/TYP_01604")
			.then().log()
			.all()
			.assertThat().statusCode(200);
			
			
	}
	}

