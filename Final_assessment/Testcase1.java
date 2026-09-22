package LastDay_Assessment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Testcase1 
{
	public static void main(String[] args) throws InterruptedException
	{
		//Launch the Browser
		WebDriver driver =new ChromeDriver();
		
		//Maximize the browser
		driver.manage().window().maximize();
		
		//Apply implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//Navigate to demoappsQspiders toggle page
		driver.get("https://demoapps.qspiders.com/ui/toggle?sublist=0");
		Thread.sleep(2000);
		
		//click on disabled toggle buttons
		//toggle button after doing disble it is hidden
		
		driver.findElement(By.xpath("//a[text()='Disabled']")).click();
		Thread.sleep(2000);
		WebElement profilebutton = driver.findElement(By.xpath("//input[@id='tog']"));
		WebElement namebutton = driver.findElement(By.xpath("//input[@id='togg']"));
		WebElement phnobutton = driver.findElement(By.xpath("//input[@id='toggl']"));
		WebElement emailbutton = driver.findElement(By.xpath("//input[@id='toggler']"));
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].removeAttribute('disabled');", profilebutton);
		js.executeScript("arguments[0].click();", profilebutton);
		Thread.sleep(2000);
		
		js.executeScript("arguments[0].removeAttribute('disabled');",namebutton);
		js.executeScript("arguments[0].click();", namebutton);
		Thread.sleep(2000);
		
		js.executeScript("arguments[0].removeAttribute('disabled');", phnobutton);
		js.executeScript("arguments[0].click();", phnobutton);
		Thread.sleep(2000);
		
		js.executeScript("arguments[0].removeAttribute('disabled');", emailbutton);
		js.executeScript("arguments[0].click();", emailbutton);
		Thread.sleep(2000);
		
		//click on place order button
		WebElement placeorder = driver.findElement(By.xpath("//button[text()='Place Order']"));
		placeorder.click();
		Thread.sleep(2000);
		
		//verify that order is placed
		WebElement verify = driver.findElement(By.xpath("//p[text()='Your Order has been successfully placed!']"));
		if(verify.getText().contains("Your Order has been successfully placed!"))
		{
			System.out.println("Order is placed successfully");
		}
		else
		{
			System.out.println("Order is not placed");
		}		
		
		//close the browser
		Thread.sleep(4000);
		driver.quit();
		
	}

}
