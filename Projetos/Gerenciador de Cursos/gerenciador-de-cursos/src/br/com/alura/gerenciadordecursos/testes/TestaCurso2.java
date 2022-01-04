package br.com.alura.gerenciadordecursos.testes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import br.com.alura.gerenciadordecursos.models.Aula;
import br.com.alura.gerenciadordecursos.models.Curso;

public class TestaCurso2 {
	public static void main(String[] args) {
		Curso javaColecoes = new Curso("Dominando Colecoes", "Paulo Silveira");
		
		javaColecoes.adiciona(new Aula("Listas de objetos", 20));
		javaColecoes.adiciona(new Aula("Criando uma Aula", 15));
		javaColecoes.adiciona(new Aula("Modelando Coleções", 23));
		
		List<Aula> aulasImutaveis = javaColecoes.getAulas();
				
		System.out.println(aulasImutaveis);
		
		List<Aula> aulas = new ArrayList<>(aulasImutaveis);
		
		Collections.sort(aulas);
		//aulas.sort(Comparator.comparing(Aula::getTempo));
		System.out.println(aulas);
		
		System.out.println("Tempo total: " + javaColecoes.getTempoTotal());
		
		System.out.println(javaColecoes);
	}
}
