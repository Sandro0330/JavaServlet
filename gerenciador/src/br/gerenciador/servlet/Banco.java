package br.gerenciador.servlet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//Simulando um Banco de Dados
public class Banco {

	private static List<Empresa> lista = new ArrayList<>();
	private static Integer chaveSequencial = 1;
	
	static {
		Empresa empresa = new Empresa();
		empresa.setId(chaveSequencial++);
		empresa.setNome("Goole");
		
		Empresa empresa2 = new Empresa();
		empresa2.setId(chaveSequencial++);
		empresa2.setNome("Informática");
		
		lista.add(empresa);
		lista.add(empresa2);
	}
	
	public void adiciona(Empresa empresa) {
		empresa.setId(Banco.chaveSequencial++);
		lista.add(empresa);
		
	}
	
	public List<Empresa> getEmpresas() {
		return  Banco.lista;
	}

	public void removeEmpresa(Integer id) {
		
		Iterator<Empresa> it = lista.iterator();
		
		 while(it.hasNext()) {
			 Empresa empresa = it.next();
			 
			 if(empresa.getId() == id) {
				 it.remove();
			 }
		 }
		
		for (Empresa empresa : lista) {
			if (empresa.getId() == id) {
				lista.remove(empresa);
			}
		}	
	}

}
