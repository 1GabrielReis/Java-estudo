package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.FuncionarioDao;
import model.entities.Departamento;
import model.entities.Funcionario;

public class ProgramFuncionario {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		FuncionarioDao funcionarioDao= DaoFactory.createFuncionario();
		
		Departamento obj= new Departamento(2,"Mano brown");
		Funcionario fun= new Funcionario();
		
		
		System.out.println("\n=== teste 1: inserir ===");
		Funcionario novoFuncionario= new Funcionario(null,"Otario",1300.0, obj);
		funcionarioDao.insert(novoFuncionario);
		System.out.println("Inserido! novo ID= " + novoFuncionario.getId());
		System.out.println(novoFuncionario);
		
		System.out.println("\n=== teste 2: atualizar ===");
		fun= funcionarioDao.findById(1);
		fun.setNome("Besta");
		funcionarioDao.update(fun);
		System.out.println("atualização com sucesso!");
		System.out.println(fun);
		
		System.out.println("\n=== teste 3: deletar ====");
		System.out.print(" entre com Id para teste: ");
		int id= sc.nextInt();
		funcionarioDao.deleteById(id);
		System.out.println("Delete realizado com sucesso!");
		
		System.out.println("\n=== teste 4: encontrar por id ===");
		Funcionario fun1= funcionarioDao.findById(2);
		System.out.println(fun1);
		
		System.out.println("\n=== test 5: tabela por id ===");
		List<Funcionario> lista= new ArrayList<>();
		lista= funcionarioDao.findAll();
		for(Funcionario fun2 : lista) {
			System.out.println(fun2);
		}
		
		System.out.println("\n=== test 6: tabela por Departamento===");
		lista= funcionarioDao.findByDepartamento(obj);
		for(Funcionario fun3 : lista) {
			System.out.println(fun3);
		}
				
		
	}

}
