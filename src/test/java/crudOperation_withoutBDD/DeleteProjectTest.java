package crudOperation_withoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class DeleteProjectTest {

	@Test
	public void deleteProject() {
		Response response = RestAssured.delete("http://localhost/:8084/projects/TY_PROJ_814");
		ValidatableResponse vresponse = response.then();
		vresponse.assertThat().contentType("application/json");
		vresponse.assertThat().statusCode(204);
		
	}
}
