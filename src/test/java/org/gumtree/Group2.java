package org.gumtree;

import java.io.IOException;
import java.util.Date;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Group2 extends Baseclass {
	
	@BeforeSuite
	private void browserLaunch() {
		System.out.println("Start");
	}
	
	@BeforeClass(alwaysRun=true)
	private void browserName() throws InterruptedException {
		launchUrl();
		max();
		loadUrl("https://www.gumtree.com.au/");
		Thread.sleep(8000);
		printTitle();
		ctUrl();
	}
	
	@AfterClass(alwaysRun=true)
	private void browserClose() {
		System.out.println("close");
	}
	
	@BeforeMethod(alwaysRun=true)
	private void reloadBrowser() {
		driver.navigate().to("https://www.gumtree.com.au/");
		dynamicImplicitWait(10);
		System.out.println(new Date());
	}
	
	@Test(groups="search")
	private void search1() throws InterruptedException  {
       SearchPojo s= new SearchPojo();
       textPass(s.getSearchBar(), "sports");
       textPass(s.getAddrSearch(), "sydney");
       clickbtn(s.getSearchClk());
       waitTime(3000);
	}
	
	@Test(groups="search")
	private void search2() throws InterruptedException  {
       SearchPojo s= new SearchPojo();
       textPass(s.getSearchBar(), "furniture");
       textPass(s.getAddrSearch(), "Orange");
       clickbtn(s.getSearchClk());
       waitTime(3000);
	}
	
	@Test(groups="car")
	private void postCarAd1() throws InterruptedException, IOException {
		
		NextWinPojo n= new NextWinPojo();
		
		clickbtn(n.getStartBtn());
		windowNavigate();
		
		clickbtn(n.getMakeDropdown());
		dropDownValue(n.getMakeDropdown(),"BENTLEY");
		dynamicImplicitWait(5);
		
		clickbtn(n.getModelDropdown());
		dropDownText(n.getModelDropdown(),"CONTINENTAL");
		dynamicImplicitWait(5);
		
		clickbtn(n.getYearDropdown());
		dropDownValue(n.getYearDropdown(),"2006");
		dynamicImplicitWait(5);
		
		clickbtn(n.getVariantDropdown());
		dropDownText(n.getVariantDropdown(),"GT");
		dropDownText(n.getVehicleSumDropdown(),"3W, 2D COUPE, TURBO MPFI, 6 SP AUTO SEQUENTIAL, 5998 CC, 6.0L, W12");
		dynamicImplicitWait(5);
		
		javaScriptClick(n.getViewBtn());
		dynamicImplicitWait(5);
		
		webText(n.getTextGenerated());	
		clickbtn(n.getPostYourCar());
		
		windowNavigate();
		
		textPass(n.getEmailPost(),"peter@gmail.com");
		textPass(n.getPassword(),"987065");
		clickbtn(n.getSubmitBtn());
	}
	
	@Test (groups="car")
	private void postCarAd2() throws InterruptedException, IOException {
		
		NextWinPojo n= new NextWinPojo();
		
		clickbtn(n.getStartBtn());
		windowNavigate();
		
		clickbtn(n.getMakeDropdown());
		dropDownValue(n.getMakeDropdown(),"GREAT WALL");
		dynamicImplicitWait(5);
		
		clickbtn(n.getModelDropdown());
		dropDownText(n.getModelDropdown(),"STEED");
		dynamicImplicitWait(5);
		
		clickbtn(n.getYearDropdown());
		dropDownValue(n.getYearDropdown(),"2018");
		dynamicImplicitWait(5);
		
		clickbtn(n.getVariantDropdown());
		dropDownText(n.getVariantDropdown(),"(4x4)");
		dropDownText(n.getVehicleSumDropdown(),"K2, C/CHAS, TURBO DIESEL DIR INJ, 6 SP MANUAL, 1996 CC, 2.0L, DT4");
		dynamicImplicitWait(5);
		
		javaScriptClick(n.getViewBtn());
		dynamicImplicitWait(5);
		
		webText(n.getTextGenerated());	
		clickbtn(n.getPostYourCar());
		
		windowNavigate();
		
		textPass(n.getEmailPost(),"ruby@gmail.com");
		textPass(n.getPassword(),"zxcvbn");
		clickbtn(n.getSubmitBtn());
	}
	
	
}
