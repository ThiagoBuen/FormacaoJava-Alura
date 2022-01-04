package br.com.alura.gerenciadordecursos.testes;

import java.util.Collection;
import java.util.HashSet;

public class TesteHashPerformance {
	public static void main(String[] args) {

		//Collection<Integer> numeros = new ArrayList<Integer>();
		Collection<Integer> numeros = new HashSet<>();
		
        long inicio = System.currentTimeMillis();

        for (int i = 1; i <= 50000; i++) {
            numeros.add(i);
        }
        
        long mid = System.currentTimeMillis();
        
        for (Integer numero : numeros) {
            numeros.contains(numero);
        }

        long fim = System.currentTimeMillis();

        long tempoDeExecucao = fim - inicio;
        
        long tempoFirstFor = mid - inicio;
        
        long tempoSecondFor = fim - mid;

        System.out.println("Tempo gasto: " + tempoDeExecucao);
        System.out.println("First for: "  + tempoFirstFor);
        System.out.println("Second for: "  + tempoSecondFor);

    }
}
