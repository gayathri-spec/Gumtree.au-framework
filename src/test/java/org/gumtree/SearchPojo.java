package org.gumtree;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPojo extends Baseclass {
		
	public SearchPojo() {
	PageFactory.initElements(driver, this);
		}
		
	@CacheLookup
	@FindBy(xpath="(//input[@type='text'])[1]")
	private WebElement searchBar;
	
	@CacheLookup
	@FindBy(xpath="//button[@type='submit']")
	private WebElement searchClk;
	
	@CacheLookup
	@FindBy(id="search-area")
	private WebElement addrSearch;
	

	public WebElement getSearchBar() {
		return searchBar;
	}

	public WebElement getSearchClk() {
		return searchClk;
	}

	public WebElement getAddrSearch() {
		return addrSearch;
	}

	
}

