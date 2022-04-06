package br.com.alura.mvc.mudi.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pedido {
		
		@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		private String nome;
		private BigDecimal valorNegociado;
		private LocalDate dataDaEntrega;
		private String urlProduto;
		private String urlImagem;
		private String descricao;
		
		@Enumerated(EnumType.STRING)
		private StatusPedido status;
		
		
		public StatusPedido getStatus() {
			return status;
		}
		public void setStatus(StatusPedido status) {
			this.status = status;
		}
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
