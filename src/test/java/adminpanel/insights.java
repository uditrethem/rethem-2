package adminpanel;

import java.io.IOException;


import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.automation.utility.Baseclass;
import Pageobject.insight_page;
import Pageobject.login_page;


public class insights extends Baseclass {
	
	insight_page admin_insights;
	
	
	
	@Test(groups = { "insights" },priority='0')
	public void add_insights() throws IOException
	{
		login_page log = PageFactory.initElements(driver, login_page.class);
		admin_insights = new insight_page(driver);
		log.login(excel.getstringdata("Login", 0, 0), excel.getstringdata("Login", 0, 1));
		admin_insights.insight_create("Automation insight test","Test");
		System.out.println("insights created successfully");
		
		
	}
	
	@Test(groups = { "insights" },priority='1')
	public void search_insights() throws IOException
	{
		login_page log = PageFactory.initElements(driver, login_page.class);
		admin_insights = new insight_page(driver);
		log.login(excel.getstringdata("Login", 0, 0), excel.getstringdata("Login", 0, 1));
		admin_insights.insight_search("Automation insight test");
		
	}
	
	@Test(groups = { "insights" },priority='2')
	public void update_insights() throws IOException
	{
		login_page log = PageFactory.initElements(driver, login_page.class);
		
		log.login(excel.getstringdata("Login", 0, 0), excel.getstringdata("Login", 0, 1));
		admin_insights = new insight_page(driver);
		admin_insights.update_insight("Automation insight test","Automation test");
		
		
	}
	
	
	@Test(groups = { "Decision_criteria" },priority='3')
	public void delete_insights() throws IOException
	{
		login_page log = PageFactory.initElements(driver, login_page.class);
		log.login(excel.getstringdata("Login", 0, 0), excel.getstringdata("Login", 0, 1));
		admin_insights = new insight_page(driver);
		admin_insights.delete_insight();
		
		
		
	}
	
	
}
