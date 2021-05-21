package br.com.spring.data.service;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.spring.data.orm.Cargo;
import br.com.spring.data.repository.CargoRepository;

@Service
public class CrudCargosServices {

	private final CargoRepository cargoRepository;

	public CrudCargosServices(CargoRepository cargoRepository) {
		this.cargoRepository = cargoRepository;
	}
	
	public void inicial(Scanner input) {
		salvar(input);
	}
	
	private void salvar(Scanner input) {
		System.out.println("Descrição do cargo");
		String descricao = input.next();
		Cargo cargo = new Cargo();
		cargo.setDescricao(descricao);
		cargoRepository.save(cargo);
		System.out.println("Salvo com sucesso !");
	}
	
}
