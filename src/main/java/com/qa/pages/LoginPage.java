package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//Page Factory - Object repository
	@FindBy(xpath="//a[contains(text(),'Login')]")
	WebElement login_hyperlink;
	
	@FindBy(name="email")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//div[@class='field']/following-sibling::div[contains(text(),'Login')]")
	WebElement login_button;
	
	@FindBy(xpath="//a[@class='navbar-brand']//img[@class='img-responsive']")
	WebElement logo;
	
	//Constructor
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validateLoginPageTiltle() {
		return driver.getTitle();
	}
	
	public boolean validatelogo() {
		boolean b = logo.isDisplayed();
		return b;
	}
	
	public HomePage login(String un, String pwd) {
		login_hyperlink.click();
		username.sendKeys(un);
		password.sendKeys(pwd);
		login_button.click();
		
		return new HomePage();
	}
}
