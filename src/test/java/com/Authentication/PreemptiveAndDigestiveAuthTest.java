package com.Authentication;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
public class PreemptiveAndDigestiveAuthTest {
@Test
public void auth() {
	given()
	.auth()
	.preemptive().basic("rmgyantra","rmgy@9999")
	.when()
	.get("http://localhost:8084/projects")
	.then()
	.log().all().assertThat().statusCode(202);

}
@Test
public void digestive() {
	given()
	.auth()
	.digest("rmgyantra","rmgy@9999")
	.when()
	.get("http://localhost:8084/login")
	.then()
	.log().all().assertThat().statusCode(202);
}
}

