package webdriver_api;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_01_Template {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", ".//libraries//chromedriveVer102.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}

	@Test
	public void TC_01_() {
		driver.get("https://kyna.vn/");
		
		driver.findElement(By.xpath("//img[@alt='facebook']")).click();
		
	}
/*
	@Test
	public void TC_02_() {
		driver.get("");
	}
	@Test
	public void TC_03_() {
		driver.get("");
	}
	*/
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}