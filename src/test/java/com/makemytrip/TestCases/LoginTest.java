package com.makemytrip.TestCases;

import org.hamcrest.core.Is;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.makemytrip.generic_utils.ExcelUtilityClass;
import com.makemytrip.pageObject.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;


public class LoginTest {
		
	WebDriver driver;
	ExcelUtilityClass eUtil=new ExcelUtilityClass();
	@Parameters("browsername")
	@BeforeTest
	public void setup(String browsername)
	{
		System.out.println("BrowserType nameBrowserType Is :"+browsername);
		if(browsername.equalsIgnoreCase("chrome"))
		{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		}
		else if(browsername.equalsIgnoreCase("firefox"))
		{
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		}
		else {
			driver.close();
		}
	}
	@Test
	public void testLogin() throws Throwable
	{
		String url=eUtil.getExcelData("Sheet1", 2, 2);
		String uname=eUtil.getExcelData("Sheet1", 0, 2);
		String pwd=eUtil.getExcelData("Sheet1", 1, 2);
		driver.get(url);
		Thread.sleep(3000);
		LoginPage l=new LoginPage(driver);
		l.login(uname, pwd);
		l.addTraveller();
	}
	
}

