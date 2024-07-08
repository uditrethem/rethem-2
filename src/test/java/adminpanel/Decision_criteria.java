package adminpanel;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.automation.utility.Baseclass;
import Pageobject.DecisionCriteria_page;
import Pageobject.login_page;


public class Decision_criteria extends Baseclass {
	
	DecisionCriteria_page admin_descision;
	
	
	
	@Test(groups = { "Decision_criteria" },priority='0')
	public void add_decisioncriteria() throws IOException
	{
		login_page log = PageFactory.initElements(driver, login_page.class);
		admin_descision = new DecisionCriteria_page(driver);
		log.login(excel.getstringdata("Login", 0, 0), excel.getstringdata("Login", 0, 1));
		
		admin_descision.create_decisioncriteria("automation test","automation test","automation test" );
		admin_descision.validate_decisioncriteria();
		
	}
	/*
	@Test(groups = { "Decision_criteria" },priority='1')
	public void search_decisioncriteria() throws IOException
	{
		login_page log = PageFactory.initElements(driver, login_page.class);
		admin_descision = new DecisionCriteria_page(driver);
		log.login(excel.getstringdata("Login", 0, 0), excel.getstringdata("Login", 0, 1));
		admin_descision.search_decisioncriteria("automation test");
		admin_descision.validate_decisioncriteria();
	}
	
	@Test(groups = { "Decision_criteria" },priority='2')
	public void update_decisioncriteria() throws IOException
	{
		login_page log = PageFactory.initElements(driver, login_page.class);
		admin_descision = new DecisionCriteria_page(driver);
		log.login(excel.getstringdata("Login", 0, 0), excel.getstringdata("Login", 0, 1));
		admin_descision.update_decisioncriteria("automation update");
		String updateRelevance= admin_descision.update_Relevance_text.getText();
		String expectedRelevance= "AUTOMATION UPDATE";
		Assert.assertEquals(updateRelevance, expectedRelevance);
		// Print the error message
		System.out.println("Added decision Criteria is:"+updateRelevance);
	
	}
	
	@Test(groups = { "Decision_criteria" },priority='3')
	public void archive_decisioncriteria() throws IOException
	{
		login_page log = PageFactory.initElements(driver, login_page.class);
		admin_descision = new DecisionCriteria_page(driver);
		log.login(excel.getstringdata("Login", 0, 0), excel.getstringdata("Login", 0, 1));
		admin_descision.archive_decisioncriteria();
	}
	
	@Test(groups = { "Decision_criteria" },priority='4')
	public void delete_decisioncriteria() throws IOException
	{
		login_page log = PageFactory.initElements(driver, login_page.class);
		admin_descision = new DecisionCriteria_page(driver);
		log.login(excel.getstringdata("Login", 0, 0), excel.getstringdata("Login", 0, 1));
		admin_descision.delete_decisioncriteria();
		
		String actualmessage= admin_descision.no_decision_criteria.getText();
		String expectedmessage= "No Decision Criteria";
		Assert.assertEquals(actualmessage, expectedmessage);
		// Print the error message
		System.out.println("delete decision Criteria confirmation message is:"+actualmessage);
	}
	
*/
}
