public class Conta{
	//Atributos
	private double saldo;
	private int agencia = 42; //valor padrão para todos os objetos
	private int numero;
	private static int numeroTotalDeContas = 0;
	
	Cliente titular;
	
	public Conta(int agencia, int numero) {
		this.agencia = agencia;
		this.numero = numero;
		Conta.numeroTotalDeContas++;
		System.out.println("Estou criando uma conta");
	}
	
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
		System.out.println("Saldo: " + this.getSaldo());
		System.out.println("Agência: " + this.getAgencia());
		System.out.println("Numero: " + this.getNumero());
		System.out.println("Titular: " + this.titular.getNome());
		
		
	}
	
	public double getSaldo() {
		return this.saldo;
	}
	
	public double getNumero() {
		return this.numero;
	}
	
	public void setNumero(int numero) {
		if(numero <= 0) {
			System.out.println("Erro! Valor menor ou igual a 0");
			return;
		}
		this.numero = numero;
	}
	
	public int getAgencia() {
		return this.agencia;
	}
	
	public void setAgencia(int agencia) {
		if(agencia <= 0) {
			System.out.println("Erro! Valor não aceito");
			return;
		}
		this.agencia = agencia;
	}
	
	public void setTitular(Cliente titular) {
		this.titular = titular;
	}
	
	public Cliente getTitular() {
		return this.titular;
	}
	
	public static int getTotalContas() {
		//static apenas acessa recursos static da classe	
		return Conta.numeroTotalDeContas;
	}
}