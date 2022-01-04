package br.com.alura.teste.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import br.com.alura.modelo.Cliente;
import br.com.alura.modelo.ContaCorrente;

public class TesteSerializacao {
	public static void main(String[] args) throws IOException, ClassNotFoundException{
		Cliente cliente = new Cliente();
		cliente.setNome("John");
		cliente.setProfissao("Dev");
		cliente.setCpf("1235415");
		
		
		ContaCorrente cc = new ContaCorrente(222, 333);
		cc.setTitular(cliente);
		cc.deposita(222.4);
		
	
				//String nome = "Drei";
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("cc.bin"));
		oos.writeObject(cc);
		oos.close();
//				
//		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("object2.bin"));
//		Cliente clienteOIS = (Cliente) ois.readObject();
//		ois.close();
//		System.out.println(clienteOIS.getCpf());
			
	}
}
