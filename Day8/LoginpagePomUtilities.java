package Day8;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginpagePomUtilities 
{
	//Initialize
	WebDriver driver;
	public void LoginpageUtilities(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	//Declare 
    @FindBy(xpath="//input[@name='username']")
    private WebElement username;
    
    @FindBy(xpath="//input[@name='password']")
    private WebElement password;
    
    @FindBy(xpath="//button[@type='submit']")
    private WebElement login;
	public void getUsername() {
		username.sendKeys("Admin");
	}

	public void getPassword() {
		password.sendKeys("admin123");
	}

	public void getLogin() {
		login.click();
	}
    
    
	
}
