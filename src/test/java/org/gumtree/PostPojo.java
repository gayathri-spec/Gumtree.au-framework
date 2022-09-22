package org.gumtree;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PostPojo extends Baseclass{
	
	public PostPojo() {
		PageFactory.initElements(driver, this);
	}

	@CacheLookup
	@FindBy(xpath="//span[@class='header__my-gumtree-trigger-text']")
	private WebElement myGumtreeBtn;
	

	@FindBy(xpath="//a[@class='header__post-ad-button new-listing-button h-url']")
	private WebElement postBtn;
	

	@FindBy(xpath="//input[@id='login-email']")
	private WebElement postEmail;
	
	
	@FindBy(xpath="//input[@id='login-password']")
	private WebElement postPass;
	
	
	@FindBy(xpath="//button[@id='btn-submit-login']")
	private WebElement postClk;
	

	public WebElement getMyGumtreeBtn() {
		return myGumtreeBtn;
	}

	public WebElement getPostBtn() {
		return postBtn;
	}

	public WebElement getPostEmail() {
		return postEmail;
	}

	public WebElement getPostPass() {
		return postPass;
	}

	public WebElement getPostClk() {
		return postClk;
	}
}



