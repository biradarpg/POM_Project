package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactPage contactPage;
	public HomePageTest(){
		super();
	}
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage=new LoginPage();
		testUtil=new TestUtil(); 
		contactPage=new ContactPage();
		homePage=loginPage.login(CONFIG.getProperty("username"), CONFIG.getProperty("password"));
	}
	@Test(priority=1)
	public void verifyHomePageTitleTest(){
		String homePageTitile=homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitile, "CRMPR","Home page Tittle not matching");
	}
	@Test(priority=3)
	public void verifyUserNameTest(){
		testUtil.switchToFrame();
		Assert.assertTrue(homePage.verifyCorrectUserName());
		
	}
	@Test(priority=2)
	public void verifyContactLinkText(){
		testUtil.switchToFrame();
		contactPage=homePage.clickContacts();
	}
	@AfterMethod
	public void tearDown(){
		driver.close();
	}
}
