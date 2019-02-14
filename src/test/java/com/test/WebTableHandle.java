package com.test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class WebTableHandle {
static WebDriver driver;
	public static void main(String[] args) {
		
		//inititalize Chrome browser
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
		driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
//Enter url
		driver.get("https://www.w3schools.com/html/html_tables.asp");

		//*[@id ='customers']/tbody/tr[2]/td[1]
		//*[@id ='customers']/tbody/tr[3]/td[1]
		//*[@id ='customers']/tbody/tr[4]/td[1]
		
		List<WebElement>listrow =driver.findElements(By.xpath("//table[@id='customers']/tbody/tr"));
		
		System.out.println(listrow.size());
		String before_xpath_row = "//*[@id ='customers']/tbody/tr[";
		String after_xpath_row ="]/td[";
		
		/*for (int i=2;i<=listrow.size();i++) {
			
			String actualXpath = before_xpath_row+i+after_xpath_row;
			
			String companyname =driver.findElement(By.xpath(actualXpath)).getText();
			System.out.println(companyname);
			
		}*/
		
/*for (int j=1;j<=3;j++) {
	for (int i=2;i<=listrow.size();i++) {
		
			String actualXpath = before_xpath_row+i+after_xpath_row+j+"]";
			if(j==1) {
			String companyname =driver.findElement(By.xpath(actualXpath)).getText();
			System.out.println("company name "+(i-1)+") "+companyname);
			}
			if(j==2) {
				String Contact =driver.findElement(By.xpath(actualXpath)).getText();
				System.out.println("contact "+(i-1)+") "+Contact);
				}
			if(j==3) {
				String country =driver.findElement(By.xpath(actualXpath)).getText();
				System.out.println("country "+(i-1)+") "+country);
				}
			
	}
			
		}*/
//*[@id ='customers']/tbody/tr[2]/td[1]
		//*[@id ='customers']/tbody/tr[3]/td[1]
		//*[@id ='customers']/tbody/tr[4]/td[1]
		//Xls_Reader  reader = new Xls_Reader("E:\\SeleniumMaven\\SeleniumTraining\\src\\TestData\\W3School_testdata.xlsx");
	for (int i=2;i<=listrow.size();i++) {
		for (int j=1;j<=3;j++) {
			String after_xpath_row1 ="]/td["+j+"]";
			String actualXpath = before_xpath_row+i+after_xpath_row1;
			if(j==1){
			String companyname =driver.findElement(By.xpath(actualXpath)).getText();
			System.out.println("company name "+(i-1)+") "+companyname);
			
			}else if(j==2) {
				String Contact =driver.findElement(By.xpath(actualXpath)).getText();
				
				System.out.println("contact "+(i-1)+") "+Contact);
				
			}else if(j==3) {	
				String country =driver.findElement(By.xpath(actualXpath)).getText();
				System.out.println("country "+(i-1)+") "+country);
				
		}
			
	}
		
		
			
		}
		
	}

	
	
}
