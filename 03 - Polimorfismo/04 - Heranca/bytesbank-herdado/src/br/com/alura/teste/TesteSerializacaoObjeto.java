package br.com.alura.teste;

import br.com.alura.modelo.Cliente;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TesteSerializacaoObjeto {
	public static void main(String[] args) throws IOException, ClassNotFoundException{
		Cliente cliente = new Cliente();
		cliente.setNome("John");
		cliente.setProfissao("Dev");
		cliente.setCpf("1235415");
		
		
		
	
				//String nome = "Drei";
//		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("object2.bin"));
//		oos.writeObject(cliente);
//		oos.close();
//				
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("object2.bin"));
		Cliente clienteOIS = (Cliente) ois.readObject();
		ois.close();
		System.out.println(clienteOIS.getCpf());
			
			
		

	}
}
