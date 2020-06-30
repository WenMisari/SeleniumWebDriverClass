package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class HomePage {
	WebDriver driver;
	
	By signInButton = By.xpath("//a[contains(.,'Sign in')]");
	By logoLocator = By.xpath("//img[@alt='My Store']");
	By blouseClothes = By.xpath("//ul[@id='homefeatured']//img[@alt='Blouse']");
	By addButton = By.cssSelector("ul#homefeatured [data-id-product='2']");
	By proceedButton = By.xpath("//a[contains(.,'Proceed to checkout')]");
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickSignInButton() {
		driver.findElement(signInButton).click();
	}
	
	public void clickLogo() {
		driver.findElement(logoLocator).click();
	}
	
	public void addClotheToTheShopCart() {
		Actions action = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", blouseClothes);
		action.moveToElement(driver.findElement(blouseClothes)).build().perform();
		driver.findElement(addButton).click();
	}
}
