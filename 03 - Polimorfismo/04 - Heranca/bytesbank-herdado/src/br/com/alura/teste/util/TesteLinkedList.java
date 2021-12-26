package br.com.alura.teste.util;

import java.util.LinkedList;

import br.com.alura.modelo.Conta;
import br.com.alura.modelo.ContaCorrente;

public class TesteLinkedList {
	public static void main(String[] args) {
	
		LinkedList<Conta> lista = new LinkedList<Conta>();
		
		Conta cc = new ContaCorrente(123, 44);
		
		lista.add(cc);
			
		Conta cc2 = new ContaCorrente(55, 233);
				
		lista.add(cc2);
		
		Conta cc3 = new ContaCorrente(55, 233);
		
		boolean existe = lista.contains(cc3);
		
		
		System.out.println("Já existe? " + existe);
	}
}
