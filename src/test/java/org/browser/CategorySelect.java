package org.browser;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CategorySelect {
	
	  public static void nestDrop(String value) {
		  WebDriverManager.chromedriver().setup();
		    WebDriver driver=new ChromeDriver();
		   
		    driver.get("https://www.gumtree.com.au/");
		    driver.manage().window().maximize();
		   
		    WebElement drop=driver.findElement(By.xpath("//span[@class='search-bar__category-name']"));
		    drop.click();
		   
		    List<WebElement> dropdown = driver.findElements(By.xpath("(//ul[contains(@class,'j-selectbox__ul')])[1]//li//div"));
		        System.out.println("Size of the Outer DropDown: "+dropdown.size());
		   
		    for (int i = 0; i < dropdown.size(); i++) {        
		       
		        if(dropdown.get(i).getText().equals("Antiques, Art & Collectables")) {
		        driver.findElement(By.xpath("(//span[@class='c-icon c-icon-down j-selectbox__down-icon'])[1]")).click();
		        List<WebElement> drop1 = driver.findElements(By.xpath("(//ul[@class='j-selectbox__child-ul j-selectbox__child-ul--is-expanded'])[1]//li//div"));
		        System.out.println("\nSize of the inner DropDown: "+drop1.size());
		           
		            for (int j = 0; j < drop1.size(); j++) {        
		           
		            if(drop1.get(j).getText().contains(value)) {
		            drop1.get(j).click();
		            }
		    }
		        }
		        else if(dropdown.get(i).getText().equals("Baby & Children")) {
		           
		          driver.findElement(By.xpath("(//span[@class='c-icon c-icon-down j-selectbox__down-icon'])[3]")).click();
		          List<WebElement> drop2 = driver.findElements(By.xpath("(//li[@class='j-selectbox__li j-selectbox__li-1'])[7]//li//div"));
		          System.out.println("\nSize of the inner DropDown: "+drop2.size());
		               
		          for (int j = 0; j < drop2.size(); j++) {        
		               
		              if(drop2.get(j).getText().contains("Safety")) {
		        driver.findElement(By.xpath("(//span[@class='c-icon c-icon-down j-selectbox__down-icon'])[2]")).click();    
		        List<WebElement> drop21 = driver.findElements(By.xpath("(//ul[@class='j-selectbox__child-ul j-selectbox__child-ul--is-expanded'])[3]//li//div"));
		                   
		        for (int k = 0; k < drop21.size(); k++) {
		        if(drop21.get(k).getText().contains(value)) {
		        drop21.get(k).click();
		        }
		        }
		        }
		        }
		          }
		        else if(dropdown.get(i).getText().equals("Boats & Jet Skis")) {
		        driver.findElement(By.xpath("(//span[@class='c-icon c-icon-down j-selectbox__down-icon'])[4]")).click();
		        List<WebElement> drop3 = driver.findElements(By.xpath("(//ul[@class='j-selectbox__child-ul j-selectbox__child-ul--is-expanded'])[3]//li//div"));
		                System.out.println("\nSize of the inner DropDown: "+drop3.size());
		           
		            for (int j = 0; j < drop3.size(); j++) {        
		           
		            if(drop3.get(j).getText().contains(value)) {
		            drop3.get(j).click();
		           
		            }
		    }
		        }
	   
	   else if(dropdown.get(i).getText().equals("Books, Music & Games")) {
		driver.findElement(By.xpath("(//span[@class='c-icon c-icon-down j-selectbox__down-icon'])[7]")).click();
		   
		List<WebElement> drop4 = driver.findElements(By.xpath("(//ul[@class='j-selectbox__child-ul j-selectbox__child-ul--is-expanded'])[4]//li//div"));
		System.out.println("\nSize of the inner DropDown: "+drop4.size());
		       
		for (int j = 0; j < drop4.size(); j++) {
		     
		if(drop4.get(j).getText().equals("Books")) {
		driver.findElement(By.xpath("(//span[@class='c-icon c-icon-down j-selectbox__down-icon'])[5]")).click();
		List<WebElement> drop41 = driver.findElements(By.xpath("(//ul[@class='j-selectbox__child-ul j-selectbox__child-ul--is-expanded'])[5]//li//div"));
		for (int k = 0; k < drop41.size(); k++) {
		if(drop41.get(k).getText().contains(value)) {
		drop41.get(k).click();
		}
		}
		}
		       
		  else if(drop4.get(j).getText().equals("Musical Instruments")){
		   driver.findElement(By.xpath("(//span[@class='c-icon c-icon-down j-selectbox__down-icon'])[6]")).click();
		    List<WebElement> drop42 = driver.findElements(By.xpath("(//ul[@class='j-selectbox__child-ul j-selectbox__child-ul--is-expanded'])[6]//li//div"));
		    for (int k = 0; k < drop42.size(); k++) {
		    if(drop42.get(k).getText().contains(value)) {
		        drop42.get(k).click();
		        }
		        }
		      }
		        else {
		        drop4.get(j).click();
		        }
		       }
		     }
		       
		        else if(dropdown.get(i).getText().equals("Cars & Vehicles")) {
		        driver.findElement(By.xpath("(//span[@class='c-icon c-icon-down j-selectbox__down-icon'])[15]")).click();
		       
		        List<WebElement> drop5 = driver.findElements(By.xpath("(//ul[@class='j-selectbox__child-ul j-selectbox__child-ul--is-expanded'])[8]"));
		        System.out.println("\nSize of the inner DropDown: "+ drop5.size());
		        for (int j = 0; j < drop5.size(); j++) {
		        String text = drop5.get(j).getText();
	        	System.out.println(text);
		}
		  }
		    }  
		}
		   
		public static void main(String[] args) {
		CategorySelect t= new CategorySelect();
		t.nestDrop("baby clothing");
		}           
}
