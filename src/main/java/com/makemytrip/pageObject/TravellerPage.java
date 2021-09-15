package com.makemytrip.pageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class TravellerPage {
	WebDriver driver;
	public TravellerPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
       }
	
	@FindBy(xpath = "//li[@class='makeFlex hrtlCenter font10 makeRelative lhUser userLoggedIn']")
	private WebElement profileoptn;
	
	@FindBy(xpath = "//p[contains(text(),'My Profile')]")
	private WebElement myProfileLink;
	
	@FindBy(id = "travellerFirstName")
	private WebElement travellername;
	
	@FindBy(xpath = "//div[text()='Gender']/following-sibling::div")
	private WebElement genderoptn;
	
	@FindBy(xpath = "//ul[@class='dropDown__optionsLst']/child::li[text()='FEMALE']")
	private WebElement genderdropdown;
	
	@FindBy(xpath="//div[text()='Birthday']/following-sibling::div")
	private WebElement birthdayoptn;
	
	@FindBy(xpath = "//select[@name='year']")
	private WebElement yearDropdown;
	
	@FindBy(xpath = "//select[@name='month']")
	private WebElement monthDropdown;
	
	@FindBy(xpath = "//div[text()='4']")
	private WebElement dateElement;
	
	@FindBy(xpath = "//button[text()='save']")
	private WebElement savebtn;
	
	public void createTraveller(String name) throws InterruptedException
	{
		Actions a=new Actions(driver);
		Thread.sleep(3000);
		a.moveToElement(profileoptn).build().perform();
		myProfileLink.click();
		Thread.sleep(3000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("document.getElementsByClassName('myPrfilSprit myPrfilSprit__edtIcn noShrink appendRight5')[1].click()");
		Thread.sleep(2000);
		travellername.sendKeys(name);
		genderoptn.click();
		Thread.sleep(2000);
		genderdropdown.click();
		Thread.sleep(3000);
		JavascriptExecutor js1=(JavascriptExecutor)driver;
		js1.executeScript("window.scrollBy(0,2000)");
		birthdayoptn.click();
		Thread.sleep(3000);
		Select sl=new Select(yearDropdown);
		sl.selectByVisibleText("1995");
		Thread.sleep(3000);
		Select sl1=new Select(monthDropdown);
		sl1.selectByVisibleText("April");
		dateElement.click();
		savebtn.click();
		
		
		
		
		
		
	}

}
