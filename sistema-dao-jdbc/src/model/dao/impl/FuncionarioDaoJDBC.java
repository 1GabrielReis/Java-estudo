package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DB;
import db.DbException;
import model.dao.FuncionarioDao;
import model.entities.Departamento;
import model.entities.Funcionario;

public class FuncionarioDaoJDBC implements FuncionarioDao{
	
	private Connection conn= null;
	
	public FuncionarioDaoJDBC(Connection conn) {
		this.conn= conn;
	}
	
	@Override
	public void insert(Funcionario fun) {
		PreparedStatement st= null;
		try {
			st= conn.prepareStatement(
					"INSERT INTO funcionario "
					+ "(nome, salario, departamento_id) "
					+ "VALUES "
					+ "(?, ?, ?) ",
					Statement.RETURN_GENERATED_KEYS);
			
			st.setString(1, fun.getNome());
			st.setDouble(2, fun.getSalario());
			st.setInt(3, fun.getDepartamento().getId());
			
			int rowsAffected= st.executeUpdate();
			
			if(rowsAffected > 0) {
				ResultSet rs= st.getGeneratedKeys();
				if(rs.next()) {
					int id= rs.getInt(1);
					fun.setId(id);
				}
				DB.closeResultSet(rs);
			}
			else {
				throw new DbException("Erro, nenhuma linha alterada!");
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
	public void update(Funcionario fun) {
		PreparedStatement st= null;
		try {
			st= conn.prepareStatement(
					 "UPDATE funcionario "
					 + "SET nome = ?, salario = ?, departamento_id = ? "
					 + "WHERE id = ?");
			
			st.setString(1, fun.getNome());
			st.setDouble(2, fun.getSalario());
			st.setInt(3, fun.getDepartamento().getId());
			st.setInt(4, fun.getId());
			
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
			st= conn.prepareStatement("DELETE FROM funcionario WHERE id = ?");
			
			st.setInt(1, id);
			
			int rows= st.executeUpdate();
			
			if(rows == 0) {
				throw new DbException("Nenhuma linha afetada, id não existente ");
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
	public Funcionario findById(Integer id) {
		PreparedStatement st= null;
		ResultSet rs= null;
		try {
			st= conn.prepareStatement(
					"SELECT funcionario.*,departamento.nome as DepNome "
					+ "FROM funcionario INNER JOIN departamento "
					+ "ON funcionario.departamento_id = departamento.id "
					+ "WHERE funcionario.id = ?");
			
			
			st.setInt(1,id);
			rs= st.executeQuery();
			if(rs.next()) {
				
				Departamento obj= instanciarDepartamento(rs);
				Funcionario fun= instanciarFuncionario(rs, obj);
				return fun;
				
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
	
	private Funcionario instanciarFuncionario(ResultSet rs, Departamento obj) throws SQLException {
		Funcionario fun= new Funcionario();
		fun.setId(rs.getInt("id"));
		fun.setNome(rs.getString("nome"));
		fun.setSalario(rs.getDouble("salario"));
		fun.setDepartamento(obj);
		return fun;
	}

	private Departamento instanciarDepartamento(ResultSet rs) throws SQLException {
		Departamento obj= new Departamento();
		obj.setId(rs.getInt("id"));
		obj.setNome(rs.getString("nome"));
		return obj;
	}
	
	
	@Override
	public List<Funcionario> findAll() {
		PreparedStatement st= null;
		ResultSet rs= null;
		try {
			st= conn.prepareStatement(
					"SELECT funcionario.*,departamento.nome as DepNome "
					+ "FROM funcionario INNER JOIN departamento "
					+ "ON funcionario.departamento_id = departamento.id "
					+ "ORDER BY nome");
			
			rs= st.executeQuery();
			
			List<Funcionario> lista= new  ArrayList<>();
			Map<Integer,Departamento> chave= new HashMap<>();
			
			while(rs.next()) {
				
				Departamento obj= chave.get(rs.getInt("departamento_id"));
				
				if(obj == null) {
					obj= instanciarDepartamento(rs);
					chave.put(rs.getInt("departamento_id"), obj);
				}
				
				Funcionario fun= instanciarFuncionario(rs,obj);
				lista.add(fun);
				
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

	@Override
	public List<Funcionario> findByDepartamento(Departamento departamento) {
		PreparedStatement st= null;
		ResultSet rs= null;
		try {
			st= conn.prepareStatement(
					"SELECT funcionario.*,departamento.nome as DepNome "
					+ "FROM funcionario INNER JOIN departamento "
					+ "ON funcionario.departamento_id = departamento.id "
					+ "WHERE departamento_id = ? "
					+ "ORDER BY nome");
			
			
			st.setInt(1, departamento.getId());
			
			rs= st.executeQuery();
			
			List<Funcionario> lista= new ArrayList<>();
			Map<Integer, Departamento> chave= new HashMap<>();
			
			while(rs.next()) {
				
				Departamento obj= chave.get(rs.getInt("departamento_id"));
				
				if(obj == null) {
					obj=instanciarDepartamento(rs);
					chave.put(rs.getInt("departamento_id"), obj);
				}
				
				Funcionario fun= instanciarFuncionario(rs,obj);
				lista.add(fun);
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
