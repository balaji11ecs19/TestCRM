package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.base.TestBase;

public class HomePage extends TestBase{
	
	//Page Factory - Object repository
	@FindBy(xpath="//b[contains(text(),'TestCRM')]")
	WebElement homepage_title;
	
	@FindBy(xpath="//span[@class='user-display']")
	WebElement homepage_username;
	
	@FindBy(xpath="//a[@href='/contacts']//i")
	WebElement homepage_contact_icon;
	
	//Constructor
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public boolean validateHomePageTiltle() {
		boolean b = homepage_title.isDisplayed();
		return b;
	}
	
	public String validateHomeUserName() {
		String name=homepage_username.getText();
		return name;
	}
	
	public ContactsPage HomePage_Contacts_Icon_click() {
		homepage_contact_icon.click();
		
		return new ContactsPage();
	}
}
