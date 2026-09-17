package Day10_assessment_PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Saucedemo_Checkoutpage 
{
	//Initialize
	WebDriver driver;
	public Saucedemo_Checkoutpage (WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	//Declare
	@FindBy(xpath="//input[@id='first-name']")
	private WebElement fn;
	
	@FindBy(xpath="//input[@id='last-name']")
	private WebElement ln;
	
	@FindBy(xpath="//input[@id='postal-code']")
	private WebElement postalCode;
	
	@FindBy(xpath="//input[@id='continue']")
	private WebElement clickContinue;
	
	//Access using getters
	public void getFn(String value) 
	{
		fn.sendKeys(value);
	}

	public void getLn(String value) 
	{
		ln.sendKeys(value);
	}

	public void getPostalCode(String value) 
	{
		postalCode.sendKeys(value);
	}
	
	public void getClickContinue()
	{
		clickContinue.click();
	}
}
