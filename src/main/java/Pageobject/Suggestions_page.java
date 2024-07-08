package Pageobject;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;




 

public class Suggestions_page {
	
	
	public Suggestions_page(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebDriver driver;
	
	@FindBy(xpath=("//span[normalize-space()='Suggestions']"))
	WebElement suggestions;
		
	@FindBy(xpath=("//button[normalize-space()='ADD SUGGESTION']"))
	WebElement Add_sugestions;
	
	@FindBy(xpath=("//textarea[@placeholder='Add Business Outcome']"))
	WebElement select_suggestion_type;
	
	@FindBy(xpath=("//button[@class='button primary_blue']"))
	WebElement Add_business_outcome_button;
	
	@FindBy(xpath=("//input[@placeholder='Search Business Outcome']"))
	WebElement business_outcome_search;
	
	@FindBy(xpath=("//p[@class='insight-name']"))
	WebElement insight_name;
	
	@FindBy(xpath=("//div[@class='edit-icon']"))
	WebElement edit_insight_button;
	
	@FindBy(xpath=("(//textarea)[1]"))
	WebElement keyword_textarea;
	
	@FindBy(xpath=("//button[normalize-space()='Save']"))
	WebElement edit_save_button;
	
	@FindBy(xpath=("//p[@class='keywords']"))
	WebElement update_insightkeyword;
	
	@FindBy(xpath=("//div[@class='delete-icon']"))
	WebElement delete_insighticon;
	
	@FindBy(xpath=("//div[@class='title']"))
	WebElement No_insights_message;
	
	
	
	
		
		

		
		public void suggestions_create(String Buisnessoutcome_text)
		{
			DecisionCriteria_page admin_descision = PageFactory.initElements(driver, DecisionCriteria_page.class);
			
			admin_descision.dropdown.click();
			
			admin_descision.adminpanel.click();
			suggestions.click();
			Add_sugestions.click();
		}
		
		public void delete_suggestions()
		{
			
			
		}
		
}
