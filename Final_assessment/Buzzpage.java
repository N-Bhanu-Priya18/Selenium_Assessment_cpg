package LastDay_assessment_Pompages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import junit.framework.Assert;

public class Buzzpage 
{
	
	WebDriver driver;

    public Buzzpage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    
	@FindBy(xpath="//textarea[@class='oxd-buzz-post-input']")
	private WebElement textfield;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement postbutton;
	
	@FindBy(xpath="//p[text()='advanced selenium']")
	private WebElement verifypost;

	public void getTextfield(String value)
	{
		textfield.sendKeys(value);
	}
	
	public void getPost()
	{
		postbutton.click();
	}
	
	public void getverifypost(String value)
	{
		boolean verification = driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--label-warn orangehrm-post-filters-button']/../..//p[text()='"+value+"']")).isDisplayed();
		Assert.assertTrue(verification);
		System.out.println("Post is posted in recent post");
	}
	
}
