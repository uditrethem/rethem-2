package conversations;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.automation.utility.Baseclass;
import Pageobject.Conversation_page;
import Pageobject.login_page;


public class converstion extends Baseclass {
	
	Conversation_page Conversation_page_search;
	
	
	/*
	@Test(groups = { "conversation" },priority='0')
	public void name_search() throws IOException, InterruptedException
	{
		login_page log = PageFactory.initElements(driver, login_page.class);
		log.login(excel.getstringdata("Login", 0, 0), excel.getstringdata("Login", 0, 1));
		Conversation_page_search = new Conversation_page(driver);
		Conversation_page_search.conversation_name_search("line 4");	
	}
	
	@Test(groups = { "conversation" },priority='1')
	public void Competitors_search() throws IOException, InterruptedException
	{
		login_page log = PageFactory.initElements(driver, login_page.class);
		log.login(excel.getstringdata("Login", 0, 0), excel.getstringdata("Login", 0, 1));
		Conversation_page_search = new Conversation_page(driver);
		Conversation_page_search.Competitors_name_search("computer");	
	}
	

	
	@Test(groups = { "conversation" },priority='2')
	public void Account_search() throws IOException, InterruptedException
	{
		login_page log = PageFactory.initElements(driver, login_page.class);
		log.login(excel.getstringdata("Login", 0, 0), excel.getstringdata("Login", 0, 1));
		Conversation_page_search = new Conversation_page(driver);
		Conversation_page_search.account_name_search("udtest");	
	}
	
	
	@Test(groups = { "conversation" },priority='3')
	public void date_search() throws IOException, InterruptedException
	{
		login_page log = PageFactory.initElements(driver, login_page.class);
		log.login(excel.getstringdata("Login", 0, 0), excel.getstringdata("Login", 0, 1));
		Conversation_page_search = new Conversation_page(driver);
		Conversation_page_search.Date_range_to_search("08/01/2023");	
	}
	*/
	@Test(groups = { "conversation" },priority='4')
	public void date_from_search() throws IOException, InterruptedException
	{
		login_page log = PageFactory.initElements(driver, login_page.class);
		log.login(excel.getstringdata("Login", 0, 0), excel.getstringdata("Login", 0, 1));
		Conversation_page_search = new Conversation_page(driver);
		Conversation_page_search.Date_range_from_search("08/01/2023");	
	}
}
