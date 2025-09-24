package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegisterAccount;
import testBase.basetest;   // import the Base Test class

public class AccountRegistration extends basetest {

    @Test(priority=1, groups="Sanity")
    public void registration() throws InterruptedException {
    	
    	logger.info("********Register account test case started*********");
       HomePage hp=new HomePage();
       hp.register();
       WebDriverWait mywait=new WebDriverWait(getDriver(),Duration.ofSeconds(30));

       logger.info("********Adding information for Account Registration*********");
    	RegisterAccount ra=new RegisterAccount();
    	
    	ra.setfname("Pooja");
    	ra.setlname("pooja");
    	WebElement wait=mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='E-Mail']")));
    	ra.setEmail(RandomString()+"@gmail.com");
    	ra.settelephone(RandomNumber());
    	String password=RandomAlphaNumber();
    	ra.setPass(password);
    	ra.setConfirmPass(password);
    	ra.agreeCb();
    	ra.btn();
    	logger.info("*********Validating Confirmation Message***********");
    	String cm=ra.msgvalidation();
    	Assert.assertEquals(cm,"Your Account Has Been Created!");
    
    }
    
    
    
    
    
    
}
