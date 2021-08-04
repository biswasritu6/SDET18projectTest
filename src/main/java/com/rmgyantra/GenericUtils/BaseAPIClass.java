package com.rmgyantra.GenericUtils;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
/**
 * 
 * @author Ritu
 *
 */
public class BaseAPIClass {
	DataBaseUtilities  db=new DataBaseUtilities();
	@BeforeSuite
	public void configBeforeSuite() {
		System.out.println("====start====");
		db.connectToDB();
		System.out.println("=====connected to database======");
		String baseURI = "http://localhost";
		int port = 8084;
	}
	@AfterSuite
	public void configAfterSuite() throws Throwable{
		db.closeDB();
		System.out.println("=======database is closed==========");
	}
}