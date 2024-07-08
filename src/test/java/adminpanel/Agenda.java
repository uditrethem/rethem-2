package adminpanel;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.automation.utility.Baseclass;
import Pageobject.Agenda_page;
import Pageobject.login_page;


public class Agenda extends Baseclass {
	
	Agenda_page admin_Agenda;
	
	
	
	@Test(groups = { "agendas" },priority='0')
	public void add_agendas() throws IOException
	{
		login_page log = PageFactory.initElements(driver, login_page.class);
		log.login(excel.getstringdata("Login", 0, 0), excel.getstringdata("Login", 0, 1));
		admin_Agenda = new Agenda_page(driver);
		admin_Agenda.agendas_create("automation agenda template");
		
		System.out.println("Business outcome created successfully");
		
		
	}
	

}
