package Generic_Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility {

	/**
	 * This method is used to read data from ExcelSheet
	 * @param sheetName
	 * @param rownum
	 * @param cellNum
	 * @return
	 * @throws Throwable
	 * @author Shobha
	 */
	public String getExcelData(String sheetName,int rownum,int cellNum) throws Throwable
	{
		
	//	FileInputStream fes = new FileInputStream("./src/test/resources/TestData7am.xlsx");
		FileInputStream fes = new FileInputStream(IPathConstant.ExcelPAth);
		// step2:- open workbook in read mode
		Workbook book = WorkbookFactory.create(fes);

		// step3:-get control of the Sheet
		Sheet sheet = book.getSheet(sheetName);

		// step4:-get control of the row
		Row row = sheet.getRow(rownum);

		// step5:-get control of the cell
		Cell cel = row.getCell(cellNum);

		// //step6:-read cell value
		String ExcelData = cel.getStringCellValue();
		
		return ExcelData;
		}
	
	/**
	 * This method is used to read data from Excel using DataFormatter
	 * @param SheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws Throwable
	 */
	public String getExcelDataUsingDataFormatter(String SheetName,int rowNum,int cellNum) throws Throwable
	{
		FileInputStream fes = new FileInputStream("./src/test/resources/TestData7am.xlsx");
		// step2:- open workbook in read mode
		Workbook book = WorkbookFactory.create(fes);

		// step3:-get control of the Sheet
		Sheet sheet = book.getSheet(SheetName);

		// step4:-get control of the row
		Row row = sheet.getRow(rowNum);

		// step5:-get control of the cell
		Cell cel = row.getCell(cellNum);

		DataFormatter format = new DataFormatter();
		String ExcelData = format.formatCellValue(cel);
		return ExcelData;
		
	}
	
	public Object[][] getDataProviderData(String sheetName) throws Throwable
	{
		FileInputStream fes = new FileInputStream("./src/test/resources/TestData7am.xlsx");
		// step2:- open workbook in read mode
		Workbook book = WorkbookFactory.create(fes);

		// step3:-get control of the Sheet
		Sheet sheet = book.getSheet(sheetName);
		
		int lastRow = sheet.getLastRowNum();
		int lastCell = sheet.getRow(0).getLastCellNum();
		
		Object[][] objArr = new Object[lastRow][lastCell];
		
		for (int i = 0; i <=lastRow; i++)
		{	
			for (int j = 0; j <lastCell; j++) 
			{
				objArr[i][j]=sheet.getRow(i).getCell(j).toString();
			}
		}
		
		return objArr;
		
	}
	
}
