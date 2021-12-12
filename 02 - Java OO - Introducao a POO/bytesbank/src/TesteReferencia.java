
public class TesteReferencia {
	public static void main(String[] args) {
		Conta primeiraConta = new Conta();		//Cria uma refer�ncia do objeto tipo Conta
		primeiraConta.saldo = 300;
		
		System.out.println("Saldo da primeira conta: " + primeiraConta.saldo);
		
		Conta segundaConta = primeiraConta;		//Cria uma refer�ncia para o mesmo endere�o de mem�ria da refer�ncia primeiraConta
		
		segundaConta.saldo += 150;
		System.out.println("Saldo da primeira conta: " + primeiraConta.saldo);
		
		System.out.println("Saldo da segunda conta: " + segundaConta.saldo);
		
		System.out.println(primeiraConta);
		System.out.println(segundaConta);
		
	}
}
