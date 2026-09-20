package BaseClassUtility;

import java.awt.AWTException;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import Data.Day12_data;
import Day12_Assessment_PomPages.Testcase_Addvacancypage;
import Day12_Assessment_PomPages.Testcase_Homepage;
import Day12_Assessment_PomPages.Testcase_Loginpage;
import Day12_Assessment_PomPages.Testcase_MyInfopage;
import Day12_Assessment_PomPages.Testcase_Recruitmentpage;

public class Day12_baseclass extends Day12_data
{
    public Testcase_Homepage homepage;
    public Testcase_Recruitmentpage recruit;
    public Testcase_Addvacancypage addvacancy;
    public Testcase_MyInfopage infopage;
    
    public Day12_data data;

    protected WebDriver driver=null;

    @BeforeSuite
    public void BS()
    {
        System.out.println("Open-DataBase Connectivity");
    }

    @AfterSuite
    public void AS()
    {
        System.out.println("Close-DataBase Connectivity");
    }

    @BeforeTest
    public void BT()
    {
        System.out.println("Pre-conditions");
    }

    @AfterTest
    public void AT()
    {
        System.out.println("Post-conditions");
    }

    @BeforeClass
    public void BC() throws IOException, AWTException
    {
        data=new Day12_data();
        data.datastorage();

        if(data.browser.equalsIgnoreCase("chrome"))
        {
            driver=new ChromeDriver();
        }
        else if(data.browser.equalsIgnoreCase("edge"))
        {
            driver=new EdgeDriver();
        }
        else if(data.browser.equalsIgnoreCase("firefox"))
        {
            driver=new FirefoxDriver();
        }
        else
        {
            System.out.println("Browser not supported");
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        homepage=new Testcase_Homepage(driver);
        recruit=new Testcase_Recruitmentpage(driver);
        addvacancy=new Testcase_Addvacancypage(driver);
        infopage = new Testcase_MyInfopage(driver);
        
    }

    @AfterClass
    public void AC()
    {
        driver.quit();
        System.out.println("close the browser");
    }

    @BeforeMethod
    public void BM()
    {
        Testcase_Loginpage login=new Testcase_Loginpage(driver);

        driver.get(data.url);

        login.getUn(data.username);
        login.getPwd(data.password);
        login.getLogin();
    }

    @AfterMethod
    public void aM() throws InterruptedException
    {
    	homepage.getUserdropdown();
        Thread.sleep(1000);
    	homepage.getLogout();
    	System.out.println("LogoutExecuted");
    }
}