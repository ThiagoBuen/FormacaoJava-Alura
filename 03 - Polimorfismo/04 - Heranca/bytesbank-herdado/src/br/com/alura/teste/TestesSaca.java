package br.com.alura.teste;
import br.com.alura.modelo.Conta;
import br.com.alura.modelo.ContaCorrente;

public class TestesSaca {
	public static void main(String[] args) {
		Conta conta = new ContaCorrente(123, 321);
		
		conta.deposita(200);
		try {			
			conta.saca(290);
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}

		System.out.println(conta.getSaldo());
	}
}
