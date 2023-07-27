package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.FabricanteDao;
import model.entities.Fabricante;

public class ProgramFabricante {

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		FabricanteDao fabricanteDao= DaoFactory.createFabricanteDao();
		
		System.out.println("\n=== Teste fabriccante 1: findById ====");
		Fabricante fab= fabricanteDao.findById(2);
		System.out.println(fab);
		
		System.out.println("\n=== teste fabricante 2: atualizar ===");
		fab= fabricanteDao.findById(3);
		fab.setPaisOrigem("URSS");
		fabricanteDao.update(fab);
		System.out.println("Atualição com sucesso!");
		System.out.println(fab);
		
		System.out.println("\n=== teste fabricante 3: inserir ===");
		Fabricante newFabricante= new Fabricante(null,"SBT", "Gotham City");
		fabricanteDao.insert(newFabricante);
		System.out.println("Inserido! novo ID= "+ newFabricante.getId());
		System.out.println(newFabricante);
		
		System.out.println("\n=== teste fabricante 4: deletar ====");
		System.out.println("Entre com Id para teste: ");
		int id= sc.nextInt();
		fabricanteDao.deleteById(id);
		System.out.println("Delete realizado com sucesso!");
		
		System.out.println("\n=== teste Modelo 5: tabela por id ===");
		List<Fabricante> lista= fabricanteDao.findAll();
		for(Fabricante fab1 : lista) {
			System.out.println(fab1);
		}
		
		System.out.println("\n=== teste Carro : todos realizados ===");

	}

}
