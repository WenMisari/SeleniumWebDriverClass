package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.*;

public class GuruTest {
	String driverPath = "/Users/wen/Downloads/chromedriver";
	WebDriver driver;
	String url = "http://demo.guru99.com/Agile_Project/Agi_V1/index.php";
	
	LoginPage objLogin;
	HomePage objHome;
	MiniStatementPage objMini;
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(url);
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
	
	@Test
	public void guruTest() {
		objLogin = new LoginPage(driver);
		objHome = new HomePage(driver);
		objMini = new MiniStatementPage(driver);
		
		objLogin.loginGuru99("1303", "Guru99");
		Assert.assertEquals(objHome.getValidationMessage(), "Welcome To Customer's Page of Guru99 Bank");
		objHome.clickMiniStatementLink();
		objMini.SelectAndSubmitOption("3308");
		Assert.assertTrue(objMini.isAccount3308Displayed());
		objMini.clickContinueLink();
		objHome.logOutAndPopup();
		Assert.assertEquals(objLogin.validateURL(), url);
	}
}
