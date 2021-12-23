package br.com.alura.teste;
import br.com.alura.modelo.ContaCorrente;
import br.com.alura.modelo.ContaPoupanca;

public class TesteConta {
	public static void main(String[] args) {
		ContaCorrente cc = new ContaCorrente(111, 111);
		cc.deposita(100);
		
		ContaPoupanca cp = new ContaPoupanca(222, 222);
		cp.deposita(200);
		
		cc.transfere(10, cp);
		
		System.out.println("CP " + cp.getSaldo());
		System.out.println("CC " + cc.getSaldo());
		
	}
}
