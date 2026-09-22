package LastDay_Assessment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Testcase3 
{
	public static void main(String[] args) throws InterruptedException 
	{
		//Launch the Browser
		WebDriver driver=new ChromeDriver();
		
		//Maximize the browser
		driver.manage().window().maximize();
		
		//Apply implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//Navigate to demoappsQspiders dragdrop multiple page
		driver.get("https://demoapps.qspiders.com/ui/dragDrop/dragToMultiple?sublist=3");
		Thread.sleep(2000);
		
		//drag and drop the accessories accordingly
		WebElement m1 = driver.findElement(By.xpath("//div[text()='Mobile Cover']"));
		WebElement m2 = driver.findElement(By.xpath("//div[text()='Mobile Charger']"));
		WebElement l1 = driver.findElement(By.xpath("//div[text()='Laptop Cover']"));
		WebElement l2 = driver.findElement(By.xpath("//div[text()='Laptop Charger']"));
		WebElement mobile = driver.findElement(By.xpath("//div[@id='dropZone1']"));
		WebElement laptop = driver.findElement(By.xpath("//div[@id='dropZone2']"));
		
		Actions act=new Actions(driver);
		m1.click();
		m2.click();
		act.dragAndDrop(m1,mobile).perform();
		Thread.sleep(2000);
		
		l1.click();
		l2.click();
		act.dragAndDrop(l1, laptop).perform();
		Thread.sleep(2000);

		//close the browser
		Thread.sleep(2000);
		driver.quit();
		
	}
}
