package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchCriteria;
import testBase.basetest;

public class SearchingProduct extends basetest{

	
	
	@Test(groups="Regression")
	public void searchingproduct() {
		logger.info("**********Home Page************");
		HomePage hp=new HomePage(driver);
		hp.searchproductbtn();
		
		logger.info("**********Search Page************");
		SearchCriteria sc=new SearchCriteria(driver);
		sc.searchCri("Iphone");
		sc.cate("Phones & PDAs");
		sc.searchitem();
		Boolean prod=sc.productval();
		Assert.assertEquals(prod, true);
	}
	

	
	

}
