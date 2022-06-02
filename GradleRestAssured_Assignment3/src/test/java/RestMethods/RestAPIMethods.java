package RestMethods;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;


import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RestAPIMethods {
	
	@Test(description = "to demostrate the get method")
	public void getMethod() {
		
		Response res = given().when().get("https://reqres.in/api/users/2");
		System.out.println("Response is :" + res.asString());
		System.out.println(res.path("data.email").toString());
		assertEquals(res.getStatusCode(), 200);
	}
	
	@Test(description = "to demostrate the get method")
	public void getGenericMethod(String url) {
		
		Response res = given().when().get(url);
		System.out.println("Response is :" + res.asString());
		System.out.println(res.path("data.email").toString());
		assertEquals(res.getStatusCode(), 200);
	}
	
	@Test(description = "to demostrate the another get method")
	public void getMethod1() {
		
		Response res = given().when().get("https://reqres.in/api/unknown");
		assertEquals(res.getStatusCode(), 200);
	}
	
	@Test(description = "to demostrate the another get method 2")
	public void getMethod2() {
		
		int number = 10;
		
		Response res = given().when().get("https://reqres.in/api/users?page={number}", number);
		Response res1 = given().queryParam("page", "2").when().get("https://reqres.in/api/users");
		assertEquals(res.getStatusCode(), 200);
		System.out.println("Response is res:" + res.asString());
		System.out.println("Response is res1:" + res1.asString());
		System.out.println(res.path("data.email").toString());
		System.out.println(res.path("support.url").toString());
	}
	
	@Test(description = "Post method")
	public void postMethod() {
		
		Response res = given().body("{\r\n    \"name\": \"morpheus\",\r\n    \"job\": \"leader\"\r\n}").header("Content-Type", "application/json").when().post("https://reqres.in/api/users");
		System.out.println(res.asString());
	}
	
	@Test(description = "Post method with json file")
	public void postMethodwithJsonFile() throws IOException {
		
		FileInputStream file = new FileInputStream(new File(System.getProperty("user.dir")+"\\Data\\postData.json"));
		
		Response res = given().body(IOUtils.toString(file)).header("Content-Type", "application/json").when().post("https://reqres.in/api/users");
		System.out.println(res.asString());
	}
	
	@Test(description = "Put method")
	public void putMethod() {
		
		Response res = given().body("{\r\n    \"name\": \"morpheus\",\r\n    \"job\": \"zion resident\"\r\n}").header("Content-Type", "application/json").when().put("https://reqres.in/api/users/2");
		System.out.println(res.asString());
	}
	
	@Test(description = "Put method with json file")
	public void putMethodwithJsonFile() throws IOException {
		
		FileInputStream file = new FileInputStream(new File(System.getProperty("user.dir")+"\\Data\\putData.json"));
		
		Response res = given().body(IOUtils.toString(file)).header("Content-Type", "application/json").when().put("https://reqres.in/api/users/2");
		System.out.println(res.asString());
	}
	
	@Test(description = "Patch method")
	public void patchMethod() {
		
		Response res = given().body("{\r\n    \"name\": \"morpheus\",\r\n    \"job\": \"zion resident\"\r\n}").header("Content-Type", "application/json").when().patch("https://reqres.in/api/users/2");
		System.out.println(res.asString());
	}
	
	@Test(description = "Patch method with json file")
	public void patchMethodwithJsonFile() throws IOException {
		
		FileInputStream file = new FileInputStream(new File(System.getProperty("user.dir")+"\\Data\\patchData.json"));
		
		Response res = given().body(IOUtils.toString(file)).header("Content-Type", "application/json").when().put("https://reqres.in/api/users/2");
		System.out.println(res.asString());
	}
	
	@Test(description = "Delete method")
	public void deleteMethod() {
		
		Response res = given().when().delete("https://reqres.in/api/users/2");
		assertEquals(res.getStatusCode(), 204);
	}

}
