package com.blogDoAgi.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BlogDoAgiPage extends AbstractPage{
	
	By searchOpenBtn_locator = By.id("search-open");
	By searchField_locator = By.xpath("//*[@class=\"desktop-search\"]//input[@placeholder=\"Pesquisar …\"]");
	By searchBtn_locator = By.xpath("//*[@class=\"desktop-search\"]//input[@type=\"submit\"]");
	
	
	public BlogDoAgiPage(WebDriver driver) {
		super(driver);
	}
		
	public void clicarNaLupa() throws Exception {
		clickOnButton(searchOpenBtn_locator);
	}
	
	public void preencherCampoDeBusca(String text) throws Exception {
		setTextField(searchField_locator, text);
	}
	
	public SearchResultPage clicarEmPesquisar() throws Exception {
		clickOnButton(searchBtn_locator);
		return new SearchResultPage(driver);
	}
}
