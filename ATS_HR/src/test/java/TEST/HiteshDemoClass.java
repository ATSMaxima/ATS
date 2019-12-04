package TEST;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import Generic.ExcelReader;

public class HiteshDemoClass {

	private static final String DD_LOGIN_EXCEL = null;
	private String str  = "Login";

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	 
	public static void setExcelData(String sheetname, int rownum, int cellnum, String value, String excelPath) {
		String path = excelPath;
		try {
			Workbook ExcelWBook = WorkbookFactory.create(new FileInputStream(path));
			Sheet ExcelWSheet = ExcelWBook.getSheet(sheetname);
			Row row = ExcelWSheet.getRow(rownum);
			Cell cell = row.createCell(cellnum);
			cell.setCellValue(value+"--"+System.currentTimeMillis());
			ExcelWBook.write(new FileOutputStream(path));
		} catch (Exception e) {
			e.printStackTrace();
		}

	for (int i = 1; i < 5; i++) {
		  
	      //int count =1;
		if (str.equalsIgnoreCase("Login")) {
			ExcelReader.setExcelData("Sheet1", i, 2, "fail", DD_LOGIN_EXCEL);
			System.out.println("Test Case is failed "+i+"----");
			
			break;
			
			
		} else if (str.contains("Applicant Tracking System")) {
			ExcelReader.setExcelData("Sheet1", i, 2, "pass", DD_LOGIN_EXCEL);
			System.out.println("Test Case is Passed " +i+ "-----");
			
		    break;
		}

		//count++;
	}

}
