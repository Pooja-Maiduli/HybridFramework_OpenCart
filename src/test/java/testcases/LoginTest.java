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

public class LoginTest extends basetest{
	
	
@Test(groups="Regression")

	public void login() throws InterruptedException {
		logger.info("***********Starting login test*********");
		
	
		HomePage hp=new HomePage(driver);
	       hp.login();
	       WebDriverWait mywait=new WebDriverWait(driver,Duration.ofSeconds(30));

		
		LoginPage lp=new LoginPage(driver);
		
		lp.enteremail(p.getProperty("email"));
		lp.enterpass(p.getProperty("password"));
		lp.loginbtn();
		AccountPage ap=new AccountPage(driver);
		boolean pagexist=ap.myaccountpage();
		
			Assert.assertEquals(pagexist,true,"Login Failed");
		
			}
	
	
}
