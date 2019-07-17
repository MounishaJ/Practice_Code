package code_practice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.Base;

public class Test1 extends Base {

	@BeforeTest
	public void initialize() throws IOException, InterruptedException {
		driver = initializeDriver();
		driver.get("https://projects.appdevelopment.com/bac_qa_43298787/");
		driver.manage().window().maximize();
		driver.findElement(By.id("email")).sendKeys("mjeela@compindia.com");
		driver.findElement(By.id("password")).sendKeys("test123@");
		driver.findElement(By.id("login_submit")).click();

		Page p = new Page(driver);
		p.customer_Tab().click();

		Assert.assertEquals(p.customer_Tab().getText(), "Customers");
	}

	@Test
	public void run() throws InterruptedException
	{
		List<String> m=mouni();
		System.out.println(m);
		Collections.sort(m);
		List<String> x=m;
		System.out.println(x);
		
	}
	
	
public List<String> mouni() throws InterruptedException {

	List<String> Actual = new ArrayList<String>();
	Page p = new Page(driver);
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
			break;
		}
	}
	return Actual;
}
}