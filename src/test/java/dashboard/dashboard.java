package dashboard;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.automation.utility.Baseclass;
import Pageobject.dashboard_page;
import Pageobject.login_page;

public class dashboard extends Baseclass {

	dashboard_page dashboard_detail;

	@Test(groups = { "dashboard" }, priority = '0')
	public void add_agendas() throws IOException {
		login_page log = PageFactory.initElements(driver, login_page.class);
		log.login(excel.getstringdata("Login", 0, 0), excel.getstringdata("Login", 0, 1));
		dashboard_detail = new dashboard_page(driver);
		dashboard_detail.meeting_details();

	}

}
