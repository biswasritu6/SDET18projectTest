package Assignment_RMG_API;

import static io.restassured.RestAssured.when;

import org.testng.annotations.Test;

public class GetTheSingleprojectTest {
	@Test
	public void getSingleProject() {
	when()
		.get("http://localhost:8084/projects/TY_PROJ_635")
	.then()
		.assertThat().statusCode(200)
		.and()
		.assertThat().contentType("application/json")
		.and()
		.log().all();
}
}
