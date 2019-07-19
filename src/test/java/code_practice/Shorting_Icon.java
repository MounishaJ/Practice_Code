package code_practice;

import java.io.IOException;
import java.util.ArrayList;
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







public void verify()
{

List<WebElement> Rows = driver.findElements(By.xpath("//tbody/tr"));

System.out.println("No of Rows in the table" + Rows.size());

for (int i = 1; i < Rows.size()-1; i++)
{ 
    //find the columns in specific row
    List<WebElement> Columns = Rows.get(i).findElements(By.xpath("//td"));
    System.out.println("No of Columns in the table" + Columns.size()  );

    for (int j = 1; j <Columns.size()-1; j++ )
    {
        String text = Columns.get(j).getText();
        System.out.println(text);

        /* adjust as you needed.
        if(identifyvalue.equalsIgnoreCase(text))
        {
            leavecount = leavecount+1;
            System.out.println("Leavecounttilldate" + leavecount );
        }
        */
    }
} 
}

	
	public void test1()
	{
List<WebElement> rows = driver.findElements(By.xpath("//tbody/tr"));
WebElement icon=driver.findElement(By.xpath("//span[contains(@class,'sorting')]/parent::*"));
if(icon.isDisplayed())
{
	for (WebElement tr : rows) 
{
   List<WebElement> columns = tr.findElements(By.tagName("td"));
   for (WebElement td: columns) 
   {
      System.out.println(td.getText());
   }
}
}
}

@Test
public void test2()
{

List<WebElement> rows = driver.findElements(By.xpath("//tbody//tr"));
List<ArrayList<String>> rowsData = new ArrayList<ArrayList<String>>();
ArrayList<String> rowData = new ArrayList<String>();

for(WebElement row:rows){
    List<WebElement> rowElements = row.findElements(By.xpath(".//td"));

    for(WebElement column:rowElements){
        rowData.add(column.getText().toString());
    }

    rowsData.add(rowData);
}
System.out.println(rowData);


}




}
/*
 * List allHeadersOfTable2= driver.findElements(By.xpath("//table[@name='BookTable']/tbody/tr[1]/th"));
for(int k=0;k&lt;allHeadersOfTable2.size();k++)
{
	if(allHeadersOfTable2.get(k).getText().equalsIgnoreCase("price"))
	{
		System.out.println("Column index of Price column is: "+(k+1));
	}
				
}
 * 
 * 	public void test1()

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

https://stackoverflow.com/questions/36263315/java-selenium-webdriver-get-cell-value-from-table
https://www.guru99.com/handling-dynamic-selenium-webdriver.html
http://www.software-testing-tutorials-automation.com/2014/05/how-to-extract-table-dataread-table.html


*/