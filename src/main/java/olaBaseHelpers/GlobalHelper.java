package olaBaseHelpers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.sun.media.sound.InvalidFormatException;

public class GlobalHelper {

	public String configPath= "./src/test/resources/Config/config.properties";
	public String dbConfigPath= "./src/test/resources/Config/db.properties";
	public String contentTypeJson="application/json";
	
	static Workbook wb;
	static Sheet sheet;

	public static Object[][] getTestData(String sheetName, String filePath)
			throws org.apache.poi.openxml4j.exceptions.InvalidFormatException {
		FileInputStream file = null;
		try {
			file = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			wb = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = wb.getSheet(sheetName);

		int rowCount = sheet.getLastRowNum();
		int colnCount = sheet.getRow(0).getLastCellNum();

		Object[][] excel = new Object[rowCount][colnCount];

		for (int i = 0; i < rowCount; i++) {
			for (int j = 0; j < colnCount; j++) {
				excel[i][j] = sheet.getRow(i + 1).getCell(j).toString();
				// System.out.println(data[i][k]);
			}
		}

		return excel;
	}

	public String readFromPropertiesFile(String fileName, String propertyName) throws IOException {

		String propertyValue = null;
		InputStream input = null;
		Properties prop = new Properties();
		try {
			input = new FileInputStream(fileName);
			prop.load(input);
			propertyValue=prop.getProperty(propertyName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return propertyValue;
	}

	
	public static String getDatafromDB(String dbcon,String databaseusername,String password,String Querystr,String row)
	{
		String value="";
		Statement stmnt;
		try {
			Class.forName("oracle.jdbc.OracleDriver").newInstance();
			Connection con=DriverManager.getConnection(dbcon, databaseusername, password);
			stmnt=con.createStatement();
			ResultSet rs=stmnt.executeQuery(Querystr);
			while(rs.next())
			{
				value=rs.getString(row);
				break;
			}
		}
			catch (Exception e) {
			System.out.println(e);
		}
		 
	return value;
}
}
