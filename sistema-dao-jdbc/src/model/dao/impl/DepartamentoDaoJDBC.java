package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.DepartamentoDao;
import model.entities.Departamento;

public class DepartamentoDaoJDBC implements DepartamentoDao {
	
	public Connection conn= null;
	
	public DepartamentoDaoJDBC(Connection conn) {
		this.conn= conn;
	}
	
	@Override
	public void insert(Departamento obj) {
		PreparedStatement st= null;
		try {
			st= conn.prepareStatement(
					"INSERT INTO departamento "
					+ "(nome) "
					+ "VALUES "
					+ "(?) ",
					Statement.RETURN_GENERATED_KEYS);
			
			st.setString(1, obj.getNome());
			
			int rowsAffected= st.executeUpdate();
			
			if(rowsAffected > 0) {
				//pegar o novo id 
				ResultSet rs= st.getGeneratedKeys();
				if(rs.next()) {
					int id= rs.getInt(1);
					obj.setId(id);
				}
				DB.closeResultSet(rs);
			}
			else {
				throw new DbException("Erro, nenhuma linha alterada!");
			}
		}
		catch(SQLException e){
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public void update(Departamento obj) {
		PreparedStatement st= null;
		try {
			st= conn.prepareStatement(
					 "UPDATE departamento "
					 + "SET nome = ? "
					 + "WHERE id = ?");
			
			st.setString(1, obj.getNome());
			st.setInt(2, obj.getId());
			
			st.executeUpdate();
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public void deleteById(Integer id) {
		PreparedStatement st= null;
		try {
			st= conn.prepareStatement("DELETE FROM departamento WHERE id = ?");
			
			st.setInt(1, id);
			
			int rows= st.executeUpdate();
			
			if(rows == 0) {
				throw new DbException("Nenhuma linha afetada, id n�o existente");
			}
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
		
	}

	@Override
	public Departamento findById(Integer id) {
		PreparedStatement st= null;
		ResultSet rs= null;
		try{
			st= conn.prepareStatement("SELECT * FROM departamento WHERE id = ?");
			
			st.setInt(1, id);
			
			rs= st.executeQuery();
			
			if(rs.next()) {
				Departamento obj= instanciarDepartamento(rs);
				return obj;
			}
			return null;
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	private Departamento instanciarDepartamento(ResultSet rs) throws SQLException {
		Departamento obj= new Departamento();
		obj.setId(rs.getInt("id"));
		obj.setNome(rs.getString("nome"));
		return obj;
	}

	@Override
	public List<Departamento> findAll() {
		PreparedStatement st= null;
		ResultSet rs= null;
		try {
			st= conn.prepareStatement("SELECT * FROM departamento ORDER BY nome");
			
			rs= st.executeQuery();
			
			List<Departamento> lista= new ArrayList<>();
			
			while(rs.next()) {
				Departamento obj= new Departamento();
				obj.setId(rs.getInt("id"));
				obj.setNome(rs.getString("nome"));
				lista.add(obj);
			}
			return lista;
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

}
