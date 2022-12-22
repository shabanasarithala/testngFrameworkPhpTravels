package com.qa.php.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.php.base.BasePage;

public class LandingPage extends BasePage{
	
	WebDriver driver;
	
	By SIGN_IN_LINK = By.xpath( "//div[@class='panel header']//a[contains(text(),'Sign In')]");
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String check_LandingPage_Title() {
		return driver.getTitle();
	}
	
	public void click_SignIn_Link() {
		driver.findElement(SIGN_IN_LINK).click();
	}

}
