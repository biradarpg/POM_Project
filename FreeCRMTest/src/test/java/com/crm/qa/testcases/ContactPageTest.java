package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactPage contactPage;
	String sheetName="Contacts";
	public ContactPageTest(){
		super();
	}
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage=new LoginPage();
		testUtil=new TestUtil(); 
		contactPage=new ContactPage();
		homePage=loginPage.login(CONFIG.getProperty("username"), CONFIG.getProperty("password"));
		testUtil.switchToFrame();
		contactPage=homePage.clickContacts();
	}
	
	@Test(priority=1)
	public void verifyContactsLableTest(){
	Assert.assertTrue(contactPage.verifyContacstLable());
	}
	@Test(priority=2, dataProvider="getCRMTestData")
	public void createNewContactTest(String title,String fname,String lname,String company){
		homePage.clickNewContact();
		contactPage.createNewcontact(title, fname, lname, company);
		
	}
	@DataProvider 
	public Object[][] getCRMTestData(){
	Object data[][]=testUtil.getData(sheetName);
	return data;
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
