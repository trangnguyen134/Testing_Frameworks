package com.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.*;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.base.BaseTest;

public class TestUtils extends BaseTest {

	public static Workbook book;
	public static Sheet sheet;
	public static List<String> runFlag = new ArrayList<>();

	public static final String OS_NAME = System.getProperty("os.name").toLowerCase();

	/*** DATA DRIVER TESTING IMPLEMENTATION ***/

	public Object[][] getTestData(String dataFilePath, String sheetName) {
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
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			runFlag.add(sheet.getRow(i + 1).getCell(0).toString());
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
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

}
