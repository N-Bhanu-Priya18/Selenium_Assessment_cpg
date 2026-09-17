package Data;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Day10_specificdata 
{
	public String fn;
	public String ln;
	public String postalcode;
	public String productpage;
	public String oneincart;
	public String saucebackup;
	public String checkout;
	public String orderplaced;

	public void sdata() throws EncryptedDocumentException, IOException
	{
		FileInputStream fis1 = new FileInputStream("./src/test/resources/Day10_assessment/Day10_Saucedemo.xlsx");
		
		Workbook wb = WorkbookFactory.create(fis1);

		fn = wb.getSheet("Sheet1").getRow(1).getCell(0).getStringCellValue();

		ln = wb.getSheet("Sheet1").getRow(1).getCell(1).getStringCellValue();

		postalcode = wb.getSheet("Sheet1").getRow(1).getCell(2).getStringCellValue();

		productpage = wb.getSheet("Sheet1").getRow(1).getCell(3).getStringCellValue();

		oneincart = wb.getSheet("Sheet1").getRow(1).getCell(4).getStringCellValue();

		saucebackup = wb.getSheet("Sheet1").getRow(1).getCell(5).getStringCellValue();

		checkout = wb.getSheet("Sheet1").getRow(1).getCell(6).getStringCellValue();

		orderplaced = wb.getSheet("Sheet1").getRow(1).getCell(7).getStringCellValue();
	}
}