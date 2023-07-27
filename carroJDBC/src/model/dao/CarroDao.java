package model.dao;

import java.util.List;

import model.entities.Carro;
import model.entities.Modelo;

public interface CarroDao {
	
	void insert(Carro car);
	void update(Carro car);
	void deleteById(Integer id);
	Carro findById(Integer id);
	List<Carro> findAll(); 
	List<Carro> findByModel(Modelo mod);
	
}
