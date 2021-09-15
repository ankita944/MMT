package com.makemytrip.pageObject;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LoginPage {
	
	 WebDriver driver;
		public LoginPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
			this.driver = driver;
		}
		
		@FindBy(xpath="(//span[@class='rightArrow pushRight'])[2]")
		private WebElement loginlink;
		
		@FindBy(id="username")
		private WebElement untbx;
		
		@FindBy(xpath="//span[contains(text(),'Continue')]")
		private WebElement continuebtn;
		
		@FindBy(xpath = "//input[@id='password']")
		private WebElement pwdtbx;
		
		@FindBy(xpath = "//span[contains(text(),'Login')]")
		private WebElement loginbtn;
		
		@FindBy(xpath = "//span[@class='crossIcon popupSprite popupCrossIcon']")
		private WebElement crossbtn;
		
		public void login(String un, String pwd) throws InterruptedException
		{
			loginlink.click();
			untbx.sendKeys(un);
			Thread.sleep(2000);
			continuebtn.click();
			Thread.sleep(3000);
			pwdtbx.sendKeys(pwd);
			loginbtn.click();
			Thread.sleep(2000);
			crossbtn.click();
			Thread.sleep(3000);
		}
		
		public void addTraveller() throws InterruptedException
		{   
			
			WebElement profiletab = driver.findElement(By.xpath("//li[@class='makeFlex hrtlCenter font10 makeRelative lhUser userLoggedIn']"));
			Actions a=new Actions(driver);
			Thread.sleep(2000);
			a.moveToElement(profiletab).build().perform();
			driver.findElement(By.xpath("//p[contains(text(),'My Profile')]")).click();
			Thread.sleep(5000);
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("document.getElementsByClassName('myPrfilSprit myPrfilSprit__edtIcn noShrink appendRight5')[1].click()");
			
			Thread.sleep(2000);
			driver.findElement(By.id("travellerFirstName")).sendKeys("Ankita");
			driver.findElement(By.xpath("//div[text()='Gender']/following-sibling::div")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//ul[@class='dropDown__optionsLst']/child::li[text()='FEMALE']")).click();
			Thread.sleep(3000);
			JavascriptExecutor js1=(JavascriptExecutor)driver;
			js1.executeScript("window.scrollBy(0,2000)");
			driver.findElement(By.xpath("//div[text()='Birthday']/following-sibling::div")).click();
			Thread.sleep(3000);
			WebElement yearDropdown = driver.findElement(By.xpath("//select[@name='year']"));
			Select sl=new Select(yearDropdown);
			sl.selectByVisibleText("1995");
			Thread.sleep(3000);
			
			WebElement monthDropdown = driver.findElement(By.xpath("//select[@name='month']"));
			Select sl1=new Select(monthDropdown);
			sl1.selectByVisibleText("April");
			
			driver.findElement(By.xpath("//div[text()='4']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//button[text()='save']")).click();
		}

}
