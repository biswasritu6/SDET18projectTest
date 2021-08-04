package Assignment_RMG_API;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class JsonFileTest {
	public class UsingJsonFile {
		@Test
		public void jsonFileCreate() {
			File file=new File("src/test/resources/data.json");
			given()
				.contentType(ContentType.JSON)
				.body(file)
			.when()
				.post("http://localhost:8084/addProject")
				.then()
				.assertThat().statusCode(201)
				.log().all()
				.and()
				.assertThat().contentType("application/json");
		}

	}

}
