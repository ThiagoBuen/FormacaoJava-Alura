package br.com.caelum.livraria.dominio;

public class ValidarISBN {
	
	private String valor;

	
	public ValidarISBN(String valor) {
		super();
		this.valor = valor;

	}
	
	public boolean validar() {
		if (this.valor == null) return false;

		String isbnSomenteNumeros = this.valor.replaceAll("-", "");
		if(isbnSomenteNumeros.length() != 13) return false;
		
		try{
			int tot = 0;
			for (int i = 0; i < 12; i++ ){
				int digito = Integer.parseInt(isbnSomenteNumeros.substring(i, i + 1));
				tot += (i % 2 == 0) ? digito * 1 : digito * 3;
			}

			int checksum = 10 - (tot % 10);
			if (checksum == 10) checksum = 0;

			return checksum == Integer.parseInt(isbnSomenteNumeros.substring(12));
		}
		catch (NumberFormatException nfe){
			return false;
		}
	}
	
	
}
