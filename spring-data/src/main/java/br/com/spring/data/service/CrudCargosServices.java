package br.com.spring.data.service;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.spring.data.orm.Cargo;
import br.com.spring.data.repository.CargoRepository;

@Service
public class CrudCargosServices {

	private Boolean system = true;
	private final CargoRepository cargoRepository;

	public CrudCargosServices(CargoRepository cargoRepository) {
		this.cargoRepository = cargoRepository;
	}
	
	public void inicial(Scanner input) {
		while(system) {
			System.out.println("Qual a opção deseja executar ?");
			System.out.println("0 - Sair");
			System.out.println("1 - Salvar");
			System.out.println("2 - Atualizar");
			System.out.println("3 - Visualizar");
			System.out.println("4 - Deletar");
			
			int action = input.nextInt();
			
			switch (action) {
			case 1:
				 salvar(input);
				 break;
			case 2:
				atualizar(input);
				break;
			case 3:
				visualizar();
				break;
			case 4:
				deletar(input);
				break;	
			default:
				system = false;
				break;
			}
		}
	}
	
	private void salvar(Scanner input) {
		System.out.println("Descrição do cargo");
		String descricao = input.next();
		Cargo cargo = new Cargo();
		cargo.setDescricao(descricao);
		cargoRepository.save(cargo);
		System.out.println("Salvo com sucesso !");
	}
	
	private void atualizar(Scanner input) {
		System.out.println("Id");
		long id = (Integer) input.nextInt();
		System.out.println("Descrição do Cargo");
		String descricao = input.next();
		
		Cargo cargo = new Cargo();
		cargo.setId(id);
		cargo.setDescricao(descricao);
		cargoRepository.save(cargo);
		System.out.println("Cargo atualizado com sucesso ! ");
	}
	
	private void visualizar() {
		Iterable<Cargo> cargos = cargoRepository.findAll();
		cargos.forEach(cargo -> System.out.println(cargo));
	}
	
	private void deletar(Scanner input) {
		System.out.println("Id");
		long id = (Integer) input.nextInt();
		cargoRepository.deleteById(id);
		System.out.println("Deletado");
	}
	
	
}















