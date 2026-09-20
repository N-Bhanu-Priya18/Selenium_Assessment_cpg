package Day12_Assessment_PomPages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Testcase_Addvacancypage
{
    WebDriver driver;
    Robot r;

    public Testcase_Addvacancypage(WebDriver driver) throws AWTException
    {
        this.driver=driver;
        r=new Robot();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//button[text()=' Add ']")
    private WebElement add;

    @FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[2]")
    private WebElement vacname;

    @FindBy(xpath="//div[text()='-- Select --']")
    private WebElement select;

    @FindBy(xpath="//textarea[@placeholder='Type description here']")
    private WebElement description;

    @FindBy(xpath="//input[@placeholder='Type for hints...']")
    private WebElement hiringmgr;

    @FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[3]")
    private WebElement positions;

    @FindBy(xpath="//button[text()=' Save ']")
    private WebElement save;

    public void getAdd()
    {
        add.click();
    }

    public void getVacname(String value)
    {
        vacname.sendKeys(value);
    }

    public void getSelect() throws InterruptedException
    {
        select.click();
        Thread.sleep(2000);

        r.keyPress(KeyEvent.VK_DOWN);
        r.keyRelease(KeyEvent.VK_DOWN);

        r.keyPress(KeyEvent.VK_DOWN);
        r.keyRelease(KeyEvent.VK_DOWN);

        r.keyPress(KeyEvent.VK_ENTER);
        r.keyRelease(KeyEvent.VK_ENTER);
    }

    public void getDescription(String value)
    {
        description.sendKeys(value);
    }

    public void getHiringmgr(String value) throws InterruptedException
    {
        hiringmgr.sendKeys(value);
        Thread.sleep(3000);

        r.keyPress(KeyEvent.VK_DOWN);
        r.keyRelease(KeyEvent.VK_DOWN);

        r.keyPress(KeyEvent.VK_ENTER);
        r.keyRelease(KeyEvent.VK_ENTER);
    }

    public void getPositions(String value)
    {
        positions.sendKeys(value);
    }

    public void getSave()
    {
        save.click();
    }
}