package Day12_Assessment_PomPages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Testcase_MyInfopage
{
    WebDriver driver;

    public Testcase_MyInfopage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name="firstName")
    private WebElement fn;

    @FindBy(xpath="//input[@name='lastName']")
    private WebElement ln;

    @FindBy(xpath="//label[normalize-space()='Employee Id']/ancestor::div[contains(@class,'oxd-input-group')]//input")
    private WebElement empid;

    @FindBy(xpath="//button[@type='submit' and normalize-space()='Save']")
    private WebElement savebutton;

    public void getFn(String value)
    {
        fn.sendKeys(Keys.CONTROL+"a");
        fn.sendKeys(Keys.BACK_SPACE);
        fn.sendKeys(value);
    }

    public void getLn(String value)
    {
    	ln.sendKeys(Keys.CONTROL+"a");
        ln.sendKeys(Keys.BACK_SPACE);
        ln.sendKeys(value);
    }

    public void getEmpid(String value)
    {
    	empid.sendKeys(Keys.CONTROL+"a");
    	empid.sendKeys(Keys.BACK_SPACE);
        empid.sendKeys(value);
    }

    public void getSavebutton()
    {
        savebutton.click();
    }

    
    public String getFirstName()
    {
    	return fn.getAttribute("value");
    }

    public void verifyEmpid(String value)
    {
        Assert.assertEquals(empid.getAttribute("value"), value);
    }
}