package Assignment_RMG_API;

import static io.restassured.RestAssured.when;

import org.testng.annotations.Test;

public class deleteSingleProject {
	@Test
	public void deleteprojects() {
		when()
		.delete("http://localhost:8084/projects/TY_PROJ_640")
	.then()
		.assertThat().statusCode(204)
		.and()
		.log().all();
	}
}
