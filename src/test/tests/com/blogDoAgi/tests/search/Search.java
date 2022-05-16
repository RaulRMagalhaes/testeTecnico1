package com.blogDoAgi.tests.search;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import com.blogDoAgi.pages.BlogDoAgiPage;
import com.blogDoAgi.pages.SearchResultPage;
import com.blogDoAgi.tests.AbstractTestScenary;

public class Search extends AbstractTestScenary{
	
 
	@Test
	public void test_001_validSearch() throws Exception {
		String searchedText = "investimento";
		
		BlogDoAgiPage blogDoAgiPage = new BlogDoAgiPage(getDriver());
		SearchResultPage searchResultPage = new SearchResultPage(getDriver());

		blogDoAgiPage.clicarNaLupa();
		blogDoAgiPage.preencherCampoDeBusca(searchedText);
		blogDoAgiPage.clicarEmPesquisar();
		
		String headerResult = searchResultPage.obterTextoCabeçalhoDaPesquisa();
		String textResult = searchResultPage.obterTextoConteudoPesquisa();
				
		assertNotEquals(searchResultPage.messageHeaderForInvalidSearch, headerResult);
		assertNotEquals(searchResultPage.messageTextForInvalidSearch, textResult);

		assertTrue(searchResultPage.validaPesquisa(searchedText, headerResult));
		assertTrue(searchResultPage.validaPesquisa(searchedText, textResult));
	}
	
	@Test
	public void test_002_searchWithEmptyField() throws Exception {
		String searchedText = "";
		
		BlogDoAgiPage blogDoAgiPage = new BlogDoAgiPage(getDriver());
		SearchResultPage searchResultPage = new SearchResultPage(getDriver());

		blogDoAgiPage.clicarNaLupa();
		blogDoAgiPage.preencherCampoDeBusca(searchedText);
		blogDoAgiPage.clicarEmPesquisar();
		
		String headerResult = searchResultPage.obterTextoCabeçalhoDaPesquisa();
		String textResult = searchResultPage.obterTextoConteudoPesquisa();
				
		assertNotEquals(searchResultPage.messageHeaderForInvalidSearch, headerResult);
		assertNotEquals(searchResultPage.messageTextForInvalidSearch, textResult);

		assertTrue(searchResultPage.validaPesquisa(searchedText, headerResult));
		assertTrue(searchResultPage.validaPesquisa(searchedText, textResult));
	}
	
	@Test
	public void test_003_invalidSearchWithVeryLargeText() throws Exception {
		String searchedText = "testestestestestestestestestestestestestestestestestestestestestestestestestestestestestestestestestestestestestestestestestestestestestestestestestestestestestestestestestestestestestestestes";
		
		BlogDoAgiPage blogDoAgiPage = new BlogDoAgiPage(getDriver());
		SearchResultPage searchResultPage = new SearchResultPage(getDriver());

		blogDoAgiPage.clicarNaLupa();
		blogDoAgiPage.preencherCampoDeBusca(searchedText);
		blogDoAgiPage.clicarEmPesquisar();
		
		String headerResult = searchResultPage.obterTextoCabeçalhoDaPesquisa();
		String textResult = searchResultPage.obterTextoConteudoPesquisa();
				
		assertEquals(searchResultPage.messageHeaderForInvalidSearch, headerResult);
		assertEquals(searchResultPage.messageTextForInvalidSearch, textResult);
	}
	
	@Test
	public void test_004_invalidSearchWithSpecialCharacters() throws Exception {
		String searchedText = "!@#$%";
		
		BlogDoAgiPage blogDoAgiPage = new BlogDoAgiPage(getDriver());
		SearchResultPage searchResultPage = new SearchResultPage(getDriver());

		blogDoAgiPage.clicarNaLupa();
		blogDoAgiPage.preencherCampoDeBusca(searchedText);
		blogDoAgiPage.clicarEmPesquisar();
		
		String headerResult = searchResultPage.obterTextoCabeçalhoDaPesquisa();
		String textResult = searchResultPage.obterTextoConteudoPesquisa();
				
		assertEquals(searchResultPage.messageHeaderForInvalidSearch, headerResult);
		assertEquals(searchResultPage.messageTextForInvalidSearch, textResult);
	}
	
}
