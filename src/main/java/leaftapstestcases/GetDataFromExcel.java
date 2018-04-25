package leaftapstestcases;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GetDataFromExcel {
	
	@Test
	public Object[][] getDataFromExcel() throws IOException {
		//1.open the workbook
		XSSFWorkbook Wbook = new XSSFWorkbook("./ReadData/TC001.xlsx");
		//2.get the working sheet
		XSSFSheet sheet = Wbook.getSheetAt(0);
		//3.get the row count excluding the header
		int rowcount = sheet.getLastRowNum();
		//4.get the header row
		XSSFRow headerRow = sheet.getRow(0);
		//5.get the column count
		short colcount = headerRow.getLastCellNum();
		Object[][] data = new Object[rowcount][colcount];
		for (int j = 1; j <= rowcount; j++) {
			XSSFRow row = sheet.getRow(j);
			for (int i = 0; i < colcount; i++) {
				String cellvalue = row.getCell(i).getStringCellValue();
				System.out.println(cellvalue);
				data[j-1][i]=cellvalue;
			} 
		}
		Wbook.close();
		return data;
	}

}
