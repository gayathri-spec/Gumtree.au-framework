package org.gumtree;

import java.util.Date;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PostAnAD extends Baseclass{
	
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
	
	@Test(priority=1, enabled=true, invocationCount= 4 )
	private void postAd() {
		
		PostPojo p = new PostPojo();
		
		clickbtn(p.getPostBtn());
		dynamicImplicitWait(5);
		textPass(p.getPostEmail(), "apple@gmail.com");
		textPass(p.getPostPass(), "apple");
		clickbtn(p.getPostClk());
		}

	@Test(priority=-2, enabled=true, invocationCount=2)
	private void postAd3() {
		
		PostPojo p = new PostPojo();
		
		clickbtn(p.getPostBtn());
		dynamicImplicitWait(5);
		textPass(p.getPostEmail(), "olivia@gmail.com");
		textPass(p.getPostPass(), "asdfgh");
		clickbtn(p.getPostClk());
		}
	
	@Parameters({"email2","pass2"})
	@Test
	private void postAd1(String s1, String s2) {
		
		PostPojo p = new PostPojo();
		
		javaScriptClick(p.getMyGumtreeBtn());
		clickbtn(p.getPostBtn());
		dynamicImplicitWait(5);
		textPass(p.getPostEmail(), s1 );
		textPass(p.getPostPass(), s2);
		clickbtn(p.getPostClk());
		}
	
	@Parameters({"email3","pass3"})
	@Test
	private void postAd2(String s1, String s2) {
		
		PostPojo p = new PostPojo();
		
		javaScriptClick(p.getMyGumtreeBtn());
		clickbtn(p.getPostBtn());
		dynamicImplicitWait(5);
		textPass(p.getPostEmail(), s1);
		textPass(p.getPostPass(), s2);
		clickbtn(p.getPostClk());
		}
	
	
	
	
}
