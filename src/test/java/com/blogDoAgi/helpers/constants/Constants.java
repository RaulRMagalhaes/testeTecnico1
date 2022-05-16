package com.blogDoAgi.helpers.constants;

public class Constants {

	/**
	 * Name User
	 */
	public static final String USER = System.getenv("username");

	/**
	 * Time for waiting
	 */
	public static final int TIME = 5;

	/**
	 * Time more for waiting
	 */
	public static final int TIME_LONG = 30;
	
	/**
	 * Time more for get element with waiting
	 */
	public static final int TIME_MILLISECONDS = 120;

	/**
	 * Chrome Driver Path
	 */
	public static final String PATH = "src\\test\\resources\\chromedriver.exe";

	/**
	 * Web Browser
	 */
	public static final String KEY_DRIVER = "webdriver.chrome.driver";

	/**
	 * System Link Page
	 */
	public static final String BLOGDOAGI_URL = "https://blogdoagi.com.br";
}
