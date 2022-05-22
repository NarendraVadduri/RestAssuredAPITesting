package testCases;

import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

public class TC_ResReqAPI {

	@Test(priority=1)
	public void getAllUsers() {
	
		Response res = 
		given()		
		.when()
			.get("https://reqres.in/api/users?page=2")
		.then()
			.statusCode(200)
			.log().body()
			.extract().response();
		
	String jsonString = res.asString();
	System.out.println(jsonString);
	//Assert.assertEquals(0, 0)
	}
	
	@Test(priority=2)
	public void addUser() {
		
		HashMap data = new HashMap();
		data.put("name", "Shreyas");
		data.put("job", "leader");
		
		Response res = 
		given()
			.contentType("application/json")
			.body(data)
		.when()
			.post("https://reqres.in/api/users")
		.then()
			.statusCode(201)
			.log().body()
			.extract().response();
		
	String jsonString = res.asString();
	System.out.println(jsonString);
	}
	
	@Test(priority=3)
	public void updateUser() {
		
		HashMap data = new HashMap();
		data.put("name", "Durga");
		data.put("job", "SA");
		
		Response res = 
		given()
			.contentType("application/json")
			.body(data)
		.when()
			.put("https://reqres.in/api/users/996")
		.then()
			.statusCode(200)
			.log().body()
			.extract().response();
		
	String jsonString = res.asString();
	System.out.println(jsonString);
	}
	
	@Test(priority=4)	
	public void patchUser() {
		
		
		Response res = 
		given()
		.when()
			.patch("https://reqres.in/api/users/996")
		.then()
			.statusCode(200)
			.log().body()
			.extract().response();
		
	String jsonString = res.asString();
	System.out.println(jsonString);
	Assert.assertEquals(jsonString.contains("updatedAt"), true);
	Assert.assertEquals(jsonString.contains("updatedAt"), "updatedAt");
	}
	
	@Test(priority=5)	
	public void deleteUser() {
		
		
		Response res = 
		given()
		.when()
			.delete("https://reqres.in/api/users/996")
		.then()
			.statusCode(204)
			.log().body()
			.extract().response();
		
	String jsonString = res.asString();
	System.out.println(jsonString);
	}
	
	
}
