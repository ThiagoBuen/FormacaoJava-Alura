package br.com.alura.leilao.login;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.alura.leilao.PageObject;
import br.com.alura.leilao.cadastro.LeiloesPage;

public class LoginPage extends PageObject{
	
	
	private static final String loginUrl = "http://localhost:8080/login";
	
	public LoginPage() {
		super(null);
		this.browser.navigate().to(loginUrl);
	}
	
	public void preencheFormularioDeLogin(String username, String password) {
		this.browser.findElement(By.id("username")).sendKeys(username);
		this.browser.findElement(By.id("password")).sendKeys(password);		
	}

	public void efetuarLogin() {
		this.browser.findElement(By.id("login-form")).submit();
	}

	public boolean isPaginaLogin() {
		return this.browser.getCurrentUrl().equals(loginUrl);
	}

	public String getNomeUsuarioLogado() {
		try {
			return this.browser.findElement(By.id("usuario-logado")).getText();
		}catch(NoSuchElementException e){
			return null;
		}
		
	}

	public boolean getLoginPageError() {
		return this.browser.getCurrentUrl().equals(loginUrl+"?error");
	}

	public boolean paginaContemTexto(String content) {
		return this.browser.getPageSource().contains(content);
	}

	public void goToPaginaDeLances() {
		this.browser.navigate().to("http://localhost:8080/leiloes/2");
	}
	
	public LeiloesPage efetuarLoginLeiloes() {
		this.browser.findElement(By.id("login-form")).submit();
		return new LeiloesPage(browser);
	}
	
}
