package com.makemytrip.TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.NewSessionPayload;
import org.testng.annotations.Test;

import com.makemytrip.generic_utils.ExcelUtilityClass;
import com.makemytrip.pageObject.LoginPage;
import com.makemytrip.pageObject.TravellerPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddTravellerTest {
	
	WebDriver driver;
	ExcelUtilityClass eUtil=new ExcelUtilityClass();
	
	
	@Test
	public void testAddTraveller() throws Throwable
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		String url=eUtil.getExcelData("Sheet1", 2, 2);
		String name=eUtil.getExcelData("Sheet1", 3, 2);
		driver.get(url);
		LoginPage l=new LoginPage(driver);
		l.login("ankitakumari944@gmail.com", "ankita12354@");
		Thread.sleep(3000);
		TravellerPage tPage=new TravellerPage(driver);
		tPage.createTraveller(name);
	}

}
