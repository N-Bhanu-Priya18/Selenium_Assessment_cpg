/*
 //Testcase 2
1.Navigate to orange Hrm application
2.Enter the username password and click on login button
by reading the data from excel file.
*/

package Day5_assessment;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Testcase2_Using_ExcelFile
{
	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException
	{
		// Read data from EXCEL FILE
		FileInputStream fis = new FileInputStream("./src/test/resources/Data_Driven_Testing/Testcase2_excel.xlsx");

		Workbook wb = WorkbookFactory.create(fis);

		String browser = wb.getSheet("Sheet1").getRow(1).getCell(0).getStringCellValue().toString();
		String url = wb.getSheet("Sheet1").getRow(1).getCell(1).getStringCellValue().toString();
		String un = wb.getSheet("Sheet1").getRow(1).getCell(2).getStringCellValue().toString();
		String pwd = wb.getSheet("Sheet1").getRow(1).getCell(3).getStringCellValue().toString();

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

		// 1. Navigate to Orange HRM application --> Do not hardcode
		driver.get(url);

		// 2. Enter the username by reading the data from Excel file
		driver.findElement(By.name("username")).sendKeys(un);

		// Enter the password by reading the data from Excel file
		driver.findElement(By.name("password")).sendKeys(pwd);

		// Click on login button
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		// Verify that login is successful
		WebElement text = driver.findElement(By.xpath("//h6[text()='Dashboard']"));

		if(text.isDisplayed())
			System.out.println("login successful");
		else
			System.out.println("not login");

		// Close the browser
		Thread.sleep(2000);
		driver.quit();
	}
}
