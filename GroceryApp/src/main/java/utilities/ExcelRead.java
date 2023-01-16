package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelRead {
	
	public static FileInputStream f;
	public static XSSFWorkbook w;
	public static XSSFSheet s;
	
	public static String readStringData(int row, int column){

		try {
			f = new FileInputStream(System.getProperty("user.dir")+ "\\src\\main\\resources\\UploadFile\\Data.xlsx");
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		try {
			w = new XSSFWorkbook(f);
		} catch (IOException e) {
			
			e.printStackTrace();
	//		throw(e);
		}
		s = w.getSheet("Sheet1");
		Row r = s.getRow(row);
		Cell c = r.getCell(column);
		return c.getStringCellValue();	
	}
	
	
	public static String readIntegerData(int row, int column) 
	{
		try {
			f = new FileInputStream(System.getProperty("user.dir")+ "\\src\\main\\resources\\UploadFiles\\Data.xlsx");
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		try {
			w = new XSSFWorkbook(f);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		s = w.getSheet("Sheet1");
		Row r = s.getRow(row);
		Cell c = r.getCell(column);
		int a =(int) c.getNumericCellValue();
		return String.valueOf(a);
	}
}