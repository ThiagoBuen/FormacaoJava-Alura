
public class TestaBanco {

	public static void main(String[] args) {
		Cliente john = new Cliente();
		john.setNome("John McCartney");
		john.setCpf("222.111.444.333-24");
		john.setProfissao("programador");
		
		Conta contaDoJohn = new Conta(24,344);
		contaDoJohn.deposita(1000);
		contaDoJohn.titular = john;
		
		contaDoJohn.extrato();
	}
}
