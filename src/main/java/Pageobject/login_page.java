package Pageobject;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class login_page {

	public WebDriver driver;

	public login_page(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "username")
	WebElement username;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//button[normalize-space()='Sign in']")
	WebElement login_button;

	@FindBy(xpath = "//div[@class='amplify-flex amplify-authenticator__icon-wrapper']//div[1]")
	public WebElement login_error;

	public void login(String sUsername, String sPassword) {
		username.sendKeys(sUsername);
		password.sendKeys(sPassword);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		login_button.click();
	}

	public void verify_errormessage() {
		String actualerror = login_error.getText();
		String expectederror = "Incorrect username or password.";
		Assert.assertEquals(actualerror, expectederror);
		// Print the error message
		System.out.println("Error message is:" + actualerror);

	}

	public String verify_pagetitle() {
		String actualTitle = driver.getTitle();

		System.out.println("Actual title is: " + actualTitle);
		return actualTitle;
	}

}
