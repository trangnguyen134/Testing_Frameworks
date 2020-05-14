package com.utilities;

import com.relevantcodes.extentreports.LogStatus;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Log4j extends com.base.BaseTest {

// Initialize Log4j logs

	private static Logger Log4j = LogManager.getLogger(Log4j.class.getName());

	// This is to print log for the beginning of the test case, as we usually run so
	// many test cases as a test suite

	public static void startTestCase(String sTestCaseName, String sOS, String sBrowser) {

		Log4j.info("****************************************************************************************");

		Log4j.info("$$$$$$$$$$$$$$$$$$$$$            " + sTestCaseName + "       $$$$$$$$$$$$$$$$$$$$$$$$$");

		Log4j.info("$$$$$$$$$$$$$$$$$$$$$            " + sOS + "       $$$$$$$$$$$$$$$$$$$$$$$$$");

		Log4j.info("$$$$$$$$$$$$$$$$$$$$$            " + sBrowser + "       $$$$$$$$$$$$$$$$$$$$$$$$$");

		Log4j.info("****************************************************************************************");

	}

	// This is to print log for the ending of the test case

	public static void endTestCase() {

		Log4j.info("$$$$$$$$$$$$$$$$$$$$$$$$$          " + "-E---N---D-" + "       $$$$$$$$$$$$$$$$$$$$$$$$$");

	}

	// Need to create these methods, so that they can be called

	public static void info(String message) {

		Log4j.info(message);

	}

	public static void warning(String message) {

		Log4j.warn("[ WARNING ]" + message);

		/*
		 * // For ExtentReport logger.log(LogStatus.WARNING, "[ WARNING ] " + message);
		 */

	}

	public static void error(String message) {

		Log4j.error(message);

	}

	public static void fatal(String message) {

		Log4j.fatal(message);

	}

	public static void breakDatasetIteration() {
		Log4j.info("---------------------------------------------------------");
		Log4j.info("$$$$$$======== DATASET ITERATION ========$$$$$$");
		Log4j.info("---------------------------------------------------------");

		/*
		 * // For ExtentReport logger.log(LogStatus.INFO,
		 * "$$$$$$======== DATASET ITERATION ========$$$$$$");
		 */
	}

	public static void breakSection(String message) {
		Log4j.info("---------------------------------------------------------");
		Log4j.info(">>>> SECTION >>>> " + message.toUpperCase() + " >>>>");
		Log4j.info("---------------------------------------------------------");

		/*
		 * // For ExtentReport logger.log(LogStatus.INFO, ">>> [SECTION] >>> " +
		 * message.toUpperCase());
		 */
	}

	public static void debug(String message) {

		Log4j.info("[debug] " + message);

	}

	public static void testResult(String message) {
		Log4j.info("---------------------------------------------------------");
		Log4j.info(">>>> TEST RESULT ~~~~~~~ " + message.toUpperCase() + " ~~~~~~");
		Log4j.info("---------------------------------------------------------");

//        // For ExtentReport
//        logger.log(LogStatus.INFO, message);
	}

	public static void testResult(boolean result) {

		String message = "PASSED";
		LogStatus status = LogStatus.PASS;

		if (!result) {
			message = "FAILED";
			status = LogStatus.FAIL;
		}

		Log4j.info("---------------------------------------------------------");
		Log4j.info(">>>> TEST RESULT ~~~~~~~ " + message.toUpperCase() + " ~~~~~~");
		Log4j.info("---------------------------------------------------------");

		/*
		 * // For ExtentReport // HTML ExtentReport String details =
		 * "Find execution log here: " + System.getProperty("logfilename");
		 * Log.log(LogStatus.INFO, details); logger.log(status,
		 * "[::: TEST EXECUTION RESULT :::] " + message);
		 */
	}

	public static void testStep(String message) {
		Log4j.info("[Test Step] " + message);

		/*
		 * // For ExtentReport logger.log(LogStatus.INFO, "[STEP] " + message);
		 */
	}

	public static void pass(String message) {
		Log4j.info("[PASSED] " + message);

		/*
		 * // For ExtentReport logger.log(LogStatus.PASS, message);
		 */
	}

	public static void pass(String message, String expectedResult, String actualResult) {
		String logMsg = "[PASSED] " + message + " - EXPECTED: [" + expectedResult + "] ACTUAL: [" + actualResult + "]";

		Log4j.info(logMsg);

		/*
		 * // For ExtentReport logger.log(LogStatus.PASS, logMsg);
		 */
	}

	public static void pass(String message, boolean expectedResult, boolean actualResult) {
		String logMsg = "[PASSED] " + message + " - EXPECTED: [" + String.valueOf(expectedResult) + "] ACTUAL: ["
				+ String.valueOf(actualResult) + "]";

		Log4j.info(logMsg);

		/*
		 * // For ExtentReport logger.log(LogStatus.PASS, logMsg);
		 */
	}

	public static void fail(String message) {
		Log4j.info("[ !!!! FAILED !!!!] " + message);

		/*
		 * // For ExtentReport logger.log(LogStatus.FAIL, message);
		 */
	}

	public static void fail(String message, String expectedResult, String actualResult) {
		String logMsg = "[ !!!! FAILED !!!!] " + message + " - EXPECTED: [" + expectedResult + "] ACTUAL: ["
				+ actualResult + "]";

		Log4j.info(logMsg);
		/*
		 * // For ExtentReport logger.log(LogStatus.FAIL, logMsg);
		 */
	}
}