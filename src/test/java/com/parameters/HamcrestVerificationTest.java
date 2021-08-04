package com.parameters;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class HamcrestVerificationTest {
	@Test
	public void ham() {
		when()
		.get("http://localhost:8084/projects")
		.then()
			.assertThat().time(Matchers.lessThan(100L),TimeUnit.MILLISECONDS)
			.assertThat().body("[2].projectName",Matchers.equalTo("TYSS366"))
			.log().all();
	}

}
