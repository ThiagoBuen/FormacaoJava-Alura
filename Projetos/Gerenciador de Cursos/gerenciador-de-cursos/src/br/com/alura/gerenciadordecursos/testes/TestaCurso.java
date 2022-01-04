package br.com.alura.gerenciadordecursos.testes;

import java.util.List;

import br.com.alura.gerenciadordecursos.models.Aula;
import br.com.alura.gerenciadordecursos.models.Curso;

public class TestaCurso {
	public static void main(String[] args) {
		Curso javaColecoes = new Curso("Dominando Colecoes", "Paulo Silveira");
		
		//List<Aula> aulas = javaColecoes.getAulas();
		
		//aulas.add(new Aula("Trabalhando com ArrayList", 21));
		//javaColecoes.getAulas().add(new Aula("Listas de objetos", 20));
		//System.out.println(aulas);
		//System.out.println(aulas == javaColecoes.getAulas());
		
		
		javaColecoes.adiciona(new Aula("Listas de objetos", 20));
		javaColecoes.adiciona(new Aula("Criando uma Aula", 15));
		javaColecoes.adiciona(new Aula("Modelando Coleções", 23));
		
		List<Aula> aulas = javaColecoes.getAulas();
				
		System.out.println(javaColecoes.getAulas());
		
		
		
		
		
		
	}
}
