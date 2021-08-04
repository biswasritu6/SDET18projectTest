package crudOperation_withoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class CompleteUpdationTest {
@Test
public void updation() {
	JSONObject jobj=new JSONObject();
	
	jobj.put("projectName", "RituBiswas");
	
	
	RequestSpecification reqspec = RestAssured.given();
	reqspec.contentType(ContentType.JSON);
	reqspec.body(jobj);
	Response response = reqspec.post("http://localhost:8084/projects/TY_PROJ_1403");
	ValidatableResponse vres =response.then();

}
}
