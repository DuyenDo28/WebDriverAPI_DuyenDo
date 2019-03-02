package WebElements;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class WebelementExcercise {
	WebDriver driver;
	
	
	@BeforeClass
		
		public void beforeClass()
		{	
			System.setProperty("webdriver.chrome.driver",".\\driver\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("http://live.guru99.com/");
			
		}
		@Test
		public void TC_01_LoginEmpty()
		
		{   
			
			driver.findElement(By.xpath("//span[text()='Account']")).click();	
			driver.findElement(By.xpath("//a[text()='My Account']")).click();	
			driver.findElement(By.xpath("//input[@id='email']")).sendKeys("");		
			driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("");
			WebElement LogInbtn= driver.findElement(By.xpath("//button[@id='send2']"));
			LogInbtn.click();

			String WarningEmail = driver.findElement(By.xpath("//div[@id='advice-required-entry-email']")).getText();
			Assert.assertEquals("This is a required field.", WarningEmail);			
		}
		@Test
		public void TC_02_LoginWithInvalidEmail()
		{			
					
			driver.navigate().to("http://live.guru99.com/index.php/customer/account/");		
			
			driver.findElement(By.xpath("//input[@id='email']")).sendKeys("123434234@12312.123123");
			
			driver.findElement(By.xpath("//input[@name='login[password]']")).sendKeys("");
			WebElement LogInbtn= driver.findElement(By.xpath("//button[@id='send2']"));
			
			LogInbtn.click();
			
			String InvalidEmailWarning =driver.findElement(By.xpath("//div[@id='advice-validate-email-email']")).getText();
			Assert.assertEquals("Please enter a valid email address. For example johndoe@domain.com.", InvalidEmailWarning);
			
			
		}
		public int RandomEmail()
		{
			Random rd = new Random();
			int em= rd.nextInt(1000000);
			return em;
		}
		public String EmailAdress="Kieuduyen" +RandomEmail()+"@gmail.com";
		@Test
		public void TC_03_CreateAnAccount()
		{
			
			//driver.get("http://live.guru99.com/");
			//span[text()='Account']
			driver.findElement(By.xpath("//span[text()='Account']")).click();
	  	    driver.findElement(By.xpath("//a[text()='My Account']")).click();
	  	    driver.findElement(By.xpath("//span[text()='Create an Account']")).click();
	  	    driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys("DuyenDo19");
	  	    driver.findElement(By.xpath("//input[@id='middlename']")).sendKeys("Kieu");
	  	    driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys("Kieu");
	  	    driver.findElement(By.xpath("//input[@id='email_address']")).sendKeys(EmailAdress);
	  	    driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
	  	    driver.findElement(By.xpath("//input[@id='confirmation']")).sendKeys("123456");
	  	    driver.findElement(By.xpath("//input[@id='is_subscribed']")).click();  
	  	    driver.findElement(By.xpath("//button[@title='Register']")).click();  
	  	    String urlLoginPage= driver.getCurrentUrl();
		    Assert.assertEquals("http://live.guru99.com/index.php/customer/account/index/",urlLoginPage);
	  	    driver.findElement(By.xpath("//span[text()='Account']")).click();
	        driver.findElement(By.xpath("//a[text()='Log Out']")).click();
	        driver.findElement(By.xpath("//span[text()='Account']")).click();
	    	driver.findElement(By.xpath("//a[@title='Log In']")).click();
	    	driver.findElement(By.xpath("//input[@id='email']")).sendKeys(EmailAdress);   	
	    	driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("123456");	
	    	driver.findElement(By.xpath("//span[text()='Login']")).click();
	    	String currentURL= driver.getCurrentUrl();
	    	Assert.assertEquals("http://live.guru99.com/index.php/customer/account/",currentURL);
	    	driver.findElement(By.xpath("//span[text()='Account']")).click();
	        driver.findElement(By.xpath("//a[text()='Log Out']")).click();
	  	   
		}
		@Test
		public void TC_04_LogInWithIncorrectPassword()
		{
			
	        driver.navigate().to("http://live.guru99.com/index.php/customer/account/");		
	        driver.findElement(By.xpath("//input[@id='email']")).clear();
			
			driver.findElement(By.xpath("//input[@name='login[password]']")).clear();
			
			driver.findElement(By.xpath("//input[@id='email']")).sendKeys(EmailAdress);
			
			driver.findElement(By.xpath("//input[@name='login[password]']")).sendKeys("123");
			WebElement LogInbtn= driver.findElement(By.xpath("//button[@id='send2']"));		
			LogInbtn.click();
			
			String InvalidPasswordWarning =driver.findElement(By.xpath("//div[@id='advice-validate-password-pass']")).getText();
			Assert.assertEquals("Please enter 6 or more characters without leading or trailing spaces.", InvalidPasswordWarning );
		}
		
		@AfterClass
		public void afterClass()
		{
			
		}

}
