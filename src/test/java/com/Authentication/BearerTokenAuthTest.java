package com.Authentication;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;
public class BearerTokenAuthTest {
@Test
public void bearerToken() {
	given()
		.auth().oauth2("xxxxxxxxxxxxxxxxxxxxxxxxx")//hve to add own repo token
		.when()
		.get("https://api.github.com/user/")
		.then()
		.log().all()
		.assertThat().statusCode(202);
}
}
