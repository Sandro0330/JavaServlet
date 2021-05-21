package br.com.spring.data;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.spring.data.service.CrudCargosServices;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {
	
	private final CrudCargosServices crudCargosServices;

	private Boolean system= true;
	
	public SpringDataApplication(CrudCargosServices crudCargosServices) {
		this.crudCargosServices = crudCargosServices;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner input = new Scanner(System.in);
		
		while(system) {
			System.out.println("Qual ação execurta");
			System.out.println("0 - Sair");
			System.out.println("1 - Cargo");
			
			int action = input.nextInt();
			if(action == 1) {
				crudCargosServices.inicial(input);
			} else {
				system = false;
			}
		}
	}

}
