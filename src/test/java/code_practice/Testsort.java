package code_practice;

import java.io.IOException;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.Base;

public class Testsort extends Base{

 
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
		//p.truck_Tab().click();

	}



@Test
public void sort() throws InterruptedException
{
	
	int columncount=driver.findElements(By.xpath("//thead/tr/th")).size();
	for(int i=0;i<columncount;i++)
	{
		
	System.out.println("getattribute"+i+" "+driver.findElements(By.xpath("//thead/tr/th")).get(i).getAttribute("class"));
	String name=driver.findElements(By.xpath("//thead/tr/th")).get(i).getAttribute("class");
	if(name.endsWith("sorting"))
	{
		
		driver.findElements(By.xpath("//thead/tr/th")).get(i).click();
		Thread.sleep(2000);
				
		List<WebElement> Rows = driver.findElements(By.xpath("//tbody/tr"));
		System.out.println("rows"+Rows.size());
		int size=Rows.size();
		for (int j=1; j<=size; j++) 
		  { //find the columns in specific row
		  
			  List<WebElement> Columns = Rows.get(j).findElements(By.xpath("//tr"+"["+ j+"]"+"//td"));
			  String text =   Columns.get(i).getText(); 
			  System.out.println(text);
		  }}}}


	public void doing()
{
	WebElement tbl = driver.findElement(By.xpath("//tbody"));

	//check all row, identification with 'tr' tag
	List<WebElement> rows = tbl.findElements(By.tagName("tr"));

	for(int i=0; i<rows.size(); i++) {
	    //check column each in row, identification with 'td' tag
	    List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));

	for(int j=0; j<cols.size(); j++) {
	 System.out.println(cols.get(j).getText());
	}

	
}}
}



//int count=Columns.size();
//System.out.println("column countin row"+count );
/* 
for (int k =j; k <=j; k++ )
{
String text =   Columns.get(i).getText(); 
System.out.println(text);


}*/
