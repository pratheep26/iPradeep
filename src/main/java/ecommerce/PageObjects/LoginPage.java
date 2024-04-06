package ecommerce.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import AbstractComponents.AbstractComponents;

public class LoginPage extends AbstractComponents {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "input#username")
	WebElement userName;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(css = ".customradio:nth-child(2)")
	WebElement userRadioButton;

	By popupAcceptButton = By.id("okayBtn");

	@FindBy(xpath = "//select[@class='form-control']")
	WebElement dropdownField;

	@FindBy(id = "terms")
	WebElement checkboxTerms;

	@FindBy(id = "signInBtn")
	WebElement signinButton;

	public ProductListing loginIntoTheApplication(String username, String pwd, String drpValue) {
		userName.sendKeys(username);
		password.sendKeys(pwd);
		userRadioButton.click();
		waitForElementToBeAppear(popupAcceptButton);
		driver.findElement(popupAcceptButton).click();
		Select select = new Select(dropdownField);
		select.selectByVisibleText(drpValue);
		checkboxTerms.click();
		signinButton.click();
		
		ProductListing productListing = new ProductListing(driver);
		return productListing;

	}

	public void goToLoginPage() {
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
	}

}
