package model.dao;

import java.util.List;

import model.entities.Department;
import model.entities.Seller;

public interface DepartmentDao {
	
	void insert(Department obj);
	void update(Department obj);
	void deeleteById(Integer id);
	Department findById(Integer Id);
	List<Department> findAll(); 
}
