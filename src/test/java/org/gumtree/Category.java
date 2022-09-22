package org.gumtree;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Category extends Baseclass {
	
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
		System.out.println(new Date());
	}
	
	@AfterMethod
	private void afterMethod() {
		System.out.println(new Date());
	}

	@Test()
	private void selectCarAndVehicle() {
		CatPojo c= new CatPojo();
		dynamicImplicitWait(20);
		
		cursorMove(c.getCarAndVehicle());	
	}
	
	@Test(priority=1)
	private void selectHomeAndGarden() {
		CatPojo c= new CatPojo();
		dynamicImplicitWait(20);
		cursorMove(c.getHomeAndGarden());
		List<WebElement> home = driver.findElements(By.xpath("(//ul[@class='header__secondary-navigation-list '])[2]/li"));
       for (int i = 0; i < home.size(); i++) {
		String hg= home.get(i).getText();
		if(hg.contains("Home Decor")) {
			home.get(i).click();
		}
	}
	}
	
	@Test(priority=3)
	private void selectMore() {
		CatPojo c= new CatPojo();
		cursorMove(c.getMore());
		dynamicImplicitWait(20);
		List<WebElement> more = driver.findElements(By.xpath("(//ul[@Class='header__secondary-navigation-list header__secondary-navigation-list--all-categories'])[2]/li/a/li"));
		System.out.println(more.size());
		//javaScriptClick(c.getMore());
	}
	
	@Test(priority=6)
	private void selectValueMyCar() {
		CatPojo c= new CatPojo();
		cursorMove(c.getValueMyCar());
		dynamicImplicitWait(20);
		List<WebElement> more = driver.findElements(By.xpath("(//ul[@Class='header__secondary-navigation-list header__secondary-navigation-list--all-categories'])[2]/li/a/li"));
		javaScriptClick(c.getMore());
	}
	
	@Test(priority=4)
	private void selectServiceHire() {
		
		CatPojo c= new CatPojo();
		dynamicImplicitWait(20);
		cursorMove(c.getServiceHire());
		List<WebElement> service = driver.findElements(By.xpath("(//ul[@Class='header__secondary-navigation-list '])[3]/li/a"));
		System.out.println(service.size());
		
		for(int i=0; i< service.size(); i++) {
			String ser = service.get(i).getText();
			if(ser.contains("Childcare")) {
				service.get(i).click();
			}
		}
	}
}
	

	

