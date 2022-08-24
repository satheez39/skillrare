package com.EducationalDomain.tcs.genericLib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;

import com.mysql.jdbc.Driver;


/**
 * 
 * @author GSK
 *
 */

public class FileUtilies {
	/**
	 * it is used to read data from property file
	 * @param key
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static Connection con;
	public String getPropertyFile(String key) throws FileNotFoundException, IOException {
		Properties p=new Properties();
		p.load(new FileInputStream(AutoConstant.datapropertyfile));
		return p.getProperty(key);
	}
	/**
	 * it is used to read data from excel sheet
	 * @param sheetname
	 * @param rownum
	 * @param cellnum
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String getExcelfile(String sheetname, int rownum, int cellnum) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(AutoConstant.excelfilepath); 
		Workbook wb = WorkbookFactory.create(fis); 
		return wb.getSheet("sheetName").getRow(rownum).getCell(cellnum).getStringCellValue();
		
	}
	
	@DataProvider
	public Object[][] readExcelData() throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(AutoConstant.excelfilepath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1");
		int rowNum = sh.getLastRowNum();
		short cellNum = sh.getRow(1).getLastCellNum();
		Object obj[][]=new Object[rowNum][cellNum];
		for(int i=0;i<rowNum;i++) {
			for(int j=0;j<cellNum;j++) {
				obj[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
				System.out.println(obj[i][j]);
			}
		}
		return obj;
	}
	/**
	 * it used to read data from  database
	 * @return
	 * @throws SQLException
	 */
	public static Connection getDataDb() throws SQLException {
		Driver driverref=new Driver();
		DriverManager.registerDriver(driverref);
		return con=DriverManager.getConnection("jdbc:mysql://localhost:3306/advsel","root","root");
	}
	public static String queryExecution(String query,int column,String expdata) throws SQLException {
		Statement statement=con.createStatement();
		ResultSet result=statement.executeQuery(query);
		while(result.next()) {
			if(result.getString(column).equals(expdata)) {
				break;
			}
			else {
				Reporter.log("data not matching");
			}
		}
		return expdata;
	}
			
		
}


