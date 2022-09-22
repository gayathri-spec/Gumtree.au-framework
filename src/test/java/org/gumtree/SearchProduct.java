package org.gumtree;

import java.util.Date;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SearchProduct extends Baseclass {
	@BeforeSuite
	private void browserLaunch() {
		System.out.println("Start");
	}
	
	@BeforeClass
	private void browserName() throws InterruptedException {
		launchUrl();
		max();
		loadUrl("https://www.gumtree.com.au/");
		Thread.sleep(8000);
		printTitle();
		ctUrl();
	}
	
	@AfterClass
	private void browserClose() {
		System.out.println("close");
		
	}
	
	@BeforeMethod
	private void reloadBrowser() {
		driver.navigate().to("https://www.gumtree.com.au/");
		System.out.println(new Date());
	}
	
	@AfterMethod
	private void afterMethod() {
		System.out.println(new Date());
	}

	@Test(invocationCount=2, enabled=true)
	private void search1() throws InterruptedException  {
       SearchPojo s= new SearchPojo();
       textPass(s.getSearchBar(), "crime novels");
       textPass(s.getAddrSearch(), "canberra");
       clickbtn(s.getSearchClk());
       waitTime(3000);
	}
	
	@Parameters({"search1","addr1"})
	@Test
	private void search2(String s1, String s2) throws InterruptedException  {
       SearchPojo s= new SearchPojo();
       textPass(s.getSearchBar(),s1 );
       textPass(s.getAddrSearch(), s2);
       clickbtn(s.getSearchClk());
       waitTime(3000);
	}
	
	@Parameters({"search2","addr2"})
	@Test
	private void search3(String s1, String s2) throws InterruptedException  {
       SearchPojo s= new SearchPojo();
       textPass(s.getSearchBar(), s1);
       textPass(s.getAddrSearch(), s2);
       clickbtn(s.getSearchClk());
       waitTime(3000);
	}
	
	@Parameters({"search","addr"})
	@Test
	private void search4(@Optional("fiction novels")String s1, @Optional("Sydney")String s2) throws InterruptedException  {
       SearchPojo s= new SearchPojo();
       textPass(s.getSearchBar(), s1);
       textPass(s.getAddrSearch(), s2);
       clickbtn(s.getSearchClk());
       waitTime(3000);
	}
	
	@Test(invocationCount=1, enabled=true, dataProvider="searchDetails")
	private void search5(String d1, String d2) throws InterruptedException  {
       SearchPojo s= new SearchPojo();
       textPass(s.getSearchBar(), d1);
       textPass(s.getAddrSearch(), d2);
       clickbtn(s.getSearchClk());
       waitTime(3000);
	}

	@DataProvider(name="searchDetails")
	private Object [][] details(){
		return new Object [] [] {
			{"kids clothing","Brisbane"},
			{"German Shepherd puppies","Townsville"},
			{"Digital camera","NewCastle"},
			{"Camping van","Port Augusta"}
		} ;
		
		
	} 
}
