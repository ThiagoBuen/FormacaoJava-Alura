package br.com.alura.leilao.util.builder;

import java.math.BigDecimal;
import java.time.LocalDate;

import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;

public class LeilaoBuilder {
	
	private String nome;
	private BigDecimal valorInicial;
	private Usuario usuario;
	private LocalDate dataInicial;
	
	
	public LeilaoBuilder comNome(String nome) {
		this.nome = nome;
		return this;
	}
	
	public LeilaoBuilder comValorInicial(String valorInicial) {
		this.valorInicial = new BigDecimal(valorInicial);
		return this;
	}
	
	public LeilaoBuilder comDataInicial(LocalDate dataInicial) {
		this.dataInicial = dataInicial;
		return this;
	}
	
	public LeilaoBuilder comUsuario(Usuario usuario) {
		this.usuario = usuario;
		return this;
	}
	
	public Leilao criar() {
		return new Leilao(nome, valorInicial, dataInicial, usuario);
	}

}
