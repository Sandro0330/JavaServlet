package br.gerenciador.acao;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.gerenciador.modelo.Banco;

public class RemoveEmpresa {

	public void executa(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("acao removendo empresa");
		
		String parameterId = request.getParameter("id");
		Integer id = Integer.valueOf(parameterId);
		
		System.out.println(id);
		
		Banco banco = new Banco();
		banco.removeEmpresa(id);
		
		response.sendRedirect("entrada?acao=ListaEmpresas");
		
	}
}
