package LastDay_assessment_Pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage 
{
	WebDriver driver;

    public Homepage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//span[text()='Buzz']")
    private WebElement buzz;

    @FindBy(xpath="//img[@class='oxd-userdropdown-img']")
    private WebElement userdropdown;

    @FindBy(xpath="//a[text()='Logout']")
    private WebElement logout;
    
    
    public void getBuzz()
    {
    	buzz.click();
    }
 
    public void getLogout()
    {
    	userdropdown.click();
        logout.click();
    }
    
    
}
