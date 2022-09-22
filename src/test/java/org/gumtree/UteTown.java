package org.gumtree;

import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UteTown extends Baseclass {
	
	@BeforeSuite
	private void browserLaunch() {
		System.out.println("Start");
	}
	
	@BeforeClass
	private void browserName() throws InterruptedException {
		launchUrl();
		max();
		loadUrl("https://www.gumtree.com.au/");
		Thread.sleep(10000);
		printTitle();
		ctUrl();
	}
	
	@AfterClass
	private void browserClose() {
		System.out.println("close");
	}
	
	@BeforeMethod
	private void reloadBrowser() {
		System.out.println(new Date());
	}
	
	@AfterMethod
	private void afterMethod() {
		System.out.println(new Date());
	}

	@Test(invocationCount=1,priority=-1)
	private void uteTown1() throws IOException {
		UtePojo u= new UtePojo();
		driver.navigate().to("https://www.ldvautomotive.com.au/vehicles/ldv-t60-max-ute/");
		//javaScriptClick(u.getUteTown());
		//windowNavigate();
		clickbtn(u.getFindDealer());
		clickbtn(u.getSuburbBtn());
		textPass(u.getLocationText(),"New Castle");
		clickbtn(u.getFindBtn());
		
		screenShot("Ute", 1);
	}
	
	@Test(invocationCount=1,priority=2)
	private void uteTown2() throws IOException {
		UtePojo u= new UtePojo();
		driver.navigate().to("https://www.ldvautomotive.com.au/vehicles/ldv-t60-max-ute/");
		//javaScriptClick(u.getUteTown());
		//windowNavigate();
		clickbtn(u.getFindDealer());
		clickbtn(u.getSuburbBtn());
		textPass(u.getLocationText(),"Orange");
		clickbtn(u.getFindBtn());
		
		
		screenShot("Ute", 2);
	}
		
	
	
}
