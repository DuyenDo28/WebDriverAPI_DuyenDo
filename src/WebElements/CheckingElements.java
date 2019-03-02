package WebElements;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CheckingElements {
WebDriver driver;
	
	
	@BeforeClass
		
		public void beforeClass()
		{	
			System.setProperty("webdriver.chrome.driver",".\\driver\\chromedriver.exe");
			driver = new ChromeDriver();
			
			
		}
		@Test
		public void TC_01_Exercise()
		
		{   	
			driver.get("https://daominhdam.github.io/basic-form/");
	     	WebElement element1 = driver.findElement(By.xpath("//input[@id='password']"));			
			Assert.assertFalse(element1. isEnabled());
			String PlaceholderIscorrect= driver.findElement(By.xpath("//input[@id='password']")).getAttribute("placeholder");
		    Assert.assertEquals("Textbox is disabled",PlaceholderIscorrect);						
		}
		@Test
		public void TC_02_Exercise()
		{		
			driver.get("http://demo.guru99.com/test/radio.html");
			WebElement element = driver.findElement(By.xpath("//input[@id='vfb-7-1']"));
			Assert.assertFalse(element. isSelected());
			driver.findElement(By.xpath("//input[@id='vfb-7-1']")).click();
			WebElement RadionButtonIsCheck = driver.findElement(By.xpath("//input[@id='vfb-7-1']"));
			Assert.assertTrue(RadionButtonIsCheck. isSelected());
			WebElement CheckbocIsCheck = driver.findElement(By.xpath("//input[@id='vfb-6-2']"));
			Assert.assertFalse(CheckbocIsCheck. isSelected());
			driver.findElement(By.xpath("//input[@id='vfb-6-2']")).click();	  	
		}				
		@Test
		public void TC_03_Excercise()
		{
			
			driver.get("https://www.facebook.com/");
			Select selectDay = new Select(driver.findElement(By.xpath("//select[@id='day']")));
			selectDay.selectByVisibleText("14");
			String selectItems = selectDay.getFirstSelectedOption().getText();
			Assert.assertEquals("14", selectItems);
			
			Select selectMonth = new Select(driver.findElement(By.xpath("//select[@id='month']")));
			selectMonth.selectByVisibleText("Tháng 8");
			String selectItems1 = selectMonth.getFirstSelectedOption().getText();
			Assert.assertEquals("Tháng 8", selectItems1);
			
			Select selectYear = new Select(driver.findElement(By.xpath("//select[@id='year']")));
			selectYear.selectByVisibleText("1993");
			String selectItems2 = selectYear.getFirstSelectedOption().getText();
			Assert.assertEquals("1993", selectItems2);

		}
	
		
		
		@AfterClass
		public void afterClass()
		{
			driver.quit();
		}

}
