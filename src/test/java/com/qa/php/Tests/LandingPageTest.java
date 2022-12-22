package com.qa.php.Tests;

import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.php.base.BasePage;
import com.qa.php.pages.LandingPage;
import com.qa.php.utils.Constants;

public class LandingPageTest {
	public static final Logger log = LogManager.getLogger("LandingPageTest");
	BasePage basepage;
	Properties prop;
	WebDriver driver;
	LandingPage landingPage;
	
	@BeforeTest
	public void setUp() {
		basepage = new BasePage();
		prop = basepage.initialize_propertiesFile();
		driver = basepage.initialize_driver(prop);
		landingPage = new LandingPage(driver);
	}
	
	@Test(priority = 0)
	public void verify_LandingPage_Title_Test() {
		String title = landingPage.check_LandingPage_Title();
		log.info( "Landing page title is " + title);
 		Assert.assertEquals( title , Constants.LANDINGPAGE_TITLE);
		
	}
	
	@Test(priority = 1)
	public void verify_Click_SignIn_Click_On_LandingPage_Test() {
		landingPage.click_SignIn_Link();
		String LoginpageTitle = driver.getTitle();
		log.info( "Login page title is " + LoginpageTitle);
 		Assert.assertEquals( LoginpageTitle ,  Constants.LOGINPAGE_TITLE);
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
