package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.utilities.Log4j;

public class Page_Home {

	private static WebElement element = null;

	/*
	 * Get "Website For Testing Selenium WebDriver / Protractor Automation Scripts"
	 * textbox
	 */
	public static WebElement banner_Top(WebDriver driver) {
		driver.findElement(By.xpath("//div[@class='container margin-top-20']//following-sibling::h1"));
		Log4j.info("Top banner is found");
		return element;

	}

	/*
	 * Get message: "After clicking on Above menu items or clicking on below boxes
	 * you will be navgiated to AngularJS based websites where you will find many ng
	 * elements and can test your Protractor or Selenium WebDriver script, Examples
	 * are taken by the courtesy of various AngularJS based websites and the
	 * intention is to let the audience play and practice protractor scripts without
	 * paying anything or developing additional AngularJS websites. Try automating
	 * below elements through Protractor or Selenium WebDriver and see how much you
	 * are comfortable in writing and executing automation scripts. If you are able
	 * to handle these elements then you can automate any website in the world."
	 */
	public static WebElement txt_IntrodutionMessage(WebDriver driver) {
		driver.findElements(By.xpath("//div[@class='container margin-top-20']//following-sibling::p"));
		Log4j.info("Introduction message is found");
		return element;
	}

	/* Get "AngularJS Elements" textbox */
	public static WebElement box_BottomText(WebDriver driver) {
		driver.findElement(By.xpath("//div[@class='linkbox margin-bottom-20']//following-sibling::h1"));
		Log4j.info("Botton Text box is found");
		return element;
	}

	/* Get Selenium Tutorial Link */
	public static WebElement lnk_SeleniumTutorial(WebDriver driver) {
		driver.findElement(By.xpath("//*[contains(text(),'Selenium Tutorials')]"));
		Log4j.info("Selenium Tutorial link is found");
		return element;

	}

	/* Get Registration Link */
	public static WebElement lnk_Registration(WebDriver driver) {
		driver.findElement(By.xpath("//*[contains(text(),'Registration')]"));
		Log4j.info("Registration link is found");
		return element;

	}

	/* Get Multi Form Link */
	public static WebElement lnk_MultiFrom(WebDriver driver) {
		driver.findElement(By.xpath("//*[contains(text(),'Multi Form')]"));
		Log4j.info("Multi Form link is found");
		return element;

	}

	/* Get Calculator Link */
	public static WebElement lnk_Calculator(WebDriver driver) {
		driver.findElement(By.xpath("//*[contains(text(),'Calculator')]"));
		Log4j.info("Calculator link is found");
		return element;

	}

	/* Get Checkbox Link */
	public static WebElement lnk_Checkbox(WebDriver driver) {
		driver.findElement(By.xpath("//*[contains(text(),'Checkboxes')]"));
		Log4j.info("Checkboxes link is found");
		return element;

	}

	/* Get Banking Link */
	public static WebElement lnk_Banking(WebDriver driver) {
		driver.findElement(By.xpath("//*[contains(text(),'Banking')]"));
		Log4j.info("Banking link is found");
		return element;

	}

	/* Get WebTables Link */
	public static WebElement lnk_WebTables(WebDriver driver) {
		driver.findElement(By.xpath("//*[contains(text(),'WebTables')]"));
		Log4j.info("Web Tables link is found");
		return element;

	}
}
