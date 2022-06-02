package Assignment3;

import java.io.IOException;

import org.testng.annotations.Test;

public class Assignmnt03 extends testBase{
	
	@Test(description="perform test to CREATE user")
	public void createUser()
	{
		//creating user with escape character
		this.post_CreateUser("{\r\n  \"id\": 1,\r\n  \"first_name\": \"Syed\",\r\n  \"middle_name\": \"\",\r\n  \"last_name\": \"Taher\",\r\n  \"date_of_birth\": \"19-05-1991\"\r\n}", "http://thetestingworldapi.com/Help/api/studentsDetails", "Content-Type","application/json", 200);
		
	}
		
	@Test(description="perform PUT operation with escape character")
	public void putEscape() throws IOException
	{
		
		this.put_updateUserEscapechar("{\r\n  \"id\": 1,\r\n  \"first_name\": \"Syed-Modified\",\r\n  \"middle_name\": \"\",\r\n  \"last_name\": \"Taher\",\r\n  \"date_of_birth\": \"19-05-1991\"\r\n}", "http://thetestingworldapi.com/Help/api/studentsDetails", "Content-Type", "application/json", 200);		
	}
	
	@Test(description="to perform GET modified User details")
	public void getUser()
	{
				//get User Details
		this.get_GetUser(1,"http://thetestingworldapi.com/Help/api/studentsDetails", "message", 200);
	}
	
	
	@Test(description="perform DELETE operation")
	public void deleteUser()throws IOException
	{
		this.deleteUser(1,"http://thetestingworldapi.com/Help/api/studentsDetails", "message", 200);
	}
	
		
}
