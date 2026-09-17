package Day10_assessment_PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Saucedemo_Orderplacedpage 
{
	//Initialize
	WebDriver driver;
	public Saucedemo_Orderplacedpage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	//declare
	@FindBy(xpath="//h2[text()='Thank you for your order!']")
	private WebElement message;
	
	//access using getters
	public void verifyorder(String value) {
		if(message.getText().contains(value))
			System.out.println("Thank you for your order! is displayed");
		else 
			System.out.println("Thank you for your order! is not  displayed");
			
	}
	
	
}
