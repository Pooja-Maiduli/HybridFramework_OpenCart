package testcases;


import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.HomePage;
import pageObjects.SearchCriteria;
import pageObjects.ShoppingCartPage;
import testBase.basetest;

public class AddToCart extends basetest{
	
	
	@Test(groups="Regression")
	public void addToCart() throws InterruptedException {
	HomePage hp=new HomePage();
    hp.searchTextBox(p.getProperty("productname"));
    hp.searchproductbtn();
   SearchCriteria sc= new SearchCriteria();
   js.executeScript("arguments[0].scrollIntoView(true);", sc.productTitle());
    sc.AddToCart();
    String text= sc.successText();
    SoftAssert sa=new SoftAssert();
    sa.assertTrue(text.contains("Success: You have added iPhone to your shopping cart!"));
    js.executeScript("arguments[0].scrollIntoView(true);", sc.shoppingcartlink());
    Thread.sleep(3000);
    sc.shoppingcartlink();
  
    ShoppingCartPage scp=new ShoppingCartPage();
	 Assert.assertEquals(scp.productval(), p.getProperty("productname"));
	}

	
	}
	
	
