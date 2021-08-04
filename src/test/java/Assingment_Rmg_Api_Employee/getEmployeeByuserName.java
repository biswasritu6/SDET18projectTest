package Assingment_Rmg_Api_Employee;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class getEmployeeByuserName {
	@Test
	public void getEmployee() {
	when()
		.get("http://localhost:8084/employees/TYP_01405")
	.then()
		.assertThat().statusCode(200)
		.and()
		.assertThat().contentType("application/json")
		.and()
		.log().all();
}
}