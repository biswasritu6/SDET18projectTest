package com.rmgyantra.projectTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import org.codehaus.groovy.tools.javac.JavaAwareCompilationUnit;
import com.mysql.cj.jdbc.Driver;
import com.projectpojolibrary.ProjectLib;
import com.rmgyantra.GenericUtils.BaseAPIClass;
import com.rmgyantra.GenericUtils.DataBaseUtilities;
import com.rmgyantra.GenericUtils.Endpoints;
import com.rmgyantra.GenericUtils.JavaUtility;
import com.rmgyantra.GenericUtils.JsonUtility;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class CreateProjectWithCompletedStatusUsingFrameworkTest extends BaseAPIClass {
@Test
public void CreateProject() throws Throwable {
	JavaUtility javautils = new JavaUtility();
	JsonUtility jsonUtils = new JsonUtility();
	DataBaseUtilities dbUtility = new DataBaseUtilities();
	
	String expectedProjectName="TeamIndia"+javautils.randomNumber();
	String expectedStatus="completed";
	
	//create a resource  inside the serverusing pojo class
	ProjectLib projectlib = new ProjectLib("ViratKholi",expectedProjectName,expectedStatus,15);
	
	//Give precondition and capture the response after doing post operation
	Response response = given()
	.contentType(ContentType.JSON)
	.body(projectlib)
	.when().post(Endpoints.addProject_EP);
	
	
	//Capture projectName and Statuscode from the response
	String responseProjectName=jsonUtils.getJsonPathData("projectName",response);
	String responseStatus=jsonUtils.getJsonPathData("status", response);
	
	//provide the restassured verificaton
	response.then()
		.assertThat().statusCode(201)
		.assertThat().contentType(ContentType.JSON)
		.log().all();
	
	String querry="select * from project";
	String actualProjectName=dbUtility.executeQuerryAndGetData(querry, 4, expectedProjectName);
	String actualstatus=dbUtility.executeQuerryAndGetData(querry, 5, expectedStatus);
		 
	//assertion for both db and response bodyy projectname
	Assert.assertEquals(actualProjectName, expectedProjectName);
	Assert.assertEquals(responseProjectName,expectedProjectName);
	 
	 //assertion for both db and response body status
	 Assert.assertEquals(actualstatus, expectedStatus);
	 Assert.assertEquals(responseStatus, expectedStatus);


}
}

















