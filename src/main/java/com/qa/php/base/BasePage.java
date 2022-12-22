package com.qa.php.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;

public class BasePage {

	public WebDriver driver;
	public static final Logger log = LogManager.getLogger("BasePage");
	public Properties prop;

	public WebDriver initialize_driver(Properties prop) {

		String browser = prop.getProperty("browser");
		log.info("browser name is " + browser);
		if (browser.equalsIgnoreCase("chrome")) {
			driver = WebDriverManager.chromedriver().create();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = WebDriverManager.firefoxdriver().create();
		}

		else if (browser.equalsIgnoreCase("edge")) {
			driver = WebDriverManager.edgedriver().create();
		}

		else if (browser.equalsIgnoreCase("firefox")) {
			driver = WebDriverManager.getInstance(SafariDriver.class).create();
		}

		else {
			log.info(browser + " is not found, please pass the correct browser");

		}

		driver.get(prop.getProperty("url"));
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		return driver;
	}

	public Properties initialize_propertiesFile() {
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("./src/main/java/com/qa/php/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;

	}

}
