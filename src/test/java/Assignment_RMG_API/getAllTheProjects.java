package Assignment_RMG_API;

import static io.restassured.RestAssured.when;

import org.testng.annotations.Test;

public class getAllTheProjects {
	@Test
	public void getProjects() {
	when()
		.get("http://localhost:8084/projects")
	.then()
		.assertThat().statusCode(200)
		.and()
		.assertThat().contentType("application/json")
		.and()
		.log().all();
}
}