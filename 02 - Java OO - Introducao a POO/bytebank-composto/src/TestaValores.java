
public class TestaValores {
	public static void main(String[] args) {
		
		System.out.println("Total de contas criadas é " + Conta.getTotalContas());
		
		Conta conta = new Conta(55, 254);
		
		// conta está inconsistente
		
		conta.setAgencia(-50);
		conta.setNumero(-130);
		
		System.out.println(conta.getAgencia());
		
		Conta conta2 = new Conta(23, 244);
		
		conta2.getAgencia();
		
		System.out.println("Total de contas criadas é " + Conta.getTotalContas());
		
	}
}
