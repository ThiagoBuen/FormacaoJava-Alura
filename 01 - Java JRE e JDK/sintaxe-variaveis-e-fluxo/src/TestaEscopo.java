
public class TestaEscopo {

	public static void main(String[] args) {
		System.out.println("Testando condicionais");

		int idade = 20;
		int quantidadePessoas = 1;
		//boolean acompanhado = (quantidadePessoas >= 2);
		boolean acompanhado;					//default boolean: dentro de escopo local n�o h� valor padr�o
		
		if(quantidadePessoas >= 2) {			//escopo de uma vari�vel � { .... }
			acompanhado = true;
		}
		else {
			acompanhado = true;
		}
		if (idade >= 18 && acompanhado) { // && ||
			System.out.println("Pode entrar");
		} else {
			System.out.println("You shall not pass");
		}

	}

}

