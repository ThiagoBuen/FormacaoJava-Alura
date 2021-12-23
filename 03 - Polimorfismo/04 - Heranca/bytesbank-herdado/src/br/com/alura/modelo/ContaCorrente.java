package br.com.alura.modelo;

public class ContaCorrente extends Conta implements Tributavel{
	public ContaCorrente(int agencia, int numero) {
		// TODO Auto-generated constructor stub
		//super(); implícito
		super(agencia, numero);
		
	}
	
	@Override			//anotação para o compilador -- reescrever um método
	public void saca(double valor) {		//throws SaldoInsuficienteException
		// TODO Auto-generated method stub
		double valorASacar = valor + 0.2;
		super.saca(valorASacar);
	}

	@Override
	public void deposita(double valor) {
		// TODO Auto-generated method stub
		super.setSaldo(valor);
		
	}

	@Override
	public double getValorImposto() {
		// TODO Auto-generated method stub
		return super.getSaldo() * 0.01;
	}
	
	@Override
	public String toString() {
		return "ContaCorrente: " + super.toString();
	}
}
