package br.com.alura.gerenciadordecursos.testes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class TestandoListas {

	public static void main(String[] args) {
		String aula1 = "Conhecendo mais de listas";
		String aula2 = "Modelando a classe Aula";
		String aula3 = "Trabalhando com Cursos e Sets";
		
		ArrayList<String> aulas = new ArrayList<String>();
		
		aulas.add(aula1);
		aulas.add(aula2);
		aulas.add(aula3);
		
		System.out.println(aulas);
		
		
		for (String aula : aulas) {
			System.out.println("Aula: " + aula);
		}
		
		aulas.remove(0);
		aulas.remove(aula2);
		
		System.out.println(aulas);
		
		String primeiraAula = aulas.get(0);
		
		System.out.println("A primeira aula é: " + primeiraAula);

		for(int i = 0; i < aulas.size(); i++) {
			System.out.println("Aula: " + aulas.get(i));
		}
		
		aulas.forEach(aula -> {
			System.out.println("Percorrendo");
			System.out.println("Aula: " + aula);
		});
		
		aulas.add("Aumentando nosso conhecimento");
		System.out.println(aulas);
		Collections.sort(aulas);			//Sort padrão = alfabético
		System.out.println("Sorted: " + aulas);
		
		
	}

}
