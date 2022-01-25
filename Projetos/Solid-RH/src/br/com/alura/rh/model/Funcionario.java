package br.com.alura.rh.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

import br.com.alura.rh.ValidacaoException;

public class Funcionario {

	private DadosPessoais dadosPessoais;
	
	private LocalDate dataUltimoReajuste;

	public Funcionario(String nome, String cpf, Cargo cargo, BigDecimal salario) {
		dadosPessoais.setNome(nome); 
		dadosPessoais.setCpf(cpf);
		dadosPessoais.setCargo(cargo);
		dadosPessoais.setSalario(salario);
	}

	public void atualizarSalario(BigDecimal novoSalario) {
		dadosPessoais.setSalario(novoSalario);
		this.dataUltimoReajuste = LocalDate.now();
	}

	public String getNome() {
		return dadosPessoais.getNome();
	}

	public void setNome(String nome) {
		dadosPessoais.setNome(nome);
	}

	public String getCpf() {
		return dadosPessoais.getCpf();
	}

	public void setCpf(String cpf) {
		dadosPessoais.setCpf(cpf);;
	}

	public Cargo getCargo() {
		return dadosPessoais.getCargo();
	}

	public void setCargo(Cargo cargo) {
		dadosPessoais.setCargo(cargo);
	}

	public BigDecimal getSalario() {
		return dadosPessoais.getSalario();
	}

	public void setSalario(BigDecimal salario) {
		dadosPessoais.setSalario(salario);
	}

	public LocalDate getDataUltimoReajuste() {
		return dataUltimoReajuste;
	}

	public void setDataUltimoReajuste(LocalDate dataUltimoReajuste) {
		this.dataUltimoReajuste = dataUltimoReajuste;
	}

	public void promover(Cargo novoCargo) {
		dadosPessoais.setCargo(novoCargo);
		
	}

}
