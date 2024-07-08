package adminpanel;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.automation.utility.Baseclass;
import Pageobject.Suggestions_page;
import Pageobject.login_page;


public class suggestions extends Baseclass {
	
	Suggestions_page admin_suggestions;
	
	
	
	@Test(groups = { "suggestions" },priority='0')
	public void add_business_outcome() throws IOException
	{
		login_page log = PageFactory.initElements(driver, login_page.class);
		log.login(excel.getstringdata("Login", 0, 0), excel.getstringdata("Login", 0, 1));
		admin_suggestions = new Suggestions_page(driver);
		admin_suggestions.suggestions_create("automation business outcome");
		
		//System.out.println("Business outcome created successfully");
		
		
	}
	

}
 