package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.base.BaseTest;
import com.utilities.Log4j;

public class Page_Login extends BaseTest{

	private static WebElement element = null;

	public static WebElement txt_userName(WebDriver driver) {
		element = driver.findElement(By.name("uid"));
		Log4j.info("Username textbox is found");
		return element;

	}

	public static WebElement txt_password(WebDriver driver) {
		element = driver.findElement(By.name("password"));
		Log4j.info("Password textbox is found");
		return element;
	}
	
	public static WebElement btn_logIn(WebDriver driver) {
		element = driver.findElement(By.name("btnLogin"));
		Log4j.info("Login button is found");
		return element;
	}
	
	public static WebElement btn_reset(WebDriver driver) {
		element = driver.findElement(By.name("btnReset"));
		Log4j.info("Reset button is found");
		return element;
	}
	
	public static WebElement banner_Banner(WebDriver driver) {
		element = driver.findElement(By.xpath("//div/h2[@class='barone']"));
		Log4j.info("Banner is found");
		return element;
	}

}
