package code_practice;
import java.util.List;
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
	
	@FindBy(xpath="//ul[@class='links']/li")
	List<WebElement> alltabs;

	@FindBy(xpath="//td[@class='dataTables_empty']")
	WebElement errormsg;
	
	
	
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
	public List<WebElement> Tabs()
	{
		return alltabs;
	}
	
	public WebElement alertmessage()
	{
		return errormsg;
	}
	
	
	
	

	@FindBy(xpath="//tr/td")
	List<WebElement> rowdata;
	public List<WebElement>  data()
	{
		return rowdata;
	}
	
	@FindBy(xpath="//tbody/tr[@role='row']")
	List<WebElement> allrows;
	public List<WebElement> listallrows()
	{
		return allrows;
	}
	

	@FindBy(xpath="//div[@id='customer_list_paginate']")
	WebElement scrolldown;
	public WebElement scrollingdown()
	{
		return scrolldown;
	}
	@FindBy(xpath="//div[@class='main_header clearfix']")
	WebElement scrollup;
	public WebElement scrollingup()
	{
		return scrollup;
	}
	
	
	@FindBy(xpath="//span[@class='paginate_button next icon-right-arrow x_small']")
	WebElement nextpage;
		
	public WebElement getNextpage() {
		return nextpage;
	}
	
	
	@FindBy(xpath="//span[@class='paginate_button next icon-right-arrow x_small disabled']")
	WebElement disablepagearrow;
	public WebElement pageArrowDisable()
	{
		return disablepagearrow;
	}
	
	@FindBy(xpath="//span[contains(@class,'icon-right-arrow x_small disabled')]")
	WebElement darrow;
	public WebElement pagedisable()
	{
		return darrow;
	}
	
	
	
	@FindBy(xpath="//td[@class=' capitalize'][1]")
	List <WebElement> name;
	public List<WebElement> Name()
	{
		return name;
	}
	
	@FindBy(xpath="//span[@class='paginate_total']")
	WebElement pagecount;
	public WebElement pcount()
	{
		return pagecount;
	}
	
	
	
	
	
	
	
	
	
	
	
	public Page(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	

}
