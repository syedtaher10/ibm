package stepDefinitions;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;

public class souceDemoSteps {

	WebDriver driver;

	@Given("user is on saucedemo homepage")
	public void user_is_on_saucedemo_homepage() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\0037FQ744\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com");
		driver.manage().window().maximize();

		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement souceDemoPage = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='login_logo']")));
		if (souceDemoPage.isDisplayed()) {
			System.out.println("Souce Demo Page loaded successfully!!");
		}
	}

	@Given("user logged in using correct credential")
	public void user_logged_in_using_correct_credential(DataTable dataTable) {
		List<Map<String, String>> mData = dataTable.asMaps(String.class, String.class);
		driver.findElement(By.id("user-name")).sendKeys(mData.get(0).get("username"));
		driver.findElement(By.id("password")).sendKeys(mData.get(0).get("password"));
		driver.findElement(By.id("login-button")).click();
	}

	@Given("user adds required item to cart")
	public void user_adds_required_item_to_cart() throws InterruptedException {
		Thread.sleep(3000);
		WebElement bagpack = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']"));
		if (bagpack.isDisplayed()) {
			driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
		}
	}

	@Given("user proceeds to checkout")
	public void user_proceeds_to_checkout() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.id("shopping_cart_container")).click();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement souceDemoPage = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkout")));
		if (souceDemoPage.isDisplayed()) {
			souceDemoPage.click();
		}
		
	}

	@Given("user enters the following details for checkout")
	public void user_enters_the_following_details_for_checkout(DataTable dataTable) {
		List<Map<String, String>> details = dataTable.asMaps(String.class, String.class);
		driver.findElement(By.id("first-name")).sendKeys(details.get(0).get("FirstName"));
		driver.findElement(By.id("last-name")).sendKeys(details.get(0).get("LastName"));
		driver.findElement(By.id("postal-code")).sendKeys(details.get(0).get("PostalCode"));
		driver.findElement(By.id("continue")).click();
	}

	@When("user confirm checkout")
	public void user_confirm_checkout() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.id("finish")).click();
	}

	@Then("user verify final confirmation message")
	public void user_verify_final_confirmation_messagge() throws InterruptedException {
		Thread.sleep(2000);
		String eText = "THANK YOU FOR YOUR ORDER";
		WebElement confirmation = driver.findElement(By.xpath("//h2[@class='complete-header']"));
		String cText = confirmation.getText();
		Assert.assertEquals(cText, eText);
		System.out.println("Confirmation text verified successfully!!");
		Thread.sleep(2000);
		driver.quit();
	}

	@Given("user adds one item and then remove that item to go back")
	public void user_adds_one_item_and_then_remove_that_item_to_go_back() throws InterruptedException {
		Thread.sleep(3000);
		WebElement bagpack = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']"));
		if (bagpack.isDisplayed()) {
			driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
		}
		
		WebElement bikelight = driver.findElement(By.xpath("//div[text()='Sauce Labs Bike Light']"));
		if (bikelight.isDisplayed()) {
			driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
		}
		Thread.sleep(2000);
		driver.findElement(By.id("remove-sauce-labs-backpack")).click();
	}

	@Given("user sorts item low to high")
	public void user_sorts_item_low_to_high() throws InterruptedException {
		Select objSelect = new Select(driver.findElement(By.xpath("//select[@class='product_sort_container']")));
		Thread.sleep(2000);
		objSelect.selectByVisibleText("Price (low to high)");
	}

}
