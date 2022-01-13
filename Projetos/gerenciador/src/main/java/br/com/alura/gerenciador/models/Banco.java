package br.com.alura.gerenciador.models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

public class Banco {

	private static List<Empresa> listaDeEmpresas = new ArrayList<Empresa>();
	private static Integer chaveSequencial = 1;
	
	static {
		Empresa empresa = new Empresa();
		empresa.setId(chaveSequencial++);;
		empresa.setNome("Alura");
		Empresa empresa2 = new Empresa();
		empresa2.setNome("Scala ad Caelum");
		empresa2.setId(chaveSequencial++);
		listaDeEmpresas.add(empresa);
		listaDeEmpresas.add(empresa2);
	}
	
	public void adiciona(Empresa empresa) {
		// TODO Auto-generated method stub
		empresa.setId(Banco.chaveSequencial++);
		Banco.listaDeEmpresas.add(empresa);
	}

	public List<Empresa> getEmpresas(){
		return Banco.listaDeEmpresas;
	}

	public void removeEmpresa(Integer id) {
		
		Iterator<Empresa> it = listaDeEmpresas.iterator();
		
		while(it.hasNext()) {
			Empresa emp = it.next();
			if(emp.getId() == id) {
				it.remove();				
			}
		}
	}
		
//		for (Empresa empresa : listaDeEmpresas) {		erro 500 - não pode apagar iterando na lista
//			if(empresa.getId() == id) {
//				listaDeEmpresas.remove(empresa);				
//			}
//		}
		
	

	public Empresa buscaEmpresaPeloId(Integer id) {
		for (Empresa empresa : listaDeEmpresas) {		
			if(empresa.getId() == id) {
				return empresa;				
			}
	
		}
		return null;
		
	}
		
	
}
