package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

public class Test_HomePage extends TestBase{
	
	HomePage homepage;
	LoginPage loginpage;
	
	public Test_HomePage() {
		super();
	}
	
	@BeforeMethod
	public void Setup() {
		initialization();
		homepage = new HomePage();
		loginpage = new LoginPage();
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test (priority=1)
	public void homepagetitleTest() {
		Boolean title = homepage.validateHomePageTiltle();
		Assert.assertTrue(title, "Title is not displaying");
	}
	
	@Test (priority=2)
	public void homepagenameTest() {
		String name = homepage.validateHomeUserName();
		Assert.assertEquals(name, "Balaji M");
	}
	
	@Test (priority=3)
	public void homepageConatctIconClick_Test() {
		homepage.HomePage_Contacts_Icon_click();
		
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
