package org.gumtree;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UtePojo extends Baseclass{
	
	public UtePojo() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//div[@class='bz-el bz-CMDBjI knd-HOTSPOT_V2 ']")
	private WebElement uteTown;
	
	@FindBy(xpath="(//span[text()='Find a dealer'])[5]")
	private WebElement findDealer;
	
	
	@FindBy(id="search-by-postcode")
	private WebElement postcodeBtn;
	
	@FindBy(xpath="//input[@id='search-by-suburb']")
	private WebElement suburbBtn;
	
	@FindBy(xpath="//input[@id='user-suburb']")
	private WebElement locationText;
	
	@FindBy(xpath="//input[@value='Find']")
	private WebElement findBtn;

	public WebElement getUteTown() {
		return uteTown;
	}

	public WebElement getFindDealer() {
		return findDealer;
	}

	public WebElement getPostcodeBtn() {
		return postcodeBtn;
	}
	
	public WebElement getSuburbBtn() {
		return suburbBtn;
	}

	public WebElement getLocationText() {
		return locationText;
	}

	public WebElement getFindBtn() {
		return findBtn;
	}
	
	
	
	

}
