package Pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class dashboard_page {

	public dashboard_page(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebDriver driver;

	// @FindBy(xpath=("//div[@class='meeting-item meeting-item
	// last-item']//div[@class='title__name'][normalize-space()='Automation
	// test']"))
	@FindBy(xpath = ("//div[@class='layout mb-5']//div//div[@class='meeting-item meeting-item last-item']"))

	WebElement title;

	@FindBy(xpath = ("//div[normalize-space()='Upcoming Meetings']"))
	WebElement section_header;

	public void meeting_details() {
		String actualmeetingdetails = section_header.getText();
		String expectedmeetingdetails = "Upcoming Meetings";
		Assert.assertEquals(actualmeetingdetails, expectedmeetingdetails);
		// Print the error message
		System.out.println("section header is:" + actualmeetingdetails);
		System.out.println(title.getText());
	}

	public void delete_suggestions() {

	}

}
