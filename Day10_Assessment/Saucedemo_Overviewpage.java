package Day10_assessment_PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Saucedemo_Overviewpage 
{
	//Initialize
	WebDriver driver;
	public Saucedemo_Overviewpage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	//Declare
	@FindBy(xpath="//span[text()='Checkout: Overview']")
	private WebElement overviewcheck;
	
	@FindBy(xpath = "//button[@id='finish']")
	private WebElement clickFinish;
	
	//Access using getters
	
	public void verifyoverview(String value) 
	{
		if(overviewcheck.getText().contains(value))
			System.out.println("Overview page is displayed");
		else 
			System.out.println("Overview page is not displayed");
	}
	public void getClickFinish()
	{
		clickFinish.click();
	}
}
