package Day8;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CandidatesPomUtilities 
{
	//Initialize
	WebDriver driver;
	Actions act;
	public CandidatesPomUtilities (WebDriver driver)
	{
		this.driver = driver;
		act=new Actions(driver);
		PageFactory.initElements(driver,this);
	}
	
	//Declare
	@FindBy(xpath = "//a[text()='Candidates']")
	private WebElement candidates;
	
	@FindBy(xpath = "//input[@placeholder='Type for hints...']")
	private WebElement cname;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement searchButton;
	
	@FindBy(xpath = "//div[text()='Candidate']/ancestor::div[@class='orangehrm-container']/descendant::div[text()='N Bhanu Priya']")
	private WebElement isRecordsFound;
	
	//access using getters
	public void getCandidates() 
	{
	    candidates.click();
	}

	public void getCname(String value) throws AWTException, InterruptedException
	{
	    cname.sendKeys(value);
	    Thread.sleep(3000);
	    Robot r = new Robot();
	    r.keyPress(KeyEvent.VK_DOWN);
	    r.keyRelease(KeyEvent.VK_DOWN);

	    r.keyPress(KeyEvent.VK_ENTER);
	    r.keyRelease(KeyEvent.VK_ENTER);
	}

	public void getSearchButton() 
	{
	    searchButton.click();
	}
	
	public boolean getIsRecordsFound() 
	{
	    if(isRecordsFound.isDisplayed())
	    	return true;
	    else
	    	return false;
	}
}
