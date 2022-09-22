package org.gumtree;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NextWinPojo  extends Baseclass {
	
	public NextWinPojo() {
		PageFactory.initElements(driver,this);
	}
		
	@FindBy(xpath="//a[@id='carval_cta_button']")
	private WebElement startBtn;
	
	@FindBy(xpath="(//select[@class='css-fdobmv-Box evp4u3p0'])[1]")
	private WebElement makeDropdown;
	
	@FindBy(xpath="(//select[@class='css-fdobmv-Box evp4u3p0'])[2]")
	private WebElement modelDropdown;
	
	@FindBy(xpath="(//select[@class='css-fdobmv-Box evp4u3p0'])[3]")
	private WebElement yearDropdown;
	
	@FindBy(xpath="(//select[@class='css-fdobmv-Box evp4u3p0'])[4]")
	private WebElement variantDropdown;
	
	@FindBy(xpath="(//select[@class='css-fdobmv-Box evp4u3p0'])[5]")
	private WebElement vehicleSumDropdown;
	
	@FindBy(xpath="(//button[text()='View valuation'])[2]")
	private WebElement viewBtn;
	
	@FindBy(xpath="//h2[@class='css-z0t6h7-Box evp4u3p0']")
	private WebElement textGenerated;
	
	@FindBy(xpath="//a[text()='Post your car now']")
	private WebElement postYourCar;
		
	@FindBy(id="login-email")
	private WebElement emailPost;
	
	@FindBy(id="login-password")
	private WebElement password;
	
	@FindBy(id="btn-submit-login")
	private WebElement submitBtn;

	
	
	public WebElement getStartBtn() {
		return startBtn;
	}

	public WebElement getMakeDropdown() {
		return makeDropdown;
	}

	public WebElement getModelDropdown() {
		return modelDropdown;
	}

	public WebElement getYearDropdown() {
		return yearDropdown;
	}

	public WebElement getVariantDropdown() {
		return variantDropdown;
	}

	public WebElement getVehicleSumDropdown() {
		return vehicleSumDropdown;
	}

	public WebElement getViewBtn() {
		return viewBtn;
	}

	public WebElement getTextGenerated() {
		return textGenerated;
	}

	public WebElement getPostYourCar() {
		return postYourCar;
	}

	public WebElement getEmailPost() {
		return emailPost;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}

}
