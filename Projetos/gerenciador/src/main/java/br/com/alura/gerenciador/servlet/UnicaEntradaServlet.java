package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.acao.Acao;
import br.com.alura.gerenciador.acao.AlteraEmpresa;
import br.com.alura.gerenciador.acao.FormCriarEmpresa;
import br.com.alura.gerenciador.acao.ListaEmpresas;
import br.com.alura.gerenciador.acao.MostraEmpresa;
import br.com.alura.gerenciador.acao.NovaEmpresa;
import br.com.alura.gerenciador.acao.RemoveEmpresa;
import br.com.alura.gerenciador.models.Banco;
import br.com.alura.gerenciador.models.Empresa;

@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String paramAcao =  request.getParameter("acao");
		
		String nomeDaClasse = "br.com.alura.gerenciador.acao." + paramAcao;
		
		System.out.println(nomeDaClasse);
		
		String nome;
		
		try {
			Class classe = Class.forName(nomeDaClasse);					// carrega a classe com o nome da string
			Acao acao = (Acao) classe.newInstance();			
			nome = acao.executa(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new ServletException(e);
		} 
		
		
		String[] tipoEEndereco = nome.split(":");
		if(tipoEEndereco[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipoEEndereco[1]);
			rd.forward(request, response);			
		}else {
			response.sendRedirect(tipoEEndereco[1]);
		}
		
//		String nome = null; 
//		
//		if(paramAcao.equals("ListaEmpresas")) {
//			
//			ListaEmpresas acao = new ListaEmpresas();
//			nome = acao.executa(request, response);
//			
//		}else if(paramAcao.equals("RemoveEmpresa")) {
//			
//			RemoveEmpresa acao = new RemoveEmpresa();
//			nome = acao.executa(request, response);
//			
//		}else if(paramAcao.equals("MostraEmpresa")) {
//			
//			MostraEmpresa acao = new MostraEmpresa();
//			nome = acao.executa(request, response);
//			
//		}else if(paramAcao.equals("AlteraEmpresa")) {
//			
//			AlteraEmpresa acao = new AlteraEmpresa();
//			nome = acao.executa(request, response);
//			System.out.println(nome);
//			
//		}else if(paramAcao.equals("NovaEmpresa")) {
//			
//			NovaEmpresa acao = new NovaEmpresa();
//			nome = acao.executa(request, response);	
//		}else if(paramAcao.equals("CriarEmpresa")) {
//			
//			FormCriarEmpresa acao = new FormCriarEmpresa();
//			nome = acao.executa(request, response);	
//		}
		
	}


}
