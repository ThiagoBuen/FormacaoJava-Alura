package br.com.alura.gerenciadordecursos.models;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

public class Curso {
	private String nome;
	private String instrutor;
	private List<Aula> aulas = new LinkedList<Aula>();
	private Set<Aluno> alunos = new HashSet<>();			//LinkedHashSet; TreeSet (Estruturas com Comparable)
	private Map<Integer, Aluno> matriculaParaAluno = new HashMap<>();
	
	public Curso(String nome, String instrutor) {
		super();
		this.nome = nome;
		this.instrutor = instrutor;
	}

	public List<Aula> getAulas() {
		return Collections.unmodifiableList(aulas);
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getInstrutor() {
		return instrutor;
	}
	
	public void adiciona(Aula aula) {
		this.aulas.add(aula);
	}
	
	public int getTempoTotal() {
//		int tempoTotal = 0;
//		
//		for (Aula aula : aulas) {
//			tempoTotal += aula.getTempo();
//		}
//		
//		return tempoTotal;
		
		return this.aulas.stream().mapToInt(Aula::getTempo).sum();
	}
	
	@Override
	public String toString() {
		return "[Curso: " + nome + ", tempo total: " + this.getTempoTotal() + " + aulas: " + this.aulas + "]";
	}

	public void matricula(Aluno aluno) {
		this.alunos.add(aluno);
		this.matriculaParaAluno.put(aluno.getNumeroMatricula(), aluno);
		
	}
	
	public Set<Aluno> getAlunos() {
		return Collections.unmodifiableSet(alunos);
	}

	public boolean estaMatriculado(Aluno aluno) {
		return this.alunos.contains(aluno);
	}

	public Aluno buscaMatricula(int matricula) {
		if(!matriculaParaAluno.containsKey(matricula))
			throw new NoSuchElementException("N�o h� tal aluno");
		return matriculaParaAluno.get(matricula);
//		outra alternativa nem t�o eficiente
//		for (Aluno aluno : alunos) {
//			if(aluno.getNumeroMatricula() == matricula) {
//				return aluno;
//			}
//		}
//		throw new NoSuchElementException("Matricula n�o encontrada.");
	}

}
