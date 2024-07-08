package adminpanel;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.automation.utility.Baseclass;

import Pageobject.business_outcome_page;
import Pageobject.login_page;


public class business_outcome extends Baseclass {
	
	business_outcome_page admin_buinessoutcome;
	
	
	/*
	@Test(groups = { "business_outcome" },priority='0')
	public void add_business_outcome() throws IOException
	{
		login_page log = PageFactory.initElements(driver, login_page.class);
		log.login(excel.getstringdata("Login", 0, 0), excel.getstringdata("Login", 0, 1));
		admin_buinessoutcome = new business_outcome_page(driver);
		admin_buinessoutcome.businessoutcome_create("automation business outcome");
		
		System.out.println("Business outcome created successfully");
		
		
	}
	*/
	
	@Test(groups = { "business_outcome" },priority='1')
	public void search_business_outcome() throws IOException
	{
		login_page log = PageFactory.initElements(driver, login_page.class);
		log.login(excel.getstringdata("Login", 0, 0), excel.getstringdata("Login", 0, 1));
		admin_buinessoutcome = new business_outcome_page(driver);
		admin_buinessoutcome.businessoutcome_search("automation business outcome");
	}
	/*
	@Test(groups = { "business_outcome" },priority='2')
	public void update_business_outcome() throws IOException
	{
		login_page log = PageFactory.initElements(driver, login_page.class);
		
		log.login(excel.getstringdata("Login", 0, 0), excel.getstringdata("Login", 0, 1));
		admin_buinessoutcome = new business_outcome_page(driver);
		
		
	}
	
	
	@Test(groups = { "business_outcome" },priority='3')
	public void delete_business_outcome() throws IOException
	{
		login_page log = PageFactory.initElements(driver, login_page.class);
		log.login(excel.getstringdata("Login", 0, 0), excel.getstringdata("Login", 0, 1));
		admin_buinessoutcome = new business_outcome_page(driver);
		
		
		
		
	}
	*/

}
