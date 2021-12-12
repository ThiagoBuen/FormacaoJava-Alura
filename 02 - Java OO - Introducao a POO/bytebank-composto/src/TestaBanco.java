
public class TestaBanco {

	public static void main(String[] args) {
		Cliente john = new Cliente();
		john.nome = "John McCartney";
		john.cpf = "222.111.444.333-24";
		john.profissao = "programador";
		
		Conta contaDoJohn = new Conta();
		contaDoJohn.deposita(1000);
		contaDoJohn.titular = john;
		
		contaDoJohn.extrato();
	}
}
