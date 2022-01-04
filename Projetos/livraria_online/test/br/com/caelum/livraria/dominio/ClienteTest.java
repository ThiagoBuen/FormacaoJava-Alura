package br.com.caelum.livraria.dominio;

import static br.com.caelum.livraria.dominio.ObjetosParaTestes.CEP;
import static br.com.caelum.livraria.dominio.ObjetosParaTestes.ID_CLIENTE;
import static br.com.caelum.livraria.dominio.ObjetosParaTestes.UM_CLIENTE;
import static br.com.caelum.livraria.dominio.ObjetosParaTestes.ddd;
import static br.com.caelum.livraria.dominio.ObjetosParaTestes.numeroTelefone;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class ClienteTest {

	@Test
	public void igualdade() {
		Cliente outroCliente = new Cliente(ID_CLIENTE, CEP, ddd, numeroTelefone);
		
		assertThat(UM_CLIENTE, is(equalTo(outroCliente)));
		assertThat(UM_CLIENTE.hashCode(), is(equalTo(outroCliente.hashCode())));
	}
	
	@Test
	public void lerTelefoneFormatado() {
		assertThat(UM_CLIENTE.getTelefone(), is(equalTo("(11) 55555555")));
	}
}
