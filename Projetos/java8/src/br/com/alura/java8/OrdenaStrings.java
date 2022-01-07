package br.com.alura.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class OrdenaStrings {

	public static void main(String[] args) {
		List<String> palavras = new ArrayList<String>();
		palavras.add("alura online");
		palavras.add("editora casa do codigo");
		palavras.add("caelum");

//		Comparator<String> comparador = new ComparadorPorTamanho();
//		Collections.sort(palavras, comparador);
//		System.out.println(palavras);

//		for (String p : palavra) {
//			System.out.println(p);
//		}

//		palavras.sort((String s1, String s2) -> {
//				if (s1.length() < s2.length()) {
//					return -1;
//				} else if (s1.length() > s2.length()) {
//					return 1;
//				}
//				return 0;
//		});

//		palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
//		
		palavras.sort(Comparator.comparing(s -> s.length()));
//		palavras.sort(Comparator.comparing(String::length));		equivalente ao de cima
//		

		palavras.forEach(s -> System.out.println(s));

	}
}
//
//class ImprimeNaLinha implements Consumer<String>{
//	
//}

//class ComparadorPorTamanho implements Comparator<String> {
//
//	@Override
//	public int compare(String s1, String s2) {
//		
//	}
//
//}