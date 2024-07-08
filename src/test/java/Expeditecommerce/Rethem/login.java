
package Expeditecommerce.Rethem;

import java.io.IOException;
import java.time.Duration;

//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.automation.utility.Baseclass;
import org.testng.Assert;

import Pageobject.login_page;

public class login extends Baseclass {

	login_page loginPage;

	@Test(groups = { "login" })
	public void loginrethem() throws IOException {

		// Define object of login_page

//		login_page log = PageFactory.initElements(driver, login_page.class);
		loginPage = new login_page(driver);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		loginPage.login(excel.getstringdata("Login", 0, 0), excel.getstringdata("Login", 0, 1));

		String actualTitle = loginPage.verify_pagetitle();

		String expectedTitle = "re:them";
		Assert.assertEquals(actualTitle, expectedTitle, "Login Failed Current page title is:" + actualTitle);

	}

	@Test(groups = { "login" })
	public void invalidloginrethem() throws IOException {

		// Define object of login_page
		// Call the function
		//user will not able to login in the system.
		loginPage = new login_page(driver);
		loginPage.login(excel.getstringdata("Login", 1, 0), excel.getstringdata("Login", 1, 1));
		loginPage.verify_errormessage();
		
	}

}
