package br.com.alura.leilao.dao;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.alura.leilao.model.Usuario;
import br.com.alura.leilao.util.JPAUtil;
import br.com.alura.leilao.util.builder.UsuarioBuilder;
import junit.framework.Assert;

class UsuarioDaoTest {

	private UsuarioDao dao;
	
	private EntityManager em;
	
	@BeforeEach
	public void beforeEach() {
		this.em = JPAUtil.getEntityManager();
		this.dao = new UsuarioDao(em);
		em.getTransaction().begin();		
	}
	
	@AfterEach
	public void afterEach() {
		em.getTransaction().rollback();
	}
	
	@Test
	void testeBuscaUsuarioCadastradoValido() {
		
		Usuario usuario = new UsuarioBuilder()
								.comNome("joao")
								.comEmail("joao@email.com")
								.comSenha("12345")
								.criar();
		
		em.persist(usuario);
		
		Usuario userFound = this.dao.buscarPorUsername(usuario.getNome());
		
		Assert.assertEquals(usuario.getNome(), userFound.getNome());
	}
	
	@Test
	void testeBuscaUsuarioNaoCadastrado() {	
		
		Usuario usuario = new UsuarioBuilder()
				.comNome("joao")
				.comEmail("joao@email.com")
				.comSenha("12345")
				.criar();
		
		em.persist(usuario);
		
		org.junit.Assert.assertThrows(NoResultException.class, 
										() -> this.dao.buscarPorUsername("felipe"));
	}
	
	@Test
	void shouldRemoveUser() {
		
		Usuario usuario = new UsuarioBuilder()
				.comNome("joao")
				.comEmail("joao@email.com")
				.comSenha("12345")
				.criar();
		
		em.persist(usuario);
		
		dao.deletar(usuario);
		
		org.junit.Assert.assertThrows(NoResultException.class, 
				() -> this.dao.buscarPorUsername(usuario.getNome()));
		
	}
	


}
