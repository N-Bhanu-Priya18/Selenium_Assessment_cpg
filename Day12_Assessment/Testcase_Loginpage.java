package Day12_Assessment_PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Testcase_Loginpage
{
    WebDriver driver;

    public Testcase_Loginpage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(name="username")
    private WebElement un;

    @FindBy(name="password")
    private WebElement pwd;

    @FindBy(xpath="//button[@type='submit']")
    private WebElement login;

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