package DDT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class InsertingDataIntoExcelUSingMap {

	public static void main(String[] args) throws Throwable {

		FileInputStream fis = new FileInputStream("./src/test/resources/TestData7am.xlsx");

		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet("Sheet3");

		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
		map.put("10", "Banglore");
		map.put("20", "hyd");
		map.put("30", "Goa");
		map.put("40", "pune");

		int runNum = 0;
		for (Entry<String, String> m : map.entrySet()) {
			Row row = sheet.createRow(runNum++);
			row.createCell(0).setCellValue((String) m.getKey());// 10
			row.createCell(1).setCellValue((String) m.getValue());// Banglore

		}
		FileOutputStream fos = new FileOutputStream("./src/test/resources/TestData7am.xlsx");
		book.write(fos);
		book.close();

	}

}
