package model.dao;

import db.DB;
import model.dao.impl.DepartamentoDaoJDBC;
import model.dao.impl.FuncionarioDaoJDBC;
import model.dao.impl.ProjetoDaoJDBC;

public class DaoFactory {
	
	public static DepartamentoDao createDepartamento() {
		return new DepartamentoDaoJDBC(DB.getConnection());
	}
	
	public static FuncionarioDao createFuncionario() {
		return new FuncionarioDaoJDBC(DB.getConnection());
	}
	
	public static ProjetoDao createProejto() {
		return new ProjetoDaoJDBC(DB.getConnection());
	}
}
