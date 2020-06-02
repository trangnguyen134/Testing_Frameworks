package com.appObjects;

import org.openqa.selenium.Alert;

import com.base.BaseTest;
import com.pageObjects.Page_Home;
import com.pageObjects.Page_Login;
import com.utilities.Log4j;

public class Logout extends BaseTest {

	public static void Execute() throws Exception {

		Page_Home.btn_LogOut(driver).click();
		Log4j.info("Log out....");

		// Handle Logout Confirmation alert
		Alert logoutAlert = driver.switchTo().alert();
		String logOutConfirmationText = logoutAlert.getText(); // get content of the Alter Message
		logoutAlert.accept();
		Log4j.info(logOutConfirmationText);
		Log4j.info("Confirming... log out");

	}

}
