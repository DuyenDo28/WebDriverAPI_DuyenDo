package IFrame;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class IFrameSection5 {
	WebDriver driver;

	@BeforeClass

	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		driver = new ChromeDriver();

	}

	@Test
	public void TC_01_Excercise1()

	{
		driver.get("http://the-internet.herokuapp.com/iframe");
		WebElement iframeLookingfor = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
		driver.switchTo().frame(iframeLookingfor);
		WebElement iframeLookingforChild = driver.findElement(By.xpath("//body[@id='tinymce']"));
		iframeLookingforChild.clear();
		iframeLookingforChild.sendKeys("Ronaldo");

		driver.switchTo().defaultContent();
		WebElement iframeOutsiteChildFrame = driver
				.findElement(By.xpath("//h3[text()='An iFrame containing the TinyMCE WYSIWYG Editor']"));
		String Header = iframeOutsiteChildFrame.getText();
		Assert.assertEquals("An iFrame containing the TinyMCE WYSIWYG Editor", Header);
	}

	@Test
	public void TC_02_Exercise2() {
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_input_disabled");
		WebElement iframeOfLname = driver.findElement(By.xpath("//iframe[@id='iframeResult']"));
		driver.switchTo().frame(iframeOfLname);
		WebElement LnameField = driver.findElement(By.xpath("//input[@name='lname']"));

		// Boolean LnameIsDisable=LnameField.isEnabled();
		// System.out.print(LnameIsDisable);
		Assert.assertFalse(LnameField.isEnabled());
		WebElement FnameField = driver.findElement(By.xpath("//input[@name='fname']"));
		FnameField.sendKeys("nguyen");

		driver.findElement(By.xpath("//input[@value='Submit']")).click();

		WebElement WarningMSG = driver.findElement(By.xpath("//div[@class='w3-container w3-large w3-border']"));
		String AlertMsg = WarningMSG.getText().trim();
		Assert.assertEquals("fname=nguyen", AlertMsg);
	}

	@Test
//	public void TC_03_Exercise3() {
//		// a[text()='Click Here']
//		driver.get("http://demo.guru99.com/popup.php");
//		driver.findElement(By.xpath("//a[text()='Click Here']")).click();
//
//	}

	public void switchToWindowByTitle(String title) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String childWindows : allWindows) {
			driver.switchTo().window(childWindows);
			String childTitle = driver.getTitle();
			if (childTitle.equals(title)) {
				break;
			}
		}
	}

	@Test
	public void TC_04_Exercise4() {

		driver.get("http://www.hdfcbank.com/");
		WebElement Tab2 = driver.findElement(By.xpath("//a[text()='Agri']"));
		Tab2.click();
		//Vao console > Document.Title>
		switchToWindowByTitle("HDFC Bank Kisan Dhan Vikas e-Kendra");
		
		//String parentID = driver.getWindowHandle();// lấy 1 window hiện tại
		WebElement Tab3 = driver.findElement(By.xpath("//p[text()='Account Details']"));
		Tab3.click();
		
		switchToWindowByTitle("Welcome to HDFC Bank NetBanking");
		//- Click Privacy Policy link (nằm trong frame) -> Mở ra tab/window mới -> Switch qua tab mới
		WebElement Tab4 = driver.findElement(By.xpath("//frame[@name='footer']"));
		driver.switchTo().frame(Tab4);
		driver.findElement(By.xpath("//a[text()='Privacy Policy']")).click();
		
		switchToWindowByTitle("HDFC Bank - Leading Bank in India, Banking Services, Private Banking, Personal Loan, Car Loan");
		
		WebElement Tab5 = driver.findElement(By.xpath("//a[text()='CSR']"));
		Tab5.click();
		//switchToWindowByTitle("HDFC Bank: Personal Banking Services");
		// String parentID = driver.getWindowHandle();//lấy 1 window hiện tại
		// Set<String> allWindows = driver.getWindowHandles();//Lấy all windows

	}

	@Test
	public void TC_05_Exercise5() {

	}

	@Test
	public void TC_06_Exercise6() {

	}

	public void TC_07_Exercise7() {

	}

	@AfterClass
	public void afterClass() {
		// driver.quit();
	}

}
