package sprint1;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class EmployeeDetails {
	public static void main(String[] args) throws IOException {
		//Set the workbook path
		XSSFWorkbook wbook= new XSSFWorkbook("./data/login.xlsx");
		
		// Get into the particular sheet
		XSSFSheet wsheet = wbook.getSheetAt(0);
		
		// Get the number of Rows
		int rowCount = wsheet.getLastRowNum();
		System.out.println(rowCount);
		
		// Get the number of Columns - Get into the header row through index and get the last column number
		short columnCount = wsheet.getRow(0).getLastCellNum();
		System.out.println(columnCount);
		
		// Iterate the data
		for(int i=1;i<=rowCount;i++) {
			XSSFRow row = wsheet.getRow(i);
			for(int j=0;j<columnCount;j++) {
				 String stringCellValue = row.getCell(j).getStringCellValue();
				 System.out.println(stringCellValue);
			}
			System.out.println("--------------------------------");
		}
	}
}
