package Day10_assessment_PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Saucedemo_Loginpage
{
	//Initialize
	WebDriver driver;
	public Saucedemo_Loginpage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	//Declare
	@FindBy(xpath="//input[@id='user-name']")
	private WebElement un;
	
	@FindBy(xpath="//input[@id='password']")
	private WebElement pwd;
	
	@FindBy(xpath="//input[@id='login-button']")
	private WebElement login;
	
	//Access using getters
	public void getUn(String value) 
	{
		un.sendKeys(value);
	}

	public void getPwd(String value) 
	{
		pwd.sendKeys(value);
	}

	public void getLogin() 
	{
		login.click();
	}	
}
