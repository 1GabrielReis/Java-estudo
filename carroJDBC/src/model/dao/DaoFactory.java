package model.dao;

import db.DB;
import model.dao.impl.CarroDaoJDBC;
import model.dao.impl.FabricanteDaoJDBC;
import model.dao.impl.ModeloDaoJDBC;

public class DaoFactory {
	
	public static FabricanteDao createFabricanteDao() {
		return new FabricanteDaoJDBC(DB.getConnection());
	}
	
	public static ModeloDao createModeloDao() {
		return new ModeloDaoJDBC(DB.getConnection()); 
	}
	
	public static CarroDao createCarroDao() {
		return new CarroDaoJDBC(DB.getConnection()); 
	}
	
}
