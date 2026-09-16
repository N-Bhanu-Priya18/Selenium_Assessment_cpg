package Day8;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Day8.HomepagePomutilities;
import Day8.LoginpagePomUtilities;
import Day8.RecruitmentPomUtilities;
import Day8.CandidatesPomUtilities;

public class TestcasePompageImplementation 
{
	public static void main(String[] args) throws IOException, InterruptedException, AWTException
	{
		//READ DATA FROM PROPERTIES FILE
		FileInputStream fis1 = new FileInputStream("./src/test/resources/Day8/Day8_Testcase1.properties");	
		Properties p = new Properties();	
		p.load(fis1);
		
		String browser = p.getProperty("browser");
		String url = p.getProperty("url");
		String un = p.getProperty("username");
		String pwd = p.getProperty("password");
		
		//READ DATA FROM EXCEL FILE
		FileInputStream fis2 = new FileInputStream("./src/test/resources/Day8/Day8_orangehrrm.xlsx");
		Workbook wb = WorkbookFactory.create(fis2);
		
		String fn = wb.getSheet("Sheet1").getRow(1).getCell(0).getStringCellValue();
		String mn = wb.getSheet("Sheet1").getRow(1).getCell(1).getStringCellValue();
		String ln = wb.getSheet("Sheet1").getRow(1).getCell(2).getStringCellValue();
		String email = wb.getSheet("Sheet1").getRow(1).getCell(3).getStringCellValue();
		String phno = wb.getSheet("Sheet1").getRow(1).getCell(4).getStringCellValue();
		String filepath = wb.getSheet("Sheet1").getRow(1).getCell(5).getStringCellValue();
		String date = wb.getSheet("Sheet1").getRow(1).getCell(6).getStringCellValue();
		String cname = wb.getSheet("Sheet1").getRow(1).getCell(7).getStringCellValue();
		String fromdate = wb.getSheet("Sheet1").getRow(1).getCell(8).getStringCellValue();
		String todate = wb.getSheet("Sheet1").getRow(1).getCell(9).getStringCellValue();
		
		
		// Launch browser
		WebDriver driver = null;

		if(browser.equalsIgnoreCase("chrome"))
		{
		    driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
		    driver = new EdgeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
		    driver = new FirefoxDriver();
		}

		//maximize the browser
		driver.manage().window().maximize();
		
		//apply implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		//create object 
		LoginpagePomUtilities login = new LoginpagePomUtilities(driver);
		HomepagePomutilities homepage = new HomepagePomutilities(driver);
		RecruitmentPomUtilities recpage = new RecruitmentPomUtilities(driver);
		CandidatesPomUtilities candpage = new CandidatesPomUtilities(driver);

		//mavigate to Ornagehrm application
		driver.get(url);

		// Login
		login.getUntf(un);
		login.getPwdtf(pwd);
		login.getLoginButton();

		// Homepage
		homepage.getRecruitment();

		// Recruitmentpage
		recpage.getAddButton();
		recpage.getFntf(fn);
		Thread.sleep(2000);
		recpage.getMntf(mn);
		Thread.sleep(2000);
		recpage.getLntf(ln);
		Thread.sleep(2000);
		recpage.getVacancy();
		Thread.sleep(2000);
		recpage.getEmailtf(email);
		Thread.sleep(2000);
		recpage.getPhnotf(phno);
		Thread.sleep(2000);
		recpage.getFileUpload(filepath);
		Thread.sleep(2000);
		recpage.getSaveButton();
		Thread.sleep(2000);

		// Candidates page
		candpage.getCandidates();
		Thread.sleep(2000);
		candpage.getCname(fn);
		Thread.sleep(2000);
		candpage.getSearchButton();
		Thread.sleep(6000);

		// Verification
		if(candpage.getIsRecordsFound())
		{
		    System.out.println("Record found");
		}
		else
		{
		    System.out.println("Record not found");
		}
		Thread.sleep(2000);
		
		// Logout
		homepage.getLogoutButton();

		System.out.println("Logged out successfully");

		Thread.sleep(2000);
		driver.quit();
					
		
	}
}
