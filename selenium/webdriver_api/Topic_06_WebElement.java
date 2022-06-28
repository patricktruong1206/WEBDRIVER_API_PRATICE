package webdriver_api;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_06_WebElement {
	WebDriver driver;
	String emailValue = "ace"+randomNumber()+"@gmail.com";

	By email =By.xpath("//input[@id='mail']");
	
	By passWord=By.xpath("//input[@id='password']");
	
	By ageUnder18 =By.xpath("//input[@id='under_18']");
	
	By education = By.xpath("//textarea[@id='edu']");
	
	By jobRole1 =By.xpath("//select[@id='job1']");
	
	By jobRole2 = By.xpath("//select[@id='job2']");
	
	By jobRole3 = By.xpath("//select[@id='job3']");
	
	By interest = By.xpath("//input[@id='development']");
	
	By interestDisabled =By.xpath("//input[@id='check-disbaled']");
	
	By interestDevelopment = By.xpath("//input[@id='development']");
	
	By biography = By.xpath("//textarea[@id='bio']");
	
	By slider01 = By.xpath("//input[@id='slider-1']");
	
	By slider02 = By.xpath("//input[@id='slider-2']");
	
	By ageDisabled = By.xpath("//input[@id='radio-disabled']");

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}

	@Test
	public void TC_01_VerifyDisplayed() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		if(isElementDisplayed(email)==true)
		{
			sendKeytoElement(email,emailValue);
		}		
		if(isElementDisplayed(ageUnder18)==true)
		{
			clickElement(ageUnder18);
		}	
		if(isElementDisplayed(education)==true)
		{
			sendKeytoElement(education,"automation testing");
		}	
	}
		

	@Test
	public void TC_02_VerifyIsEnable() {
		driver.get("https://automationfc.github.io/basic-form/index.html");
		isElementEnabled(email);
		isElementEnabled(ageUnder18);
		isElementEnabled(education);
		isElementEnabled(jobRole1);
		isElementEnabled(jobRole2);
		isElementEnabled(interestDevelopment);
		isElementEnabled(slider01);
		isElementEnabled(passWord);
		isElementEnabled(ageDisabled);
		isElementEnabled(biography);
		isElementEnabled(jobRole3);
		isElementEnabled(interestDisabled);
		isElementEnabled(slider02);		
	}

	public void sendKeytoElement(By by, String value) {
		driver.findElement(by).clear();
		driver.findElement(by).sendKeys(value);
	}
	
	public void clickElement(By by)
	{
		driver.findElement(by).click();
	}
	
	public boolean isElementDisplayed(By by) {
		if(driver.findElement(by).isDisplayed())
		{
			System.out.println("Element with locator["+ by +"] is displayed");
			return true;
		}
		else {
			System.out.println("Element with locator["+ by +"] is not displayed");
			return false;
		}	
	}
	
	public boolean isElementEnabled(By by) {
		if(driver.findElement(by).isDisplayed())
		{
			System.out.println("Element with locator["+ by +"] is enabled");
			return true;
		}
		else {
			System.out.println("Element with locator["+ by +"] is disable");
			return false;
		}	
	}
	
	public boolean isElementSelected(By by) {
		if(driver.findElement(by).isDisplayed())
		{
			System.out.println("Element with locator["+ by +"] is selected");
			return true;
		}
		else {
			System.out.println("Element with locator["+ by +"] is selected");
			return false;
		}	
	}
	
	public int randomNumber() {
		Random rand = new Random();
		int n = rand.nextInt(50);
		return n;
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}