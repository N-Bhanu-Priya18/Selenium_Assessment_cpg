package Day12_Assessment_PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Testcase_Homepage
{
    WebDriver driver;

    public Testcase_Homepage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//span[text()='Recruitment']")
    private WebElement recruitment;

    @FindBy(xpath="//img[@class='oxd-userdropdown-img']")
    private WebElement userdropdown;

    @FindBy(xpath="//a[text()='Logout']")
    private WebElement logout;
    
    @FindBy(xpath="//span[text()='My Info']")
    private WebElement myinfo;

    public void getRecruitment()
    {
        recruitment.click();
    }

    public void getUserdropdown()
    {
        userdropdown.click();
    }

    public void getLogout()
    {
        logout.click();
    }
    
    public void getmyInfo()
    {
    	myinfo.click();
    }
    
}