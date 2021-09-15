package com.makemytrip.TestCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.makemytrip.generic_utils.ExcelUtilityClass;
import com.makemytrip.pageObject.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;


public class SearchFlightTest {
	
	WebDriver driver;
	ExcelUtilityClass eUtil=new ExcelUtilityClass();
	
	@Test
	public void testLogin() throws Throwable
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		String url=eUtil.getExcelData("Sheet1", 2, 2);
		String uname=eUtil.getExcelData("Sheet1", 0, 2);
		String pwd=eUtil.getExcelData("Sheet1", 1, 2);
		String fromcity=eUtil.getExcelData("Sheet1", 7, 2);
		String tocity=eUtil.getExcelData("Sheet1", 8, 2);
		driver.get(url);
		Thread.sleep(3000);
		LoginPage l1=new LoginPage(driver);
		l1.login(uname, pwd);
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//span[@class='tabsCircle appendRight5'])[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='fsw_inputBox searchCity inactiveWidget ']/label")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@class='react-autosuggest__input react-autosuggest__input--open']")).sendKeys(fromcity);
		Thread.sleep(2000);
		List<WebElement> FromlistBox = driver.findElements(By.xpath("//p[@class='font14 appendBottom5 blackText']"));
		for(int i=0;i<FromlistBox.size();i++)
		{
			String text=FromlistBox.get(i).getText();
			if(text.contains("Bengaluru"))
			{
				FromlistBox.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='fsw_inputBox searchCity inactiveWidget ']/following-sibling::div/label/span[@class='lbl_input latoBold  appendBottom5']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='toCity']")).sendKeys(tocity);
		Thread.sleep(2000);
		List<WebElement> TolistBox = driver.findElements(By.xpath("//p[@class='font14 appendBottom5 blackText']"));
		Thread.sleep(2000);
		for(int i=0;i<TolistBox.size();i++)
		{
			String text=TolistBox.get(i).getText();
			if(text.contains("Mumbai"))
			{
				TolistBox.get(i).click();
				break;
			}
		}
		driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='DayPicker-Months']/descendant::div[@class='DayPicker-Body'][2]//div[@class='DayPicker-Day']")).click();
		driver.findElement(By.xpath("(//p[@class=' todayPrice'])[1]")).click();





	}
}
