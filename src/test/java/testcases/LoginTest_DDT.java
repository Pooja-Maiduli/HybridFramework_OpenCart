package testcases;
import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import pageObjects.AccountPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.basetest;
import utilities.dataproviders;

public class LoginTest_DDT extends basetest{
	
	
@Test(dataProvider="LoginData", dataProviderClass=dataproviders.class, groups="Sanity")


   
	public void login(String email, String Password, String Exp) throws InterruptedException {
		logger.info("***********Starting login test*********");
		
	try {
		
		HomePage hp=new HomePage();
	       hp.login();
	       WebDriverWait mywait=new WebDriverWait(getDriver(),Duration.ofSeconds(30));

		
		LoginPage lp=new LoginPage();
		
		lp.enteremail(email);
		lp.enterpass(Password);
		lp.loginbtn();
		AccountPage ap=new AccountPage();
		boolean pagexist=ap.myaccountpage();
		
			if(Exp.equalsIgnoreCase("Valid"))
			{
				if(pagexist==true) {
					ap.logout();
					Assert.assertTrue(true);
					
				}
				else
				{
					Assert.assertTrue(false);
				}
			}
			if(Exp.equalsIgnoreCase("Invalid"))
			{
				if(pagexist==true) {
					ap.logout();
					Assert.assertTrue(false);
					
				}
				else
				{
				
					Assert.assertTrue(true);
				}

			}
		

			
	}
	catch(Exception e)
	{
		Assert.fail();
	}
	
}
}
			
	





	
	

