package br.com.alura.leilao.acceptance.steps;

import java.time.LocalDate;

import org.junit.Assert;

import br.com.alura.leilao.e2e.pages.Browser;
import br.com.alura.leilao.e2e.pages.LeiloesPage;
import br.com.alura.leilao.e2e.pages.LoginPage;
import br.com.alura.leilao.e2e.pages.NovoLeilaoPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LeilaoSteps {
	
	private LoginPage loginPage;
	private LeiloesPage leiloesPage;
	private NovoLeilaoPage novaLeilaoPage;
	private Browser browser;
	
	@Given("usuario logado")
	public void usuario_logado() {
		
		this.browser = new Browser();
		loginPage = new Browser().getLoginPage();
		browser.seed();
		loginPage = browser.getLoginPage();
		leiloesPage = loginPage.realizaLoginComo("fulano", "pass");
	}

	@When("acessa a pagina de novo leilao")
	public void acessa_a_pagina_de_novo_leilao() {
		novaLeilaoPage = this.leiloesPage.visitaPaginaParaCriarUmNovoLeilao();
		
	}
	
	@When("preenche o formulario com dados validos")
	public void preenche_o_formulario_com_dados_validos() {
		this.leiloesPage = this.novaLeilaoPage.preencheForm("PC", "1500", "28/01/2021");
	}

	@Then("volta para a pagina de leiloes")
	public void volta_para_a_pagina_de_leiloes() {
		Assert.assertTrue(this.leiloesPage.estaNaPaginaDeLeiloes());
	}
	
	@Then("novo leilao aparece na tabela")
	public void novo_leilao_aparece_na_tabela() {
		Assert.assertTrue(this.leiloesPage.existe("PC", "1500", "28/01/2021", "fulano"));
		this.browser.clean();
	}
}
