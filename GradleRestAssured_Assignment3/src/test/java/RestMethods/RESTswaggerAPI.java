package RestMethods;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;


public class RESTswaggerAPI {
	
	@Test(description = "to demostrate the get method")
	public void getMethod() {
		
		Response res = given().when().get("https://petstore.swagger.io/v2/user/syedtaher");
		System.out.println("Response is :" + res.asString());
		System.out.println(res.path("email").toString());
		assertEquals(res.getStatusCode(), 200);
	}
	
	@Test(description = "Post method")
	public void postMethod() {
		
		Response res = given().body("[\r\n  {\r\n    \"id\": 12,\r\n    \"username\": \"abcefg1\",\r\n    \"firstName\": \"abc1\",\r\n    \"lastName\": \"efg1\",\r\n    \"email\": \"abc1@email.com\",\r\n    \"password\": \"efg1\",\r\n    \"phone\": \"776655443\",\r\n    \"userStatus\": 0\r\n  }\r\n]").header("Content-Type", "application/json").when().post("https://petstore.swagger.io/v2/user/createWithArray");
		System.out.println(res.asString());
		assertEquals(res.getStatusCode(), 200);
	}
	
	@Test(description = "Post method with json file")
	public void postMethodwithJsonFile() throws IOException {
		
		FileInputStream file = new FileInputStream(new File(System.getProperty("user.dir")+"\\Data\\swaggerpost.json"));
		
		Response res = given().body(IOUtils.toString(file)).header("Content-Type", "application/json").when().post("https://petstore.swagger.io/v2/user/createWithArray");
		System.out.println(res.asString());
		assertEquals(res.getStatusCode(), 200);
	}
	
	@Test(description = "Put method")
	public void putMethod() {
		
		Response res = given().body("{\r\n  \"id\": 10,\r\n  \"username\": \"syedtaher\",\r\n  \"firstName\": \"syed\",\r\n  \"lastName\": \"taher\",\r\n  \"email\": \"tahe1r@gmail.com\",\r\n  \"password\": \"taher123\",\r\n  \"phone\": \"8934388932\",\r\n  \"userStatus\": 0\r\n}").header("Content-Type", "application/json").when().put("https://petstore.swagger.io/v2/user/syedtaher");
		System.out.println(res.asString());
		assertEquals(res.getStatusCode(), 200);
	}
	
	@Test(description = "Put method with json file")
	public void putMethodwithJsonFile() throws IOException {
		
		FileInputStream file = new FileInputStream(new File(System.getProperty("user.dir")+"\\Data\\swaggerput.json"));
		
		Response res = given().body(IOUtils.toString(file)).header("Content-Type", "application/json").when().put("https://petstore.swagger.io/v2/user/syedtaher");
		System.out.println(res.asString());
		assertEquals(res.getStatusCode(), 200);
	}
	
	@Test(description = "Delete method")
	public void deleteMethod() {
		
		Response res = given().when().delete("https://petstore.swagger.io/v2/user/syedtaher");
		assertEquals(res.getStatusCode(), 200);
	}
	
	@Test(description = "to demostrate the get method 404")
	public void getMethod404() {
		
		Response res = given().when().get("https://petstore.swagger.io/v2/user/taher");
		assertEquals(res.getStatusCode(), 404);
	}
	
	@Test(description = "Post method 404")
	public void postMethod404() {
		
		Response res = given().body("[\r\n  {\r\n    \"id\": 12,\r\n    \"username\": \"abcefg1\",\r\n    \"firstName\": \"abc1\",\r\n    \"lastName\": \"efg1\",\r\n    \"email\": \"abc1@email.com\",\r\n    \"password\": \"efg1\",\r\n    \"phone\": \"776655443\",\r\n    \"userStatus\": 0\r\n  }\r\n]").header("Content-Type", "application/json").when().post("https://petstore.swagger.io/v2/user/createWithArrayaa");
		assertEquals(res.getStatusCode(), 404);
	}
	
	@Test(description = "Post method with json file, perform assertion to check whether any \r\n"
			+ "     paramater code exist or not")
	public void postMethodwithJsonFileValidation() throws IOException {
		
		FileInputStream file = new FileInputStream(new File(System.getProperty("user.dir")+"\\Data\\swaggerpost.json"));
		
		Response res = given().body(IOUtils.toString(file)).header("Content-Type", "application/json").when().post("https://petstore.swagger.io/v2/user/createWithArray");
		System.out.println(res.asString());
		@SuppressWarnings("rawtypes")
		ResponseBody body = res.getBody();
		String bodyAsString = body.asString();
		// Validate if Response Body Contains a specific parameter
		Assert.assertEquals(bodyAsString.contains("code"), true);
		assertEquals(res.getStatusCode(), 200);
	}

}
