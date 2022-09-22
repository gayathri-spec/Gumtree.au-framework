package org.gumtree;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CatPojo extends Baseclass {
	
	public CatPojo() {
		PageFactory.initElements(driver, this);
	}

	@CacheLookup
	@FindBy(xpath="//a[@class='header__primary-link']")
	private WebElement homeBtn;
	
	@FindBy(xpath="(//a[@class='j-menu-parent header__primary-navigation-link'])[1]")
	private WebElement carAndVehicle;
	
	@CacheLookup
	@FindBy(xpath="(//a[@class='j-menu-parent header__primary-navigation-link'])[2]")
	private WebElement homeAndGarden;
	
	@FindBy(xpath="(//li[@class='header__primary-navigation-item'])[3]")
	private WebElement jobs;

	@FindBy(xpath="(//a[@class='j-menu-parent header__primary-navigation-link'])[4]")
	private WebElement realEstate;

	@FindBy(xpath="(//a[@class='j-menu-parent header__primary-navigation-link'])[5]")
	private WebElement serviceHire;
	
	@CacheLookup
	@FindBy(xpath="(//a[@class='j-menu-parent header__primary-navigation-link'])[11]")
	private WebElement valueMyCar;
	
	@CacheLookup
	@FindBy(xpath="//span[@class='header__more-categories-medium-up']")
	private WebElement more;
	
	@FindBy(xpath="(//ul[@class='header__secondary-navigation-list '])[9]")
	private WebElement serviceHireOptions;
	
	
	
	public WebElement getHomeBtn() {
		return homeBtn;
	}

	public WebElement getCarAndVehicle() {
		return carAndVehicle;
	}

	public WebElement getHomeAndGarden() {
		return homeAndGarden;
	}

	public WebElement getJobs() {
		return jobs;
	}

	public WebElement getRealEstate() {
		return realEstate;
	}

	public WebElement getServiceHire() {
		return serviceHire;
	}

	public WebElement getValueMyCar() {
		return valueMyCar;
	}

	public WebElement getMore() {
		return more;
	}
	
	public WebElement getServiceHireOptions() {
		return serviceHireOptions;
	}
	
}
