package com.automation.utility;

import java.io.File;
import java.io.FileInputStream;
//import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {

	XSSFWorkbook wb;

	public ExcelDataProvider() {

		String currentDirectory = System.getProperty("user.dir");
		String xmlfilepath = "\\\\TestData\\\\Data.xlsx";
		File src = new File(currentDirectory + xmlfilepath);

		try {
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("unable to read excel file" + e.getMessage());
		}

	}

	public String getstringdata(String sheetname, int row, int cloumn) {
		return wb.getSheet(sheetname).getRow(row).getCell(cloumn).getStringCellValue();
	}

	public double numericdata(String sheetname, int row, int cloumn) {
		return wb.getSheet(sheetname).getRow(row).getCell(cloumn).getNumericCellValue();
	}

}
