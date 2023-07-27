package application;

import java.util.List;
import java.util.Scanner;

import model.dao.CarroDao;
import model.dao.DaoFactory;
import model.entities.Carro;
import model.entities.Modelo;

public class ProgramCarro {

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		CarroDao carroDao= DaoFactory.createCarroDao();
		
		System.out.println("\n=== Teste carro 1: findById ====");
		Carro car= carroDao.findById(1);
		System.out.println(car);
		
		System.out.println("\n=== teste carro 2: atualizar ===");
		car= carroDao.findById(2);
		car.setPlaca("BOB-2469");
		carroDao.update(car);
		System.out.println("atualição com sucesso!");
		System.out.println(car);
		
		System.out.println("\n=== teste Carro 3: tabela por modelo===");
		Modelo mod= new Modelo(2, null, null, null);
		List<Carro> lista= carroDao.findByModel(mod);
		for(Carro car1 : lista) {
			System.out.println(car1);
		}
		
		System.out.println("\n=== teste Carro 4: inserir ===");
		Carro newCar= new Carro(null,"KGB","Naruto",mod);
		carroDao.insert(newCar);
		System.out.println("Inserido! novo ID= " + newCar.getId());
		System.out.println(newCar);
		
		System.out.println("\n=== teste Carro 5: deletar ====");
		System.out.print(" entre com Id para teste: ");
		int id= sc.nextInt();
		carroDao.deleteById(id);
		System.out.println("Delete realizado com sucesso!");
		
		System.out.println("\n=== teste Carro 5: tabela por id ===");
		lista= carroDao.findAll();
		for(Carro car2 : lista) {
			System.out.println(car2);
		}
		
		System.out.println("\n=== teste Carro : todos realizados ===");
		
	}

}
