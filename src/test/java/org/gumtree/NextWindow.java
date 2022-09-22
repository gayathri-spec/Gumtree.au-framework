package org.gumtree;

import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class NextWindow extends Baseclass {
	
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

	@Test
	private void postCarAd1() throws InterruptedException, IOException {
		
		NextWinPojo n= new NextWinPojo();
		
		clickbtn(n.getStartBtn());
		windowNavigate();
		
		clickbtn(n.getMakeDropdown());
		dropDownValue(n.getMakeDropdown(), "JEEP");
		dynamicImplicitWait(5);
		
		clickbtn(n.getModelDropdown());
		dropDownText(n.getModelDropdown(),"COMPASS");
		dynamicImplicitWait(5);
		
		clickbtn(n.getYearDropdown());
		dropDownValue(n.getYearDropdown(),"2020");
		dynamicImplicitWait(5);
		
		clickbtn(n.getVariantDropdown());
		dropDownText(n.getVariantDropdown(),"NIGHT EAGLE (FWD)");
		dropDownText(n.getVehicleSumDropdown(),"M6 MY20, 5D WAGON, MULTI POINT F/INJ, 6 SP AUTOMATIC, 2359 CC, 2.4L, 4 cyl");
		dynamicImplicitWait(5);
		
		javaScriptClick(n.getViewBtn());
		dynamicImplicitWait(5);
		
		webText(n.getTextGenerated());	
		clickbtn(n.getPostYourCar());
		
		windowNavigate();
		screenShot("summary", 1);
		textPass(n.getEmailPost(),"Ashley@gmail.com");
		textPass(n.getPassword(),"ashash");
		clickbtn(n.getSubmitBtn());
	}
	
	@Test
	private void postCarAd2() throws InterruptedException, IOException {
		
		NextWinPojo n= new NextWinPojo();
		
		clickbtn(n.getStartBtn());
		windowNavigate();
		
		clickbtn(n.getMakeDropdown());
		dropDownValue(n.getMakeDropdown(), getData(3,1));
		dynamicImplicitWait(5);
		
		clickbtn(n.getModelDropdown());
		dropDownText(n.getModelDropdown(),getData(3,2));
		dynamicImplicitWait(5);
		
		clickbtn(n.getYearDropdown());
		dropDownValue(n.getYearDropdown(),getData(3,3));
		dynamicImplicitWait(5);
		
		clickbtn(n.getVariantDropdown());
		dropDownText(n.getVariantDropdown(),getData(3,4));
		dropDownText(n.getVehicleSumDropdown(),getData(3,5));
		dynamicImplicitWait(20);
		
		javaScriptClick(n.getViewBtn());
		dynamicImplicitWait(25);
		
		webText(n.getTextGenerated());	
		clickbtn(n.getPostYourCar());
		
		windowNavigate();
		
		textPass(n.getEmailPost(),"david@gmail.com");
		textPass(n.getPassword(),"david");
		clickbtn(n.getSubmitBtn());
	}
	
	@Test
	private void postCarAd3() throws InterruptedException, IOException {
		
		NextWinPojo n= new NextWinPojo();
		
		clickbtn(n.getStartBtn());
		windowNavigate();
		
		clickbtn(n.getMakeDropdown());
		dropDownValue(n.getMakeDropdown(), getData(10,1));
		dynamicImplicitWait(5);
		
		clickbtn(n.getModelDropdown());
		dropDownText(n.getModelDropdown(),getData(10,2));
		dynamicImplicitWait(5);
		
		clickbtn(n.getYearDropdown());
		dropDownValue(n.getYearDropdown(),getData(10,3));
		dynamicImplicitWait(5);
		
		clickbtn(n.getVariantDropdown());
		dropDownText(n.getVariantDropdown(),getData(10,4));
		dropDownText(n.getVehicleSumDropdown(),getData(10,5));
		dynamicImplicitWait(20);
		
		javaScriptClick(n.getViewBtn());
		dynamicImplicitWait(10);
		
		webText(n.getTextGenerated());	
		clickbtn(n.getPostYourCar());
		
		screenShot("summary", 2);
		windowNavigate();
		
		textPass(n.getEmailPost(),"emily@gmail.com");
		textPass(n.getPassword(),"emy123");
		clickbtn(n.getSubmitBtn());
	}
	
	
	
}
