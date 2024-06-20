package test;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

import pom.CartPage;
import pom.NaptolHomePage;
import pom.ProductDetailPage;
import pom.ProductResultPage;

public class BaseTest {

	public static WebDriver driver;
	public NaptolHomePage naptolHomePage;
	public ProductResultPage productResultPage;
	public ProductDetailPage productDetailPage;
	public CartPage cartPage;
	
	
	public void switchToChildBrowser() {
		Set<String> handles =driver.getWindowHandles();
		Iterator<String> i=handles.iterator();
		driver.switchTo().window(i.next());
		driver.switchTo().window(i.next());
	}
	
	
}
