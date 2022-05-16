package com.blogDoAgi.tests;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.Timeout;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.blogDoAgi.helpers.constants.Constants;

public abstract class AbstractTestScenary {

	public WebDriver driver;

	@Rule
	public Timeout globalTimeout = Timeout.seconds(15);

	@Before
	public void before() {
		final String URL = Constants.BLOGDOAGI_URL;
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		//options.addArguments("--headless");
		System.setProperty(Constants.KEY_DRIVER, Constants.PATH);
		this.driver = new ChromeDriver(options);
		this.driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.get(URL);
	}

	@After
	public void after() {
		driver.quit();
	}

	public WebDriver getDriver() {
		return this.driver;
	}
}
