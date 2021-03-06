package br.com.alura.leilao.acceptance.steps;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Assert;

import br.com.alura.leilao.model.Lance;
import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PropondoLanceSteps {
	
	private Lance lance, lance10, lance15, lance25;
	private Leilao leilao;
	private ArrayList<Lance> lista;
	
	@Before
	public void setup() {
		this.lista = new ArrayList<Lance>();
		leilao = new Leilao("Table XPTO");
		System.out.println("Before");
	}
	
//	@After
//	public void tearDown() {
//		System.out.println("After");
//	}
	
	
	@Given("Dado um lance valido")
	public void dado_um_lance_valido() {
	   
		Usuario usuario = new Usuario("kairi");
		lance = new Lance(usuario, BigDecimal.TEN);
		
	}

	@When("Quando propoe o lance")
	public void quando_propoe_o_lance() {
		leilao.propoe(lance);
		
	}
	
	
	@Then("Entao o lance e aceito")
	public void entao_o_lance_e_aceito() {
	    
		Assert.assertEquals(1, leilao.getLances().size());
		Assert.assertEquals(BigDecimal.TEN, leilao.getLances().get(0).getValor());
		
	}
	

	
	@Given("um lance valido de {double} reais do usuario {string}")
	public void um_lance_do_usuario(Double valor, String nomeUsuario) {
		lance = new Lance(new Usuario(nomeUsuario), new BigDecimal(valor));
		lista.add(lance);
	}
	
	@When("propoe varios lances ao leilao")
	public void propoe_varios_lances_ao_leilao() {
		this.lista.forEach(lance -> leilao.propoe(lance));
	    
	}
	@Then("lances sao aceitos")
	public void lances_sao_aceitos() {
		Assert.assertEquals(this.lista.size(), leilao.getLances().size());
		Assert.assertEquals(this.lista.get(0).getValor(), leilao.getLances().get(0).getValor());
		Assert.assertEquals(this.lista.get(1).getValor(), leilao.getLances().get(1).getValor());
	}
	
	
	@Given("um lance invalido de {double} reais e do usuario {string}")
	public void um_lance_invalido_de_reais(Double valor, String nomeUsuario) {
		this.lance = new Lance(new BigDecimal(valor));
	}
	
	@Then("lance nao e aceito")
	public void lances_nao_e_aceito() {
		Assert.assertEquals(0, leilao.getLances().size());
	}
	

	@Then("o segundo lance nao e aceito")
	public void o_segundo_lance_nao_e_aceito() {
		Assert.assertEquals(1, leilao.getLances().size());
		Assert.assertEquals(this.lista.get(0).getValor(), leilao.getLances().get(0).getValor());
	}
	
	@Given("dois lances")
	public void dois_lances(DataTable dataTable) {
		
		List<Map<String,String>> valores = dataTable.asMaps();
		
		for (Map<String,String> mapa : valores) {
			
			String valor = mapa.get("valor");
			String nome  = mapa.get("nomeUsuario");
			
			Lance lance = new Lance(new Usuario(nome), new BigDecimal(valor));
			
			lista.add(lance);
			
		}
	}
	
}


