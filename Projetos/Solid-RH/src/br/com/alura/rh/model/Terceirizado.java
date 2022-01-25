package br.com.alura.rh.model;

import java.math.BigDecimal;

public class Terceirizado {

	private String empresa; 
	private DadosPessoais dadosPessoais;
	
	public Terceirizado(String nome, String cpf, Cargo cargo, BigDecimal salario) {
		dadosPessoais.setNome(nome); 
		dadosPessoais.setCpf(cpf);
		dadosPessoais.setCargo(cargo);
		dadosPessoais.setSalario(salario);
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	
	public String getNome() {
		return dadosPessoais.getNome();
	}
	
	public String getCpf() {
		return dadosPessoais.getCpf();
	}
	
	public BigDecimal getSalario() {
		return dadosPessoais.getSalario();
	}
	
	public Cargo getCargo() {
		return dadosPessoais.getCargo();
	}
	
	
	
}
