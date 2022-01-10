package br.com.alura.tdd.calculadora.test;

import org.junit.jupiter.api.Test;

import br.com.alura.tdd.calculadora.model.Calculadora;
import org.junit.Assert;			//junit.framework.Assert; deprecated

public class CalculadoraTest {
	
	@Test
	public void somarDoisNumerosPositivos() {
		Calculadora calc = new Calculadora();
		int soma  = calc.somar(3, 7);	
		
		Assert.assertEquals(10, soma);
		
		
	}
	
	
}
