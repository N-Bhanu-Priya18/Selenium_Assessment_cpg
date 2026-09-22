package LastDay_Assessment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Testcase2
{
	public static void main(String[] args) throws InterruptedException 
	{
		//Launch the Browser
		WebDriver driver =new ChromeDriver();
		
		//Maximize the browser
		driver.manage().window().maximize();
		
		//Apply implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//Navigate to demoappsQspiders slidder page
		driver.get("https://demoapps.qspiders.com/ui/slider?sublist=0");
		Thread.sleep(2000);
		
		//slide the bar till men cotton jacket 
		WebElement a = driver.findElement(By.xpath("//input[@value='40']"));
		
		a.sendKeys(Keys.RIGHT,Keys.RIGHT,Keys.RIGHT);
		
		//Verify 
		WebElement text=driver.findElement(By.xpath("//h3[text()='Mens Cotton Jacket']"));
		if(text.getText().contains("Mens Cotton Jacket"))
		{
			System.out.println("slided successfull");
		}
		else
		{
			System.out.println("NOT slided");
		}
		
		//close the browser
		Thread.sleep(2000);
		driver.quit();
	}

}
