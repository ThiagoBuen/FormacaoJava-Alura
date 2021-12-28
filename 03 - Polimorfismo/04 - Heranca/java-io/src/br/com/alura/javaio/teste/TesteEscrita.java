package br.com.alura.javaio.teste;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class TesteEscrita {

	public static void main(String[] args) throws IOException{
		
		OutputStream fos = new FileOutputStream("writerExample.txt");
		Writer osr = new OutputStreamWriter(fos);
		BufferedWriter bw = new BufferedWriter(osr);
		
		bw.write("Test first line");
		bw.newLine();
		bw.newLine();
		bw.newLine();
		bw.write("Goodbye stranger!");
		
		bw.close();
	}
}
