package br.com.alura.mvc.mudi.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Pedido {

		private String nome;
		private BigDecimal valorNegociado;
		private LocalDate dataDaEntrega;
		private String urlProduto;
		private String urlImagem;
		private String descricao;
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public BigDecimal getValorNegociado() {
			return valorNegociado;
		}
		public void setValorNegociado(BigDecimal valorNegociado) {
			this.valorNegociado = valorNegociado;
		}
		public LocalDate getDataDaEntrega() {
			return dataDaEntrega;
		}
		public void setDataDaEntrega(LocalDate dataDaEntrega) {
			this.dataDaEntrega = dataDaEntrega;
		}
		public String getUrlProduto() {
			return urlProduto;
		}
		public void setUrlProduto(String urlProduto) {
			this.urlProduto = urlProduto;
		}
		public String getUrlImagem() {
			return urlImagem;
		}
		public void setUrlImagem(String urlImagem) {
			this.urlImagem = urlImagem;
		}
		public String getDescricao() {
			return descricao;
		}
		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}
		
		
}
