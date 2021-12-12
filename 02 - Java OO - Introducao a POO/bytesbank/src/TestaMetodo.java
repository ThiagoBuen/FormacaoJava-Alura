
public class TestaMetodo {
	public static void main(String[] args) {
		Conta conta = new Conta();
		
		System.out.println(conta.saldo);
		conta.deposita(1000);
		System.out.println(conta.saldo);
		boolean saqueConcluido = conta.saca(500);
		System.out.println(saqueConcluido);
		System.out.println(conta.saldo);
		
		Conta conta2 = new Conta();
		
		conta2.deposita(1750);
		
		boolean transferenciaExecutada = conta2.transfere(750, conta);
		
		if(transferenciaExecutada) {
			System.out.println("Transferência executada com sucesso!");
		}else {
			System.out.println("Saldo insuficiente");
		}
		
		conta.titular = "Joneses";
		
		conta.extrato();
	}
}
