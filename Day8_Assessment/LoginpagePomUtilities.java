package Day8;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginpagePomUtilities  
{
	//Initialize
	WebDriver driver;
	public LoginpagePomUtilities (WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	//Declare
	@FindBy(name = "username")
	private WebElement untf;
	
	@FindBy(name = "password")
	private WebElement pwdtf;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement loginButton;

	//Access using getters
	public void getUntf(String value) 
	{
		untf.sendKeys(value);
	}

	public void getPwdtf(String value) 
	{
		pwdtf.sendKeys(value);
	}

	public void getLoginButton() 
	{
		loginButton.click();
	}
	
}
