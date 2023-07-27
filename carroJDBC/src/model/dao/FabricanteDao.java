package model.dao;

import java.util.List;

import model.entities.Fabricante;

public interface FabricanteDao {
	
	void insert(Fabricante fab);
	void update(Fabricante fab);
	void deleteById(Integer id);
	Fabricante findById(Integer id);
	List<Fabricante> findAll(); 
	
}
