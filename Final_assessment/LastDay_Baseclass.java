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

import Data.Lastday_data;
import LastDay_assessment_Pompages.Buzzpage;
import LastDay_assessment_Pompages.Homepage;
import LastDay_assessment_Pompages.loginpage;

public class LastDay_Baseclass extends Lastday_data 
{
	public Homepage hp;
	public loginpage lp;
	public Buzzpage buzz;
	
	protected WebDriver driver;

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
       
    	cdata();
        if(browser.equalsIgnoreCase("chrome"))
        {
            driver=new ChromeDriver();
        }
        else if(browser.equalsIgnoreCase("edge"))
        {
            driver=new EdgeDriver();
        }
        else if(browser.equalsIgnoreCase("firefox"))
        {
            driver=new FirefoxDriver();
        }
        else
        {
            System.out.println("Browser not supported");
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));

        hp=new Homepage(driver);
        lp=new loginpage(driver);
        buzz=new Buzzpage(driver);
        
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
       
        driver.get(url);
        lp.getUn(username);
        lp.getPwd(password);
        lp.getLogin();
    }

    @AfterMethod
    public void aM() throws InterruptedException
    {
        Thread.sleep(1000);
    	hp.getLogout();
    	System.out.println("LogoutExecuted");
    }
}
