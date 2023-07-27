package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartamentoDao;
import model.entities.Departamento;

public class ProgramDepartamento {

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		DepartamentoDao departamentoDao= DaoFactory.createDepartamento();
		
		Departamento departamento= new Departamento(); //sera usando em algumas situaçoes
		
		System.out.println("\n=== teste 1: inserir ===");
		Departamento novoDepartamento= new Departamento(null,"Departamento compliance");
		departamentoDao.insert(novoDepartamento);
		System.out.println("Inserido! novo ID= " + novoDepartamento.getId());
		System.out.println(novoDepartamento);
		
	
		System.out.println("\n=== teste 2: atualizar ===");
		departamento= departamentoDao.findById(1);
		departamento.setNome("Departamento pessoal");
		departamentoDao.update(departamento);
		System.out.println("atualização com sucesso!");
		System.out.println(departamento);
		
		
		System.out.println("\n=== teste 3: deletar ====");
		System.out.print(" entre com Id para teste: ");
		int id= sc.nextInt();
		departamentoDao.deleteById(id);
		System.out.println("Delete realizado com sucesso!");
		
		
		System.out.println("\n=== teste 4: encontrar por id ===");
		departamento= departamentoDao.findById(3);
		System.out.println(departamento);

		
		System.out.println("\\n=== test 5: tabela por id ===");
		List<Departamento> lista= new ArrayList<>();
		lista= departamentoDao.findAll();
		for(Departamento obj : lista) {
			System.out.println(obj);
		}
		
		
		

	}

}
