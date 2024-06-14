package test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pojo.Browser;
import pom.NaptolHomePage;

public class ProductSearchTest extends BaseTest {

	@BeforeMethod
	public void openApplication() {
		driver =Browser.launchApplication();
	}
	
	@Test
	public void verifyIfUserIsAbleRoSerachProduct() {
		NaptolHomePage naptolHomePage = new NaptolHomePage(driver);
		naptolHomePage.enterProductToSearch("iphone");
		naptolHomePage.clickOnSearch();
		Assert.assertTrue(driver.getTitle().contains("iphone"));
		Assert.assertTrue(naptolHomePage.getNumberOfProductDisplayed()>0);
		
	}
	
}
