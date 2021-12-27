package br.com.alura.teste.util;

import java.util.ArrayList;
import java.util.List;

public class TesteOutrosWrappers {
	public static void main(String[] args) {
		
		Integer idadeRef = Integer.valueOf(29);  //autoboxing
		System.out.println(idadeRef.doubleValue()); // unboxing
		
		Double dRef = Double.valueOf(3.2);			//autoboxing
		System.out.println(dRef.doubleValue());		//unboxing
		
		Boolean bRef = Boolean.TRUE;
		System.out.println(bRef.booleanValue());
		
		Number refnumero = Double.valueOf(29.9);
		
		Number refNumeroFloat = Float.valueOf(35.5f);
		
		
		List<Number> list = new ArrayList<>();
		
		list.add(10);
		
		list.add(32.6);
		list.add(25.6f);
		
		
	}
}
