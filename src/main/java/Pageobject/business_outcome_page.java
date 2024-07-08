package Pageobject;


import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;



 

public class business_outcome_page {
	
	String searchinsight;
	public business_outcome_page(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebDriver driver;
	
	@FindBy(xpath=("//span[normalize-space()='Business Outcome']"))
	WebElement businessoutcome;
		
	@FindBy(xpath=("//button[normalize-space()='ADD BUSINESS OUTCOME']"))
	WebElement Add_business_outcome;
	
	@FindBy(xpath=("//textarea[@placeholder='Add Business Outcome']"))
	WebElement Add_business_outcome_text;
	
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
	
	
	
	
		
		

		
		public void businessoutcome_create(String Buisnessoutcome_text)
		{
			DecisionCriteria_page admin_descision = PageFactory.initElements(driver, DecisionCriteria_page.class);
			
			admin_descision.dropdown.click();
			
			admin_descision.adminpanel.click();
			businessoutcome.click();
			Add_business_outcome.click();
			Add_business_outcome_text.sendKeys(Buisnessoutcome_text);
			Add_business_outcome_button.click();
		}
		
		public void businessoutcome_search(String search_businessoutcome)
		{
			DecisionCriteria_page admin_descision = PageFactory.initElements(driver, DecisionCriteria_page.class);
			
			admin_descision.dropdown.click();
			
			admin_descision.adminpanel.click();
			businessoutcome.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			//business_outcome_search.sendKeys(searchinsight);
			business_outcome_search.sendKeys(search_businessoutcome);
			String actulainsight=insight_name.getText();
			String expectedinsight="automation business outcome";
			Assert.assertEquals(actulainsight, expectedinsight);
			// Print the error message
			System.out.println("Search decision Criteria is:"+actulainsight);
		}
		
		public void update_insight(String searchinsight,String keyword)
		{
			
			businessoutcome_search(searchinsight);
			
			edit_insight_button.click();
			keyword_textarea.clear();
			keyword_textarea.sendKeys(keyword);
			edit_save_button.click();
			String updatedkeyword=update_insightkeyword.getText();
			String expectedkeyword="Automation test";
			Assert.assertEquals(updatedkeyword, expectedkeyword);
			// Print the error message
			System.out.println("updated insight keyword is:"+updatedkeyword);
			
		}
		
		public void delete_insight()
		{
			
			businessoutcome_search("Automation insight test");
			delete_insighticon.click();
			DecisionCriteria_page admin_descision = PageFactory.initElements(driver, DecisionCriteria_page.class);
			admin_descision.yes_delete_button.click();
			String actualmeesage=No_insights_message.getText();
			String expectedmessage="No Insights";
			Assert.assertEquals(actualmeesage, expectedmessage);
			// Print the error message
			System.out.println("delete insights confirmation message is:"+actualmeesage);
		}
		
}
