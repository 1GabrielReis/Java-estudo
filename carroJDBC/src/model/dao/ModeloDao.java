package model.dao;

import java.util.List;

import model.entities.Fabricante;
import model.entities.Modelo;

public interface ModeloDao {
	
	void insert(Modelo mod);
	void update(Modelo mod);
	void deeleteById(Integer id);
	Modelo findById(Integer id);
	List<Modelo> findAll(); 
	List<Modelo> findByFab(Fabricante fab);
	
}
