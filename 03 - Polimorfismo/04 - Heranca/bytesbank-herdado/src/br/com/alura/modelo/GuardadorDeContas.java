package br.com.alura.modelo;

public class GuardadorDeContas {
	private Conta[] referencias;
	private int posicaoLivre;
	
	public GuardadorDeContas() {
		this.referencias = new Conta[10];
		posicaoLivre = 0;
	}
	
	public void adiciona(Conta ref) {
		this.referencias[posicaoLivre] = ref;
		posicaoLivre++;
	}

	public int getQuantidadeElementos() {
		return this.posicaoLivre;
	}

	public Conta getReferencia(int i) {
		return this.referencias[i];
	}
	
}
