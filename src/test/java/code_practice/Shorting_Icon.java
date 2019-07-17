package code_practice;

import java.io.IOException;
import java.util.Iterator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.Base;

public class Shorting_Icon extends Base {

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

		
	}

	
	
	@Test
	public void demo()
	{
		Page p=new Page(driver);
		Assert.assertEquals(p.customer_Tab().getText(), "Customers");
		int size=driver.findElements(By.xpath("//span[contains(@class,'sorting')]/parent::*")).size();
		
		System.out.println(size);
		for(int i=0;i<size;i++)
		{
			String name=driver.findElements(By.xpath("//span[contains(@class,'sorting')]/parent::*")).get(i).getText();
			System.out.println(" name"+ name);
			driver.findElements(By.xpath("//span[contains(@class,'sorting')]/parent::*")).get(i).click();
			System.out.println("successfully clicked"+name);
		}
		//Iterator it = p.Name().iterator(); // name is present
	//	while (it.hasNext()) // next element is present or not

		//	it.next();
	}

}














/*	public void test1()
	{
		for(int i=0;i<23;i++)
		{
			for(int j=0;j<9;j++)
			{
				WebElement icon=driver.findElement(By.xpath("//span[@class=\"icon-sort-up-or-sort-down-couple-of-arrows sorting_icon\"]"));
				if(icon.isDisplayed())
				{
					System.out.println(j);
				}
			}
		}
	}
}
*/