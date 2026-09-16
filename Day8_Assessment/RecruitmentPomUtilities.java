package Day8;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RecruitmentPomUtilities 
{
	//Initialize
	WebDriver driver;
	Actions act;

	public RecruitmentPomUtilities(WebDriver driver) 
	{
		this.driver = driver;
		act = new Actions(driver);
		PageFactory.initElements(driver,this);
	}
	
	//Declare
	@FindBy(xpath = "(//button[@type='button'])[5]")
	private WebElement addButton;
	
	@FindBy(name = "firstName")
	private WebElement firstname_tf;
	
	@FindBy(name = "middleName")
	private WebElement middlename_tf;
	
	@FindBy(name = "lastName")
	private WebElement lastname_tf;
	
	@FindBy(xpath = "//div[@class='oxd-select-text-input']")
	private WebElement vacancy;
	
	@FindBy(xpath = "//input[@placeholder='Type here']")
	private WebElement emailtf;
	
	@FindBy(xpath = "(//input[@placeholder='Type here'])[2]")
	private WebElement phnotf;
	
	@FindBy(xpath = "//input[@type='file']")
	private WebElement fileUpload;
	
	@FindBy(xpath = "//input[@placeholder='yyyy-dd-mm']")
	private WebElement date;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement saveButton;
	
	//Access using getters
	public void getAddButton() 
	{
	    addButton.click();
	}

	public void getFntf(String value) 
	{
	    firstname_tf.sendKeys(value);
	}

	public void getMntf(String value) 
	{
	    middlename_tf.sendKeys(value);
	}

	public void getLntf(String value)
	{
	    lastname_tf.sendKeys(value);
	}

	public void getVacancy() throws AWTException, InterruptedException 
	{
	    vacancy.click();
	    Thread.sleep(2000);
	    Robot r = new Robot();
	    r.keyPress(KeyEvent.VK_DOWN);
	    r.keyRelease(KeyEvent.VK_DOWN);

	    r.keyPress(KeyEvent.VK_DOWN);
	    r.keyRelease(KeyEvent.VK_DOWN);
	    
	    r.keyPress(KeyEvent.VK_ENTER);
	    r.keyRelease(KeyEvent.VK_ENTER);
	}

	public void getEmailtf(String value) 
	{
	    emailtf.sendKeys(value);
	}

	public void getPhnotf(String value) 
	{
	    phnotf.sendKeys(value);
	}

	public void getFileUpload(String value) 
	{
	    fileUpload.sendKeys(value);
	}

	public void getDate(String value) 
	{
	    date.sendKeys(value);
	    date.click();
	}

	public void getSaveButton() {
	    saveButton.click();
	}

	
}
