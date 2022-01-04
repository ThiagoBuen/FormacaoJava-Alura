package br.com.caelum.livraria.dominio;

import org.javamoney.moneta.Money;

public class CalculadoraDeCompra {
	
	public Money calcularValorTotal(Money subtotal, Money valorDoFrete, Desconto desconto) {
		if(subtotal.isZero()) return subtotal;
		
		Money resultado = subtotal;
		
		resultado = resultado.subtract(desconto.getValor());
		resultado = resultado.add(valorDoFrete);
		return resultado;
	}
}
