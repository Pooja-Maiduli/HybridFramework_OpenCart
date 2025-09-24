package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import testBase.basetest;

public class BasePage {
	
	//constructor
	protected WebDriver driver;
	
	public BasePage() {
        this.driver = basetest.getDriver(); // ThreadLocal driver
        PageFactory.initElements(this.driver, this);
    }

}
