package Pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class DecisionCriteria_page {
	
	public WebDriver driver;

	public DecisionCriteria_page (WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='header__end__user__profile']//div")
	WebElement dropdown;
	
	@FindBy(xpath="//a[normalize-space()='Admin Panel']")
	WebElement adminpanel;
	
	@FindBy(xpath="//span[normalize-space()='Decision Criteria']")
	WebElement decisioncriteria_link;
	
	@FindBy(xpath="//button[normalize-space()='ADD DECISION CRITERIA']")
	WebElement Adddecisioncriteria_button;
	
	@FindBy(xpath="//textarea[@placeholder='Add Decision Criteria']")
	WebElement Adddecisioncriteria_text;
	
	@FindBy(xpath="//textarea[@placeholder='Relevance']")
	WebElement Relevance;
	
	@FindBy(xpath="//textarea[@placeholder='How we Meet']")
	WebElement howwemeet;
	
	@FindBy(xpath="//button[@class='button primary_blue']")
	WebElement Addcriteria_button;
	
	@FindBy(xpath="//p[@class='list-item-name'][normalize-space()='automation test']")
	public WebElement addedcriteria_text;
	
	@FindBy(xpath="//input[@placeholder='Search Decision Criteria']")
	WebElement Searchbox;
	
	@FindBy(xpath="(//*[name()='svg'][@class='icon-edit_big'])[1]")
	WebElement edit_icon;
	
	@FindBy(xpath= "//button[normalize-space()='Save']")
	WebElement save_button;
	
	@FindBy(xpath= "//p[normalize-space()='automation update']")
	public WebElement update_Relevance_text;
	
	@FindBy(xpath= "(//div[@class='delete-icon'])[1]")
	public WebElement Archive;
	
	@FindBy(xpath= "(//button[normalize-space()='Yes, Archive It!'])[1]")
	public WebElement yes_Archive_button;
	
	@FindBy(xpath= "(//div[@class='delete-icon'])[1]")
	public WebElement delete_icon;
	
	@FindBy(xpath= "(//button[normalize-space()='Yes, Delete It!'])[1]")
	public WebElement yes_delete_button;
	
	@FindBy(xpath= "(//div[contains(text(),'No Decision Criteria')])[1]")
	public WebElement no_decision_criteria;
	
	public void create_decisioncriteria(String decisiontext,String relevance,String Howwemeet)
	{
		dropdown.click();
		adminpanel.click();
		decisioncriteria_link.click();
		Adddecisioncriteria_button.click();
		Adddecisioncriteria_text.sendKeys(decisiontext);
		Relevance.sendKeys(relevance);
		howwemeet.sendKeys(Howwemeet);
		Addcriteria_button.click();
		
	}
	
	public void search_decisioncriteria(String searchdata)
	{
		dropdown.click();
		adminpanel.click();
		decisioncriteria_link.click();
		Searchbox.sendKeys(searchdata);
	}
	
	public void validate_decisioncriteria()
	{
		String actualdecisioncriteria= addedcriteria_text.getText();
		String expecteddecisioncriteria= "automation test";
		Assert.assertEquals(actualdecisioncriteria, expecteddecisioncriteria);
		// Print the error message
		System.out.println("Search decision Criteria is:"+actualdecisioncriteria);
	}
	
	public void update_decisioncriteria(String updatedata)
	{/*
		dropdown.click();
		adminpanel.click();
		decisioncriteria_link.click();
		Searchbox.sendKeys("automation test");
		*/
		search_decisioncriteria("automation test");
		edit_icon.click();
		Relevance.clear();
		Relevance.sendKeys(updatedata);
		save_button.click();
		
	}
	
	public void archive_decisioncriteria()
	{
		search_decisioncriteria("automation test");
		Archive.click();
		yes_Archive_button.click();
	}
	
	public void delete_decisioncriteria()
	{
		search_decisioncriteria("automation test");
		delete_icon.click();
		yes_delete_button.click();
	}
	
	
	
}
