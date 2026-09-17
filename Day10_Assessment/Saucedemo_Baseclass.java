package BaseClassUtility;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import Data.Day10_Common_Data;
import Data.Day10_specificdata;
import Day10_assessment_PomPages.Saucedemo_Loginpage;

public class Saucedemo_Baseclass extends Day10_Common_Data
{
	Day10_specificdata sd=new Day10_specificdata();
	
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
	public void BC() throws IOException
	{
		// Launch browser
		cdata();
		if(browser.equals("chrome"))
		{
		    driver = new ChromeDriver();
		}
		else if(browser.equals("edge"))
		{
		    driver = new EdgeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
		    driver = new FirefoxDriver();
		}
		else
			System.out.println("not launching");

		//maximize the browser
		driver.manage().window().maximize();
		
		//apply implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@AfterClass
	public void AC()
	{
		//close the browser
		driver.quit();
		System.out.println("close the browser");
	}
	
	@BeforeMethod
	public void BM ()
	{
		Saucedemo_Loginpage login = new Saucedemo_Loginpage(driver);
		//Navigate to SauceDemo application
		driver.get(url);
		
		login.getUn(username);
		login.getPwd(password);
		login.getLogin();
		
		
	}
	
	@AfterMethod
	public void aM()
	{
		System.out.println("LogoutExecuted");
	}
	
	
}
