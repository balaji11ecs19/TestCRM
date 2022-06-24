package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.LoginPage;

public class Test_LoginPage extends TestBase{
	
	LoginPage loginpage;
	
	public Test_LoginPage() {
		super();
	}
	
	@BeforeMethod
	public void Setup() {
		initialization();
		loginpage = new LoginPage();
	}
	
	@Test (priority=1)
	public void loginpagetitleTest() {
		String title = loginpage.validateLoginPageTiltle();
		Assert.assertEquals(title, "Free CRM software for customer relationship management, sales, marketing campaigns and support.");
	}
	
	@Test (priority=2)
	public void crmlogoTest() {
		boolean flag = loginpage.validatelogo();
		Assert.assertEquals(flag, true);
	}
	
	@Test (priority=3)
	public void Login_UN_PWD_Test() {
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
