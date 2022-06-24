package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.base.TestBase;

public class ContactsPage extends TestBase{
	
	//Page Factory - Object repository
	@FindBy(xpath="(//div[@id='dashboard-toolbar']//div)[1]")
	WebElement contactpage_title;
	
	@FindBy(xpath="//button[contains(text(),'Create')]")
	WebElement contactpage_create_btn;
	
	@FindBy(xpath="(//div[@id='dashboard-toolbar']//div)[1]")
	WebElement contactpage_createnewcontact_title;
	
	@FindBy(xpath="//input[@name='first_name']")
	WebElement createnewcontact_firstname_txtbox;
	
	@FindBy(xpath="//input[@name='last_name']")
	WebElement createnewcontact_lastname_txtbox;
	
	@FindBy(xpath="//div[@name='company']//input[@class='search']")
	WebElement createnewcontact_companyname_txtbox;
	
	@FindBy(xpath="//button[contains(text(),'Save')]")
	WebElement createnewcontact_save_btn;
	
	//Constructor
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public boolean validate_ContactPage_Tiltle() {
		boolean b = contactpage_title.isDisplayed();
		return b;
	}
	
	public void Contacts_create_btn_click() {
		contactpage_create_btn.click();
	}
	
	public boolean validate_CreateContactPage_Tiltle() {
		boolean t = contactpage_createnewcontact_title.isDisplayed();
		return t;
	}
	
	public void createnewcontact_save(String fname, String lname, String compname) {
		createnewcontact_firstname_txtbox.sendKeys(fname);
		createnewcontact_lastname_txtbox.sendKeys(lname);
		createnewcontact_companyname_txtbox.sendKeys(compname);
		createnewcontact_save_btn.click();
	}
}
