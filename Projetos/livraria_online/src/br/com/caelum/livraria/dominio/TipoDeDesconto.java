package br.com.caelum.livraria.dominio;

import java.math.BigDecimal;

import org.javamoney.moneta.Money;

public enum TipoDeDesconto {
	
	CUPOM_DE_DESCONTO {
		@Override
		public Money getValor(Money subtotal) {
			return subtotal.subtract(subtotal.with(quantia -> quantia.subtract(Money.of(5, Livraria.reais))));
		}
	}, FIDELIDADE {
		@Override
		public Money getValor(Money subtotal) {
			return subtotal.subtract(subtotal.with(quantia -> quantia.multiply(BigDecimal.ONE.subtract(porcentagem(new BigDecimal(10))))));
		}
		
		private BigDecimal porcentagem(BigDecimal fatorDeCalculo) {
			return fatorDeCalculo.divide(BigDecimal.valueOf(100));
		}
	}, NENHUM {
		@Override
		public Money getValor(Money subtotal) {
			return Money.of(0, Livraria.reais);
		}
	};
	
	public abstract Money getValor(Money subtotal); /*{
		Money valor = Money.of(0, Livraria.reais);
		if(this.equals(TipoDeDesconto.CUPOM_DE_DESCONTO)) {
			valor = subtotal.subtract(subtotal.with(quantia -> quantia.subtract(Money.of(5, Livraria.reais))));
		}
		else if(this.equals(TipoDeDesconto.FIDELIDADE)) {
			valor = subtotal.subtract(subtotal.with(quantia -> quantia.multiply(BigDecimal.ONE.subtract(porcentagem(new BigDecimal(10))))));
		}
		return valor;
	}
	
	*/
	
}