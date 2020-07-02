package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AuthenticationPage {
	WebDriver driver;
	
	By signInTextBox = By.id("email_create");
	By createAccountButton = By.id("SubmitCreate");
	By mrsRadioButton = By.id("id_gender2");
	By firstnameTextBox = By.id("customer_firstname");
	By lastnameTextBox = By.id("customer_lastname");
	By emailTextBox = By.id("email");
	By passwordTextBox = By.id("passwd");
	By addressField = By.id("address1");
	By cityField = By.id("city");
	By zipTextBox = By.id("postcode");
	By mobileTextBox = By.id("phone_mobile");
	By aliasTextBox = By.id("alias");
	By registerButton = By.id("submitAccount");
	
	public AuthenticationPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Ingresar el email para crear la cuenta, debe cambiar cada que se ejecute
	public void insertEmailCreateAccount(String email) {
		driver.findElement(signInTextBox).sendKeys(email);
		driver.findElement(createAccountButton).click();
	}
	
	//Ingresar la informacion personal del usuario
	public void insertUserPersonalInformation(String firstname, String lastname, String pass, String day, 
			String month, String year) {
		driver.findElement(mrsRadioButton).click();
		driver.findElement(firstnameTextBox).sendKeys(firstname);
		driver.findElement(lastnameTextBox).sendKeys(lastname);
		driver.findElement(passwordTextBox).sendKeys(pass);
		Select dayOfBirth = new Select(driver.findElement(By.id("days")));
		Select monthOfBirth = new Select(driver.findElement(By.id("months")));
		Select yearOfBirth = new Select(driver.findElement(By.id("years")));
		dayOfBirth.selectByValue(day);
		monthOfBirth.selectByValue(month);
		yearOfBirth.selectByValue(year);
	}
	
	//Ingresar los datos de direccion del usuario, usar la pagina de ayuda para ciertos datos
	public void insertUserAddress(String address, String city, String state, 
			String zipcode, String mobile, String alias) {
		driver.findElement(addressField).sendKeys(address);
		driver.findElement(cityField).sendKeys(city);
		Select stateSelectBox = new Select(driver.findElement(By.id("id_state")));
		stateSelectBox.selectByVisibleText(state);
		driver.findElement(zipTextBox).sendKeys(zipcode);
		driver.findElement(mobileTextBox).sendKeys(mobile);
		driver.findElement(aliasTextBox).clear();
		driver.findElement(aliasTextBox).sendKeys(alias);
		driver.findElement(registerButton).click();
	}
}
