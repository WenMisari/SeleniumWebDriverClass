package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	WebDriver driver;
	
	By welcomeMessage = By.xpath("//marquee[@class='heading3']");
	By miniStatementLink = By.xpath("//a[.='Mini Statement']");
	By logOutLink = By.xpath("//a[.='Log out']");
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getValidationMessage() {
		return driver.findElement(welcomeMessage).getText();
	}
	
	public void clickMiniStatementLink() {
		driver.findElement(miniStatementLink).click();
	}
	
	public void clicklogOutLink() {
		driver.findElement(logOutLink).click();
	}
	
	public void clickPopUp() {
		driver.switchTo().alert().accept();
	}
	
	public void logOutAndPopup() {
		clicklogOutLink();
		clickPopUp();
	}
}
