package Day8;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Testcase1Pompage
{
    public static void main(String[] args) throws IOException, InterruptedException
    {
        // ================= COMMON DATA FROM PROPERTIES =================

        FileInputStream fis = new FileInputStream(
                "./src/test/resources/Day8/Day8_Testcase1.properties");

        Properties p = new Properties();

        p.load(fis);

        String browser = p.getProperty("browser");
        String url = p.getProperty("url");
        String username = p.getProperty("username");
        String password = p.getProperty("password");


        // ================= TEST SPECIFIC DATA FROM EXCEL =================

        FileInputStream fis2 = new FileInputStream(
                "./src/test/resources/Day8/Day8_orangehrrm.xlsx");

        Workbook wb = WorkbookFactory.create(fis2);

        String fn = wb.getSheet("Sheet1").getRow(1).getCell(0).getStringCellValue();
        String mn = wb.getSheet("Sheet1").getRow(1).getCell(1).getStringCellValue();
        String ln = wb.getSheet("Sheet1").getRow(1).getCell(2).getStringCellValue();
        String email = wb.getSheet("Sheet1").getRow(1).getCell(3).getStringCellValue();
        String mobileno = wb.getSheet("Sheet1").getRow(1).getCell(4).getStringCellValue();
        String filepath = wb.getSheet("Sheet1").getRow(1).getCell(5).getStringCellValue();
        String dateofapp = wb.getSheet("Sheet1").getRow(1).getCell(6).getStringCellValue();
        String candidatename = wb.getSheet("Sheet1").getRow(1).getCell(7).getStringCellValue();
        String fromdate = wb.getSheet("Sheet1").getRow(1).getCell(8).getStringCellValue();
        String todate = wb.getSheet("Sheet1").getRow(1).getCell(9).getStringCellValue();


        // ================= LAUNCH BROWSER =================

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

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get(url);


        // ================= CREATE POM OBJECT =================

        Testcase1PomUtilities qs = new Testcase1PomUtilities(driver);

        Thread.sleep(2000);


        

        // ================= RECRUITMENT =================

        qs.getRecruitment();

        Thread.sleep(2000);

        qs.getAdd();

        Thread.sleep(2000);


        // ================= ENTER TEST DATA =================

        qs.getFirstname(fn);

        qs.getMiddlename(mn);

        qs.getLastname(ln);

        qs.getVacancy();

        qs.getEmail(email);

        qs.getMobileNumber(mobileno);

        qs.uploadFile(filepath);

        qs.getDateOfApplication(dateofapp);

        qs.clickSave();


        // ================= CANDIDATES =================

        Thread.sleep(3000);

        qs.clickCandidates();

        Thread.sleep(2000);

        qs.selectJobTitle();

        qs.selectCandidateVacancy();

        qs.selectHiringManager();

        qs.selectStatus();

        qs.getCandidateName(candidatename);

        qs.getApplicationDate(fromdate, todate);

        qs.clickSearch();

        Thread.sleep(3000);


        // ================= VERIFY CANDIDATE =================

        qs.verifyCandidate(candidatename);


        // ================= LOGOUT =================

        qs.logout();

        Thread.sleep(2000);


        // ================= CLOSE =================

        wb.close();

        fis2.close();

        fis.close();

        driver.quit();
    }
}
