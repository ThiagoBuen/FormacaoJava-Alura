package br.com.alura.teste;

import br.com.alura.modelo.Conta;
import br.com.alura.modelo.ContaCorrente;
import br.com.alura.modelo.GuardadorDeReferenciasObject;

public class TesteGuardardorReferenciasObject {
	
	public static void main(String[] args) {
		GuardadorDeReferenciasObject guardador = new GuardadorDeReferenciasObject();
		
		Conta cc = new ContaCorrente(123, 44);
		
		guardador.adiciona(cc);
		
		Conta cc2 = new ContaCorrente(55, 233);
		
		guardador.adiciona(cc2);
		
		System.out.println(guardador.getQuantidadeElementos());
		
		Conta ref = (Conta) guardador.getReferencia(1);
		System.out.println(ref.getAgencia());
	}
}
