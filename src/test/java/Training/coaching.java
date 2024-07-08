package Training;

import java.io.IOException;
import java.time.Duration;

import com.automation.utility.Baseclass;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import Pageobject.coaching_page;
import Pageobject.login_page;

public class coaching extends Baseclass {
	
	String trainingName = "Automation"+"Randomstring";

	@Test(groups = { "coaching" })
	public void coaching_create() throws IOException {
		//function use to create coaching
		login_page log = PageFactory.initElements(driver, login_page.class);
		coaching_page coach=PageFactory.initElements(driver, coaching_page.class);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		log.login(excel.getstringdata("Login", 0, 0), excel.getstringdata("Login", 0, 1));
		
//		pass parameter.
		coach.coaching_create();
		coach.badexample();
}
	}
