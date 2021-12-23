package br.com.bytebank.banco.teste;

public class TesteString {
	public static void main(String[] args) {
		
		String nome = "Alura";  //object literal
								//String é imutável
		//String outro = new String("Alura);
		
		String outroNome = nome.replace("A", "a");
		
		nome = nome.toLowerCase(); //toUpperCase();
		nome = nome.trim();
		
		System.out.println(nome.charAt(2));
		System.out.println("Posicao: " + nome.indexOf("ur"));
		
		System.out.println("Length: " + nome.length());
		
		System.out.println("Vazio? " + nome.isEmpty());
		
		System.out.println("Possui Alu? " + nome.contains("Alu"));
		
		System.out.println(nome);
		System.out.println(outroNome);
		
		
	}
}
