package Pageobject;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class insight_page {
	
	String searchinsight;
	public insight_page(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebDriver driver;
	
	@FindBy(xpath=("//span[normalize-space()='Insights']"))
	WebElement insight;
		
	@FindBy(xpath=("//button[normalize-space()='ADD INSIGHT TEMPLATE']"))
	WebElement Add_insight_template;
	
	@FindBy(xpath=("//input[@placeholder='Insights title']"))
	WebElement insight_title;
	
	@FindBy(xpath=("//textarea[@placeholder='Keywords']"))
	WebElement keywords;
	
	@FindBy(xpath=("//button[normalize-space()='Add Insight']"))
	WebElement Add_insight_button;
	
	@FindBy(xpath=("//input[@placeholder='Search Insights']"))
	WebElement insight_search;
	
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
	
	
	
	
		
		

		
		public void insight_create(String insightname, String keyword)
		{
			DecisionCriteria_page admin_descision = PageFactory.initElements(driver, DecisionCriteria_page.class);
			
			admin_descision.dropdown.click();
			
			admin_descision.adminpanel.click();
			insight.click();
			Add_insight_template.click();
			insight_title.sendKeys(insightname);
			keywords.sendKeys(keyword);
			Add_insight_button.click();
		}
		
		public void insight_search(String searchinsight)
		{
			DecisionCriteria_page admin_descision = PageFactory.initElements(driver, DecisionCriteria_page.class);
			
			admin_descision.dropdown.click();
			
			admin_descision.adminpanel.click();
			insight.click();
			insight_search.sendKeys(searchinsight);
			String actulainsight=insight_name.getText();
			String expectedinsight="Automation insight test";
			Assert.assertEquals(actulainsight, expectedinsight);
			// Print the error message
			System.out.println("Search decision Criteria is:"+actulainsight);
		}
		
		public void update_insight(String searchinsight,String keyword)
		{
			
			insight_search(searchinsight);
			
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
			
			insight_search("Automation insight test");
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
