package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.ModeloDao;
import model.entities.Fabricante;
import model.entities.Modelo;

public class ProgramModelo {

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		ModeloDao modeloDao= DaoFactory.createModeloDao();
		
		System.out.println("\n=== Teste Modelo 1: findById ====");
		Modelo mod= modeloDao.findById(3);
		System.out.println(mod);
		
		System.out.println("\n=== teste Modelo 2: atualizar ===");
		mod= modeloDao.findById(3);
		mod.setNome("HomerCar");
		modeloDao.update(mod);
		System.out.println("atualição com sucesso!");
		System.out.println(mod);
		
		System.out.println("\n=== teste Modelo 3: tabela por fabricante===");
		Fabricante fab= new Fabricante(3, null, null);
		List<Modelo> lista= modeloDao.findByFab(fab);
		for( Modelo mod1 : lista) {
			System.out.println(mod1);
		}
		
		System.out.println("\n=== teste Modelo 4: inserir ===");
		Modelo newMod= new Modelo(null,"X9",2023,fab);
		modeloDao.insert(newMod);
		System.out.println("Inserido! novo ID= "+newMod.getId());
		System.out.println(newMod);
		
		System.out.println("\n=== teste Modelo 5: deletar ====");
		System.out.println("Entre com Id para teste: ");
		int id= sc.nextInt();
		modeloDao.deeleteById(id);
		System.out.println("Delete realizado com sucesso!");
		
		System.out.println("\n=== teste Modelo 5: tabela por id ===");
		lista= modeloDao.findAll();
		for(Modelo mod2 : lista) {
			System.out.println(mod2);
		}
		
		System.out.println("\n=== teste Carro : todos realizados ===");
		

	}

}
