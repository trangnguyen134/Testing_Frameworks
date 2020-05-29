package com.testCases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.appObjects.App_Login;
import com.base.BaseTest;
import com.utilities.TestUtils;

public class VerifyLogIn extends BaseTest {

	@BeforeTest

	public void setUp() {

	}

	@DataProvider
	public static Object[][] getTestDataSet() {
		Object data[][] = new TestUtils().getTestData("test_accounts");
		return data;
	}

	@Test(dataProvider = "getTestDataSet")
	public void testRunner(String sUsername, String sPassword) throws Exception {

		String expectedTitle = "Guru99 Bank Manager HomePage";
		String expectedError = "User or Password is not valid";

		App_Login.Execute(driver, sUsername, sPassword);

		try {

			Alert alt = driver.switchTo().alert();
			String actualBoxtitle = alt.getText(); // get content of the Alter Message
			alt.accept();
			if (actualBoxtitle.contains(expectedError)) { // Compare Error Text with Expected Error Value
				System.out.println("Test case SS: Passed");
			} else {
				System.out.println("Test case SS: Failed");
			}
		} catch (NoAlertPresentException Ex) {
			String actualTitle = driver.getTitle();
			// On Successful login compare Actual Page Title with Expected Title
			if (actualTitle.contains(expectedTitle)) {
				System.out.println("Test case SS: Passed");
			} else {
				System.out.println("Test case SS: Failed");
			}

		}
	}

	@AfterTest

	public void cleanUp() {

	}

}
