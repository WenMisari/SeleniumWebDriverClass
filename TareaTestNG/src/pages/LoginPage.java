package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;
	
	By usernameField = By.name("uid");
	By passwordField = By.name("password");
	By loginButton = By.name("btnLogin");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void setUsername(String username) {
		driver.findElement(usernameField).sendKeys(username);
	}
	
	public void setPassword(String password) {
		driver.findElement(passwordField).sendKeys(password);
	}
	
	public void clickButtonLogin() {
		driver.findElement(loginButton).click();
	}
	
	public void loginGuru99(String user, String pass) {
		setUsername(user);
		setPassword(pass);
		clickButtonLogin();
	}
	
	public String validateURL() {
		return driver.getCurrentUrl();
	}
}
