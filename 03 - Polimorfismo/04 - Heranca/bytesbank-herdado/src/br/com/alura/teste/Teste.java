package br.com.alura.teste;



import br.com.alura.modelo.Cliente;
import br.com.alura.modelo.ContaCorrente;
import br.com.alura.modelo.ContaPoupanca;

public class Teste {
	public static void main(String[] args) {
		Object cc = new ContaCorrente(123, 333);
		Object cp = new ContaPoupanca(222, 345);
		
		Object cliente = new Cliente();
		
		System.out.println(cc);
		System.out.println(cp);
	}
}
