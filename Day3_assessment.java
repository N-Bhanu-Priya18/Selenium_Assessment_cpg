/*Test Case 1 

1.Navigate EaseMyTrip and handle the notification popup.
2.Select One Way.
3.Enter any state  in the From field and select a valid suggestion.
4.Enter another state  in the To field and select a valid suggestion.
5.Click the Departure Date field.
6.Select any available future date from the calendar.
7.Click Traveller & Class.
8.Select 2 Adults and keep the class as Economy.
9.Click Search.
10.Verify that the flight-results page is displayed.
  */
//CODE:
package Day_3_assignment;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Testcase1 
{
	public static void main(String[] args) throws InterruptedException 
	{
		//We are avoiding notification popup
		
		//1.create object for browser specific options
		ChromeOptions option=new ChromeOptions();
		
		//2.call addArguments() using ref variable(option) and pass corect command
		option.addArguments("--disable-notifications");
		
		//pass the option ref variable while launching the browser as an argument
		WebDriver driver=new ChromeDriver(option);
		
		//Maximize the browser
		driver.manage().window().maximize();
		
		//Apply implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//naviagate to easemytrip application
		driver.get("https://easemytrip.com/");
		Thread.sleep(2000);
		
		//select one way
		driver.findElement(By.xpath("//li[@id='oway']")).click();
		Thread.sleep(2000);
		
		//Enter any state  in the From field and select a valid suggestion.
		//FROM field
		driver.findElement(By.xpath("//input[@id='FromSector_show']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='a_FromSector_show']")).sendKeys("Bangalore");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@id='spnBengaluru']")).click();
		Thread.sleep(2000);
		
		//Enter another state  in the To field and select a valid suggestion.
		//TO field
		driver.findElement(By.xpath("//input[@id='a_Editbox13_show']")).sendKeys("Mumbai");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//p[@id='airportMumbai']")).click();
		Thread.sleep(2000);
		
		//Click the Departure Date field.
		//Select any available future date from the calendar.
		
		driver.findElement(By.xpath("//img[@id='img2Nex']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//img[@id='img2Nex']")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//li[@id='snd_4_10/12/2026']")).click();
		Thread.sleep(2000);
		
		//Click Traveller & Class.
		driver.findElement(By.xpath("//div[@id='myFunction4']")).click();
		Thread.sleep(2000);
		
		//Select 2 Adults and keep the class as Economy.
		driver.findElement(By.xpath("//button[@id='add']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='rbEconomy']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@id='traveLer']")).click();
		Thread.sleep(2000);
		
		//Click Search.
		driver.findElement(By.xpath("//input[@value='Search']")).click();
		Thread.sleep(2000);
		
		//Verify that the flight-results page is displayed.
		
		//using getTitle() to verify
		String title=driver.getTitle();

		if(title.contains("EaseMyTrip.com Lowest Airfare, Flight Tickets, Cheap Air Tickets – EaseMyTrip.com"))
			System.out.println("Flight results page is displayed");
		else
			System.out.println("Flight results page is not displayed");
		
		Thread.sleep(2000);
		
		//close the browser
		driver.quit();
	}

}

/*Testcase 2

1.NAvigate to demo appa qspiders date picker---  (https://demoapps.qspiders.com/ui/datePick?sublist=0)
2.Click on calender.
3. Navigate to the next month in the current year.
4. Select any valid date from that month.
5. Verify that the selected date is displayed correctly in the date field.
  */
//CODE:
package Day_3_assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Testcase2 {

	public static void main(String[] args) throws InterruptedException 
	{
		//Launch the browser
		WebDriver driver = new ChromeDriver();
		
		//maximize the browser
		driver.manage().window().maximize();
		
		//apply implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Navigate to demoapps qspiders date picker
		driver.get("https://demoapps.qspiders.com/ui/datePick?sublist=0");
		Thread.sleep(2000);
		
		//Click on calender.
		driver.findElement(By.xpath("//input[@placeholder='Select A Date']")).click();
		Thread.sleep(2000);
		
		//Navigate to the next month in the current year.
		driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
		Thread.sleep(2000);
		
		//Select any valid date from that month.
		driver.findElement(By.xpath("//div[text()='15']")).click();
		Thread.sleep(2000);
		
		//Verify that the selected date is displayed correctly in the date field.	
		//Locate webelement
		WebElement datefield=driver.findElement(By.xpath("//input[@value='15/10/2026']"));
		
		//Use getAttribute() to verify
		System.out.println(datefield.getAttribute("value"));
		
		//condition
		if(datefield.getAttribute("value").contains("15/10/2026"))
			System.out.println("selected date is displayed");
		else
			System.out.println("selected date is not displayed");
		
		Thread.sleep(2000);
		
		//close the browser
		driver.quit();
	}

}

