package model.dao;

import java.util.List;

import model.entities.Departamento;
import model.entities.Projeto;

public interface ProjetoDao {
	
	void insert(Projeto proj);
	void update(Projeto proj);
	void deleteById(Integer id);
	Projeto findById(Integer id);
	List<Projeto> findAll();
	List<Projeto> findByDepartamento(Departamento departamento);
}
