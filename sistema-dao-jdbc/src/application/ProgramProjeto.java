package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.ProjetoDao;
import model.entities.Departamento;
import model.entities.Projeto;

public class ProgramProjeto {

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		ProjetoDao projetoDao= DaoFactory.createProejto();
		
		System.out.println("\n=== Teste: projeto 1: findById ====");
		Projeto proj= projetoDao.findById(2);
		System.out.println(proj);
		
		System.out.println("\n=== teste 2: atualizar ===");
		proj= projetoDao.findById(2);
		proj.setNome("KGB 2");
		projetoDao.update(proj);
		System.out.println("atualização com sucesso!");
		System.out.println(proj);
		
		System.out.println("\n=== test 3: tabela por departamento===");
		Departamento obj= new Departamento(2, null);
		List<Projeto> lista= projetoDao.findByDepartamento(obj);
		for(Projeto proj1 : lista) {
			System.out.println(proj1);
		}
		
		System.out.println("\n=== teste 4: inserir ===");
		Projeto novoProjeto= new Projeto(null, "Projeto Et news","só os loucos sabem",obj);
		projetoDao.insert(novoProjeto);
		System.out.println("Inserido! novo ID= "+ novoProjeto.getId());
		System.out.println(novoProjeto);
		
		System.out.println("\n=== teste 5: deletar ====");
		System.out.print(" entre com Id para teste: ");
		int id= sc.nextInt();
		projetoDao.deleteById(id);
		System.out.println("Delete realizado com sucesso!");
		
		System.out.println("\n=== test 5: tabela por id ===");
		lista= projetoDao.findAll();
		for(Projeto proj2 : lista) {
			System.out.println(proj2);
		}
				
	}
}
