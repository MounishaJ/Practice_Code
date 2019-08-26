package code_practice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.Base;

public class Add_Customer extends Base {
	
	//26-8-2019
	
	@BeforeTest
	public void initialize() throws IOException, InterruptedException 
		{
		System.setProperty("webdriver.chrome.driver", "F://Web Drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://projects.appdevelopment.com/bac_qa_43298787/");
		driver.manage().window().maximize();
		driver.findElement(By.id("email")).sendKeys("mjeela@compindia.com");
		driver.findElement(By.id("password")).sendKeys("test123@");
		driver.findElement(By.id("login_submit")).click();

		Thread.sleep(5000);
		Page p = new Page(driver);
		p.customer_Tab().click();

		Assert.assertEquals(p.customer_Tab().getText(), "Customers");
		}
	
	
	@Test
		public void add_customers() throws InterruptedException
		{
		driver.findElement(By.xpath("//div[@class='them_btn add_customer']")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@id='busniess']")).sendKeys("MOUNISHA_2128");
		Select Customer_Type=new Select(driver.findElement(By.xpath("//select[@id='customer_type']")));
		Customer_Type.selectByVisibleText("Wet & Dry");
		
		driver.findElement(By.xpath("//input[@id='phone']")).sendKeys("8749040360");
		driver.findElement(By.xpath("//input[@id='address']")).sendKeys("Mounisha Exports pvtltd");
		driver.findElement(By.xpath("//input[@id='city']")).sendKeys("Chennai");
		
		Select State=new Select(driver.findElement(By.xpath("//select[@id='state']")));
		State.selectByVisibleText("New York");
		
		driver.findElement(By.xpath("//input[@id='zip']")).sendKeys("631202");
		driver.findElement(By.xpath("//input[@id='fax']")).sendKeys("Test123");
		driver.findElement(By.xpath("//input[@id='tax_id']")).sendKeys("Tax_123");
		driver.findElement(By.xpath("//input[@id='primary_contact']")).sendKeys("JeelaMounisha");
		driver.findElement(By.xpath("//input[@id='primary_phone']")).sendKeys("8247878238");
		driver.findElement(By.xpath("//input[@id='primary_email']")).sendKeys("JeelaMounisha2128@gmail.com");
		driver.findElement(By.xpath("//input[@id='contractor_license_no']")).sendKeys("2128");
		
		
		driver.findElement(By.xpath("//input[@id='customers_del_submit']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='modal-footer']//button[@class='btn yes bootbox-accept']")).click();
		Thread.sleep(3000);
		add_job();
		}
	public void add_job()
	{
		driver.findElement(By.xpath("//input[@id='job_name']")).sendKeys("myjob228");
		driver.findElement(By.xpath("//input[@id='job_po_number']")).sendKeys("mypo2128");
		driver.findElement(By.xpath("//input[@id='job_location']")).sendKeys("Tamilnadhu");
		driver.findElement(By.xpath("//input[@id='street']")).sendKeys("Cholaimedu");
		driver.findElement(By.xpath("//input[@id='job_city']")).sendKeys("chennai");
		driver.findElement(By.xpath("//input[@id='manager_name']")).sendKeys("Mounisha");
		driver.findElement(By.xpath("//input[@id='manager_email']")).sendKeys("Mounisha2893@gmail.com");
		driver.findElement(By.xpath("//input[@id='manager_phone']")).sendKeys("8247878238");
		driver.findElement(By.xpath("//input[@id='job_del_submit']")).click();
		}
	
}
