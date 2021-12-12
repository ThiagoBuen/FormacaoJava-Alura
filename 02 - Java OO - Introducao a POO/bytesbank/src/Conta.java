public class Conta{
	//Atributos
	double saldo;
	int agencia = 42; //valor padr�o para todos os objetos
	int numero;
	String titular;
	
	public void deposita(double valor) {
		this.saldo += valor;
	}
	
	public boolean saca(double valor) {
		if(this.saldo >= valor) {
			this.saldo -= valor;
			return true;
		}else {
			System.out.println("Saldo insuficiente!");
			return false;
		}
	}
	
	public boolean transfere(double valor, Conta destino) {
		if(this.saldo >= valor) {
			destino.deposita(valor);
			this.saca(valor);
			return true;
		}
		return false;
		
	}
	
	void extrato() {
		System.out.println("Conta: " + this);
		System.out.println("Saldo: " + this.saldo);
		System.out.println("Ag�ncia: " + this.agencia);
		System.out.println("Numero: " + this.numero);
		System.out.println("Titular: " + this.titular);
		
		
	}
	
}