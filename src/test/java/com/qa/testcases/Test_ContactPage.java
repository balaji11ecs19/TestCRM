package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.ContactsPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.utilities.TestUtil;

public class Test_ContactPage extends TestBase{
	
	HomePage homepage;
	LoginPage loginpage;
	ContactsPage contactspage;
	
	public Test_ContactPage() {
		super();
	}
	
	@BeforeMethod
	public void Setup() {
		initialization();
		homepage = new HomePage();
		loginpage = new LoginPage();
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactspage = new ContactsPage();
	}
	
	@Test (priority=1)
	public void contactspagetitleTest() {
		homepage.HomePage_Contacts_Icon_click();
		Boolean title = contactspage.validate_ContactPage_Tiltle();
		Assert.assertTrue(title, "Contacts Page Title is not displaying");
	}
	
	@Test (priority=2)
	public void create_newcontant_Test() {
		homepage.HomePage_Contacts_Icon_click();
		contactspage.Contacts_create_btn_click();
		Boolean test = contactspage.validate_CreateContactPage_Tiltle();
		Assert.assertTrue(test, "Create new contact page Title is not displaying");
	}
		
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
