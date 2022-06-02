//package pack1;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Iterator;
//import java.util.LinkedHashSet;
//import java.util.List;
//import java.util.Set;
//
//import org.apache.commons.io.FileUtils;
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
//
//public class oldC {
//	
//	WebElement we = driver.findElement(By.xpath("//*[@id='navbtn_tutorials']"));
//	String bgcolor = we.getCssValue("background-color");
//	System.out.println(bgcolor);
//	Actions asn = new Actions(driver);
//	asn.moveToElement(we).perform();
//	asn.click().build();
//	
//	asn.keyDown(Keys.LEFT_CONTROL).click(we).keyUp(Keys.LEFT_CONTROL).build().perform();
//	
//	asn.clickAndHold();
//	asn.contextClick();
//	asn.doubleClick();
//	asn.moveToElement(we);
//	asn.dragAndDrop(we, we);
//}
//
//public void alerts() {
//	
//	driver.switchTo().alert().accept();
//	driver.switchTo().alert().dismiss();
//	driver.switchTo().alert().getText();
//	driver.switchTo().alert().sendKeys("syed");
//}
//
//public void windowhandles() {
//	
//	String cwin = driver.getWindowHandle();
//	Set<String> wset = driver.getWindowHandles();
//	List<String> wlist = new ArrayList<>(wset);
//	
//	Iterator<String> iterator = wset.iterator();
//	driver.switchTo().window(wlist.get(0));
//	driver.switchTo().window(cwin);
//	
//	while (iterator.hasNext()) {
//		
//		String childwindow = iterator.next();
//		driver.switchTo().window(childwindow);
//		
//		String wtitle = driver.switchTo().window(childwindow).getTitle();
//		
//		if(wtitle.equals("w3schools")) {
//			
//			System.out.println("found the window");
//			
//		}
//		
//	}
//	
//}
//
//public void webtables() {
//	
//	String chromedriverpath = "C:\\\\Users\\\\0037FQ744\\\\eclipse-workspace\\\\Automation\\\\Drivers\\\\chromedriver.exe";
//	System.setProperty("webdriver.chrome.driver", chromedriverpath);
//	
//	driver = new ChromeDriver();
//	
//	driver.get("https://myskillpoint.com/handle-dynamic-web-tables-in-selenium-webdriver/");
//	
//	String firstheader = driver.findElement(By.xpath("//table[@id='tablepress-7']//thead/tr/th[1]")).getText();
//	System.out.println(firstheader);
//	
//	List<WebElement> rowElements = driver.findElements(By.xpath("//table[@id='tablepress-7']//thead/tr/"));
//	int rowCount = rowElements.size();
//	
//	List<WebElement> colElements = driver.findElements(By.xpath("//table[@id='tablepress-7']//thead/tr/th"));
//	int colCount = colElements.size();
//	
//	for(int i=0; i<=rowCount; i++) {
//		for(int j=0; j<=colCount; j++) {
//			driver.findElement(By.xpath("//table[@id='tablepress-7']//thead/tr["+i+"]/th["+j+"]")).getText();
//		}
//	}
//	
//	for(int i=0; i<=rowCount; i++) {
//		
//		String firstnames = driver.findElement(By.xpath("//table[@id='tablepress-7']//thead/tr["+i+"]/th[2]")).getText();
//		
//		if(firstnames.contains("Syed")) {
//			
//			driver.findElement(By.xpath("//table[@id='tablepress-7']//thead/tr["+i+"]/th[2]/input")).click();
//			break;
//			
//		}
//	}
//	
//	
//}
//
//public void takeScreenshot() {
//	
//	File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//	try {
//        FileUtils.copyFile(screenshot, new File("C:\\projectScreenshots\\homePageScreenshot.png"));
//    } catch (IOException e) {
//        System.out.println(e.getMessage());
//    }
//	
//}
//
//public void removeDuplicatesFromList() {
//		
//	ArrayList<Integer> numberList = new ArrayList<Integer>(Arrays.asList(1, 2, 1, 2, 3, 4, 5, 4, 5, 6, 5, 7));
//	
//	LinkedHashSet<Integer> uniqueNumbers = new LinkedHashSet<Integer>(numberList);
//	
//	ArrayList<Integer> NewnumberList = new ArrayList<Integer>(uniqueNumbers);
//	
//	System.out.println(NewnumberList);
//	
//	
//	// Create a new ArrayList
//    //ArrayList<T> newList = new ArrayList<T>();
//
//    // Traverse through the first list
//    //for (T element : list) {
//
//        // If this element is not present in newList
//        // then add it
//        //if (!newList.contains(element)) {
//
//            //newList.add(element);
//        //}
//    //}
//	
//}
//
//}
