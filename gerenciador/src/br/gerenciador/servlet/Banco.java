package br.gerenciador.servlet;

import java.util.ArrayList;
import java.util.List;

//Simulando um Banco de Dados
public class Banco {

	private static List<Empresa> lista = new ArrayList<>();
	
	static {
		Empresa empresa = new Empresa();
		empresa.setNome("Goole");
		
		Empresa empresa2 = new Empresa();
		empresa2.setNome("Informática");
		
		lista.add(empresa);
		lista.add(empresa2);
	}
	
	public void adiciona(Empresa empresa) {
		lista.add(empresa);
		
	}
	
	public List<Empresa> getEmpresas() {
		return  Banco.lista;
	}

}
