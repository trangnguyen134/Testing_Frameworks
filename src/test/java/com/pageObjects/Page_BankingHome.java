package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.utilities.Log4j;

public class Page_BankingHome {

	private static WebElement element = null;

	/* Get Home button */
	public static WebElement btn_Home(WebDriver driver) {
		driver.findElement(By.xpath("//*[contains(text(),'Home')]"));
		Log4j.info("Home button is found");
		return element;

	}

	/* Get Customer Login button */
	public static WebElement btn_CustomerLogin(WebDriver driver) {
		driver.findElement(By.xpath("//*[contains(text(),'Customer Login')]"));
		Log4j.info("Customer Login button is found");
		return element;

	}
	
	/* Get Bank Manager Login button */
	public static WebElement btn_BankManagerLogin(WebDriver driver) {
		driver.findElement(By.xpath("//*[contains(text(),'Bank Manager Login')]"));
		Log4j.info("Bank Manager Login button is found");
		return element;

	}

}
