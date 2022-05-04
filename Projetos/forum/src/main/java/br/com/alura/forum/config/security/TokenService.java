package br.com.alura.forum.config.security;


import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import br.com.alura.forum.modelo.Usuario;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {

	@Value("${forum.jwt.expiration}")
	private String expiration;
	
	@Value("${forum.jwt.secret}")
	private String secret;
	
	public String gerarToken(Authentication authentication) {
		
		Usuario userLog = (Usuario) authentication.getPrincipal();

		Date today = new Date();
		Date expirationDate = new Date(today.getTime() + expiration);
		
		return Jwts.builder()
				   .setIssuer("API do Fórum da Alura")
				   .setSubject(userLog.getId().toString())
				   .setIssuedAt(today)
				   .setExpiration(expirationDate)
				   .signWith(SignatureAlgorithm.HS256, secret)
				   .compact();
		
	}

	public boolean isTokenValid(String token) {	
		try {
			Jwts.parser().setSigningKey(this.secret)
   						 .parseClaimsJws(token);
			return true;
		}catch(Exception e) {			
			return false;
		}
		
	}

}
