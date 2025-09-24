package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends BasePage{

	


		
		
		@FindBy(xpath="//h2[normalize-space()='My Account']")
		WebElement myaccountheading;
		
		@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
		WebElement Logout;
		
		public boolean myaccountpage() {
			try {
				return (myaccountheading.isDisplayed());
			}
			catch(Exception e){
				return false;
			}
			
		}
		public void logout(){
			Logout.click();
			
			
		}
		
	}

