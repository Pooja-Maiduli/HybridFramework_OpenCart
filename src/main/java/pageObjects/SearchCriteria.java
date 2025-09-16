package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SearchCriteria extends BasePage{

	public SearchCriteria(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//input[@id='input-search']")
	WebElement searchCriteria;
	
	@FindBy(xpath="//select[@name='category_id']")
	WebElement category;
	
	@FindBy(xpath="//input[@id='button-search']")
	WebElement search;
	
	@FindBy(xpath="//img[@title='iPhone']")
	WebElement productimg;
	
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
	

}
