package Assignment_RMG_API;

import static io.restassured.RestAssured.when;

import org.testng.annotations.Test;

public class getTheprojectWithInvalidProjectTest {
	@Test
	public void getProjectWithInvalidId() {
	when()
		.get("http://localhost:8084/projects/rrrrrrrrrr")
	.then()
		.assertThat().statusCode(500)
		.and()
		.assertThat().contentType("application/json")
		.and()
		.log().all();
}
}