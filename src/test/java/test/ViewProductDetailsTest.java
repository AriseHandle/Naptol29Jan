package test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.NaptolHomePage;
import pom.ProductResultPage;

public class ViewProductDetailsTest extends BaseTest {


	@BeforeMethod
	public void openApplication() {
		driver =Browser.launchApplication();
	}
	
	@Test
	public void verifyIfUserIsViewProductDetailsFromQuickView() {
	    NaptolHomePage naptolHomePage = new NaptolHomePage(driver);
	    naptolHomePage.enterProductToSearch("cooker");
	    naptolHomePage.clickOnSearch();
	    ProductResultPage productResultPage = new ProductResultPage(driver);
	    String productName = productResultPage.getProductTitle(1);
	    String productPrice = productResultPage.getProductPrice(1);
	    productResultPage.moveToDesiredProduct(driver, 1);
	    productResultPage.clickOnQuickView(1);
	    Assert.assertEquals(productResultPage.getProductNameOnQuickView(),productName );
	    Assert.assertEquals(productResultPage.getProductPriceOnQuickView(), productPrice);
	}
}
