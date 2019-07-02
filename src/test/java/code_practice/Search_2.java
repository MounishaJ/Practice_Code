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
		int count=0;
		
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
			search();
		}
		


		public void search()
		{
							 			 
	//serach functionality
			count=driver.findElements(By.xpath("//ul[@class='links']/li")).size(); //here da is common class name
			
			 for( int i=1;i<count-1;i++)
				{
					if (i==3)continue;
					
					titleverify1(i);
		 
				 Page p=new Page(driver);	
				 p.search().sendKeys("122222222222",Keys.ENTER);	
					
				// p.search().sendKeys(p.Searchedword().getText(),Keys.ENTER);	
						 
				 Assert.assertEquals(p.Searchedword().getText() ,p.search().getAttribute("value"),p.alertmessage().getText());
					System.out.println(p.alertmessage().getText());
					
			}
			
	}

		
		public void titleverify1(int i)
		{
							
		//title verify		
					 Page p=new Page(driver);	
					 p.Tabs().get(i).click();
					 Assert.assertEquals(p.Tabs().get(i).getText(),data[i]);
				System.out.println("title verified"+p.Tabs().get(i).getText());
				} 
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		private void titleverify(int i) {
			// TODO Auto-generated method stub
			
		}

		//text.equals("Tags")
		public void common_elem()
		{
			String text=null;
			int count=driver.findElements(By.xpath("//ul[@class='links']/li")).size(); //here da is common class name
			
			for(int i=1;i<count-1;i++)
			{

				 if(driver.findElements(By.xpath("//ul[@class='links']/li")).get(i).getText().contains("Tags")) 
					 
					 driver.findElements(By.xpath("//ul[@class='links']/li")).get(i);
				 
				 else				 				 
				 driver.findElements(By.xpath("//ul[@class='links']/li")).get(i).click();	 
			}
		}











}


