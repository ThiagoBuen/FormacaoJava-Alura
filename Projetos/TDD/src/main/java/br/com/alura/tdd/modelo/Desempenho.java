package br.com.alura.tdd.modelo;

import java.math.BigDecimal;

public enum Desempenho {
	A_Desejar {
		@Override
		public BigDecimal percentualReajuste() {
			return new BigDecimal("0.03");
		}
	}, Bom {
		@Override
		public BigDecimal percentualReajuste() {
			return new BigDecimal("0.15");
		}
	}, Otimo {
		@Override
		public BigDecimal percentualReajuste() {
			return new BigDecimal("0.20");
		}
	};

	public abstract BigDecimal percentualReajuste();
}
