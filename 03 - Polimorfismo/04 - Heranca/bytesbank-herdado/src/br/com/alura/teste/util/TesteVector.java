package br.com.alura.teste.util;

import java.util.List;
import java.util.Vector;

import br.com.alura.modelo.Conta;
import br.com.alura.modelo.ContaCorrente;

public class TesteVector {
	public static void main(String[] args) {
		List<Conta> lista = new Vector<Conta>();
		
		Conta cc = new ContaCorrente(123, 44);
		
		lista.add(cc);
			
		Conta cc2 = new ContaCorrente(55, 233);
				
		lista.add(cc2);
		
		Conta cc3 = new ContaCorrente(55, 233);
		
		lista.remove(1);
		
		boolean existe = lista.contains(cc3);
		
		
		System.out.println("Já existe? " + existe);
	}
}
