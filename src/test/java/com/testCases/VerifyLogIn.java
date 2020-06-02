package com.testCases;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import com.appObjects.Login;
import com.appObjects.Logout;
import com.base.BaseTest;
import com.utilities.Constants;
import com.utilities.Log4j;
import com.utilities.ResourceManager;
import com.utilities.TestUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

@Test
public class VerifyLogIn extends BaseTest {

	String screenshotPath = new ResourceManager().getSCREENSHOT_PATH();

	@DataProvider(name = "Authentication")
	public static Object[][] getTestDataSet() {
		Object data[][] = new TestUtils().getTestData("test_accounts");
		return data;
	}

	@BeforeMethod
	public void setup() throws Exception {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		// WebDriver driver = new BaseTest().setDriver();

		driver.get(Constants.WEB_URL);
		Log4j.info("Lauching: " + Constants.WEB_URL);

	}

	@Test(dataProvider = "Authentication")
	public void testRunner(String sUsername, String sPassword) throws Exception {

		String actualBoxMsg;
		String EXPECT_ERROR = "User or Password is not valid";
		String sTestCaseName = this.getClass().getName();

		Login.Execute(sUsername, sPassword);

		try {

			Alert alt = driver.switchTo().alert();
			actualBoxMsg = alt.getText(); // get content of the Alter Message
			alt.accept();
			// Compare Error Text with Expected Error Value
			softAssert.assertEquals(actualBoxMsg, EXPECT_ERROR);
			TestUtils.takeScreenshot(sTestCaseName);

		} catch (NoAlertPresentException Ex) {

			// Get text displays on login page
			String expectedText = driver.findElement(By.xpath("//tbody/tr[@class='heading3']")).getText();
			softAssert.assertTrue(expectedText.contains(sUsername));
			TestUtils.takeScreenshot(sTestCaseName);

		//	Logout.Execute();

		}
	}

	@AfterTest
	public void teardown() throws Exception {
		driver.quit();
	}

}
