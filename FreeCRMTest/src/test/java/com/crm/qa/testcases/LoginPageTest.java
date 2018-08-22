package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	public LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	
	public void setUp(){
		initialization();
		loginPage=new LoginPage();
		
	}
	
	
	@Test(priority=1)
	public void loginPageTitle(){
		String title=loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Free CRM software in the cloud powers sales and customer service");
	
}
	@Test(priority=2)
	public void crmImageLogoTest(){
	 boolean flag=loginPage.validateCRMImage();
	 Assert.assertTrue(flag);
	}
	@Test(priority=3)
	public void loginTest(){
		homePage=loginPage.login(CONFIG.getProperty("username"), CONFIG.getProperty("password"));
	}
	
	
	@AfterMethod
	
	public void tearDown(){
		driver.quit();
	}
	
	

}
