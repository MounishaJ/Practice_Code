package code_practice;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.Base;

public class Search_2 extends Base{
	 public static Logger log = LogManager.getLogger(CommonSearch.class.getName());
		public static Page p=new Page(driver);	
		
		
		@BeforeTest
		public void initialize() throws IOException, InterruptedException
		{
			driver= initializeDriver();
			log.info("Driver initialized successfully");	
			driver.get("https://projects.appdevelopment.com/bac_qa_43298787/");
			log.info("successfully launched URL");	
			
			driver.manage().window().maximize();
			
			driver.findElement(By.id("email")).sendKeys("mjeela@compindia.com");
			driver.findElement(By.id("password")).sendKeys("test123@");
			driver.findElement(By.id("login_submit")).click();
			log.info("sucessfully logged into the application");
			
			
			
		}

		@Test
		public void search2()
		{
		common_elem();
		}
		
		
		
		
		public void common_elem()
		{
			String text=null;
			int count=driver.findElements(By.xpath("//ul[@class='links']//li")).size(); //here da is common class name
			
			for(int i=0;i<count-1;i++)
			{
				 text=driver.findElements(By.xpath("//ul[@class='links']//li")).get(i).getText();
				 driver.findElements(By.xpath("//ul[@class='links']//li")).get(i).click();	 
			}
		}

}
