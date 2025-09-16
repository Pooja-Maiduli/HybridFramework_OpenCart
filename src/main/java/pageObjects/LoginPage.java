package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends BasePage{

	
	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//input[@id='input-email']")
	WebElement loginEmail;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement loginPass;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement loginBtn;

	
	
	public void enteremail(String useremail) {
		loginEmail.click();
		loginEmail.sendKeys(useremail);
	}
	public void enterpass(String userpass) {
		loginPass.sendKeys(userpass);
		
	}
	
	public void loginbtn() throws InterruptedException {
		loginBtn.click();
		Thread.sleep(5000);
	}

}
