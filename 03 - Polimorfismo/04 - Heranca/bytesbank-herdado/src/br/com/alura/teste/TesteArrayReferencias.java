package br.com.alura.teste;

import br.com.alura.modelo.Conta;
import br.com.alura.modelo.ContaCorrente;
import br.com.alura.modelo.ContaPoupanca;

public class TesteArrayReferencias {

	public static void main(String[] args) {
		Conta[] contas = new Conta[5];		//valor padrão = null
		
		ContaCorrente cc1 = new ContaCorrente(244, 344);
		
		contas[0] = cc1;
		
		ContaPoupanca cc2 = new ContaPoupanca(244, 22);
		
		contas[1] = cc2;
		
		Conta testeRef = contas[0];
		ContaPoupanca testeTypeCast = (ContaPoupanca) contas[1];
		
		System.out.println(contas[1].getAgencia() + " " + contas[1].getNumero());
		
		System.out.println(contas[2]);
		
		System.out.println(testeRef.getNumero());
	}
}
