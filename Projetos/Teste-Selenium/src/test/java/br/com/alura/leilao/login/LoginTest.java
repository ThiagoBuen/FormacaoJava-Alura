package br.com.alura.leilao.login;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoginTest {
	
	private LoginPage paginaDeLogin;
	
	@BeforeEach
	public void beforeEach() {
		this.paginaDeLogin = new LoginPage(); 
	}

	@AfterEach
	public void afterEach() {
		this.paginaDeLogin.quit();
	}
	
	@Test
	public void deveriaEfetuarLoginComDadosValidos() {	
		
		paginaDeLogin.preencheFormularioDeLogin("fulano", "pass");
		paginaDeLogin.efetuarLogin();
		
		Assert.assertFalse(paginaDeLogin.isPaginaLogin());
		Assert.assertEquals("fulano", paginaDeLogin.getNomeUsuarioLogado());	
		
	}
	
	@Test
	public void naoDeveriaLogarComDadosInvalidos() {
		paginaDeLogin.preencheFormularioDeLogin("invalido", "pass");
		paginaDeLogin.efetuarLogin();
		
		Assert.assertTrue(paginaDeLogin.getLoginPageError());
		Assert.assertNull(paginaDeLogin.getNomeUsuarioLogado());
		Assert.assertTrue(paginaDeLogin.paginaContemTexto("Usuário e senha inválidos."));	
		
	}
	
	@Test
	public void naoDeveriaAcessarPaginaRestritaSemLogin() {
		paginaDeLogin.goToPaginaDeLances();
		
		Assert.assertTrue(paginaDeLogin.isPaginaLogin());
		Assert.assertFalse(paginaDeLogin.paginaContemTexto("Dados do Leilão"));	
		
	}
	
	
}
