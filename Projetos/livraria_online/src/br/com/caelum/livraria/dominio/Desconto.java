package br.com.caelum.livraria.dominio;

import org.javamoney.moneta.Money;

public class Desconto {

	private final Money subtotal;
	private final TipoDeDesconto tipo;
	
	public static final Desconto NENHUM = 
			new Desconto(Money.of(0, Livraria.reais), TipoDeDesconto.NENHUM);

	public Desconto(Money subtotal, TipoDeDesconto tipo) {
		this.subtotal = subtotal;
		this.tipo = tipo;
	}

	public Money getValor() {
		return tipo.getValor(subtotal);
//		Money valor = Money.of(0, Livraria.reais);
//		if(tipo.equals(TipoDeDesconto.CUPOM_DE_DESCONTO)) {
//			valor = subtotal.subtract(subtotal.with(quantia -> quantia.subtract(Money.of(5, Livraria.reais))));
//		}
//		else if(tipo.equals(TipoDeDesconto.FIDELIDADE)) {
//			valor = subtotal.subtract(subtotal.with(quantia -> quantia.multiply(BigDecimal.ONE.subtract(porcentagem(new BigDecimal(10))))));
//		}
//		return valor;
	}
	
//	private BigDecimal porcentagem(BigDecimal fatorDeCalculo) {
//		return fatorDeCalculo.divide(BigDecimal.valueOf(100));
//	}
}
