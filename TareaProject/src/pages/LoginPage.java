package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;
	
	By usernameField = By.name("uname");
	By passwordField = By.name("pass");
	By loginButton = By.xpath("//input[@value='login']");
	By validationText = By.xpath("//td[.='Name:']");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void setUsername(String username) {
		driver.findElement(usernameField).sendKeys(username);
	}
	
	public void setPassword(String password) {
		driver.findElement(passwordField).sendKeys(password);
	}
	
	public void clickLoginButton() {
		driver.findElement(loginButton).click();
	}
	
	public boolean findValidationText() {
		return driver.findElement(validationText).isDisplayed();
	}
	
	public void login(String username, String password) {
		setUsername(username);
		setPassword(password);
		clickLoginButton();
	}
}
