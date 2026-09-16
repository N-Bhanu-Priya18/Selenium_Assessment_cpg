package Day8;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomepagePomutilities 
{
	//Initialize
	WebDriver driver;
	public HomepagePomutilities(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	//Declare
	
	//click on recruitment
	@FindBy(xpath = "//span[text()='Recruitment']")
	private WebElement recruitment;
	
	//click on icon to display logout option
	@FindBy(xpath = "//img[@class='oxd-userdropdown-img']")
	private WebElement logout;
	
	//click on logout
	@FindBy(xpath = "//a[text()='Logout']") 
	private WebElement logoutButton;
	
	//Access using getters
	public void getRecruitment() 
	{
		recruitment.click();
	}
	
	public void getLogoutButton() 
	{
		logout.click();
		logoutButton.click();
	}
	
}