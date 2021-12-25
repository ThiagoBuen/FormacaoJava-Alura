package br.com.alura.teste;

import br.com.alura.modelo.Conta;
import br.com.alura.modelo.ContaCorrente;
import br.com.alura.modelo.ContaPoupanca;

public class TesteArrayString {

	public static void main(String[] args) {
		System.out.println("Funcionou!!");
		
		for(int i = 0; i < args.length; i++) {
			System.out.println(args[i]);
		}
			
	}
}
