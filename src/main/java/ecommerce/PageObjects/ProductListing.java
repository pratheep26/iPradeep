package ecommerce.PageObjects;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponents;

public class ProductListing extends AbstractComponents {

	WebDriver driver;

	public ProductListing(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".col-lg-3.col-md-6.mb-3")
	List<WebElement> phones;

	By phoneList = By.cssSelector(".col-lg-3.col-md-6.mb-3");

	@FindBy(xpath = "//div[@class='card-footer']/button")
	WebElement ddCartButton;
	
	By phoneNames = By.cssSelector("h4.card-title");
	
	

	By AddCartButton = By.cssSelector(".btn.btn-info");

	public List<WebElement> getProductList() {
		waitForElementToBeAppear(phoneList);
		return phones;
	}

	public WebElement GetProductByName(String phoneName) {
		WebElement actualPhone = getProductList().stream()
				.filter(prod -> prod.findElement(phoneNames).getText().equals(phoneName)).findFirst().orElse(null);
		System.out.println(actualPhone.getText());
		return actualPhone;
	}

	public GoToCheckoutScreen AddProductToCart(String phoneName) {
		WebElement phone = GetProductByName(phoneName);
		phone.findElement(AddCartButton).click();
		GoToCheckoutScreen goToCheckoutScreen = new GoToCheckoutScreen(driver);
		return goToCheckoutScreen;
	}
}
