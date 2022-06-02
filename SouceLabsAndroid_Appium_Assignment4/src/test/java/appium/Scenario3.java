package appium;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class Scenario3 {
	public static void main(String[] args) throws InterruptedException {
		
		//Scenario: To verify sort low to high
	
		DesiredCapabilities dc = new DesiredCapabilities();

		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		dc.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		dc.setCapability("appPackage", "com.swaglabsmobileapp");
		dc.setCapability("appActivity", "com.swaglabsmobileapp.SplashActivity");
		dc.setCapability("noReset", "true");

		AndroidDriver<AndroidElement>and = new AndroidDriver<AndroidElement>(dc);
		//user is on saucedemo homepage   
		System.out.println("Swag Mobile opened");
		Thread.sleep(2000);
		
		//user logged in using correct credential
		and.findElementByAccessibilityId("test-Username").sendKeys("standard_user");
		and.findElementByAccessibilityId("test-Password").sendKeys("secret_sauce");
		and.findElementByAccessibilityId("test-LOGIN").click();
		
		Thread.sleep(3000);
		
		//user sorts item low to high
		and.findElementByXPath("//android.view.ViewGroup[@content-desc=\"test-Modal Selector Button\"]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView").click();
		System.out.println("Filter icon clicked");
		Thread.sleep(2000);
		
		and.findElementByXPath("//android.widget.ScrollView[@content-desc=\"Selector container\"]/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup/android.widget.TextView").click();
		System.out.println("Price(low to High) option selected.");
		Thread.sleep(3000);
		
		// user adds required item to cart
		and.findElementByXPath("(//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"])[1]").click();
		System.out.println("Product added.");
		
		//user proceeds to checkout
		and.findElementByXPath("//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.widget.ImageView").click();
		System.out.println("Clicked Cart icon");
		
		Thread.sleep(3000);
		
		and.findElementByAccessibilityId("test-CHECKOUT").click();
		System.out.println("Clicked CHECKOUT button.");
		
		Thread.sleep(3000);
		
		//user enters the following details for checkout
		and.findElementByAccessibilityId("test-First Name").isDisplayed();
		System.out.println("Checkout Details page displayed");
		
		and.findElementByAccessibilityId("test-First Name").sendKeys("abc");
		and.findElementByAccessibilityId("test-Last Name").sendKeys("def");
		and.findElementByAccessibilityId("test-Zip/Postal Code").sendKeys("400087");

		and.findElementByAccessibilityId("test-CONTINUE").click();
		System.out.println("Clicked Continue button.");
		
		Thread.sleep(3000);
		
		TouchAction tA = new TouchAction(and);
		and.findElementByXPath("//android.widget.ScrollView[@content-desc=\"test-CHECKOUT: OVERVIEW\"]/android.view.ViewGroup/android.widget.TextView[1]").isDisplayed();

		System.out.println("Checkout Overview page dislayed.");
		
		AndroidElement positn1 = and.findElementByXPath("//android.widget.ScrollView[@content-desc=\"test-CHECKOUT: OVERVIEW\"]/android.view.ViewGroup/android.widget.TextView[1]");
		AndroidElement positn2 = and.findElementByXPath("//android.view.ViewGroup[@content-desc=\"test-Description\"]/android.widget.TextView[1]");
				
		tA.longPress(longPressOptions().withElement(element(positn1)).withDuration(Duration.ofSeconds(2)))
				.moveTo(element(positn2)).release().perform();
			
		System.out.println("Checkout Overview page swiped.");
		
		
		//user confirm checkout
		if (and.findElementByAccessibilityId("test-FINISH").isDisplayed())
		{
			System.out.println("Finish button displayed");
			and.findElementByAccessibilityId("test-FINISH").click();
			Thread.sleep(3000);
		}
		
		//user verify final confirmation message
		String confMsg=and.findElementByXPath("//android.widget.ScrollView[@content-desc=\"test-CHECKOUT: COMPLETE!\"]/android.view.ViewGroup/android.widget.TextView[1]").getText();
		
		Assert.assertEquals(confMsg,"THANK YOU FOR YOU ORDER");
		System.out.println("Final confirmation message verified.");
		
		//Swag Mobile closed
		and.closeApp();
		System.out.println("Swag Mobile App closed.");

		
	}
	

}
