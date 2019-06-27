package code_practice;

import java.io.IOException;
import java.util.ArrayList;
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

public class Search_1 extends Base {
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
		public void common_Search()
		{
			Page p=new Page(driver);
			WebElement x[]=data();
			for (int i=0;i<x.length;i++)
			{									
				x[i].click();
				String tabname= driver.getTitle();
				
				p.search().sendKeys(p.Searchedword().getText(),Keys.ENTER);	
					 
				 Assert.assertEquals(p.Searchedword().getText() ,p.search().getAttribute("value"));
				 log.info(tabname+"successfully validate search functionality");
			}
					
		}
					
	public WebElement[] data()
	{
		Page p=new Page(driver);
		
		WebElement  tabs[]=new WebElement[5];
		tabs[0]=p.customer_Tab();
		tabs[1]=p.truck_Tab();
		tabs[2]=p.product_Tab();
		tabs[3]=p.yard_Tab();
		tabs[4]=p.user_Tab();
		
		return tabs;
	
			
	}
	
	
	
	
	
	
}
