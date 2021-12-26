package br.com.alura.teste.util;

import java.util.ArrayList;

import br.com.alura.modelo.Cliente;
import br.com.alura.modelo.Conta;
import br.com.alura.modelo.ContaCorrente;

public class TesteUtilArrayList {
	public static void main(String[] args) {
		
		//<...> - generics
		
		ArrayList<Conta> lista = new ArrayList<Conta>();
		
		Conta cc = new ContaCorrente(123, 44);
		//Cliente cliente = new Cliente();
		
		lista.add(cc);
		//lista.add(cliente);		//ao especificar o tipo do ArrayList, não permite mais
		
		Conta cc2 = new ContaCorrente(55, 233);
		
		lista.add(cc2);
		
		System.out.println("Tamanho: " + lista.size());
		
		Conta ref = lista.get(0);
		
		System.out.println(ref.getNumero());
		
		lista.remove(1);
		
		System.out.println("Tamanho: " + lista.size());
		
		Conta cc3 = new ContaCorrente(23, 144);
		
		lista.add(cc3);
		
		Conta cc4 = new ContaCorrente(54, 33);
		
		lista.add(cc4);
		
		for(int i =0 ; i < lista.size(); i++) {
			Object aRef = lista.get(i);
			System.out.println("Conta: " + aRef);
		}
		
		for(Conta aRef : lista ) {
			System.out.println(aRef);
		}
	}
}
