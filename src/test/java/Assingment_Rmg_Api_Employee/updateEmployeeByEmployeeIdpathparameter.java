package Assingment_Rmg_Api_Employee;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class updateEmployeeByEmployeeIdpathparameter {
	@Test
	public void updateEmployee() {
		JSONObject jobj=new JSONObject();
		jobj.put("empName", "Ritu1");
		
		
		given()
		.contentType(ContentType.JSON)
		.body(jobj)
		.pathParam("empId", "TYP_00208")
		.when()
		.get("http://localhost:8084/employees/{empId}")
		.then()
		.log().all()
		
		.assertThat().statusCode(200);
			
		
}
}
