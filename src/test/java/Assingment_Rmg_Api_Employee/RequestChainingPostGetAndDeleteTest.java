package Assingment_Rmg_Api_Employee;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class RequestChainingPostGetAndDeleteTest {

	@Test
	public void requestChaining() {
		
		// Set Base URL
		baseURI="http://localhost";
		port=8084;

		// Create Object by using HashMap
		HashMap map = new HashMap();
		map.put("createdBy", "RituBiswas");
		map.put("projectName", "Happy Life");
		map.put("status", "Created");
		map.put("teamSize", 5);

		// Create Project
		RequestSpecification data = 
				given()
				.contentType(ContentType.JSON)
				.body(map);
		Response postResponse = data.when()
				.post("/addProject");
	    postResponse.then()
	                  .log().all()
	                  .assertThat().contentType(ContentType.JSON)
	                  .assertThat().statusCode(201)
	                  .assertThat().time(Matchers.lessThan(10L),TimeUnit.SECONDS);
		
		// Capture ProjectId which i have created
				String projectId = postResponse.jsonPath().get("projectId");
				System.out.println(projectId);
				
		// Fetching the Created Project by Getting all Projects
				boolean flag = false;
				Response allProjectsResp = when().get("/projects");
				allProjectsResp.then().assertThat().statusCode(200);
				
				List<String> allProjectNames = allProjectsResp.jsonPath().get("projectId");
				for(String oneProject:allProjectNames) {
					if(projectId.equals(oneProject)) {
						flag=true;
						break;
					}
				}
				Assert.assertEquals(flag, true);
		
		// Get that Created Project
		/*		Response getResponse = given()
				   .pathParam("Proj_Id", projectId)
				.when()
				   .get("/projects/{Proj_Id}");
				getResponse.then()
					.log().all()
					.assertThat().contentType(ContentType.JSON)
					.assertThat().statusCode(200)
				    .assertThat().time(Matchers.lessThan(10L),TimeUnit.SECONDS);  */
				
		// Delete that Project
				Response deleteResponse = given()
				  .pathParam("Proj_Id", projectId)
				.when()
				  .delete("/projects/{Proj_Id}");
				deleteResponse.then()
				                .log().all()
				                .assertThat().contentType(ContentType.JSON)
				                .assertThat().statusCode(204)
				                .assertThat().time(Matchers.lessThan(10L),TimeUnit.SECONDS);
				
		// Fetching Response Time of post,get and delete request	
				System.out.println("response time of post request in Milli Second: "+postResponse.getTime());
		//		System.out.println("response time of get request in Milli Second: "+getResponse.getTime());
				System.out.println("response time of get request in Milli Second: "+allProjectsResp.getTime());
				System.out.println("response time of delete request in Milli Second: "+deleteResponse.getTime());
	}
}
