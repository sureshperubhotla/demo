package com.mercurytours.utils;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public XSSFWorkbook wb;
	public XSSFSheet sheet;
	public ReadExcel(String excelpath) {
		try {
		
		File src = new File(excelpath);
		FileInputStream fis = new FileInputStream(src);
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheetAt(0);
				
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public String getData(int sheetnumber, int row, int col) {
		
		sheet=wb.getSheetAt(sheetnumber);
		String data=sheet.getRow(row).getCell(col).getStringCellValue();
		return data;
	}
}