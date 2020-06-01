package com.testCases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.appObjects.App_Login;
import com.base.BaseTest;
import com.utilities.Constants;
import com.utilities.Log4j;
import com.utilities.TestUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyLogIn extends BaseTest {

	@DataProvider(name = "Authentication")
	public static Object[][] getTestDataSet() {
		Object data[][] = new TestUtils().getTestData("test_accounts");
		return data;
	}

	/*
	 * @BeforeTest public void init() {
	 * 
	 * }
	 */

	@BeforeMethod
	public void setup() throws Exception {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get(Constants.WEB_URL);
		Log4j.info("Lauching: " + Constants.WEB_URL);


	}

	@Test(dataProvider = "Authentication")
	public void testRunner(String sUsername, String sPassword) throws Exception {


		String actualBoxMsg;
		String EXPECT_ERROR = "User or Password is not valid";

		App_Login.Execute(driver, sUsername, sPassword);

		/*
		 * Determine Pass Fail Status of the Script If login credentials are correct,
		 * Alert(Pop up) is NOT present. An Exception is thrown and code in catch block
		 * is executed If login credentials are invalid, Alert is present. Code in try
		 * block is executed
		 */

		try {

			Alert alt = driver.switchTo().alert();
			actualBoxMsg = alt.getText(); // get content of the Alter Message
			alt.accept();
			// Compare Error Text with Expected Error Value
			softAssert.assertEquals(actualBoxMsg, EXPECT_ERROR);

		} catch (NoAlertPresentException Ex) {
			// Get text displayes on login page

			String expectedText = driver.findElement(By.xpath("//tbody/tr[@class='heading3']")).getText();

			softAssert.assertTrue(expectedText.contains(sUsername));

		}
	}

	@AfterMethod
	public void tearDown() {
		
	}

}
