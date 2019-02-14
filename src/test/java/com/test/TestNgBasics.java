//TESTNGPART1: //URL: https://www.youtube.com/watch?v=NqN3JNpZZiY&index=28&list=PLFGoYjJG_fqo4oVsa6l_V-_7-tzBnlulT

package com.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNgBasics {
/*
@BeforeSuite---Setup: system property for chrome browser
@BeforeTest---launchBrowser
@BeforeClass---login to the app

@BeforeMethod---Enter url
@Test--Get the title of the page
@AfterMethod---logout from the app

@BeforeMethod---Enter url
@Test--logoTest
@AfterMethod---logout from the app

@BeforeMethod---Enter url
@Test--search
@AfterMethod---logout from the app

@AfterClass---Close browser
@AfterTest---Delete all cookies
 */
	
	
	
	
	//preconditons annotations--Starting with @Before
	@BeforeSuite //1
	public void setUp() {
		System.out.println("@BeforeSuite---Setup: system property for chrome browser");
	}
	@BeforeTest//3
	public void launchBrowser() {
		System.out.println("@BeforeTest---launchBrowser");
	}
	@BeforeClass//2
	public void login() {
		System.out.println("@BeforeClass---login to the app");
	}
	
	
	@BeforeMethod//4
	public void enterURL() {
		System.out.println("@BeforeMethod---Enter url");
	}
	//Test Cases ---Starting with @Test
	@Test//5
	public void getTitle() {
		System.out.println("@Test--Get the title of the page");
	}
	
	@Test//5
	public void search() {
		System.out.println("@Test--search");
	}
	@Test//5
	public void logoTest() {
		System.out.println("@Test--logoTest");
	}
	
	//post conditions---- starting with @After
	@AfterMethod//6
	public void logOut() {
		System.out.println("@AfterMethod---logout from the app");
	}
	@AfterClass//7
	public void closBrowser() {
		System.out.println("@AfterClass---Close browser");
	}
	@AfterTest//8
	public void deleteCookies() {
		System.out.println("@AfterTest---Delete all cookies");
	}
	
	@AfterSuite//9
	public void generateReports() {
		System.out.println("@AfterSuite---generate html report");
	}
}
