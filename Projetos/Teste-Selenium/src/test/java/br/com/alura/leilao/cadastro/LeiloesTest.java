package br.com.alura.leilao.cadastro;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.leilao.login.LoginPage;

public class LeiloesTest {
	
private LeiloesPage paginaDeLeiloes;
private CadastroLeilaoPage paginaDeCadastro;
	
	@BeforeEach
	public void BeforeEach() {
		LoginPage paginaDeLogin = new LoginPage();
		paginaDeLogin.preencheFormularioDeLogin("fulano", "pass");
		this.paginaDeLeiloes = paginaDeLogin.efetuarLoginLeiloes();
		this.paginaDeCadastro = paginaDeLeiloes.carregarFormulario();
	}

	@AfterEach
	public void afterEach() {
		this.paginaDeLeiloes.quit();
	}
	
	
	@Test
	public void deveriaCadastrarLeilao() {
				
		String hoje = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		String nome = "Leilao do dia " + hoje;
		String valor = "500.00";
				
		this.paginaDeLeiloes = this.paginaDeCadastro.cadastrarLeilao(nome, valor, hoje);
		
		Assert.assertTrue(paginaDeLeiloes.isLeilaoCadastrado(nome, valor, hoje));
		
	}
	
	@Test
	public void deveriaValidarCadastroDeLeilao() {
		this.paginaDeLeiloes = this.paginaDeCadastro.cadastrarLeilao("", "", "");
		
		Assert.assertFalse(this.paginaDeCadastro.isPaginaAtual());
		Assert.assertTrue(this.paginaDeLeiloes.isPaginaAtual());
		Assert.assertTrue(this.paginaDeCadastro.isMensagensValidacaoExist());
	}
	
}















