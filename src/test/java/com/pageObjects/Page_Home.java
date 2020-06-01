package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.base.BaseTest;
import com.utilities.Log4j;


public class Page_Home extends BaseTest{
	
	private static WebElement element = null;
	
	public static WebElement text_Welcome(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[contains(text(),'Welcome To Manager's Page of Guru99 Bank')]"));
		Log4j.info("Welcome text  is found");
		return element;
	}
	
	

}
