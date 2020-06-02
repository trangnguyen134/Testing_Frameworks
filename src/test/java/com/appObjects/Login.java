package com.appObjects;

import org.openqa.selenium.WebDriver;

import com.base.BaseTest;

import com.pageObjects.Page_Login;
import com.utilities.Log4j;

public class Login extends BaseTest {

	public static void Execute(String sUsername, String sPassword) throws Exception {

		Page_Login.txt_userName(driver).clear();
		Page_Login.txt_userName(driver).sendKeys(sUsername);
		Log4j.info("Username: " + sUsername + " is entered.");

		Page_Login.txt_password(driver).clear();
		Page_Login.txt_password(driver).sendKeys(sPassword);
		Log4j.info("Password: " + sPassword + " is entered");

		Page_Login.btn_logIn(driver).click();
		Log4j.info("Click action is performed on Submit button");

	}

}