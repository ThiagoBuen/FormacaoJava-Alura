package br.com.alura.javaio.teste;

import java.io.File;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class TesteScanner {

	public static void main(String[] args) throws Exception{
		
		Scanner scanner = new Scanner(new File("contas.csv"), "UTF-8");
		
		while(scanner.hasNextLine()) {
			String linha = scanner.nextLine();
			//System.out.println(linha);		
			
			Scanner linhaScanner = new Scanner(linha);
			linhaScanner.useLocale(Locale.US);
			linhaScanner.useDelimiter(",");
			
			String tipoConta = linhaScanner.next();
			int agencia = linhaScanner.nextInt();
			int numero = linhaScanner.nextInt();
			String titular = linhaScanner.next();
			double saldo = linhaScanner.nextDouble();
			
			String valorFormatado = String.format(new Locale("pt","BR") ,"%s - %04d-%05d, %5s: %05.3f", tipoConta, agencia, numero, titular, saldo);
			
			System.out.println(valorFormatado);
			
			
//			String[] valores = linha.split(",");
//			System.out.println(Arrays.toString(valores));
		}
		scanner.close();
		
	}
}
