package br.com.alura.gerenciadordecursos.testes;

import br.com.alura.gerenciadordecursos.models.Aluno;
import br.com.alura.gerenciadordecursos.models.Aula;
import br.com.alura.gerenciadordecursos.models.Curso;

public class TesteBuscaAlunos {
	public static void main(String[] args) {
		
		Curso javaColecoes = new Curso("Dominando Colecoes", "Paulo Silveira");
		
		javaColecoes.adiciona(new Aula("Listas de objetos", 20));
		javaColecoes.adiciona(new Aula("Criando uma Aula", 15));
		javaColecoes.adiciona(new Aula("Modelando Coleções", 23));
		
		Aluno a1 = new Aluno("Rodrigo Turini", 35495);
		Aluno a2 = new Aluno("Jp", 201225);
		Aluno a3 = new Aluno("Luiz", 120588);
		
		javaColecoes.matricula(a1);
		javaColecoes.matricula(a2);
		javaColecoes.matricula(a3);
		
		System.out.println("Quem é o aluno 201225? ");
		Aluno aluno = javaColecoes.buscaMatricula(201225);
		System.out.println("Aluno: " + aluno);
		
		
	}
}
