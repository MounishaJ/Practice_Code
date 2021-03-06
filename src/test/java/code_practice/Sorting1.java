package code_practice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import resources.Base;

public class Sorting1 extends Base {

	public static Logger log = LogManager.getLogger(CommonSearch.class.getName());
	//public static Page p = new Page(driver);
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
		System.out.println("Custoner");
	}

	@Test
	public List<String> mouni() throws InterruptedException {

		List<String> Actual = new ArrayList<String>();
		Page p=new Page(driver);
		while (true) {
			String name = p.Arrow().getAttribute("class");
			int count = p.Name().size();
			for (int j = 0; j < count; j++) {

				Actual.add(p.Name().get(j).getText());
				System.out.println(p.Name().get(j).getText());
				Iterator it = p.Name().iterator(); // name is present
				while (it.hasNext()) // next element is present or not

					it.next();
			}
			scrolldown();
		if (!name.contains("disabled")) {
		p.Arrow().click();
		Thread.sleep(2000);
	   scrollup();
		} else if (name.contains("disabled")) {
		driver.quit();
		}
		}
	}
}

/*
 * 
 * @Test
 * 
 * public void List12() throws InterruptedException { List<String> Actual=new
 * ArrayList<String>();
 * 
 * Page p=new Page(driver);
 * 
 * while(true) { int count=p.Name().size(); for(int j=0;j<count;j++) {
 * 
 * Actual.add(p.Name().get(j).getText());
 * System.out.println(p.Name().get(j).getText()); Iterator it =
 * p.Name().iterator(); //name is present while (it.hasNext()) //next element is
 * present or not
 * 
 * it.next(); } scrolldown(); if(p.pagedisable().isDisplayed()) {
 * driver.close(); } else { p.getNextpage().click(); } Thread.sleep(2000);
 * scrollup();
 * 
 * }
 * 
 * 
 * 
 * } }
 */