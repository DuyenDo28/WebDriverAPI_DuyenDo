package UserInteraction;

import java.awt.RenderingHints.Key;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ExcerciseSection4 {
	WebDriver driver;

	@BeforeClass

	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
		driver = new ChromeDriver();

	}

	@Test
	public void TC_01_Excercise1()

	{
		driver.get("https://www.w3schools.com/Bootstrap/bootstrap_tooltip.asp");
		WebElement hoverOverMe = driver.findElement(By.xpath("//button[text()='Hover over me']"));
		Actions action = new Actions(driver);
		action.moveToElement(hoverOverMe).perform();
		Assert.assertEquals("Hooray!", action);
		//System.out.print(WebTitle + "\n");
	}

	@Test
	public void TC_02_Exercise2() {
		driver.get("https://www.24h.com.vn/");

		WebElement hoverOverDanhMuc = driver.findElement(By.xpath("//a[text()='Danh mục']"));
		Actions actionHoverDM = new Actions(driver);
		actionHoverDM.moveToElement(hoverOverDanhMuc).perform();

		WebElement hoverOverBongDa = driver.findElement(By.xpath("//a[text()='Bóng đá']"));
		Actions actionHoverBD = new Actions(driver);
		actionHoverBD.moveToElement(hoverOverBongDa).perform();

		WebElement hoverOverLTDBD = driver.findElement(By.xpath("//a[text()='Lịch thi đấu bóng đá']"));
		Actions actionHoverLTDBD = new Actions(driver);
		actionHoverLTDBD.moveToElement(hoverOverLTDBD).perform();
		driver.findElement(By.xpath("//a[text()='Lịch thi đấu bóng đá']")).click();
		String WebTitle = driver.getTitle();
		System.out.print(WebTitle + "\n");
		Assert.assertEquals("Lịch thi đấu Bóng Đá Anh, Ý TBN C1, Kết quả Tỉ lệ cược 24h", WebTitle);
		System.out.print(WebTitle + "\n");
	}
	
	@Test
	public void TC_03_Exercise3() {
		driver.get("http://jqueryui.com/resources/demos/selectable/display-grid.html");
		// doi voi list, xpath phai them "/li"
		List<WebElement> listItems = driver.findElements(By.xpath("//ol[@id='selectable']/li"));
		
		Actions actionClickAndHold = new Actions(driver);
		// doi voi list listItems.get(index),index luon tu gia tri=0
		actionClickAndHold.clickAndHold(listItems.get(0)).clickAndHold(listItems.get(7)).click().perform();

		actionClickAndHold.release();
		List<WebElement> listItemsSelected = driver.findElements(By.xpath("//li[@class='ui-state-default ui-selectee ui-selected']"));
		int numberOfList = listItemsSelected.size();
		System.out.print(numberOfList + "\n");
		Assert.assertEquals(numberOfList, 8);

	}

	@Test
	public void TC_04_Exercise4() {
		driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");

		WebElement rightBtn = driver.findElement(By.xpath("//span[text()='right click me']"));
		Actions actionRightBtn = new Actions(driver).contextClick(rightBtn);
		actionRightBtn.build().perform();

		WebElement hoverOuit = driver.findElement(By.xpath("//span[text()='Quit']"));
		Actions actionHoverQuit = new Actions(driver);
		actionHoverQuit.moveToElement(hoverOuit).perform();
		String LabelofQuit= hoverOuit.getText();
		System.out.print(hoverOuit);
		Assert.assertEquals("Quit", LabelofQuit);

	}
	@Test
	public void TC_05_Exercise5() {
		driver.get("http://www.seleniumlearn.com/double-click");
		
		WebElement btnDouble = driver.findElement(By.xpath("//button[text()='Double-Click Me!']"));
		Actions action = new Actions(driver);
		action.doubleClick(btnDouble).perform();


	}
	@Test
	public void TC_06_Exercise6() {
		driver.get("http://the-internet.herokuapp.com/drag_and_drop");
		
		WebElement dragFrom = driver.findElement(By.xpath("//div[@id='column-a']"));
		WebElement target = driver.findElement(By.xpath("//div[@id='column-b']"));
		Actions action = new Actions(driver);
		Action dragAndDrop = action.clickAndHold(dragFrom).moveToElement(target).release(target).build();
		dragAndDrop.perform();
		
		String headerExchange  = driver.findElement(By.xpath("//div[@id='column-b']//header")).getText();
		Assert.assertEquals("A",headerExchange);

	}
//	public void TC_07_Exercise7() {
//		driver.get("http://jqueryui.com/resources/demos/droppable/default.html");
//		
//		WebElement dragFrom = driver.findElement(By.xpath("//div[@id='draggable']"));
//		WebElement target = driver.findElement(By.xpath("//div[@id='droppable']"));
//		Actions action = new Actions(driver);
//		Action dragAndDrop = action.clickAndHold(dragFrom).moveToElement(target).release(target).build();
//		dragAndDrop.perform();
//		String headerExchange  = driver.findElement(By.xpath("//div[@id='droppable']//p")).getText();
//		Assert.assertEquals("Dropped!",headerExchange);
//
//	}
	@Test
	public void TC_07_Exercise7() {
		driver.get("http://demo.guru99.com/v4/");		
		WebElement userName=driver.findElement(By.xpath("//input[@name='uid']"));
		userName.sendKeys(Keys.TAB);
		WebElement Password =driver.findElement(By.xpath("//input[@name='password']"));
		Password.sendKeys("123456");
		
		Password.sendKeys(Keys.chord(Keys.SHIFT,"tab"));
		driver.findElement(By.xpath("//input[@name='uid']")).sendKeys("Ronaldo");
		userName.sendKeys(Keys.chord(Keys.CONTROL,"n"));
		
		driver.get("https://www.google.com/");
		String TitleOfGoogle=driver.getTitle();
		Assert.assertEquals(TitleOfGoogle, "Google");
	}

	@AfterClass
	public void afterClass() {
		//driver.quit();
	}

}
