package Pageobject;

import java.time.Duration;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Reflex_Page {

	public WebDriver driver;
	
	public Reflex_Page(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[normalize-space()='TRAININGS']")
	WebElement Trainingheader;
	// new training button
	@FindBy(xpath = "//button[normalize-space()='New Training']")
	WebElement Trainingbutton;
	
	// training name
	@FindBy(xpath = "//input[@placeholder='Training name']")
	WebElement Trainingname;
	
	// save button
	@FindBy(xpath = "//button[normalize-space()='Save']")
	WebElement Trainingsave ;
	

	// Get training name
	@FindBy(xpath = "//h3[normalize-space()='automation']")
	WebElement createdTrainingname ;
	
	
	// Add suggestion
	@FindBy(xpath = "//div[@class='on-boarding__questions__add']")
	WebElement Addsuggestion ;
	
	// Search suggestion
	@FindBy(xpath = "//input[@placeholder='Search suggestions...']")
	WebElement Searchuggestion ;

	// Select suggestion
	@FindBy(xpath = "//div[@data-value='Why is looking for a ___________ solution important right now?']//span[@class='checkbox__control']")
	WebElement chekboxselect ;
	

	// Suggestion count
	@FindBy(xpath = "//div[@class='selection']")
	WebElement suggestioncount ;
	
	// Add to training button
	@FindBy(xpath = "//button[normalize-space()='Add To Training']")
	WebElement Addtotraining ;
	
	//cancel button
	@FindBy(xpath = "//button[normalize-space()='Cancel']")
	WebElement cancel_training ;
	
	

	
  
	public void open_trainingpopup()
	{
		Trainingheader.click();
		Trainingbutton.click();	
	}
	
	public void reflex_create()
	{
		open_trainingpopup();
		Trainingname.sendKeys("automation");
		Trainingsave.click();
		System.out.println("Training url:" + driver.getCurrentUrl());
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		System.out.println("Training name:"+createdTrainingname.getText());	
	}
	
	public void search_suggestion()
	{
		reflex_create();
		Addsuggestion.click();
		Searchuggestion.sendKeys("Why is looking for a ___________ solution important right now?");
	}
	
	public void add_suggestion()
	{
		search_suggestion();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		chekboxselect.click();
		System.out.println("Total suggestion:" +suggestioncount.getText());
		Addtotraining.click();
	}
	
	public void cancel_suggestion()
	{
		search_suggestion();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		chekboxselect.click();
		System.out.println("Total suggestion:" +suggestioncount.getText());
		cancel_training.click();
	}
}
