package Training;

import java.io.IOException;
import java.time.Duration;

//import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.automation.utility.Baseclass;
import Pageobject.Reflex_Page;
import Pageobject.login_page;

public class Reflex extends Baseclass {

	login_page loginPage; 
	
	Reflex_Page reflexpage;
	
	@Test(groups = { "Reflex" })
	public void Reflex_Training() throws IOException {
		
		
		//Reflex_Page ref = PageFactory.initElements(driver, Reflex_Page.class);
		
		//login_page log = PageFactory.initElements(driver, login_page.class);
		loginPage = new login_page(driver);
		reflexpage= new Reflex_Page(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		loginPage.login(excel.getstringdata("Login", 0, 0), excel.getstringdata("Login", 0, 1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		 reflexpage.reflex_create();
		
	}
	
	@Test(groups = { "Reflex" })
public void Reflex_searchsuggestion() throws IOException {
		
		
		//Reflex_Page ref = PageFactory.initElements(driver, Reflex_Page.class);
		
		//login_page log = PageFactory.initElements(driver, login_page.class);
		 loginPage = new login_page(driver);
		 reflexpage= new Reflex_Page(driver);
		 

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		loginPage.login(excel.getstringdata("Login", 0, 0), excel.getstringdata("Login", 0, 1));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		reflexpage.search_suggestion();
		
	}
	/*
	@Test(groups = { "Reflex" })
	public void Reflex_addsuggestion() throws IOException {
			
			
			loginPage = new login_page(driver);
		    reflexpage= new Reflex_Page(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

			loginPage.login(excel.getstringdata("Login", 0, 0), excel.getstringdata("Login", 0, 1));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			
			reflexpage.add_suggestion();
			
		}

	
	@Test(groups = { "Reflex" },priority=3)
	public void Reflex_cancelsuggestion() throws IOException {
			
			
			loginPage = new login_page(driver);
		    reflexpage= new Reflex_Page(driver);

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

			loginPage.login(excel.getstringdata("Login", 0, 0), excel.getstringdata("Login", 0, 1));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			
			 reflexpage.cancel_suggestion();
			

		}
	*/	
}

