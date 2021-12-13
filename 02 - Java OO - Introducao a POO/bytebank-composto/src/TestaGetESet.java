
public class TestaGetESet {
	public static void main(String[] args) {
		Conta conta = new Conta(53, 123);
		conta.setNumero(1337);
		System.out.println(conta.getNumero());
		
		conta.setAgencia(55);
		conta.deposita(255);
		System.out.println(conta.getAgencia());
		
		Cliente drei = new Cliente();
		
		drei.setNome("Drei");
		drei.setProfissao("Javeiro");
		drei.setCpf("11234566-24");
		conta.setTitular(drei);
		conta.extrato();
		
		Cliente titularDaConta = conta.getTitular();
		
		System.out.println(titularDaConta);
		System.out.println(drei);
		System.out.println(conta.getTitular());
		
	}
}
