package org.gumtree;

import java.io.IOException;
import java.util.Date;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Group1 extends Baseclass {
	
	@BeforeSuite(alwaysRun = true)
	private void browserLaunch() {
		System.out.println("Start");
	}
	
	@BeforeClass(alwaysRun = true)
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
	
	@BeforeMethod(alwaysRun = true)
	private void reloadBrowser() {
		driver.navigate().to("https://www.gumtree.com.au/");
		dynamicImplicitWait(10);
		System.out.println(new Date());
	}
	
	@AfterMethod
	private void afterMethod() {
		System.out.println(new Date());
	}

	@Test (dataProvider="searchProduct")
	private void search1(String s1, String s2) throws InterruptedException, IOException  {
       SearchPojo s= new SearchPojo();
       textPass(s.getSearchBar(),s1 );
       textPass(s.getAddrSearch(), s2);
       clickbtn(s.getSearchClk());
       waitTime(3000);
      
	}
	
	@Test (groups="search")
	private void search2() throws InterruptedException, IOException  {
       SearchPojo s= new SearchPojo();
       textPass(s.getSearchBar(), "camping van" );
       textPass(s.getAddrSearch(), "Canberra");
       clickbtn(s.getSearchClk());
       waitTime(3000);
       
       screenShot("search", 5);
	}
	
	@Test(dataProvider="loginDetails", groups="post")
	private void postAd(String d1, String d2) {
		
		PostPojo p = new PostPojo();
		
		clickbtn(p.getPostBtn());
		dynamicImplicitWait(5);
		textPass(p.getPostEmail(), d1);
		textPass(p.getPostPass(), d2 );
		clickbtn(p.getPostClk());
		}
	
	@Test(groups="post")
	private void postAd() throws IOException {
		
		PostPojo p = new PostPojo();
	
		clickbtn(p.getPostBtn());
		dynamicImplicitWait(5);
		textPass(p.getPostEmail(), "john@gmial.com");
		textPass(p.getPostPass(), "jhonny" );

		 screenShot("login", 1);
		 
		clickbtn(p.getPostClk());
		}
	
	@Test(groups="car")
	private void postCarAd() throws InterruptedException, IOException {
		
		NextWinPojo n= new NextWinPojo();
		
		clickbtn(n.getStartBtn());
		windowNavigate();
		
		clickbtn(n.getMakeDropdown());
		dropDownValue(n.getMakeDropdown(), "CHEVROLET");
		dynamicImplicitWait(5);
		
		clickbtn(n.getModelDropdown());
		dropDownText(n.getModelDropdown(),"CAMARO");
		dynamicImplicitWait(5);
		
		clickbtn(n.getYearDropdown());
		dropDownValue(n.getYearDropdown(),"1972");
		dynamicImplicitWait(5);
		
		clickbtn(n.getVariantDropdown());
		dropDownText(n.getVariantDropdown(),"SS");
		dropDownText(n.getVehicleSumDropdown(),"2D COUPE, CARB, 4 SP MANUAL, 5736 CC, 5.7L, V8");
		dynamicImplicitWait(5);
		
		javaScriptClick(n.getViewBtn());
		dynamicImplicitWait(5);
		
		webText(n.getTextGenerated());	
		clickbtn(n.getPostYourCar());
		
		windowNavigate();
		
		textPass(n.getEmailPost(),"Ashley@gmail.com");
		textPass(n.getPassword(),"ashash");
	
		clickbtn(n.getSubmitBtn());
	}
	
	@DataProvider(name="searchProduct")
	private Object searchData() {
		return new Object [] [] {
			{"Part time jobs", "Darwin"},
			{"Freebies", "Broken Hill"}
		};
		}
	
	@DataProvider(name="loginDetails")
	private Object loginData() {
		return new Object [] [] {
			{"Oliver@gmail.com", "123456"},
			{"mia@gmail.com", "qwerty"}
		};
		}
}
