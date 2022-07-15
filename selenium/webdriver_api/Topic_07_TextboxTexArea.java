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
	String Editaddress= "35 Dien Bien Phu";
	String Editcity= "Ho Chi Minh";
	String Editstate= "10";
	String Editpin= "123456";
	String Editphone="0961630458";
	String Editemail = "fake"+ randomNumber()+"@gmail.com";
	
	
	By usernameTextbox = By.xpath("//input[@name='uid']");
	By passwordTextbox = By.xpath("//input[@name='password']");
	By loginBtn = By.xpath("//input[@name='btnLogin']");
	By welcomeText= By.xpath("//td[text()='Manger Id : mngr423134']");
	By newCustomer= By.xpath("//a[text()='New Customer']");
	By editCustomer = By.xpath("//a[text()='Edit Customer']");
	By customerIdTextbox= By.xpath("//input[@name='cusid']");
	By customerNameTextbox= By.xpath("//input[@name='name']");
	By genderMale= By.xpath("//input[@name='rad1' and @value='m']");
	By genderFemale= By.xpath("//input[@name='rad1' and @value='f']");
	By addressTextbox= By.xpath("//textarea[@name='addr']");
	By cityTextbox= By.xpath("//input[@name='city']");
	By stateTextbox= By.xpath("//input[@name='state']");
	By pinTextbox= By.xpath("//input[@name='pinno']");
	By phoneNumberTextbox= By.xpath("//input[@name='telephoneno']");
	By emailTextbox= By.xpath("//input[@name='emailid']");
	By registerSubmitBtn= By.xpath("//input[@name='sub']");
	By editSubmitBtn= By.xpath("//input[@name='AccSubmit']");
	By customerIdResult= By.xpath("//td[text()='Customer ID']/following-sibling::td");
	By customerNameResult= By.xpath("//td[text()='Customer Name']/following-sibling::td");
	By genderResult= By.xpath("//td[text()='gender']/following-sibling::td");
	By birthDateResult= By.xpath("//td[text()='Birthdate']/following-sibling::td");
	By addressResult= By.xpath("//td[text()='Address']/following-sibling::td");
	By cityResult= By.xpath("//td[text()='City']/following-sibling::td");
	By stateResult= By.xpath("//td[text()='State']/following-sibling::td");
	By pinResult= By.xpath("//td[text()='Pin']/following-sibling::td");
	By phoneResult= By.xpath("//td[text()='Mobile No.']/following-sibling::td");
	By emailResult= By.xpath("//td[text()='email']/following-sibling::td");
	
	
	
	

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", ".//libraries//chromedriveVer102.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void TC_01_() throws InterruptedException {
		driver.get("http://demo.guru99.com/v4");
		sendKeyToElement(usernameTextbox,username);
		sendKeyToElement(passwordTextbox,password);
		clickElement(loginBtn);
		Thread.sleep(3000);
		Assert.assertEquals("Manger Id : "+username, driver.findElement(welcomeText).getText());
		clickElement(newCustomer);
		sendKeyToElement(customerNameTextbox,customerName);
		clickElement(genderFemale);
		sendKeyToElement(addressTextbox,address);
		sendKeyToElement(cityTextbox,city);
		sendKeyToElement(stateTextbox,state);
		sendKeyToElement(pinTextbox,pin);
		sendKeyToElement(phoneNumberTextbox,phone);
		sendKeyToElement(emailTextbox,email);
		sendKeyToElement(passwordTextbox,passwordCus);
		
		clickElement(registerSubmitBtn);
		
		String customerId = getTextElement(customerIdResult);
		
		Assert.assertEquals(getTextElement(customerNameResult), customerName);
		Assert.assertEquals(getTextElement(genderResult), "female");
		Assert.assertEquals(getTextElement(birthDateResult), dob);
		Assert.assertEquals(getTextElement(addressResult), address);
		Assert.assertEquals(getTextElement(cityResult), city);
		Assert.assertEquals(getTextElement(stateResult), state);
		Assert.assertEquals(getTextElement(pinResult), pin);
		Assert.assertEquals(getTextElement(phoneResult), phone);
		Assert.assertEquals(getTextElement(emailResult), email);
		
		clickElement(editCustomer);
		sendKeyToElement(customerIdTextbox,customerId);
		clickElement(editSubmitBtn);
		Assert.assertEquals(getTextElement(customerNameTextbox), customerName);
		Assert.assertEquals(getTextElement(addressTextbox), address);
		
		sendKeyToElement(addressTextbox,Editaddress);
		sendKeyToElement(cityTextbox,Editcity);
		sendKeyToElement(stateTextbox,Editstate);
		sendKeyToElement(pinTextbox,Editpin);
		sendKeyToElement(phoneNumberTextbox,Editphone);
		sendKeyToElement(emailTextbox,Editemail);
		
		clickElement(registerSubmitBtn);
		
		Assert.assertEquals(driver.switchTo().alert().getText(), "No Changes made to Customer records");

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
	
	public String getTextElement(By by)
	{
		return driver.findElement(by).getText();
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