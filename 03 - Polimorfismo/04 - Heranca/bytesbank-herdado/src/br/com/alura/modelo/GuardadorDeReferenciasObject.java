package br.com.alura.modelo;

public class GuardadorDeReferenciasObject {
	
	private Object[] referencias;
	private int posicaoLivre;
	
	public GuardadorDeReferenciasObject() {
		this.referencias = new Object[10];
		this.posicaoLivre = 0;
	}
	
	public void adiciona(Object ref) {
		this.referencias[this.posicaoLivre] = ref;
		this.posicaoLivre++;
	}

	public int getQuantidadeElementos() {
		return this.posicaoLivre;
	}

	public Object getReferencia(int posicao) {
		return this.referencias[posicao];
	}
}
