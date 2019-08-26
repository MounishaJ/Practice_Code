package code_practice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.Base;

public class filter extends Base
{
	
	//23-8-19 and 26-8-19
	
	
	List<String> Actual = new ArrayList<String>();
	@BeforeTest
	public void initialize() throws IOException, InterruptedException {
		
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
	public void singlefilter() throws InterruptedException
		{
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='add icon-plus']")).click();
		String label=driver.findElement(By.xpath("//div[@class='fil_heading']")).getText();
		//Object label1=label;
		//System.out.println(label);
		Select registerstatus=new Select(driver.findElement(By.id("filter_type")));
		registerstatus.selectByVisibleText("Registered");
		driver.findElement(By.xpath("//input[@id='filter_del_submit']")).click();
		
		Thread.sleep(3000);
		
		
//webtable info	
		int columncount=driver.findElements(By.xpath("//thead/tr/th")).size();
		System.out.println(columncount);   
		for(int i=0;i<columncount;i++)
		{
			
		//System.out.println("getattribute"+i+" "+driver.findElements(By.xpath("//thead/tr/th")).get(i).getText());
		String name=driver.findElements(By.xpath("//thead/tr/th")).get(i).getText();
		//System.out.println(name);
		if(name.equals(label))
		{
			System.out.println("both are same"+i);
		
			while (true) 
			{
				Page p = new Page(driver);
				String name1 = p.Arrow().getAttribute("class");	
			
			List<WebElement> Rows = driver.findElements(By.xpath("//tr"));
			int size=Rows.size(); //10
			//System.out.println(size);
			for (int j=1; j<size; j++) //10
			  { 
			//find the columns in specific row
			//	Rows.get(j).findElements(By.xpath("//tr"+"["+ j +"]"+"//td"));
		
				
			List<WebElement> Columns = Rows.get(j).findElements(By.xpath("//tr"+"["+ j +"]"+"//td"));
			//System.out.println((Columns.get(i).getText())); 
						
			Actual.add(Columns.get(i).getText());
						
			Iterator it = Columns.iterator(); // name is present
			while (it.hasNext()) // next element is present or not
			it.next();
			}	
			scrolldown();
			Thread.sleep(2000);
			if (!name1.contains("disabled")) {
			p.Arrow().click();
			Thread.sleep(2000);
			scrollup();
			} else if (name1.contains("disabled")) {
			break;
			}
			}
		}
		}
		String text=driver.findElement(By.xpath("//select[@id='filter_type']//option[@value='R'][contains(text(),'Registered')]")).getText();
		System.out.println(text);
		Object o=text;
		
		String count=driver.findElement(By.xpath("//span[@id='total_result_count']")).getText().replaceAll("[\\(){}]","");
	    Integer countvalue=Integer.parseInt(count);
		//System.out.println(countvalue);
		
		System.out.println("Array list size "+Actual.size());
			 for(int i=0;i<Actual.size();i++)
				{
				
					//System.out.println(Actual.get(i));
					
					Assert.assertEquals(o,(Actual.get(i)));
					
					
				}
		    Assert.assertTrue(countvalue.equals(Actual.size()));
			 
		/*
		 * if(countvalue.equals(Actual.size())) { System.out.println("count matches"); }
		 * else System.out.println("not matched count value");
		 *//*
		 * if(countvalue.equals(Actual.size())) {
		 * System.out.println("count value matched"+" "+countvalue+" "+Actual.size()); }
		 * else System.out.println("not mached"+countvalue);
		 */	 
						
			/*
			 * if(o.equals(Actual.get(i))) { System.out.println("matching"+
			 * Actual.get(i)+" "+o); } else {
			 * System.out.println("not matched"+Actual.get(i)+" "+o); }
			 */						 
		
		
		}
		
			
			
}