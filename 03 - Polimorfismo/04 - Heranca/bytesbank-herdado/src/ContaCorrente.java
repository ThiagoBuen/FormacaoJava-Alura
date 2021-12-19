
public class ContaCorrente extends Conta implements Tributavel{
	public ContaCorrente(int agencia, int numero) {
		// TODO Auto-generated constructor stub
		//super(); impl�cito
		super(agencia, numero);
		
	}
	
	@Override			//anota��o para o compilador -- reescrever um m�todo
	public boolean saca(double valor) {
		// TODO Auto-generated method stub
		double valorASacar = valor + 0.2;
		return super.saca(valorASacar);
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
}
