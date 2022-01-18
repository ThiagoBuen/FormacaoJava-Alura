package br.com.alura.cliente;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;

public class ClienteWebService {
	
	public static void main(String[] args) throws Exception {
		String conteudo = Request.Post("http://localhost:8080/gerenciador/empresas")
								 .addHeader("Accept", "application/json")
								 .execute()
								 .returnContent()
								 .asString();	
		
		System.out.println(conteudo);
		
		
	}
}
