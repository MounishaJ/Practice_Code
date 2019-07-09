package code_practice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.Base;

public class Sorting extends Base {

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
	 public void l1() throws InterruptedException 
	 { 
		 List<String> mouni=List12();
		 System.out.println("unsorted array list items"+mouni);
		Collections.sort(mouni); 
		System.out.println("sorted array list items"+mouni);
		log.info("Comapny logs"+mouni); driver.quit();
		 }
	
	   



	public List<String> List12() throws InterruptedException
	{
		 List<String> Actual=new ArrayList<String>();
		
		Page p=new Page(driver);

		for(int i=0;i<23;i++)
		{
		int count=p.Name().size();
			for(int j=0;j<count;j++) 
			{
				
			Actual.add(p.Name().get(j).getText());
			System.out.println(p.Name().get(j).getText());
			 Iterator it = p.Name().iterator();   //name is present
			 while (it.hasNext())    //next element is present or not
				 
				it.next();
			}
		
			if(i==22)
			{	
				break;
			}
			else
			{
			scrolldown();
			p.getNextpage().click();
			Thread.sleep(2000);
			scrollup();	
		
			}
		}
		return Actual;
}
}































//staleelemnet exception

/**
 * 
 * 
 * 
	 public void pagecount()
	 {
		 Page p=new Page(driver);
		 
		
			String y=p.pcount().getAttribute("textContent");
		int m=Integer.parseInt(y);
		System.out.println(m+"m value"+y+"y value");
		
		System.out.println(m);
		
		//int u=Integer.parseInt(p.pcount().getAttribute("text"));
		//System.out.println((p.pcount().getAttribute("text")));
		
	
	 }
 
 * Retrieve the List of Items in the Table before Sorting and Store into Array
 * 
 * List<WebElement> tdList =
 * driver.findElements(By.xpath("//table[@id='myTable']/tbody/tr/td[1]"));
 * String strArray[] = new String[tdList.size()]; for(int i
 * =0;i<tdList.size();i++) { System.out.println(tdList.get(i).getText());
 * strArray[i]=tdList.get(i).getText(); }
 * 
 * 
 * 
 * 
 * 
 * // Grab the table WebElement table =
 * driver.findElement(By.id("customer_list"));
 * 
 * // Now get all the TR elements from the table List<WebElement> allRows =
 * table.findElements(By.tagName("tr"));
 * 
 * // And iterate over them, getting the cells for (WebElement row : allRows) {
 * List<WebElement> cells = row.findElements(By.tagName("td"));
 * 
 * // Print the contents of each cell for (WebElement cell : cells) {
 * System.out.println(cell.getText()); } }
 * 
 * 
 * 
 * 
 * //Page p=new Page(driver);
 * 
 * /* for(int i=0;i<=23;i++) { int count=p.listallrows().size(); for(int
 * j=0;j<count-1;j++) { System.out.println(p.data().get(i).getText()); }
 * //System.out.println(count); scroll(p.scrollingdown());
 * p.pagearrow().click();
 */
