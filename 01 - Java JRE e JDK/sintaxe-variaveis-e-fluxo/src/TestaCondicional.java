
public class TestaCondicional {

	public static void main(String[] args) {
		System.out.println("Testando condicionais");
		int idade = 10;
		int quantidadePessoas = 3;
		if (idade >= 18) {
			System.out.println("Maior de idade");
		} else {
			System.out.println("Menor de idade");
			if(quantidadePessoas >= 2) {
				System.out.println("Pode entrar pois est? acompanhado");
			}else {
				System.out.println("You shall not pass");
			}
		}

		
	}

}
