package com.Authentication;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
public class BasicAuth2test {
@Test
public void auth2() {
	Response response = given()
	.formParam("client_id", "Application_2")
	.formParam("client_secret", "eb17c9788b8c92d01f9386c4e72fa367")
	.formParam("grant_type", "client_credentials")
	.formParam("redirect_uri", "http://example.com")
	
		.when()
		.post("http://coop.apps.symfonycasts.com/token");
	System.out.println(response.prettyPrint());
	
	String token=response.jsonPath().get("access_token");
	
	given()
		.auth().oauth2(token)
		.pathParam("USER_ID", "2131")
		.when()
		.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/eggs-collect")
		.then().log().all();
}
}










