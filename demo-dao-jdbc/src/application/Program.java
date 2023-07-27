package application;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);	
		
		SellerDao sellerDao= DaoFactory.createSellerdao();
		
		Seller seller= sellerDao.findById(3);
		
		System.out.println(seller);
		
		System.out.println("\n=== Test 2: seller findByDepartment ====");
		Department department= new Department(2, null);
		List<Seller> list= sellerDao.findByDepartment(department);
		for(Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== Test 3: seller findAll ====");
		list= sellerDao.findAll();
		for(Seller obj : list) {
			System.out.println(obj);
		}	
		
		System.out.println("\n=== Test 4: seller insert ====");
		Seller newSeller= new Seller(null, "Greg","greg@gmail.com",new Date(),4000.0,department );
		sellerDao.insert(newSeller);
		System.out.println("Inseted! new Id = "+ newSeller.getId());
		
		System.out.println("\n=== Test 5: seller ipdate ====");
		seller= sellerDao.findById(1);
		seller.setName("BOB espoja");
		sellerDao.update(seller);
		System.out.println("Update completo");
		
		System.out.println("\n=== Test 6: seller delete ====");
		System.out.println(" entre com Id para test");
		int id= sc.nextInt();
		sellerDao.deeleteById(id);
		System.out.println("Delete completed");
		
		
		System.out.println("//////////////////parte referente ao department//////////////////");
		
		DepartmentDao departmentDao= DaoFactory.createDepartmentdDao();
		
		Department department1= departmentDao.findById(3);
		
		System.out.println(department1);
		
		System.out.println("\n=== Test 2: department findAll ====");
		List<Department> list1= new ArrayList<>();
		list1= departmentDao.findAll();
		for(Department obj : list1) {
			System.out.println(obj);
		}	
		
		System.out.println("\n=== Test 3: department insert ====");
		Department newDepartment= new Department(null,"Bobeira");
		departmentDao.insert(newDepartment);
		System.out.println("Inseted! new Id = "+  newDepartment.getId());
		
		System.out.println("\n=== Test 4: department ipdate ====");
		department1= departmentDao.findById(1);
		department1.setName("Cleiton Rasta");
		departmentDao.update(department1);
		System.out.println("Update completo");
		
		System.out.println("\n=== Test 6: department delete ====");
		System.out.println(" entre com Id para test");
		int id1= sc.nextInt();
		sellerDao.deeleteById(id1);
		System.out.println("Delete completed");
		
		
		sc.close();
		
	}

}
