
public class ContaPoupanca extends Conta {
	public ContaPoupanca(int agencia, int numero) {
		// TODO Auto-generated constructor stub
		super(agencia, numero);
	}

	@Override
	public void deposita(double valor) {
		// TODO Auto-generated method stub
		super.setSaldo(valor);
	}
}
