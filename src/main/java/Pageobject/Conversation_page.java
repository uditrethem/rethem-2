package Pageobject;






import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;






 

public class Conversation_page {
	
	
	public Conversation_page(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public WebDriver driver;
	
	@FindBy(xpath=("//div[normalize-space()='CONVERSATIONS']"))
	WebElement converastion_tab;
		
	@FindBy(xpath=("//div[@class='conversation_name']//input[@type='text']"))
	WebElement conversation_name;
	
	@FindBy(xpath=("//button[normalize-space()='Apply']"))
	WebElement applay_button;
	
	@FindBy(xpath=("//div[@class='multi-selected open']//input[@type='text']"))
	WebElement deal_search;
	
	@FindBy(xpath=("//div[@class='competitors']//div[@class='custom-select']"))
	WebElement Competitors_search;
	
	@FindBy(xpath=("//div[@class='multi-items']//span[@class='checkbox__control']"))
	WebElement Select_checkbox;
	
	
	@FindBy(xpath=("//div[@class='account']//input[@type='text']"))
	WebElement Account_search;
	
	@FindBy(xpath=("//div[@class='date_range__wrapper']//div[1]"))
	WebElement Date_search;
	
	@FindBy(xpath=("//body[1]/div[1]/div[2]/div[1]/div[2]/div[11]/div[2]/div[1]/input[1]"))
	WebElement enter_date;
	
	@FindBy(xpath=("//div[@class='date_range']//div[3]//input[1]"))
	WebElement Date_From_search;
	
	public void scrolldown()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,2000)");
	}
		
		public void conversation_name_search(String conversation_name_text) throws InterruptedException
		{
			
			converastion_tab.click();
			
			Thread.sleep(4000);
			conversation_name.sendKeys(conversation_name_text);
			
			applay_button.click();
		}
		
		public void Competitors_name_search(String Competitors_name_text) throws InterruptedException
		{
			
			converastion_tab.click();
			Thread.sleep(5000);
			scrolldown();
			Thread.sleep(4000);
			Competitors_search.click();
			Thread.sleep(4000);
			deal_search.sendKeys(Competitors_name_text);
			Select_checkbox.click();
			
			applay_button.click();
		}
		
		public void deal_name_search(String deal_name_text) throws InterruptedException
		{
			
			converastion_tab.click();
			Thread.sleep(4000);
			scrolldown();
			deal_search.click();
			Thread.sleep(2000);
			deal_search.sendKeys(deal_name_text);
			
			applay_button.click();
		}
		
		public void account_name_search(String account_name_text) throws InterruptedException
		{
			
			converastion_tab.click();
			Thread.sleep(4000);
			scrolldown();
			Account_search.click();
			Thread.sleep(2000);
			Account_search.sendKeys(account_name_text);
			Select_checkbox.click();
			
			applay_button.click();
		}
		
		public void Date_range_to_search(String date) throws InterruptedException
		{
			
			converastion_tab.click();
			Thread.sleep(4000);
			scrolldown();
			Date_search.click();
			Thread.sleep(2000);
			enter_date.sendKeys(date);
			applay_button.click();
		}
		
		public void Date_range_from_search(String date) throws InterruptedException
		{
			
			converastion_tab.click();
			Thread.sleep(4000);
			scrolldown();
			Date_From_search.click();
			Thread.sleep(2000);
			enter_date.sendKeys(date);
			applay_button.click();
		}
		
		
		
}
