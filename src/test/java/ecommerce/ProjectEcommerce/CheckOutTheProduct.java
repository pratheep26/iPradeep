package ecommerce.ProjectEcommerce;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestComponents.BaseTest;
import ecommerce.PageObjects.GoToCheckoutScreen;
import ecommerce.PageObjects.ProductListing;

public class CheckOutTheProduct extends BaseTest {

	@Test
	public void Checkout() throws IOException {
		String phoneName = "Nokia Edge";
		ProductListing productListing = loginPage.loginIntoTheApplication("rahulshettyacademy", "learning",
				"Consultant");
		GoToCheckoutScreen goToCheckoutScreen = productListing.AddProductToCart(phoneName);
		goToCheckoutScreen.CheckOutScreen();
		boolean isMatch = goToCheckoutScreen.VerifyAddedProduct(phoneName);
		Assert.assertTrue(isMatch);
		System.out.println("Success the continues integration");
	}

}
