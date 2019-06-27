package code_practice;
import java.util.Properties;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Page {
	
	
	public static WebDriver driver;
	public static Properties prop;
	
	
	@FindBy(xpath="//input[@type='search']")
	WebElement searchfield;
	
	
	
	@FindBy(xpath="//tr[@class='odd']//td[2]")
	WebElement searchingword;

	@FindBy(xpath="//span[contains(text(),'Customers')]")
	WebElement customertab;
	
	@FindBy(xpath="//span[contains(text(),'Trucks')]")
	WebElement trucktab;
	
	@FindBy(xpath="	//span[contains(text(),'Products')]")
	WebElement producttab;
	
	@FindBy(xpath="//span[contains(text(),'Yards')]")
	WebElement yardtab;
	
	@FindBy(xpath="//span[contains(text(),'Users')]")
	WebElement usertab;
	

	public WebElement customer_Tab()
	{
		
		return customertab;
	}
	public WebElement truck_Tab()
	{
		
		return trucktab;
	}
	public WebElement product_Tab()
	{
		
		return producttab;
	}
	public WebElement yard_Tab()
	{
		
		return yardtab;
	}
	
	public WebElement user_Tab()
	{
		
		return usertab;
	}
	

	public WebElement search()
	{
		
		return searchfield;
	}

	public WebElement Searchedword()
	{
		return searchingword;
	}
	
	
	
	
	
	
	public Page(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	

}
