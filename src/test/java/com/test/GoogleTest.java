//RELATED TO TESTNG PART 1: https://www.youtube.com/watch?v=NqN3JNpZZiY&index=28&list=PLFGoYjJG_fqo4oVsa6l_V-_7-tzBnlulT


package com.test;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
//Test Case 1: Verity title of the page and logo is displayed or not
//Test Case 2: Capture all the suggestions related to Java and verify search result
//Test Case 3: Capture tool tip in the search box
//Test Case 4: Capture broken links
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleTest {
WebDriver driver;
String strSearchVal ="java tutorial";

	@BeforeMethod
	public void setUp()
	{
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
			driver.get("https://www.google.com");
	
   }
	@Test(priority=1,groups ="logo")
	public void titleAndlogoTest() 
	{
		String Title = driver.getTitle();
		System.out.println("The title of the page is: "+ Title);
		Boolean b = driver.findElement(By.xpath("//img[@id='hplogo']")).isDisplayed();
		if(b)
		{
			System.out.println("logo is displaying properly");
		}
		Assert.assertTrue(b, "Logo is not displayed");
		Assert.assertEquals(b, "True");
	}
	
	@Test(priority=2,groups="google search")
	
	public void CaptureSearchSuggestion() throws InterruptedException 
	{
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys(strSearchVal);
		List<WebElement>list = driver.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[@class='sbl1']"));
		System.out.println("Total Available suggestions are: "+list.size());
		
		for(int i=0;i<list.size();i++) {
			
			
			if(list.get(i).getText().contains(strSearchVal)) {
				System.out.println("Expected Value found as :"+list.get(i).getText());
				list.get(i).click();
				Thread.sleep(2000);
				String resStats =driver.findElement(By.xpath("//body[@id='gsr']//descendant::div[@id='resultStats']")).getText();
				System.out.println("Clicked on: "+strSearchVal+" And Total result found : "+resStats);
				break;
				
			}
		}
	}
	
	@Test(priority=3,groups="google search")
		
		public void capturebrokenlinks() throws MalformedURLException, IOException 
		{			
		//1. get the list of all the links & imgages

				List<WebElement>linkslist = driver.findElements(By.xpath("//a"));
				linkslist.addAll(driver.findElements(By.xpath("//img")));
				//print all the list
				System.out.println("Total full links and images are available: "+linkslist.size());

				//get the list of all active links that have href
				List<WebElement>activelinks = new ArrayList<WebElement>();
				

		//2. iterate all linklist: exclude any link/image --doesnt have <href>attribute

				for(int i=0;i<linkslist.size();i++)
				{
					
					if(linkslist.get(i).getAttribute("href")!=null && (!linkslist.get(i).getAttribute("href").contains("javascript"))) {
						System.out.println(i+1+") "+linkslist.get(i).getAttribute("href"));
						//print the final url's that is not null & doesnt start with javascript
						activelinks.add(linkslist.get(i));
					}
					
				}
				 System.out.println("Total active links are ---> "+activelinks.size());
				 List <WebElement>errorlinks = new ArrayList<WebElement>();
				 for(int j=0;j<activelinks.size();j++) 
				 {
					 HttpURLConnection connection = (HttpURLConnection)new URL(activelinks.get(j).getAttribute("href")).openConnection();
					 
					 connection.connect();
					 String response = connection.getResponseMessage();
					 int errorcode =connection.getResponseCode();
					 if(errorcode!=200 && errorcode!=403) {
					 errorlinks.add(activelinks.get(j));
					 
					 }
					 connection.disconnect();
					 System.out.println(j+1 +") "+activelinks.get(j).getAttribute("href")+"----->"+response);
					 
					 }
				 
				 System.out.println("Total broken links are --->"+errorlinks.size());
				 //print all the broken links
				 for (int k =0;k<errorlinks.size();k++) {
					 System.out.println(k+1 +")"+errorlinks.get(k).getAttribute("href"));
				 }
					 
				 }
	@Test(priority=4,groups="Test")
	public void Test4()
	{
		System.out.println("test4");
			
	}
				 	
	@Test(priority=5,groups="Test")
	public void Test5()
	{
		System.out.println("test5");
			
	}	
	@Test(priority=6,groups="Test")
	public void Test6()
	{
		System.out.println("test6");
			
	}

												
		
		

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}

}
