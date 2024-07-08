package Pageobject;

import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;





public class coaching_page {
	
	public coaching_page(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebDriver driver;
	
		// Select training type
		//By Trainingtype = By.xpath("//div[@class='selected open']");
		
	@FindBy(xpath=("//div[@class='custom-select category']"))
	WebElement training_dropdown;
	
	@FindBy(xpath=("//div[normalize-space()='Coaching']"))
	WebElement select_coaching;
	
	@FindBy(xpath=("//h3[normalize-space()='automation coaching']"))
	WebElement coaching_header;
	
	@FindBy(xpath="//div[@class='add-snippet__wrapper__icon']")
	WebElement addsnippet;
	
//	@FindBy(xpath="//textarea[@placeholder='Enter the customer sentence that sales rep will reply to']")
	@FindBy(xpath="//textarea[contains(@placeholder,'Enter the customer sentence')]")
	WebElement snippet_customer;
	
	@FindBy(xpath=("//div[@class='edit-snippet__save']"))
	WebElement snippet_customer_save;
	
	@FindBy(xpath=("//span[normalize-space()='Added to test']"))
	WebElement snippet_customer_text;
	
	@FindBy(xpath=("//p[normalize-space()='Suggestion']"))
	WebElement snippet_suggestion;
	
	@FindBy(xpath=("//input[@placeholder='Find suggestion']"))
	WebElement suggestion_search;
	
	@FindBy(xpath=("//div[@class='search_list__item']"))
	WebElement suggestion_select;
	
	@FindBy(xpath=("//input[@placeholder='Type Comment']"))
	WebElement comment;
	
	@FindBy(xpath="//div[@class='examples__bad']")
	WebElement bad_example;
	
	
		
		

		
		public void coaching_create()
		{
			Reflex_Page ref = PageFactory.initElements(driver, Reflex_Page.class);
			ref.open_trainingpopup();
			ref.Trainingname.sendKeys("automation coaching");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			training_dropdown.click();
			select_coaching.click();
			ref.Trainingsave.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			System.out.println("Training name:"+coaching_header.getText());
			//goodexample();
			
		}
		public void goodexample()
		{
			//Add snippet good example
			Reflex_Page ref = PageFactory.initElements(driver, Reflex_Page.class);
			addsnippet.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			snippet_customer.sendKeys("Added to test");
			snippet_customer_save.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			snippet_customer_text.click();
			snippet_suggestion.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			suggestion_search.sendKeys("Why is looking for a ___________ solution important right now?");
			suggestion_select.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			snippet_customer.sendKeys("Added to test second");
			snippet_customer_save.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			comment.sendKeys("Added to test");
			ref.Addtotraining.click();
			
			
		}
		
		public void badexample()
		{
			//Add snippet good example
			Reflex_Page ref = PageFactory.initElements(driver, Reflex_Page.class);
			addsnippet.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			bad_example.click();
			
			snippet_customer.sendKeys("Added to test");
			snippet_customer_save.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			snippet_customer_text.click();
			snippet_suggestion.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			suggestion_search.sendKeys("Why is looking for a ___________ solution important right now?");
			suggestion_select.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			snippet_customer.sendKeys("Added to test second");
			snippet_customer_save.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			comment.sendKeys("Added to test");
			ref.Addtotraining.click();
			
		}
		
}
