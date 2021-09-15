package com.makemytrip.generic_utils;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;




public class ExcelUtilityClass {
	
	public String getExcelData(String sheetName,int rownum,int cellnum) throws Throwable {
		FileInputStream file=new FileInputStream("./src/test/TestData.xlsx");
		Workbook workbook=WorkbookFactory.create(file);
		Sheet sheet=workbook.getSheet(sheetName);
		Row row=sheet.getRow(rownum);
		Cell cell=row.getCell(cellnum);
		return cell.getStringCellValue();

}
}
