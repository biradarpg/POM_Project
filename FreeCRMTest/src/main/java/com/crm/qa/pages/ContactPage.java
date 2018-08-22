 package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactPage extends TestBase{
	
	public ContactPage(){
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//td[ contains(text(), 'Contacts')]")
	@CacheLookup
	WebElement contactsLable;
	@FindBy(id="first_name")
	WebElement firstName;
	
	@FindBy(id="surname")
	WebElement lastName;
	
	@FindBy(name="client_lookup")
	WebElement companyName;
	
	@FindBy(xpath="//input[@type='submit' and @value='Save']")
	WebElement saveBtn;
	
	public boolean verifyContacstLable(){
		return contactsLable.isDisplayed();
	}
	
	public void createNewcontact(String title,String fname,String lname,String company){
		
		Select select =new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		companyName.sendKeys(company);
		saveBtn.click();
		
		
	}

}
