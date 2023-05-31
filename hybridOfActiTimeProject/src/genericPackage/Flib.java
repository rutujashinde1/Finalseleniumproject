package genericPackage;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class Flib {
	//it is used to store generic reusable methods
	public void readExcelData(String excelPath,String sheetName,int rowCount,int cellCount) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(excelPath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetName);
		Row row=sheet.getRow(rowCount);
		Cell cell = row.getCell(cellCount);
		
		
	}
	

}
