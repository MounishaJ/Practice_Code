package code_practice;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import resources.Base;



public class CommonSearch extends Base
{
	 public static Logger log = LogManager.getLogger(CommonSearch.class.getName());
		
			
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

	@Test(dataProvider = "getData1")
	public void common_Search(String tabname,WebElement elemenet)
	{
		Page p=new Page(driver);	
		elemenet.click();
		p.search().sendKeys(p.Searchedword().getText(),Keys.ENTER);	
			 
		 Assert.assertEquals(p.Searchedword().getText() ,p.search().getAttribute("value"));
		 log.info(tabname+"successfully validate search functionality");
	
		
	}
	
	
	

@DataProvider
public Object[][] getData1()
{
	Page p=new Page(driver);	
	
	Object[][] data=new Object[5][2];
	
	data[0][0]="Customer Module";
	data[0][1]=p.customer_Tab();
	
	
	data[1][0]="Trucks Module";
	data[1][1]=p.truck_Tab();
	
	data[2][0]="Products Module";
	data[2][1]=p.product_Tab();
	
	data[3][0]="Yards Module";
	data[3][1]=p.yard_Tab();
	
	data[4][0]="Users Module";
	data[4][1]=p.user_Tab();
	
	
		return data;
	
}




}
