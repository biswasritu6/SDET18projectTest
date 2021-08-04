package com.rmgyantra.projectTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;
import com.projectpojolibrary.ProjectLib;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class CreateProjectWithCompletedStatusTest {
@Test
public void CreateProjectWithCompletedStatus() throws Throwable {
	Random random=new Random();
	int randomNumber=random.nextInt(1000);
	
	String expectedProjectName="TeamIndia+randomNumber";
	String expectedStatus="completed";
	//create a resource  inside the serverusing pojo class
	ProjectLib projectlib = new ProjectLib("ViratKholi",expectedProjectName,expectedStatus,15);
	//Give precondition and capture the response after doing post operation
	Response response = given()
	.contentType(ContentType.JSON)
	.body(projectlib)
	.when().post("http://localhost:8084/addProject");
	//Capture projectName and Statuscode from the response
	String responseProjectName=response.jsonPath().get("projectName");
	String responseStatus=response.jsonPath().get("status");
	//provide the restassured verificaton
	response.then()
		.assertThat().statusCode(201)
		.assertThat().contentType(ContentType.JSON)
		.log().all();
	
	//Register the database
	Driver driver = new Driver();
	DriverManager.registerDriver(driver);
	//connect to mysql database
	 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");

	//create the statement
	 Statement statement=connection.createStatement();
	 
	 //execute query and get the values from database
	 String actualProjectName=null;
	 String actualStatus=null;
	 boolean flag=false;
	 ResultSet result=statement.executeQuery("select * from project");
	 while(result.next()) {
		 if(result.getString(4).equals(expectedProjectName)) {
			 actualProjectName=result.getString(4);
			 actualStatus=result.getString(5);
			flag=true;
			break;
		 }
		 
		 }
	 connection.close();
	 //assertion using flag btwn expected and actual from database
	 Assert.assertEquals(flag, true);
	 //verification btwn expected and actual from database
	 Assert.assertEquals(actualProjectName, expectedProjectName);
	 //verification between expected and from response
	 Assert.assertEquals(responseProjectName, expectedProjectName);

	 //assertion for status
	 Assert.assertEquals(actualStatus, expectedStatus);
	 Assert.assertEquals(responseStatus, expectedStatus);


}
}

















