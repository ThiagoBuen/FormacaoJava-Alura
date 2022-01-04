package br.com.caelum.livraria.dominio;

public class Cliente {

	private final String id;
//	private final Telefone telefone;
	private String cep;
	
	private String ddd;
	private String numero;
	
	public Cliente(String id, String cep, String ddd, String numero) {
		this.id = id;
//		this.telefone = telefone;
		this.cep = cep;
		this.ddd = ddd;
		this.numero = numero;
	}

	@Override
	public boolean equals(Object obj) {
		boolean iguais = false;
		if(obj instanceof Cliente) {
			Cliente outra = (Cliente) obj;
			iguais = id.equals(outra.id);
		}
		return iguais;
	}
	

	public String getTelefoneFormatado() {
		return String.format("(%s) %s", ddd, numero); 
	}
	
	@Override
	public int hashCode() {
		return id.hashCode();
	}

	public String getTelefone() {
		return getTelefoneFormatado();
	}
	
	public String getCep() {
		return cep;
	}
	

}
