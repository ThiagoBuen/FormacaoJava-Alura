package br.com.alura.leilao.acceptance.steps;

import org.junit.Assert;

import br.com.alura.leilao.e2e.pages.Browser;
import br.com.alura.leilao.e2e.pages.LeiloesPage;
import br.com.alura.leilao.e2e.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	
	private Browser browser;
	private LoginPage loginPage;
	private LeiloesPage leiloesPage;

	@Given("usuario valido")
	public void usuario_valido() {
		browser = new Browser();
		browser.seed();
		loginPage = browser.getLoginPage();
	}

	@When("realiza login")
	public void realiza_login() {
		leiloesPage = this.loginPage.realizaLoginComo("fulano", "pass");
	}
	
	@Then("redirecionado para a pagina de leiloes")
	public void redirecionado_para_a_pagina_de_leiloes() {
		Assert.assertTrue(this.leiloesPage.estaNaPaginaDeLeiloes());
		browser.clean();
	}
	
	
	@Given("usuario invalido")
	public void usuario_invalido() {
		browser = new Browser();
		browser.seed();
		loginPage = browser.getLoginPage();
	}

	@When("tenta logar")
	public void tenta_logar() {
		leiloesPage = this.loginPage.realizaLoginComo("fulano", "");
	}
	
	@Then("continua na pagina de login")
	public void continua_na_pagina_de_login() {
		Assert.assertFalse(this.leiloesPage.estaNaPaginaDeLeiloes());
		Assert.assertTrue(this.loginPage.estaNaPaginaDeLoginComErro());
		browser.clean();		
	}

}
