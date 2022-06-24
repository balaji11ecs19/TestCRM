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

public class Test_CreateNewContact extends TestBase{
	
	HomePage homepage;
	LoginPage loginpage;
	ContactsPage contactspage;
	
	String sheetname = "contacts";
	
	public Test_CreateNewContact() {
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
	
	@DataProvider
	public Object getCRMTestData() {
		Object data[][] = TestUtil.getTestData(sheetname);
		return data;
	}
	
	@Test (dataProvider="getCRMTestData")
	public void newcontacts_save_flow(String fname, String lname, String Cname) {
		homepage.HomePage_Contacts_Icon_click();
		contactspage.Contacts_create_btn_click();
		contactspage.createnewcontact_save(fname,lname,Cname);
		homepage.HomePage_Contacts_Icon_click();
		Boolean title = contactspage.validate_ContactPage_Tiltle();
		Assert.assertTrue(title);
	}
	
	
		
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
