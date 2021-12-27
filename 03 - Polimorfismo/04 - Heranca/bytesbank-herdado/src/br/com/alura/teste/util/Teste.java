package br.com.alura.teste.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

import br.com.alura.modelo.Cliente;
import br.com.alura.modelo.Conta;
import br.com.alura.modelo.ContaCorrente;
import br.com.alura.modelo.ContaPoupanca;

public class Teste {
	public static void main(String[] args) {

        Conta cc1 = new ContaCorrente(22, 33);
        Cliente clienteCC1 = new Cliente();
        clienteCC1.setNome("Nico");
        cc1.setTitular(clienteCC1);
        cc1.deposita(333.0);

        Conta cc2 = new ContaPoupanca(22, 44);
        Cliente clienteCC2 = new Cliente();
        clienteCC2.setNome("Guilherme");
        cc2.setTitular(clienteCC2);
        cc2.deposita(444.0);

        Conta cc3 = new ContaCorrente(22, 11);
        Cliente clienteCC3 = new Cliente();
        clienteCC3.setNome("Paulo");
        cc3.setTitular(clienteCC3);
        cc3.deposita(111.0);

        Conta cc4 = new ContaPoupanca(22, 22);
        Cliente clienteCC4 = new Cliente();
        clienteCC4.setNome("Ana");
        cc4.setTitular(clienteCC4);
        cc4.deposita(222.0);


        List<Conta> lista = new ArrayList<>();
        lista.add(cc1);
        lista.add(cc2);
        lista.add(cc3);
        lista.add(cc4);

        for (Conta conta : lista) {
                System.out.println(conta);
        }
        
        


//        lista.sort(new Comparator<Conta>(){			//classe anônima
//			        	@Override
//			        	public int compare(Conta c1, Conta c2) {
//			        		
//			        		return Integer.compare(c1.getNumero(), c2.getNumero());
//			
//			        	}
//			        }        		        		
//        		);
        
        lista.sort((c1, c2) -> 				//lambda	
        			 Integer.compare(c1.getNumero(), c2.getNumero())	    		        		
        		);
        
        
//        Comparator<Conta> comp = new Comparator<Conta>(){
//
//        	@Override
//        	public int compare(Conta c1, Conta c2) {
//        		
//        		String nomeC1 = c1.getTitular().getNome();
//        		String nomeC2 = c2.getTitular().getNome();
//        		
//        		
//        		return nomeC1.compareTo(nomeC2);
//        	}
//        };
        
        Comparator<Conta> comp = (Conta c1, Conta c2) -> {
        	        		
        	        		String nomeC1 = c1.getTitular().getNome();
        	        		String nomeC2 = c2.getTitular().getNome();
        	        		
        	        		
        	        		return nomeC1.compareTo(nomeC2);
        	        		
        	        };
        	        
        lista.sort(comp);

        System.out.println("---------");
        
        lista.forEach((Conta conta) -> 			//method accept
				System.out.println(conta + ", " + conta.getTitular().getNome() + ", " + conta.getSaldo())      	
        );

        System.out.println("---------");
        
//        for (Conta conta : lista) {
//                System.out.println(conta + ", " + conta.getTitular().getNome() + ", " + conta.getSaldo());
//        }

        

    }
}
