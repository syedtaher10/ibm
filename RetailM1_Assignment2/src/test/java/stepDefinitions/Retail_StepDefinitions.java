package stepDefinitions;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.utility.RandomString;

public class Retail_StepDefinitions {
	WebDriver driver;
	public static String email;
	public static String password;
	
	@Given("Launch retailm1 website")
	public void launch_retailm1_website() {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
	    driver.manage().window().maximize();  
	    driver.get("http://retailm1.upskills.in/");
	    System.out.println("Retail_M1 Page opened");
	}

	@When("Account icon is displayed")
	public void account_icon_is_displayed() {
		System.out.println(driver.findElement(By.xpath("//i[contains(@class,'fa fa-user-o')]")).isDisplayed());
		System.out.println("Account icon is displayed");
	}

	@Then("click on Account icon")
	public void click_on_Account_icon() {
		driver.findElement(By.xpath("//li[contains(@class,'account_account')]")).click();
		System.out.println("Account icon clicked");
	}
	
	@Then("click on LoginRegister link")
	public void click_on_LoginRegister_link() {
		driver.findElement(By.xpath("//a[text()='Register']")).click();
		System.out.println("Login/Register link clicked");
	}

	@Then("click on Register button")
	public void click_on_Register_button() {
	    //driver.findElement(By.xpath("//a[contains(@class,'btn btn-primary')]")).click();
	    System.out.println("Register button clicked");
	}

	@When("Registration form is displayed")
	public void registration_form_is_displayed() {
	    //driver.findElement(By.xpath("//li[contains(text(),\"Registration\")]")).isDisplayed();
	    driver.findElement(By.xpath("//legend[contains(text(),'Your Personal Details')]")).isDisplayed();
	    System.out.println("Registration Form displayed");
	}

	
	@Then("Fill up the Form")
	public void fill_up_the_Form(DataTable dataTable) {
		Map<String,String> data = dataTable.asMap(String.class, String.class);
		
		String usrnamevalue=data.get("Email");
		String[]val=usrnamevalue.split("@");
				
		String rand=RandomString.make(5);
		//System.out.println(rand);
		
		String Usrnameemail=val[0]+rand+"@"+val[1];
		email=Usrnameemail;
		password=data.get("ConfPass");
		//System.out.println(Usrnameemail);
		
		driver.findElement(By.name("firstname")).sendKeys(data.get("FirstName"));
		driver.findElement(By.name("lastname")).sendKeys(data.get("LastName"));
		driver.findElement(By.name("email")).sendKeys(Usrnameemail);			
		driver.findElement(By.name("telephone")).sendKeys(data.get("Telephone"));
		driver.findElement(By.name("address_1")).sendKeys(data.get("Address1"));
		driver.findElement(By.name("address_2")).sendKeys(data.get("Address2"));
		driver.findElement(By.name("city")).sendKeys(data.get("City"));
		driver.findElement(By.name("postcode")).sendKeys(data.get("PostCode"));
		
		Select drpdnCountry = new Select(driver.findElement(By.name("country_id")));
		drpdnCountry.selectByVisibleText(data.get("Country"));
		
		Select drpdnState = new Select(driver.findElement(By.name("zone_id")));
		drpdnState.selectByVisibleText(data.get("State"));


		driver.findElement(By.name("password")).sendKeys(data.get("Pass"));
		driver.findElement(By.name("confirm")).sendKeys(data.get("ConfPass"));
			    
	    System.out.println("Form Data entered");
	}
	
	@Then("click on no in Subscribe")
	public void click_on_no_in_Subscribe() {
		driver.findElement(By.xpath("//input[@type='radio' and @value='0']")).click();
		System.out.println("Radio button 'No' clicked.");
	}

	@Then("click on agree policy")
	public void click_on_agree_policy() {
		driver.findElement(By.xpath("//input[@type='checkbox' and @value='1']")).click();
		System.out.println("Privacy Policy agreed ");
	}

	@Then("Click on the Continue Button")
	public void click_on_the_Continue_Button() {
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		System.out.println("Continue Button clicked");
	}

		
	@When("verify Success message {string}")
	public void verify_Success_message(String stringval) throws Throwable{
		WebElement continueButton= driver.findElement(By.xpath("//a[contains(text(),'Continue')]"));
		
		List<WebElement> confirmationtexts = driver.findElements(By.tagName("p"));
		System.out.println(confirmationtexts.size());
		for (WebElement webElement : confirmationtexts) 
		{
			String texts = webElement.getText();
			if(texts.contains(stringval)&&continueButton.isDisplayed()) 
			{
				System.out.println(stringval + ": Text Verified");

			}
		}
		System.out.println("a");
	    
	}

	@Then("close browser")
	public void close_browser() throws Throwable {
	    driver.close();
	    System.out.println("Browser closed."); 
	}

	
	@Then("Login Retail Portal")
	public void login_Retail_Portal() throws Throwable {
		driver.findElement(By.name("email")).sendKeys(email);
		driver.findElement(By.name("password")).sendKeys(password);
		System.out.println("Credentials entered");
	}

	@Then("click on Login link")
	public void click_on_Login_link() throws Throwable {
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		System.out.println("Login link clicked");
	}

	@When("Verify Header {string}")
	public void verify_Header(String stringval)throws Throwable {
		if(driver.findElements(By.xpath("//h2[contains(text(),'"+stringval+"')]")).size()>0) 
		{
			System.out.println(stringval + ": Text Verified");
		}
		System.out.println("Header verified");
	}

}
