package code_practice;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;

import resources.Base;

public class Sorting1 extends Base{

	public static Logger log = LogManager.getLogger(CommonSearch.class.getName());
	public static Page p = new Page(driver);
	int count = 0;

	@BeforeTest
	public void initialize() throws IOException, InterruptedException {
		driver = initializeDriver();
		log.info("Driver initialized successfully");
		driver.get("https://projects.appdevelopment.com/bac_qa_43298787/");
		log.info("successfully launched URL");

		driver.manage().window().maximize();

		driver.findElement(By.id("email")).sendKeys("mjeela@compindia.com");
		driver.findElement(By.id("password")).sendKeys("test123@");
		driver.findElement(By.id("login_submit")).click();
		log.info("sucessfully logged into the application");
		Page p = new Page(driver);
		p.customer_Tab().click();

		Assert.assertEquals(p.customer_Tab().getText(), "Customers");
		

	}

	@Test
	public void sort()
	{
		
	}
	
}
