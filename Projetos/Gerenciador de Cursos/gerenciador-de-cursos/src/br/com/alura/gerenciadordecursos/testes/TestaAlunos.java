package br.com.alura.gerenciadordecursos.testes;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class TestaAlunos {

	public static void main(String[] args) {
		Collection<String> alunos = new HashSet<>();
		
		alunos.add("Rodrigo Turini");
		alunos.add("Jp");
		alunos.add("Drei");
		alunos.add("Jack");
		alunos.add("Mauricio Aniche");
		alunos.add("Jp");
		
		System.out.println("Total de alunos: " + alunos.size());
		
		System.out.println(alunos);
		
		for (String aluno : alunos) {
			System.out.println(aluno);
		}
		
		boolean jpEstaMatriculado = alunos.contains("Jp");
		System.out.println(jpEstaMatriculado);
		
		alunos.remove("Mauricio Aniche");
		System.out.println(alunos);
	}
}
