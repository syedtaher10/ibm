package pack1;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class C1 {
	
	static WebDriver driver;

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\0037FQ744\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://demoqa.com/automation-practice-form");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Syed");
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("Taher");
		driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("sam10taher@gmail.com");
		Thread.sleep(3000);
		WebElement rb = driver.findElement(By.xpath("//input[@id='gender-radio-1']"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", rb);
		driver.findElement(By.xpath("//input[@id='userNumber']")).sendKeys("8892364692");
		
		driver.findElement(By.xpath("//input[@id='subjectsInput']")).sendKeys("Selenium Training");
		
		WebElement ch = driver.findElement(By.xpath("//input[@id='hobbies-checkbox-1']"));
		JavascriptExecutor js1 = (JavascriptExecutor)driver;
		js1.executeScript("arguments[0].click()", ch);
		
		WebElement sf = driver.findElement(By.xpath("//input[@id='uploadPicture']"));
		sf.sendKeys("");
		Thread.sleep(10000);
		
		
		
	}
}
