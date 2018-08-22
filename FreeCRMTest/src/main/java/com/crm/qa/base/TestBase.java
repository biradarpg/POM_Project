package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriver.SystemProperty;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListner;
/**
 *  
 * @author Praveen
 * 
 * test case should be separated --independent with each other 
 * before each test case --launch the browser and login
 * @Test --execute test case
 * after each test case --close the browser
 */
public class TestBase {
	public static WebDriver driver=null;
	public static Properties CONFIG=null;
	public static EventFiringWebDriver ev_driver;
	public static WebEventListner eventListener;
	public TestBase() {
		try{
		CONFIG=new Properties();
		FileInputStream ip= new FileInputStream("F:\\Old_Workspace\\Eclipse1\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
		CONFIG.load(ip);
		}catch(FileNotFoundException e){
			e.printStackTrace();
			
		}catch(IOException e){
			e.printStackTrace();
			
		}
		
	}
	public static void initialization(){
		String browserName=CONFIG.getProperty("browser");
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", CONFIG.getProperty("cpath"));
			driver=new ChromeDriver();
		}
		if(browserName.equals("firefox")){
			System.setProperty("webdriver.chrome.driver", CONFIG.getProperty("fpath"));
			driver=new FirefoxDriver();
		}
		
		//create the Object of eventfring web Driver
		ev_driver=new EventFiringWebDriver(driver);
		//now create the Object of eventListner handler to register with EventFiring web driver
		eventListener=new WebEventListner();
		ev_driver.register(eventListener);
		driver=ev_driver;
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(CONFIG.getProperty("url"));
		
	}

}
