package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.*;

public class ShopTest {
	String driverPath = "/Users/wen/Downloads/chromedriver";
	WebDriver driver;
	String url = "http://automationpractice.com/index.php";
	 
	AuthenticationPage authenticationPage;
	HomePage homePage;
	
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
	public void shopCartTest() {
		homePage = new HomePage(driver);
		authenticationPage = new AuthenticationPage(driver);
		
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		homePage.clickSignInButton();
		authenticationPage.insertEmailCreateAccount("test6@wendy.com");
		authenticationPage.insertUserPersonalInformation("wendy","misari","123456","4","7","1996");
		authenticationPage.insertUserAddress("Casa", "Chicago", "Illinois", "60606", "773-209-4447", "Nueva casa");
		homePage.clickLogo();
		homePage.addClotheToTheShopCart();
	}
}
