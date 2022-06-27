package webdriver_api;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_04_05_Xpath_Login {
	WebDriver driver;
	String url ="https://alada.vn/tai-khoan/dang-ky.html";
    String nameId= "txtFirstname";
    String emailId= "txtEmail";
    String confirmEmailId= "txtCEmail";
    String passwordId= "txtPassword";
    String confirmPasswordId= "txtCPassword";
    String telephoneId= "txtPhone";
    
	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}
	/*
	@Test
	public void TC_01_RegisterWithEmptyData() {
		driver.get(url);
		driver.findElement(By.xpath("//div[@class='form frmRegister']//button[text()='ĐĂNG KÝ']")).click();
		driver.findElement(By.id("txtFirstname-error")).getText();
		Assert.assertEquals(driver.findElement(By.id("txtFirstname-error")).getText(),"Vui lòng nhập họ tên");
		Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(),"Vui lòng nhập email");
		Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(),"Vui lòng nhập lại địa chỉ email");
		Assert.assertEquals(driver.findElement(By.id("txtPassword-error")).getText(),"Vui lòng nhập mật khẩu");
		Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(),"Vui lòng nhập lại mật khẩu");
		Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(),"Vui lòng nhập số điện thoại.");
			
	}
	

	@Test
	public void TC_02_RegisterWithInvalidEmail() {
		driver.get(url);
		driver.findElement(By.id(nameId)).sendKeys("Jack Sparrow");
		driver.findElement(By.id(passwordId)).sendKeys("123456");
		driver.findElement(By.id(confirmPasswordId)).sendKeys("123456");
		driver.findElement(By.id(telephoneId)).sendKeys("0968460789");
		driver.findElement(By.xpath("//div[@class='form frmRegister']//button[text()='ĐĂNG KÝ']")).click();
		Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(),"Vui lòng nhập email");
		Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(),"Vui lòng nhập lại địa chỉ email");		
	}
	

	@Test
	public void TC_03_RegisterWithIncorrectConfirmEmail() {
		driver.get(url);
		driver.findElement(By.id(nameId)).sendKeys("Jack Sparrow");
		driver.findElement(By.id(emailId)).sendKeys("ace@mailinator.com");
		driver.findElement(By.id(confirmEmailId)).sendKeys("jace@mailinator.com");
		driver.findElement(By.id(passwordId)).sendKeys("123456");
		driver.findElement(By.id(confirmPasswordId)).sendKeys("123456");
		driver.findElement(By.id(telephoneId)).sendKeys("0968460789");
		driver.findElement(By.xpath("//div[@class='form frmRegister']//button[text()='ĐĂNG KÝ']")).click();
		Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(),"Email nhập lại không đúng");	
	}
	
	@Test
	public void TC_04_RegisterWithPasswordLessthan6Characters() {
		driver.get(url);
		driver.findElement(By.id(nameId)).sendKeys("Jack Sparrow");
		driver.findElement(By.id(emailId)).sendKeys("ace@mailinator.com");
		driver.findElement(By.id(confirmEmailId)).sendKeys("ace@mailinator.com");
		driver.findElement(By.id(passwordId)).sendKeys("12345");
		driver.findElement(By.id(confirmPasswordId)).sendKeys("12345");
		driver.findElement(By.id(telephoneId)).sendKeys("0968460789");
		driver.findElement(By.xpath("//div[@class='form frmRegister']//button[text()='ĐĂNG KÝ']")).click();
		Assert.assertEquals(driver.findElement(By.id("txtPassword-error")).getText(),"Mật khẩu phải có ít nhất 6 ký tự");
		Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(),"Mật khẩu phải có ít nhất 6 ký tự");
	}
		
	@Test
	public void TC_05_RegisterWithIncorrectPassword() {
		driver.get(url);
		driver.findElement(By.id(nameId)).sendKeys("Jack Sparrow");
		driver.findElement(By.id(emailId)).sendKeys("ace@mailinator.com");
		driver.findElement(By.id(confirmEmailId)).sendKeys("ace@mailinator.com");
		driver.findElement(By.id(passwordId)).sendKeys("123456");
		driver.findElement(By.id(confirmPasswordId)).sendKeys("1234568");
		driver.findElement(By.id(telephoneId)).sendKeys("0968460789");
		driver.findElement(By.xpath("//div[@class='form frmRegister']//button[text()='ĐĂNG KÝ']")).click();
		Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(),"Mật khẩu bạn nhập không khớp");
	}
	*/
	
	@Test
	public void TC_06_RegisterWithInvalidPhoneNumber() {
		driver.get(url);
		driver.findElement(By.id(nameId)).sendKeys("Jack Sparrow");
		driver.findElement(By.id(emailId)).sendKeys("ace@mailinator.com");
		driver.findElement(By.id(confirmEmailId)).sendKeys("ace@mailinator.com");
		driver.findElement(By.id(passwordId)).sendKeys("1234568");
		driver.findElement(By.id(confirmPasswordId)).sendKeys("1234568");
		driver.findElement(By.id(telephoneId)).sendKeys("096079");
		driver.findElement(By.xpath("//div[@class='form frmRegister']//button[text()='ĐĂNG KÝ']")).click();
		Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(),"Số điện thoại phải từ 10-11 số.");
		driver.findElement(By.id(telephoneId)).clear();
		driver.findElement(By.id(telephoneId)).sendKeys("960324324234");	
	}
	
	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}