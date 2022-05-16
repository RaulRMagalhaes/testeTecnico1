package com.blogDoAgi.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.blogDoAgi.helpers.constants.Constants;

public class SearchResultPage extends BlogDoAgiPage {
		
	By headerLabel_locator = By.xpath("//*[@id=\"primary\"]//header[@class=\"entry-header\"]");
	By textLabel_locator = By.xpath("//*[@id=\"primary\"]//p");
	
	public final String messageHeaderForInvalidSearch = "Nenhum resultado";
	public final String messageTextForInvalidSearch = "Não encontramos nada para estes termos de busca. Tente novamente com palavras-chave diferentes.";
	
	public SearchResultPage(WebDriver driver) {
		super(driver);
	}
	
	public String obterTextoCabeçalhoDaPesquisa() throws Exception {
		return getTextField(headerLabel_locator);
	}
	
	public String obterTextoConteudoPesquisa() throws Exception {
		return getTextField(textLabel_locator);
	}
	
	public Boolean validaPesquisa(String textoPesquisa, String resultado) throws Exception {		
		if(resultado.contains(textoPesquisa)) {
			System.out.println("O texto: \"" + textoPesquisa + "\" foi encontrado em: \"" + resultado + "\"");
			return true;
		}else if (!resultado.equals(messageHeaderForInvalidSearch) && !resultado.equals(messageTextForInvalidSearch) ){
			System.out.println("O texto: \"" + textoPesquisa + "\" não esta no resultado, porem uma pesquisa relacionada foi encontrada: \"" + resultado + "\"");
			return true;
		}else {
			return false;
		}
	}
	
}
