package Assingment_Rmg_Api_Employee;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateEmployeeByJsonFile {
	@Test
	public void jsonFile() {
		File file=new File("src/test/resources/tyss1.json");
		given()
			.contentType(ContentType.JSON)
			.body(file)
		.when()
			.post("http://localhost:8084/employees")
			.then()
			.log().all()
			.assertThat().statusCode(201)
			.and()
			.assertThat().contentType("application/json")
			.and()
			.assertThat().time(Matchers.lessThan(2000L),TimeUnit.MILLISECONDS);
	}

}

