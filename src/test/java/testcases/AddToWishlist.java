package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.SearchCriteria;
import pageObjects.ShoppingCartPage;
import testBase.basetest;

public class AddToWishlist extends basetest {
	
	@Test
	public void login() throws InterruptedException {
		logger.info("************Home Page****************");
	HomePage hp=new HomePage();
	hp.login();
	
	logger.info("*************Login*************");
	LoginPage lp=new LoginPage();
	lp.enteremail(p.getProperty("email"));
	lp.enterpass(p.getProperty("password"));
	lp.loginbtn();
	
	
	logger.info("**************Searching Product*****************");
	hp.searchTextBox(p.getProperty("productname"));
	hp.searchproductbtn();
	
	
	logger.info("************Search Criteria Page*************");
	 SearchCriteria sc=new SearchCriteria();
	 js.executeScript("arguments[0].scrollIntoView(true);", sc.productTitle());
	 sc.AddToWishList();
	 
	  String st=sc.successText();
	 Assert.assertTrue(st.contains("Success: You have added iPhone to your wish list!"));
	 sc.shoppingcartlink();
	 
	 
	 logger.info("*************Wishlist Page***************");
	 ShoppingCartPage scp=new ShoppingCartPage();
	 Assert.assertEquals(scp.productval(), p.getProperty("productname"));
	
	}
	

}
