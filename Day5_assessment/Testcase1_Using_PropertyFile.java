/*
 //Test- case 1
1. Navigate to DemoWebshop application
2. Click on login link.
3. Enter email and password and click on login button by reading the data from property file.
4. Verify that login is successful.
 */

package Day5_assessment;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Testcase1_Using_PropertyFile
{
    public static void main(String[] args) throws InterruptedException, IOException
    {
        // Fetch data from properties file

        // Step 1: Create object for FileInputStream and pass the path of the properties file
        FileInputStream fis = new FileInputStream( "./src/test/resources/Data_Driven_Testing/Testcase1_property.properties");

        // Step 2: Create object for Properties
        Properties p = new Properties();

        // Step 3: Load the properties file
        p.load(fis);

        // Store the data from properties file in variables
        String BROWSER = p.getProperty("browser");
        String URL = p.getProperty("url");
        String EMAIL = p.getProperty("email");
        String PASSWORD = p.getProperty("password");

        // Launch the browser
        WebDriver driver = null;

        if(BROWSER.equalsIgnoreCase("chrome"))
        {
            driver = new ChromeDriver();
        }
        else if(BROWSER.equalsIgnoreCase("edge"))
        {
            driver = new EdgeDriver();
        }
        else if(BROWSER.equalsIgnoreCase("firefox"))
        {
            driver = new FirefoxDriver();
        }

        // Maximize the browser window
        driver.manage().window().maximize();

        // Apply implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        // 1. Navigate to DemoWebshop application
        driver.get(URL);

        Thread.sleep(2000);

        // 2. Click on login link
        driver.findElement(By.xpath("//a[text()='Log in']")).click();

        Thread.sleep(2000);

        // 3. Enter email
        driver.findElement(By.id("Email")).sendKeys(EMAIL);

        // Enter password
        driver.findElement(By.id("Password")).sendKeys(PASSWORD);

        // Click on login button
        driver.findElement(By.xpath("//input[@class='button-1 login-button']")).click();

        Thread.sleep(2000);

        // 4. Verify that login is successful
        WebElement logout = driver.findElement(By.linkText("Log out"));

        if(logout.isDisplayed())
        {
            System.out.println("Login successful");
        }
        else
        {
            System.out.println("Login not successful");
        }

        // Close the browser
        driver.quit();
    }
}
