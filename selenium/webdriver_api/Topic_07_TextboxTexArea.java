package webdriver_api;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_07_TextboxTexArea {
	WebDriver driver;
	String username= "mngr424737";
	String password= "pymEheq";
	String customerName= "phong"+randomNumber();
	String dob= "01/01/1990";
	String address= "35 Dien Bien Phu";
	String city= "Ho Chi Minh";
	String state= "10";
	String pin= "123456";
	String phone="0961630458";
	String email = "fake"+ randomNumber()+"@gmail.com";
	String passwordCus = "phong@123";
	
	
	
	By usernameTextbox = By.xpath("//input[@name='uid']");
	By passwordTextbox = By.xpath("//input[@name='password']");
	By loginBtn = By.xpath("//input[@name='btnLogin']");
	By welcomeText= By.xpath("//td[text()='Manger Id : mngr423134']");
	By newCustomer= By.xpath("//a[text()='New Customer']");
	By customerNameTextbox= By.xpath("//input[@name='name']");
	By genderMale= By.xpath("//input[@name='rad1' and @value='m']");
	By genderFemale= By.xpath("//input[@name='rad1' and @value='f']");
	By addressTextbox= By.xpath("//textarea[@name='addr']");
	By cityTextbox= By.xpath("//input[@name='city']");
	By stateTextbox= By.xpath("//input[@name='state']");
	By pinTextbox= By.xpath("//input[@name='pinno']");
	By phoneNumberTextbox= By.xpath("//input[@name='telephoneno']");
	By emailTextbox= By.xpath("//input[@name='emailid']");
	By submitBtn= By.xpath("//input[@name='sub']");
	

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", ".//libraries//chromedriveVer102.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void TC_01_() {
		driver.get("http://demo.guru99.com/v4");
		sendKeyToElement(usernameTextbox,username);
		sendKeyToElement(passwordTextbox,password);
		clickElement(loginBtn);
		Assert.assertEquals("Manger Id : "+username, driver.findElement(welcomeText).getText());
		clickElement(newCustomer);
		sendKeyToElement(customerNameTextbox,customerName);
		clickElement(genderFemale);
		sendkeyToElement(addressTextbox,address);
		sendkeyToElement(cityTextbox,city);
		sendkeyToElement(stateTextbox,state);
		sendkeyToElement();
		sendkeyToElement();
		sendkeyToElement();
		sendkeyToElement();
		sendkeyToElement();
		
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
	
	public void clickElement (By by) {
		driver.findElement(by).click();
	}
	
	public void sendKeyToElement (By by, String value) {
		driver.findElement(by).clear();
		driver.findElement(by).sendKeys(value);
	}
	
	public boolean isElementDisplayed(By by) {
		if(driver.findElement(by).isDisplayed()) {
			System.out.println("Locator"+by+"is displayed");
			return true;
		}
		else 
		{
			System.out.println("Locator"+by+"is not displayed");
			return false;
		}	
	} 
	public boolean isElementSelected(By by) {
		if(driver.findElement(by).isSelected()) {
			System.out.println("Locator"+by+"is displayed");
			return true;
		}
		else 
		{
			System.out.println("Locator"+by+"is not displayed");
			return false;
		}	
	} 
	
	public boolean isElementEnabled(By by) {
		if(driver.findElement(by).isEnabled()) {
			System.out.println("Locator"+by+"is displayed");
			return true;
		}
		else 
		{
			System.out.println("Locator"+by+"is not displayed");
			return false;
		}	
	} 
	
	public int randomNumber() {
		Random rand = new Random();
		int n = rand.nextInt();
		return n;
	}
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}