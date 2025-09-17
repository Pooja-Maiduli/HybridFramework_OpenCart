package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends BasePage {

	public ShoppingCartPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//td[normalize-space()='Product Name']//parent::tr//parent::thead//parent::table/tbody/tr/td[2]/a")
	WebElement productval;
	
	public String productval() {
		String product=productval.getText();
		return product;
	}

	
	
	
	
	
}
