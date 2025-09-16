package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterAccount extends BasePage{

	public RegisterAccount(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	//locators
	
	

	
	@FindBy(xpath="//input[@id='input-firstname']") 
	WebElement firstName;
	
	@FindBy(xpath="//input[@id='input-lastname']") 
	WebElement lastName;
	
	@FindBy(xpath="//input[@placeholder='E-Mail']") 
	WebElement EMail;
	
	@FindBy(xpath="//input[@id='input-telephone']") 
	WebElement telephone;
	
	@FindBy(xpath="//input[@id='input-password']") 
	WebElement password;
	
	@FindBy(xpath="//input[@id='input-confirm']") 
	WebElement Confirmpassword;
	
	@FindBy(xpath="//input[@value='Continue']") 
	WebElement register_btn;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement AgreeCheckBox;
	
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement accountcreated;
	
	
	//actions
	
	public void setfname(String fname) {
		firstName.sendKeys(fname);
	}
	
	public void setlname(String lname)
	{
		lastName.sendKeys(lname);
	}
	
	public void setEmail(String Email) throws InterruptedException {
		Thread.sleep(3000);
		EMail.sendKeys(Email);
	}
	
	
	public void settelephone(String tele_phone) {
		telephone.sendKeys(tele_phone);
	}
	

	public void setPass(String pwd) {
		password.sendKeys(pwd);
	}
	
	public void setConfirmPass(String pwd) {
		Confirmpassword.sendKeys(pwd);
	}
	
	public void btn() throws InterruptedException {
		register_btn.click();
		Thread.sleep(3000);
	}
	
	public void agreeCb() {
		AgreeCheckBox.click();
	}
	
public String msgvalidation() {
	try {
	return (accountcreated.getText());
	}
	catch(Exception e){
		return (e.getMessage());
	}
}
}
