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
import model.dao.ProjetoDao;
import model.entities.Departamento;
import model.entities.Projeto;

public class ProjetoDaoJDBC implements ProjetoDao {

	private Connection conn = null;

	public ProjetoDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Projeto proj) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
					"INSERT INTO projeto " 
					+ "(nome, descricao, departamento_id) " 
					+ "VALUES " 
					+ "(?, ?, ?) ",
					Statement.RETURN_GENERATED_KEYS);

			st.setString(1, proj.getNome());
			st.setString(2, proj.getDescrição());
			st.setInt(3, proj.getDepartamaneto().getId());

			int rowsAffected = st.executeUpdate();

			if (rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					proj.setId(id);
				}
				DB.closeResultSet(rs);
			} else {
				throw new DbException("nenhuma linha foi incluida");
			}
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public void update(Projeto proj) {
		PreparedStatement st = null;

		try {
			st = conn.prepareStatement(
					"UPDATE projeto " + "SET nome = ?, descricao = ?, departamento_id = ? " + "WHERE id = ?");

			st.setString(1, proj.getNome());
			st.setString(2, proj.getDescrição());
			st.setInt(3, proj.getDepartamaneto().getId());
			st.setInt(4, proj.getId());

			st.executeUpdate();
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public void deleteById(Integer id) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement("DELETE FROM projeto WHERE id = ?");

			st.setInt(1, id);
			int rows = st.executeUpdate();

			if (rows == 0) {
				throw new DbException("Id não existe");
			}
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public Projeto findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT projeto.*,departamento.nome as DepNome " + "FROM projeto INNER JOIN departamento "
							+ "ON projeto.departamento_id = departamento.id " + "WHERE projeto.id = ?");

			st.setInt(1, id);

			rs = st.executeQuery();

			if (rs.next()) {
				Departamento obj = instanciarDepartamento(rs);
				Projeto proj = instanciarProjeto(rs, obj);
				return proj;
			}
			return null;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	private Projeto instanciarProjeto(ResultSet rs, Departamento obj) throws SQLException {
		Projeto proj = new Projeto();
		proj.setId(rs.getInt("id"));
		proj.setNome(rs.getString("nome"));
		proj.setDescrição(rs.getString("descricao"));
		proj.setDepartamaneto(obj);
		return proj;
	}

	private Departamento instanciarDepartamento(ResultSet rs) throws SQLException {
		Departamento obj = new Departamento();
		obj.setId(rs.getInt("id"));
		obj.setNome(rs.getString("nome"));
		return obj;
	}

	@Override
	public List<Projeto> findAll() {
		PreparedStatement st= null;
		ResultSet rs= null;
		try {
			st= conn.prepareStatement(
					"SELECT projeto.*,departamento.nome as DepNome "
					+ "FROM projeto INNER JOIN departamento "
					+ "ON projeto.departamento_id = departamento.id "
					+ "ORDER BY nome");
			
			rs= st.executeQuery();
			
			List<Projeto> lista= new ArrayList<>();
			Map<Integer,Departamento> chave= new HashMap<>();
			
			while(rs.next()) {
				Departamento obj= chave.get(rs.getInt("departamento_id"));
				if(obj == null) {
					obj=instanciarDepartamento(rs);
					chave.put(rs.getInt("departamento_id"), obj);
				}
				
				Projeto porj= instanciarProjeto(rs,obj);
				lista.add(porj);
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
	public List<Projeto> findByDepartamento(Departamento departamento) {
		PreparedStatement st= null;
		ResultSet rs= null;
		try {
			st= conn.prepareStatement(
					"SELECT projeto.*,departamento.nome as DepNome "
					+ "FROM projeto INNER JOIN departamento "
					+ "ON projeto.departamento_id = departamento.id "
					+ "WHERE departamento_id = ? "
					+ "ORDER BY nome");
			
			st.setInt(1, departamento.getId());
			rs= st.executeQuery();
			
			List<Projeto> lista= new ArrayList<>();
			Map<Integer,Departamento> chave= new HashMap<>();
			
			while(rs.next()) {
				Departamento obj= chave.get(rs.getInt("departamento_id"));
				if(obj == null) {
					obj= instanciarDepartamento(rs);
					chave.put(rs.getInt("departamento_id"), obj);
				}
				
				Projeto proj= instanciarProjeto(rs,obj);
				lista.add(proj);
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
