package br.com.alura.forum.controller.dto;

public class TokenDto {

	private String token;
	private String tokenType;
	
	public TokenDto(String token, String tokenType) {
		this.token = token;
		this.tokenType = tokenType;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getTokenType() {
		return tokenType;
	}

	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}
	
	
}
