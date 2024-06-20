package test;

import java.util.Iterator;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.CartPage;
import pom.NaptolHomePage;
import pom.ProductDetailPage;
import pom.ProductResultPage;

public class CartTest extends BaseTest {
	
	@BeforeMethod
	public void openApplication() {
		driver =Browser.launchApplication();
	}
	
	@Test
	public void verifyAddToCartFromOrderDeatils()
	{
		naptolHomePage =new NaptolHomePage(driver);
		naptolHomePage.enterProductToSearch("cooker");
		naptolHomePage.clickOnSearch();
		productResultPage = new ProductResultPage(driver);
		productResultPage.selectDesiredProduct(0);
		switchToChildBrowser();
		productDetailPage = new ProductDetailPage(driver);
		String ExpectedName = productDetailPage.getProductName();
		double ExpectedPrice = productDetailPage.getProductPrice();
		double ExpectedShippingPrice = productDetailPage.getShippingPrice();
		productDetailPage.clickOnBuyButton();
		cartPage =new CartPage(driver);
		Assert.assertEquals(cartPage.getNumberOfProductsInCart(), 1);
		Assert.assertEquals(cartPage.getProductName(0), ExpectedName);
		Assert.assertEquals(cartPage.getProductPrice(1), ExpectedPrice);
		Assert.assertEquals(cartPage.getShippingPrice(1), ExpectedShippingPrice);	
	}
	
	
	@Test
	public void verifyAmountsInCart() {
		naptolHomePage =new NaptolHomePage(driver);
		naptolHomePage.enterProductToSearch("cooker");
		naptolHomePage.clickOnSearch();
		productResultPage = new ProductResultPage(driver);
		productResultPage.selectDesiredProduct(0);
		switchToChildBrowser();
		productDetailPage = new ProductDetailPage(driver);
		productDetailPage.clickOnBuyButton();
		cartPage = new CartPage(driver);
		Assert.assertEquals(cartPage.getOrderAmount(1), (cartPage.getProductPrice(1)+cartPage.getShippingPrice(1)));
		
		
	}
}
