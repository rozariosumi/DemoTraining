package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNgFeatureTest {
WebDriver driver;
	
	@BeforeMethod
	public void setUP() {
	System.setProperty("webdriver.chrome.driver", "E:\\Selenium tutorial\\chromedriver.exe");
	/*ChromeOptions options = new ChromeOptions();
	options.addArguments("window-size=1400,800");
	options.addArguments("headless");
	*/
	
	driver = new ChromeDriver();
	//Delete all cookies and maximize the browser
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	//dynamic wait
	driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	//Enter url
	driver.get("https://www.freecrm.com");
	
	}
//Test case 2 will be skipped because it was dependent on login 	
	@Test
	public void loginToApp() throws InterruptedException {
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("sumi1");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Nupur1279");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.switchTo().frame("leftpanel");
	}
	
	
	@Test(dependsOnMethods="loginToApp")
	public void HomePageTest() {
		String title = driver.getTitle();
		Assert.assertEquals(title, "CRMPRO", "Title is not matched");
	}
	
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	

}
