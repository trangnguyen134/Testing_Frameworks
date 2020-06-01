package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.base.BaseTest;
import com.utilities.Log4j;

public class Page_LogOut extends BaseTest {
	
private static WebElement element = null;
	
	public static WebElement btn_LogOut(WebDriver driver) {
		 element = driver.findElement(By.xpath("//*[contains(text(),'Log out')]"));
		Log4j.info("Log out is found");
		return element;
	}
	
	public static WebElement alert_LogOut(WebDriver driver) {
		 element = driver.findElement(By.xpath("//*[text()='You Have Succesfully Logged Out!!']"));
		 Log4j.info("Log out confirmation is displayed"); 
		return element;
		
	}
	

}
