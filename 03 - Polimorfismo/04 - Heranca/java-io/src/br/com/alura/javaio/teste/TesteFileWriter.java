package br.com.alura.javaio.teste;

import java.io.IOException;
import java.io.PrintWriter;

public class TesteFileWriter {

	public static void main(String[] args) throws IOException{

		//BufferedWriter bw = new BufferedWriter(new FileWriter("FileWriterExample.txt"));
		
		//PrintStream ps = new PrintStream("PrintStreamExample.txt");
		
		PrintWriter ps = new PrintWriter("PrintWriterExample.txt");

		ps.println("Test first line");
		ps.println();
		ps.println();
		ps.println("Goodbye stranger!");
		
		ps.close();
	}
}
