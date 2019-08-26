package code_practice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.Base;

public class Sortingdemo extends Base {


	public static Page p = new Page(driver);
	int count = 0;

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
		//p.truck_Tab().click();

	}
	
	@Test
	public void test1() throws InterruptedException
	{
	
List<String> Actual = new ArrayList<String>();
	
	int columncount=driver.findElements(By.xpath("//thead/tr/th")).size();
	//System.out.println("columncount"+columncount);
	for(int i=0;i<columncount;i++)
	{
		
	System.out.println("getattribute"+i+" "+driver.findElements(By.xpath("//thead/tr/th")).get(i).getAttribute("class"));
	String name=driver.findElements(By.xpath("//thead/tr/th")).get(i).getAttribute("class");
	if(name.endsWith("sorting"))
	{
		
		driver.findElements(By.xpath("//thead/tr/th")).get(i).click();
		Thread.sleep(2000);
		while (true) {
			Page p = new Page(driver);
			String name1 = p.Arrow().getAttribute("class");			
			List<WebElement> Rows = driver.findElements(By.xpath("//tr"));
			int size=Rows.size(); //10
			for (int j=1; j<size; j++) //10
			  { //find the columns in specific row
			  
		
				  List<WebElement> Columns = Rows.get(j).findElements(By.xpath("//tr"+"["+ j+"]"+"//td"));
		
				  Actual.add(Columns.get(i).getText()); 
				  Iterator it = Columns.iterator(); // name is present
					while (it.hasNext()) // next element is present or not

						it.next();
				}			
			
			scrolldown();
			if (!name1.contains("disabled")) {
				p.Arrow().click();
				Thread.sleep(2000);
				scrollup();
			} else if (name1.contains("disabled")) {
				break;
			}
		}
		
		System.out.println( Actual);
		
	}
		}
	
    }
}
	



