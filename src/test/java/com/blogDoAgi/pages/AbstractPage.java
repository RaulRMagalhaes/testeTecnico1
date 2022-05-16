package com.blogDoAgi.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.blogDoAgi.helpers.constants.Constants;

public abstract class AbstractPage {

	protected WebDriver driver;
	
	public AbstractPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void get(String url) {
		this.driver.get(url);
	}
	
	public boolean existsElement(By element) {
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		boolean exists = driver.findElements(element).size() != 0;
		return exists;
	}
		
	public boolean clickOnButton(By btn) {
		boolean result = false;
		if (existsElement(btn)){
			WebElement button = driver.findElement(btn);
			button.click();
			result = true;
		}
		return result;
	}
	
	public void setTextField(By field, String entry) throws Exception {
		WebElement fieldElement = driver.findElement(field);
		if (!entry.isEmpty()) {
			fieldElement.clear();
			fieldElement.sendKeys(entry);
			waitFieldToBeFilled(field, entry);
		} else {
			fieldElement.clear();
		}
	}
	
	public void setTextField(By field, int entry) throws Exception {
		String str = String.valueOf(entry);
		setTextField(field, str);
	}
	
	public String getTextField(By field) throws Exception {
		String txt = "";
		waitElementToBeVisible(field);
		WebElement fieldElement = driver.findElement(field);
		txt = fieldElement.getText();
		return txt;
	}
	
	public void waitElementToBeVisible(By element) {
		WebDriverWait wait = new WebDriverWait(driver, Constants.TIME);
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
	}

	public void waitFieldToBeFilled(By locator, String entry) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, Constants.TIME);
		wait.until(ExpectedConditions.attributeContains(locator, "value", entry));
	}

}
