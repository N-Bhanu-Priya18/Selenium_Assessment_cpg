package Day12_Assessment_PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Testcase_Recruitmentpage
{
    WebDriver driver;

    public Testcase_Recruitmentpage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//a[text()='Vacancies']")
    private WebElement vacancies;

    public void getVacancies()
    {
        vacancies.click();
    }
}