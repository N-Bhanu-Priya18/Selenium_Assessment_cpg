package LastDay_Assessment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Testcase4 {

	public static void main(String[] args) throws InterruptedException 
	{
		//Launch the Browser
		WebDriver driver=new ChromeDriver();
		
		//Maximize the browser
		driver.manage().window().maximize();
		
		//Apply implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//Navigate to Shopperstack application
		driver.get("https://www.shoppersstack.com/");
		Thread.sleep(20000);
		
		//click on any product
		WebElement product = driver.findElement(By.xpath("//img[@alt='iphone']"));
		product.click();
		Thread.sleep(1000);
		
		//check the product is available to that pincode or not
		WebElement cd=driver.findElement(By.xpath("//label[@id='Check Delivery-label']"));
		cd.sendKeys("583104");
		
		WebElement check=driver.findElement(By.xpath("//button[@id='Check']"));
		
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(check)).click();
		Thread.sleep(2000);
		
		WebElement text=driver.findElement(By.xpath("//p[text()='Not Deliveriable.']"));
		if(text.getText().contains("Not Deliveriable."))
		{
			System.out.println("not deliverable");
		}
		else
		{
			System.out.println("Deliverable");
		}
	
	}

}
