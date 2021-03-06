package br.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.gerenciador.acao.Acao;

/**
 * Servlet implementation class UnicaEntradaServlet
 */
//@WebServlet(urlPatterns = "/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String paramAcao = request.getParameter("acao");
		
//		HttpSession session = request.getSession();
//		boolean usuarioNaoEstaLogado = (session.getAttribute("usuarioLogado") == null);
//		boolean acaoProtegida = !(paramAcao.equals("Login") || paramAcao.equals("LoginForm"));
//		 
//		if(acaoProtegida && usuarioNaoEstaLogado) {
//			response.sendRedirect("entrada?acao=LoginForm");
//			return;
//		}
	
		
		String nomeDaClasse = "br.gerenciador.acao." + paramAcao;
		String nome;
		
		try {
			Class classe = Class.forName(nomeDaClasse);// carrega a classe com o nome
			Acao acao = (Acao) classe.newInstance();
			nome = acao.executa(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new ServletException(e);
		}
		
//		if(paramAcao.equals("ListaEmpresas")) {
//			ListaEmpresas acao = new ListaEmpresas();
//			nome = acao.executa(request, response);
//			
//		} else if(paramAcao.equals("RemoveEmpresa")) {
//			RemoveEmpresa acao = new RemoveEmpresa();
//			nome = acao.executa(request, response);
//			
//			
//		} else if(paramAcao.equals("MostraEmpresa")) {					
//			MostraEmpresa acao = new MostraEmpresa();
//			nome = acao.executa(request, response);
//		
//		} else if(paramAcao.equals("AlteraEmpresa")) {		
//			AlteraEmpresa acao = new AlteraEmpresa();
//			nome = acao.executa(request, response);
//			
//		} else if(paramAcao.equals("NovaEmpresa")) {		
//			NovaEmpresa acao = new NovaEmpresa();
//			nome = acao.executa(request, response);
//		
//		} else if(paramAcao.equals("NovaEmpresaForm")) {		
//			NovaEmpresaForm acao = new NovaEmpresaForm();
//			nome = acao.executa(request, response);
//		}
		
		String[] tipoEndereco = nome.split(":");
		if(tipoEndereco[0].equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/" + tipoEndereco[1]);
			rd.forward(request, response);
		} else {
			response.sendRedirect(tipoEndereco[1]);
		}
 	}
}
