import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Utilclass {

	public static FileInputStream fi ;
	public static FileInputStream fo ;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	
	public static String getCellData(String xlfile,String xlsheet,int rownum,int columnnum) throws Exception {
		fi= new  FileInputStream(xlfile);
		wb = new  XSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
		row=ws.getRow(rownum);
		cell=row.getCell(columnnum);
		
		String data;
		try {
			DataFormatter dataformat = new DataFormatter();
			String celldata =  dataformat.formatCellValue(cell);
			return celldata;
		}
		catch (Exception e ){
			data="";
		}
			
		wb.close();
		fi.close();
		return data;
	}
	public static int getRowCount(String xlfile,String xlsheet) throws IOException {
		fi= new  FileInputStream(xlfile);
		wb = new  XSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
		int RowCount=ws.getLastRowNum();
				wb.close();
		fi.close();
		return RowCount;
	}
	public static int getCellCount(String xlfile, String xlsheet ,int Rownum) throws IOException {
		fi= new  FileInputStream(xlfile);
		wb = new  XSSFWorkbook(fi);
		ws=wb.getSheet(xlsheet);
		row=ws.getRow(Rownum);
		int CellCount=row.getLastCellNum();
				wb.close();
		fi.close();
		return CellCount;
	}
	
	}
	

