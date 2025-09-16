package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	//locators
	@FindBy(xpath="//ul[@class='list-inline']//li[@class='dropdown']")
	WebElement homepageicon;
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement register;
	@FindBy(xpath="//a[normalize-space()='Login']")
	WebElement login;
	@FindBy(xpath="//button[@class='btn btn-default btn-lg']")
	WebElement searchBtn;
	
	
	//actions
	public void register() {
		homepageicon.click();
		register.click();
	}
	
	public void login() throws InterruptedException {
		homepageicon.click();
		login.click();
		Thread.sleep(3000);	}
	public void searchproductbtn() {
		searchBtn.click();	}


}
