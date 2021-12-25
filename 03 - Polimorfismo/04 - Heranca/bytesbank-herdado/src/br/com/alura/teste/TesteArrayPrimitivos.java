package br.com.alura.teste;

public class TesteArrayPrimitivos {
	public static void main(String[] args) {
		
		int[] idades = new int[5]; // int idades[];
									//inicializa o array com valor padrao (int = 0)
		
		for(int i = 0; i < idades.length; i++) {
			idades[i] = i * i;
		}
		
		
		for(int i = 0; i < idades.length; i++) {
			System.out.println(idades[i]);
		}


		int idade4 = idades[4];
		
		System.out.println(idade4);
		
		System.out.println(idades.length);
		
		
	}
}
