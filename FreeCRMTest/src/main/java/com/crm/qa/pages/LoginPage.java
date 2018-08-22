package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//page factory or OR
	@FindBy(name="username")
	WebElement username;
	
	
	@FindBy(name="password")
	WebElement password;
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath="//button[contains(text(),'Sign Up')]")
	WebElement signUpBtn;
	@FindBy(xpath="//img[@class='img-responsive']")
	WebElement crmlogo;
	//Initialization of page factory
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	//Actions
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	public boolean validateCRMImage(){
		return crmlogo.isDisplayed();
		
	}
public HomePage login(String us,String ps){
	 username.sendKeys(us);
	 password.sendKeys(ps);
	 loginBtn.submit();
	 return new HomePage();
}

}
