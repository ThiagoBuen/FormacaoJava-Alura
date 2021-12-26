package br.com.alura.teste.util;

import java.util.ArrayList;

import br.com.alura.modelo.Conta;
import br.com.alura.modelo.ContaCorrente;

public class TesteArrayListEquals {
	
	public static void main(String[] args) {
		//<...> - generics
		
		ArrayList<Conta> lista = new ArrayList<Conta>();
				
		Conta cc = new ContaCorrente(123, 44);
				
		lista.add(cc);
			
		Conta cc2 = new ContaCorrente(55, 233);
				
		lista.add(cc2);
		
		Conta cc3 = new ContaCorrente(55, 233);
		
		boolean existe = lista.contains(cc3);
		
		
		System.out.println("Já existe? " + existe);
		
		
		
		for(Conta conta: lista) {
			System.out.println(conta);
		}
	}
}
