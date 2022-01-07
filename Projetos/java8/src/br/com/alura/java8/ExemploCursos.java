package br.com.alura.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class Curso {
	private String nome;
	private int alunos;

	public Curso(String nome, int alunos) {
		this.nome = nome;
		this.alunos = alunos;
	}

	public String getNome() {
		return nome;
	}

	public int getAlunos() {
		return alunos;
	}
}

public class ExemploCursos {
	public static void main(String[] args) {
		List<Curso> cursos = new ArrayList<Curso>();
		cursos.add(new Curso("Python", 45));
		cursos.add(new Curso("JavaScript", 150));
		cursos.add(new Curso("Java 8", 113));
		cursos.add(new Curso("C", 55));

		cursos.sort(Comparator.comparing(Curso::getAlunos));

		cursos.forEach(c -> System.out.println(c.getNome()));

		System.out.println("--------");
		cursos.stream().filter(c -> c.getAlunos() >= 100).forEach(c -> System.out.println(c.getNome()));

		System.out.println("--------");

		cursos.stream().filter(c -> c.getAlunos() >= 100).map(c -> c.getAlunos())
				.forEach(total -> System.out.println(total));

		System.out.println("--------");

		int sum = cursos.stream().filter(c -> c.getAlunos() >= 100).mapToInt(Curso::getAlunos).sum();

		System.out.println(sum);

		System.out.println("--------");

		cursos.stream().filter(c -> c.getAlunos() >= 100).findAny().ifPresent(c -> System.out.println(c.getNome()));

//		Curso curso = optionalCurso.orElse(null);
//		System.out.println(curso.getNome());

		OptionalDouble media = cursos.stream().filter(c -> c.getAlunos() >= 100).mapToInt(Curso::getAlunos).average();
		System.out.println(media);

		System.out.println("--------");

		List<Curso> cursosFiltrados = new ArrayList<Curso>();

		cursosFiltrados = cursos.stream().filter(c -> c.getAlunos() >= 100).collect(Collectors.toList());

		cursosFiltrados.forEach(c -> System.out.println(c.getNome()));

		System.out.println("--------");

		cursos.stream().filter(c -> c.getAlunos() >= 100)
			  .collect(Collectors.toMap(
									c -> c.getNome(),
									c -> c.getAlunos()))
			  .forEach((nome, alunos) -> System.out.println(nome + " tem " + alunos + " alunos"));

		
	}
}
