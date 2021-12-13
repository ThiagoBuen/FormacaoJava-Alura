
public class TesteSacaNegativo {
	public static void main(String[] args) {
		Conta conta = new Conta(24,325);
		conta.deposita(100);
		conta.saca(200);
		System.out.println(conta.getSaldo());
	}
}
