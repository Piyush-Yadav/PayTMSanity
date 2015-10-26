package com.paytm.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ReadExcel {
String[][] data = null;
String[] column = null;
int rownum;
int colnum;
HSSFSheet ws;
int getrow;

// Get all data from the excel sheet
	public String[][] getData() throws IOException{
		loadExcel();
		for (int i = 0; i < rownum; i++) {
			HSSFRow row = ws.getRow(i);
			for (int j = 0; j < colnum; j++) {
				HSSFCell cell = row.getCell(j);
				String value = getCellValue(cell);
				data[i][j] = value;
			}
		}
		return data;
	}
	
//  Read data from entire row using data element
	public String[][] getRow(String rowElement) throws IOException{
		loadExcel();
		for (int i = 0; i < rownum; i++) {
			for (int j = 0; j < colnum; j++) {
				HSSFRow row = ws.getRow(i);
				HSSFCell cell = row.getCell(j);
				String value = getCellValue(cell);
					if(value.equals(rowElement)){
				    getrow = i;
				    }
		    }
		}
		HSSFRow row = ws.getRow(getrow);
		for (int j = 0; j < colnum; j++) {	
			   HSSFCell cell = row.getCell(j);
					String value = getCellValue(cell);
					data[0][j] = value;
					System.out.println(value+" **********************");
			}
		return data;
	 }

	public String[][] getRow(int rownum){
		int row = rownum+1;
		return data;
	}
	
	public String[] getColumn(String field){
		return column;
	}
	
	
	public String[] getCell(int row,int col){
		 return column;
	}
	
//Private methods
	private void loadExcel() throws IOException{
		File excel = new File("/home/piyushyadav/data.xls");
		FileInputStream fis = new FileInputStream(excel);
		HSSFWorkbook wb = new HSSFWorkbook(fis);
		ws = wb.getSheet("Sheet1");
		 rownum = ws.getLastRowNum()+1;
		 colnum = ws.getRow(0).getLastCellNum();
		data = new String[rownum][colnum];
	}
	
	private String getCellValue(HSSFCell cell) {
		Object result = null;
		int type = cell.getCellType();
		switch(type){
		case 0:
			result =  cell.getNumericCellValue();
			break;
		case 1:
			result = cell.getStringCellValue();
			break;
		case 2:
			result = "--";
			break;
		case 3:
			result = "--";
			break;
		}
		return result.toString();
	}

}
