package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class MiniStatementPage {
	WebDriver driver;

	By accountSelectBox = By.name("accountno");
	By submitButton = By.name("AccSubmit");
	By account3308Text = By.xpath("//p[@class='heading3']");
	By continueLink = By.xpath("//a[.='Continue']");
	
	public MiniStatementPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void selectAccountOption(String option) {
		Select account = new Select(driver.findElement(accountSelectBox));
		account.selectByVisibleText(option);		
	}
	
	public void clickSubmitButton() {
		driver.findElement(submitButton).click();
	}
	
	public void SelectAndSubmitOption(String option) {
		selectAccountOption(option);
		clickSubmitButton();
	}
	
	public boolean isAccount3308Displayed() {
		return driver.findElement(account3308Text).isDisplayed();
	}
	
	public void clickContinueLink() {
		driver.findElement(continueLink).click();
	}
}
