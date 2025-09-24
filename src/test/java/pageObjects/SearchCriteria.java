package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SearchCriteria extends BasePage{


	
	@FindBy(xpath="//input[@id='input-search']")
	WebElement searchCriteria;
	
	@FindBy(xpath="//select[@name='category_id']")
	WebElement category;
	
	@FindBy(xpath="//input[@id='button-search']")
	WebElement search;
	
	@FindBy(xpath="//img[@title='iPhone']")
	WebElement productimg;
	
	@FindBy(xpath="//div[@class='caption']//a")
	WebElement producttitle;
	
	@FindBy(xpath="//div[@class='button-group']//i[@class='fa fa-shopping-cart']")
	WebElement addtocart;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	WebElement successText;
	
	@FindBy(xpath="//a[normalize-space()='shopping cart']")
	WebElement successTextlink;
	
	@FindBy(xpath="//button[@data-original-title=\"Add to Wish List\"]")
	WebElement AddtoWishlist;
	
	
	public void searchCri(String product) {
		searchCriteria.sendKeys(product);
	}
	
	public void cate(String producttype) {
		Select sel=new Select(category);
		sel.selectByVisibleText(producttype);
	}
	
	public void searchitem() {
		search.click();
	}
	
	
	public boolean productval() {
		try {
			return productimg.isDisplayed();
		}
		catch(Exception e){
			return false;
		}
		
	}
	
	public WebElement productTitle() {
		return producttitle;
	}
	
	public void AddToCart() {
		addtocart.click();
	}
	
	public String successText() {
		String text=successText.getText();
		return text;
		}
	
	public WebElement shoppingcartlink() {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()",successTextlink);
				return successTextlink;
	}
	
	public void AddToWishList() {
		AddtoWishlist.click();
	}
	
	

}
