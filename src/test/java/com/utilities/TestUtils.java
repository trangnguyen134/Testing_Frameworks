package com.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.BaseTest;

public class TestUtils extends BaseTest {

	public static Workbook book;
	public static Sheet sheet;
	public static List<String> runFlag = new ArrayList<>();

	public static final String OS_NAME = System.getProperty("os.name").toLowerCase();

	/*** DATA DRIVER TESTING IMPLEMENTATION ***/

	/**
	 * This method returns data from excel spreadsheet in resource folder of the
	 * project
	 * 
	 * @param sheetName name of the spreadsheet that user wants to retrieve data
	 *                  from
	 * @return the data from spreadsheet
	 */

	public Object[][] getTestData(String sheetName) {
		//String dataFilePath = new ResourceManager().getDATASET_SPREADSHEET_PATH();
		
		String dataFilePath = "D:\\Ammie\\Study\\Selenium_Cert\\EclipseRepo\\Testing_Frameworks\\src\\test\\resources\\TestData.xlsx";

		FileInputStream file = null;

		try {
			file = new FileInputStream(dataFilePath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// get the sheet name
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		// Store all data in an array
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			runFlag.add(sheet.getRow(i + 1).getCell(0).toString());
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				// Get content of each cell and store to each array element.
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
			}
		}
		return data;
	}

	
	/*** END OF DATA DRIVER TESTING IMPLEMENTATION ***/

	/*** GET METHOD METHOD IMPLEMENTATION ***/
	public static String getTodayDateWithFormat(String format) {
		DateFormat dateFormat = new SimpleDateFormat(format);
		Date date = new Date();
		String today = dateFormat.format(date);
		return today;
	}

	/*** END OF METHOD METHOD IMPLEMENTATION ***/

	/**
	 * This method wait until the element is clickable. This method use the xpath of
	 * the element to find the element.
	 * 
	 * @param xpath use xpath to find the web element.
	 * @exception will throw exception when time out for waiting.
	 */

	public static void waitElementToBeClickableByXpath(String xpath) {
		try {
			new WebDriverWait(driver, Constants.IMPLICITLY_WAIT)
					.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
		} catch (org.openqa.selenium.TimeoutException e) {

		}

	}

}
