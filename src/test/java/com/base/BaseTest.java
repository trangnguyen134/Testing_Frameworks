package com.base;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;
import com.relevantcodes.extentreports.ExtentReports;
import com.utilities.Constants;
import com.utilities.Log4j;
import com.utilities.ResourceManager;
import com.utilities.TestUtils;

import io.github.bonigarcia.wdm.EdgeDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public static WebDriver driver;
	public static ExtentReports extentReport;
	public static SoftAssert softAssert;
	public static String className;
	public static WebDriverWait wait;

	/*
	 * Initialize: Web Driver Initialize: Properties Initialize: Log Initialize:
	 * Extent Report Initialize: Excel
	 * 
	 */

	@BeforeClass(alwaysRun = true)
	public void setUp() {
		/* Get class name */
		className = this.getClass().getName();

		/* Initiate Log4J instance */
		this.setLog4j(className);

		/* Initiate Web Driver instance */
		this.setDriver();

		/* LOG START TEST CASE */
		Log4j.startTestCase(className, TestUtils.OS_NAME, Constants.BROWSER);

		softAssert = new SoftAssert();

	}

	public void setDriver() {

		/* INITIATE WEB BROWSER TO EXECUTE TEST */
		switch (Constants.BROWSER.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();

			ChromeOptions chrome_options = new ChromeOptions();

			chrome_options.addArguments("--no-sandbox");
			chrome_options.addArguments("--disable-infobars");
			chrome_options.addArguments("--disable-extensions");
			chrome_options.addArguments("--disable-web-security");
			chrome_options.addArguments("--no-proxy-server");
			chrome_options.addArguments("--enable-automation");
			chrome_options.addArguments("--ignore-certificate-errors");
			chrome_options.setPageLoadStrategy(PageLoadStrategy.NONE);

			driver = new ChromeDriver(chrome_options);
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();

			driver = new FirefoxDriver();

			break;

		case "ie":
			WebDriverManager.iedriver().setup();
			DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
			caps.setCapability("ignoreZoomSetting", true);

			driver = new InternetExplorerDriver(caps);
			break;

		case "edge":
			EdgeDriverManager.edgedriver().setup();
			DesiredCapabilities edgeCaps = new DesiredCapabilities("MicrosoftEdge", "", Platform.WINDOWS);
			edgeCaps.setCapability("ignoreProtectedModeSettings", true);
			edgeCaps.setCapability("ignoreZoomSetting", true);

			driver = new EdgeDriver(edgeCaps);

			break;
		}
		/* END: WEB BROWSER TO EXECUTE TEST */

		/* Launch web application */
		driver.get(Constants.WEB_URL);
		Log4j.info("Lauching: " + Constants.WEB_URL);

		/* Maximize window of the web application */
		if (Constants.MAXIMIZE_WINDOW.equalsIgnoreCase("true")) {
			driver.manage().window().maximize();
		}
		Log4j.info("Maximize window to execute");

		/* Delete cookies */
		driver.manage().deleteAllCookies();
		Log4j.info("Delete all cookies");

		/* Add implicitly wait */
		driver.manage().timeouts().implicitlyWait(Constants.IMPLICITLY_WAIT, TimeUnit.SECONDS);
		Log4j.info("Implicit wait applied on the driver for: " + Constants.IMPLICITLY_WAIT);

	}

	 @AfterClass
	public void tearDown() {

		/* Collect test result */
		softAssert.assertAll();

		/* Close application */
		if (driver != null) {
			driver.quit();
		}
		Log4j.info("Closing application");

	}

	/*** LOG4J: SET LOG FILE NAME ***/
	private void setLog4j(String className) {
		String log4jPath = new ResourceManager().getLOG4J_PATH();
		System.setProperty("logfilename", className + "_" + TestUtils.getTodayDateWithFormat("yyyy_MM_dd_HH_mm_ss"));
		DOMConfigurator.configure(log4jPath);

	}

	/* Add main class for debugging purpose. Will remove when completes */
	public static void main(String[] args) {
		System.out.println("Web Browser to execute: " + Constants.BROWSER);
		System.out.println("Web Application to execute: " + Constants.WEB_URL);
	}
}
