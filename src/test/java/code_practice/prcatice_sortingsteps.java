package code_practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.Base;

public class prcatice_sortingsteps extends Base {

	@BeforeTest
	public void login()
	{
//Login into the application
		System.setProperty("webdriver.chrome.driver", "F://Web Drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://projects.appdevelopment.com/bac_qa_43298787/");
		driver.manage().window().maximize();
		driver.findElement(By.id("email")).sendKeys("mjeela@compindia.com");
		driver.findElement(By.id("password")).sendKeys("test123@");
		driver.findElement(By.id("login_submit")).click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//Go to customer module		
		Page p = new Page(driver);
		p.customer_Tab().click();
	}

	
	
	@Test
	public void getlist() throws InterruptedException
	{
//created empty lists		
		List<String> original = new ArrayList<String>();
		List<String> descending=new ArrayList<String>();
//prints columns count		
		int columncount=driver.findElements(By.xpath("//thead/tr/th")).size();
		System.out.println(columncount);   
		for(int i=0;i<columncount;i++)
		{
			
		System.out.println("getattribute"+i+" "+driver.findElements(By.xpath("//thead/tr/th")).get(i).getAttribute("class"));
		String name=driver.findElements(By.xpath("//thead/tr/th")).get(i).getAttribute("class");
//checks sorting option is present or not
		if(name.endsWith("sorting"))
		{
		Loop:
			while (true) {
			Page p = new Page(driver);
			String name1 = p.Arrow().getAttribute("class");			
			List<WebElement> Rows = driver.findElements(By.xpath("//tr"));
			int size=Rows.size(); //10
			for (int j=1; j<size; j++) //10
			  { //find the columns in specific row
			List<WebElement> Columns = Rows.get(j).findElements(By.xpath("//tr"+"["+ j+"]"+"//td"));
			original.add(Columns.get(i).getText()); 
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
//Go and click arrow to move 1st page			
			driver.findElement(By.xpath("//span[@class='paginate_button first icon-double_left']")).click();
			driver.findElements(By.xpath("//thead/tr/th")).get(i).click();
			Thread.sleep(2000);
			//continue Loop;
			ArrayList<String>sortedList  = new ArrayList<String>();   
			for(String s:original){
			sortedList.add(s);
			}
			Collections.sort(sortedList, Collections.reverseOrder());
			Assert.assertTrue(sortedList.equals(descending));
			}
			}
//get the customer list column data and store it in arraylist			
			//System.out.println( original);
			
	    }
	
	}
}