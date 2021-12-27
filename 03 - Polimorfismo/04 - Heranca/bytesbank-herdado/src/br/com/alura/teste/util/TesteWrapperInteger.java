package br.com.alura.teste.util;

import java.util.ArrayList;
import java.util.List;

public class TesteWrapperInteger {
	public static void main(String[] args) {
		int[] idades = new int[5];
		
		String[] nomes = new String[5];
		
		int idade = 29; //Inicialização por primitivo
		Integer idadeRef = Integer.valueOf(29); //Inicialização por classe; autoboxing
		int valor = idadeRef.intValue();		//unboxing
		idadeRef++;
		System.out.println(idadeRef);
		
		List<Integer> numeros = new ArrayList<Integer>();
		numeros.add(29); 	//Autoboxing
		
		String s = args[0];
		
		//Integer numero = Integer.valueOf(s);
		
		int numero = Integer.parseInt(s);
		
		System.out.println(numero);
	}
}
