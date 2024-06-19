package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailPage {

	@FindBy (xpath = "//div[@id='square_Details']//h1")private WebElement productNameOnQuickView;
	@FindBy (xpath = "//div[@id='square_Details']//span[@class='offer-price']")private WebElement productPriceOnQuickView;
	@FindBy (xpath = "//a[@id='cart-panel-button-0']") private WebElement clickToBuy;
	
	public ProductDetailPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public String getProductName() {
		return productNameOnQuickView.getText();
	}
	
	public String getProductPrice() {
		String [] p =	productPriceOnQuickView.getText().split(" ");
		return p[0];
	}
	
	public String getShippingPrice() {
		String [] p =	productPriceOnQuickView.getText().split(" ");
		return p[2];
	}
	
	public void clickOnBuyButton() {
		clickToBuy.click();
	}
	
	
}
