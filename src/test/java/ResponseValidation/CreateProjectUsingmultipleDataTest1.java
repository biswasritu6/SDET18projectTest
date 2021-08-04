package ResponseValidation;

import java.lang.Object;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.projectpojolibrary.ProjectLib;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProjectUsingmultipleDataTest1 {
	
	
	
@Test(dataProvider="multi")
public void CreateData (String createBy, String projectName, String status,int teamSize) {
	
	try {
		
	} catch (Exception e) {
		ProjectLib obj=new ProjectLib(createBy, projectName, status, teamSize);
		given()
		    .contentType(ContentType.JSON)
		    .body(obj)
		.when()
		   .post("http:localhost:8084/addProject")
		 .then()
		    .assertThat().statusCode(201)
		    .and()
		    .assertThat().contentType("application/json");
	}


}
	
	
	
	
	
	
	@DataProvider
	public Object[][] multi() {
		Object[][] objarray =new Object[4][4];
		objarray[0][0]="Ritu";
		objarray[0][1]="Testyantra";
		objarray[0][2]="On going";
		objarray[0][3]=5;
		objarray[1][0]="Raj";
		objarray[1][1]="Testyantra123";
		objarray[1][2]="On going";
		objarray[1][3]=5;
		objarray[2][0]="shauvik";
		objarray[2][1]="Testyantra1234";
		objarray[2][2]="On going";
		objarray[2][3]=5;
		objarray[3][0]="shoumen";
		objarray[3][1]="Testyantra1235";
		objarray[3][2]="On going";
		objarray[3][3]=5;
		
		return objarray;
		
	}

}