package br.com.alura.gerenciadordecursos.testes;

import br.com.alura.gerenciadordecursos.models.Aluno;
import br.com.alura.gerenciadordecursos.models.Aula;
import br.com.alura.gerenciadordecursos.models.Curso;

public class TestaCursosComAlunos {
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
		
		System.out.println("Todos os alunos matriculados: ");
		
		javaColecoes.getAlunos().forEach(a -> {
			System.out.println(a);
		});
		
		//for(Aluno a : javaColecoes.getAlunos()){
		//	System.out.println(a);
		//}
		
//		Set<Aluno> alunos = javaColecoes.getAlunos();
//		Iterator<Aluno> iterador = alunos.iterator();
//		
//		while(iterador.hasNext()) {
//			Aluno proximo = iterador.next();
//			System.out.println(proximo);
//		}
		
		//Vector<Aluno> vetor = new Vector<>();
		// vector thread safe
		
		 
		System.out.println("O aluno " + a1 + " está matriculado? " + javaColecoes.estaMatriculado(a1));
		
		Aluno testeAluno = new Aluno("Jp", 201225);
		
		System.out.println("Teste equals override @ aluno: ");
		System.out.println(a2.equals(testeAluno));
		
		System.out.println(a2.hashCode() == testeAluno.hashCode());
	}
}
