package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	//page factory or OR
	
	@FindBy(xpath="//td[@class='headertext' and contains(text(), 'User: Praveen Biradar')]")
	WebElement userLable;
	@FindBy(xpath="//a[(contains(text(),'Contacts'))]")	         
	WebElement contactLink;
	@FindBy(xpath="//a[(text()='New Contact')]")
	WebElement newContactLink;
	//Initialization of page factory
	@FindBy(xpath="//a[(contains(text(),'Deals'))]")
	WebElement dealsLink;

	
	public boolean verifyCorrectUserName(){
		boolean flag=userLable.isEnabled();
		
		return flag;
				

	}
	public String verifyHomePageTitle(){
		return driver.getTitle();
		
	}
	public ContactPage clickContacts(){
		contactLink.click();
		return new ContactPage();
	}
	public DealsPage clickDealspage(){
		dealsLink.click();
		return new DealsPage();
	}
	public void clickNewContact(){
		Actions act=new Actions(driver);
		act.moveToElement(contactLink).build().perform();
		newContactLink.click();
	}

}
