package br.gerenciador.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//Simulando um Banco de Dados
public class Banco {

	private static List<Empresa> lista = new ArrayList<>();
	private static List<Usuario> listaUsuarios = new ArrayList<>();
	private static Integer chaveSequencial = 1;
	
	static {
		Empresa empresa = new Empresa();
		empresa.setId(chaveSequencial++);
		empresa.setNome("Google");
		
		Empresa empresa2 = new Empresa();
		empresa2.setId(chaveSequencial++);
		empresa2.setNome("Informática");
		
		lista.add(empresa);
		lista.add(empresa2);
		
		Usuario usuario1 = new Usuario();
		usuario1.setLogin("uilson");
		usuario1.setSenha("123");
	
		Usuario usuario2 = new Usuario();
		usuario2.setLogin("ale");     
		usuario2.setSenha("123");        
		
		listaUsuarios.add(usuario1);
		listaUsuarios.add(usuario2);
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

	public Empresa buscaEmpresaPeloId(Integer id) {
		for (Empresa empresa : lista) {
			if(empresa.getId() == id) {
				return empresa;
			}
		}	
		return null;
	}

	public Usuario existeUsuario(String login, String senha) {
		for(Usuario usuario : listaUsuarios) {
			if(usuario.ehIgual(login, senha)) {
				return usuario;
			}
		}
		return null;
	}
}
