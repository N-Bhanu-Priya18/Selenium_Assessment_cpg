/*
  Testcase1:
*/

CODE:
package Problems;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Testcase3 
{
	public static void main(String[] args) throws InterruptedException 
	{
		//Launch the browser
		WebDriver driver=new ChromeDriver();
		
		//Maximize the browser window
		driver.manage().window().maximize();
		
		//Apply implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//Navigate to the instagram application
		driver.get("https://www.instagram.com");
		Thread.sleep(2000);
		
		//count and find the sizes of all the textfields		
		List<WebElement> tf=driver.findElements(By.xpath("//input[@dir='ltr']"));
		
		System.out.println(tf.size());//count:Gives number of elements in a list
		
		for(WebElement ele : tf) 
		{
		    System.out.println(ele.getSize());
		    if("email".equals(ele.getDomAttribute("name"))) 
		    {
		        ele.sendKeys("bhanupriyan91@gmail.com");
		    }
		}	
		
		Thread.sleep(2000);
		
		//close the browser
		driver.quit();	
	}

}

/*
  Testcase2:
*/
CODE:
package Problems;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Testcase4 
{
	public static void main(String[] args) throws InterruptedException 
	{
		//Launch the browser
		WebDriver driver=new ChromeDriver();
		
		//Maximize the browser window
		driver.manage().window().maximize();
		
		//apply implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//Navigate to the zomato application
		driver.get("https://www.zomato.com/bangalore/delivery");
		Thread.sleep(2000);
		
		//click on log in
		WebElement login=driver.findElement(By.xpath("//button[text()='Log in']"));
		login.click();
		
		//Locate the whole frame
		WebElement frame=driver.findElement(By.xpath("//iframe[@id='auth-login-ui']"));
		
		//switchTo()
		driver.switchTo().frame(frame);
		
		//Locate phone number textfield
		WebElement phonetf=driver.findElement(By.xpath("//input[@placeholder='Phone']"));
		phonetf.sendKeys("9108456311");
		Thread.sleep(1000);
		
		//use this click only if you want to see the main page
//		//click on cross symbol
//		driver.findElement(By.xpath("//i[@class='sc-rbbb40-1 cLEXmC sc-re4bd0-1 bKymEa']")).click();
//		Thread.sleep(2000);
		
		///switch back to the main document
		driver.switchTo().defaultContent();
		Thread.sleep(1000);
		
		//verify whether it has came back to main page or not
		WebElement ref=driver.findElement(By.xpath("//div[text()='Delivery']"));
		System.out.println(ref.getText());
		
		Thread.sleep(2000);
		
		//close the browser
		driver.quit();
	}
}

/*
	Testcase3:
*/
CODE:
package Problems;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Testcase5 
{
	public static void main(String[] args) throws InterruptedException 
	{
		//Launch the browser
		WebDriver driver=new ChromeDriver();
		
		//Maximize the browser window
		driver.manage().window().maximize();
		
		//apply implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//Navigate to the bigbasket application
		driver.get("https://www.bigbasket.com/pb/boss/");
		Thread.sleep(2000);
		
		//search for any product
		driver.findElement(By.xpath("(//input[@placeholder='Search for Products...'])[2]")).sendKeys("Apples");

		//select required product and add to cart
		List<WebElement> allmatches=driver.findElements(By.xpath("//div[@style='position: relative; overflow: hidden; width: 100%; height: auto; min-height: 0px; max-height: 60vh;']"));
		for(WebElement ele:allmatches)
		{
			driver.findElement(By.xpath("//span[text()='Indian Apple - Royal Gala, Economy']/../../..//button[text()='Add']")).click();
			Thread.sleep(2000);
		}
		
		//after clicking on add and then we need to verify that it is added or not
		WebElement verify=driver.findElement(By.xpath("//p[text()='Item has been added to your basket successfully']"));
		
		//verify
		if(verify.isDisplayed())
			System.out.println(verify.getText());
		else
			System.out.println("Item has Not Added to your basket");
		
		Thread.sleep(2000);
		
		//close the browser
		driver.quit();
	}
}





