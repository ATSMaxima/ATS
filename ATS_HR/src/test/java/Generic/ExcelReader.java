package Generic;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelReader implements AutoConstants {
	private static Sheet ExcelWSheet;
	private static Workbook ExcelWBook;
	private static Cell cell;
	private static Row row;

	// fetch data from specific row and column

	public static Object[][] getTableArray(String FilePath, String SheetName) {
		String[][] tabObjArray = null;
		try {
			FileInputStream ExcelFile = new FileInputStream(FilePath);
			ExcelWBook = WorkbookFactory.create(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(SheetName);
			int ci, cj;
			int totalRows = ExcelWSheet.getLastRowNum();
			int cellNo = ExcelWSheet.getRow(0).getLastCellNum();
			System.out.println("rows---- "+totalRows);
			System.out.println("columns----"+cellNo);
			// you can write a function as well to get Column count
			int totalCols = cellNo;
			tabObjArray = new String[totalRows][totalCols];
			ci = 0;
			for (int i = 1; i <= totalRows; i++, ci++) {
				cj = 0;
				for (int j = 0; j <= cellNo - 1; j++, cj++) {
					tabObjArray[ci][cj] = getCellData(i, j);
				}
			}

		} catch (Exception e) {
			//System.out.println(e);
			e.printStackTrace();
		}
		return (tabObjArray);
	}

	// read data from excel

	public static String getCellData(int RowNum, int ColNum) throws Exception {
		try {
			cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			// int dataType = cell.getCellType();
			// cell.setCellType(Cell.CELL_TYPE_STRING);
			
			if(cell.getCellType() == cell.CELL_TYPE_BLANK ){
				
				System.out.println("Cell is empty");
			}else{
				cell.setCellType(CellType.STRING);		
			}
			String CellData = cell.getStringCellValue();
			return CellData;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw (e);
		}
	}

	// write data in excel

	public static void setExcelData(String sheetname, int rownum, int cellnum, String value, String excelPath) {
		String path = excelPath;
		try {
			ExcelWBook = WorkbookFactory.create(new FileInputStream(path));
			ExcelWSheet = ExcelWBook.getSheet(sheetname);
			row = ExcelWSheet.getRow(rownum);
			cell = row.createCell(cellnum);
			cell.setCellValue(value);
			ExcelWBook.write(new FileOutputStream(path));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}