public class CriaConta {
	public static void main(String[] args) {
		Conta primeiraConta = new Conta();		//Cria (instancia) uma refer�ncia do tipo/classe Conta
		primeiraConta.saldo = 200;
		System.out.println(primeiraConta.saldo);
		
		primeiraConta.saldo += 200;
		System.out.println(primeiraConta.saldo);
		
		Conta segundaConta = new Conta();
		segundaConta.saldo = - 100;
		
		System.out.println("primeira conta tem " + primeiraConta.saldo);
		System.out.println("segunda conta tem " + segundaConta.saldo);
		
		System.out.println(primeiraConta.agencia);
		
		segundaConta.agencia = 155;
		System.out.println("A ag�ncia da segunda conta �: " + segundaConta.agencia);
		
		
	}
}
