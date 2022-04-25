package br.com.alura.forum.config.validacao;

public class FormErrorDto {
	
	private String campo;
	private String error;
	
	public FormErrorDto(String campo, String error) {
		this.campo = campo;
		this.error = error;
	}

	public String getCampo() {
		return campo;
	}

	public String getError() {
		return error;
	}
	
	
}
