/*
 //Testcase 3
1.Navigate to Demoappsqspiders application
2.Enter name, email,password and click on login submit button
3.Read the data from json file.
*/

package Day5_assessment;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Testcase3_Using_JSONFile {

	public static void main(String[] args) throws IOException, Exception {

		// Read data from JSON file
		FileReader fir = new FileReader("./src/test/resources/Data_Driven_Testing/Testcase3_json.json");

		JSONParser j = new JSONParser();

		Object javaobj = j.parse(fir);

		JSONObject json = (JSONObject)javaobj;

		// Store the data from JSON file in variables
		String browser = json.get("browser").toString();
		String url = json.get("url").toString();
		String name = json.get("name").toString();
		String email = json.get("email").toString();
		String pwd = json.get("password").toString();

		WebDriver driver = null;

		// Launch the browser --> Do not hardcode it
		if(browser.equals("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(browser.equals("edge"))
		{
			driver = new EdgeDriver();
		}
		else if(browser.equals("firefox"))
		{
			driver = new FirefoxDriver();
		}

		// Maximize the browser window
		driver.manage().window().maximize();

		// Apply implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// 1. Navigate to Demoappsqspiders application --> Do not hardcode
		driver.get(url);

		// 2. Enter name, email and password by reading the data from JSON file
		driver.findElement(By.id("name")).sendKeys(name,Keys.TAB,email,Keys.TAB,pwd);

		// Click on login submit button
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='Register']")).click();

		// Close the browser
		Thread.sleep(2000);
		driver.quit();

	}

}
