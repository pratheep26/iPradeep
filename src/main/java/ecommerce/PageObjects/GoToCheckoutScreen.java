package ecommerce.PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponents;

public class GoToCheckoutScreen extends AbstractComponents {
WebDriver driver;
	public GoToCheckoutScreen(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="a.btn-primary")
	WebElement checkoutButton;
	
	@FindBy(css="h4 a")
	List<WebElement> addedProducts;
	
	public void CheckOutScreen() {
		checkoutButton.click();
	}
	
	public boolean VerifyAddedProduct(String phoneName) {
		boolean actualAddedProduct = addedProducts.stream().peek(product->System.out.println("This is added product in cart: "+ product.getText()))
				.anyMatch(product->product.getText().equalsIgnoreCase(phoneName));
		return actualAddedProduct;
	
	}
}
