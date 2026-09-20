package Data;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Day12_data
{
    public String browser;
    public String url;
    public String username;
    public String password;
    public String vacancyname;
    public String description;
    public String hiringmanager;
    public String no_positions;
    public String fn;
    public String ln;
    public String empid;
    
    

    public void datastorage() throws IOException
    {
        FileInputStream fis=new FileInputStream("./src/test/resources/Day12/Testcase1.properties");

        Properties p=new Properties();
        p.load(fis);

        browser=p.getProperty("browser");
        url=p.getProperty("url");
        username=p.getProperty("username");
        password=p.getProperty("password");

        FileInputStream fis1=new FileInputStream("./src/test/resources/Day12/Day12.xlsx");

        Workbook wb=WorkbookFactory.create(fis1);

        vacancyname=wb.getSheet("Sheet1").getRow(1).getCell(0).getStringCellValue();
        description=wb.getSheet("Sheet1").getRow(1).getCell(1).getStringCellValue();
        hiringmanager=wb.getSheet("Sheet1").getRow(1).getCell(2).getStringCellValue();
        no_positions=wb.getSheet("Sheet1").getRow(1).getCell(3).getStringCellValue();
        fn=wb.getSheet("Sheet1").getRow(1).getCell(4).getStringCellValue();
        ln=wb.getSheet("Sheet1").getRow(1).getCell(5).getStringCellValue();
        empid=wb.getSheet("Sheet1").getRow(1).getCell(6).getStringCellValue();
    }
}