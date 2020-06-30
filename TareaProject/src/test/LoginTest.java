package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.LoginPage;

public class LoginTest {
  
	String driverPath = "/Users/wen/Downloads/chromedriver";
	WebDriver driver;
	
	LoginPage objLogin;
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get("http://testphp.vulnweb.com/login.php");
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
	}
	
	@Test
	public void loginTest() {
		objLogin = new LoginPage(driver);
		objLogin.login("test", "test");
		
		boolean isValidationTextDisplayed = false;
		isValidationTextDisplayed = objLogin.findValidationText();
		Assert.assertEquals(isValidationTextDisplayed, true);
	}
	
}