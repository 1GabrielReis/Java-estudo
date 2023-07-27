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
import model.dao.FabricanteDao;
import model.entities.Fabricante;

public class FabricanteDaoJDBC implements FabricanteDao {
	
	private Connection conn= null;

	public FabricanteDaoJDBC(Connection conn) {
		this.conn= conn;
	}

	@Override
	public void insert(Fabricante fab) {
		PreparedStatement st= null;
		try {
			st= conn.prepareStatement(
					 "INSERT INTO fabricante "
					+ "(nome, pais_origem) "
					+ "VALUES "
					+ "(?, ?) ",
					Statement.RETURN_GENERATED_KEYS);
			
			st.setString(1, fab.getNome());
			st.setString(2, fab.getPaisOrigem());
			
			int rowsAffected= st.executeUpdate();
			
			if(rowsAffected > 0) {
				ResultSet rs= st.getGeneratedKeys();
				if(rs.next()) {
					int id= rs.getInt(1);
					fab.setId(id);
				}
				DB.closeResultSet(rs);
			}
			else {
				throw new DbException("Erro, nenhuma linha foi afetada");
			}
			
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closePreparedStatement(st);
		}
	}

	@Override
	public void update(Fabricante fab) {
		PreparedStatement st= null;
		try {
			st= conn.prepareStatement( 
					 "UPDATE fabricante "
					 + "SET nome = ?, pais_origem = ? "
					 + "WHERE id = ?");
			
			st.setString(1, fab.getNome());
			st.setString(2, fab.getPaisOrigem());
			st.setInt(3, fab.getId());
			
			st.executeUpdate();
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closePreparedStatement(st);
			DB.closeResultSet(null);
		}
	}

	@Override
	public void deleteById(Integer id) {
		PreparedStatement st= null;
		try {
			st= conn.prepareStatement("DELETE FROM fabricante WHERE id = ?");
			
			st.setInt(1, id);
			
			int rows= st.executeUpdate();
			
			if(rows == 0) {
				throw new DbException("Id não existe, palhaço!");
			}
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closePreparedStatement(st);
		}
		
	}

	@Override
	public Fabricante findById(Integer id) {
		PreparedStatement st= null;
		ResultSet rs= null;
		try {
			st= conn.prepareStatement("SELECT * FROM fabricante WHERE id = ?");
			
			st.setInt(1, id);
			
			rs= st.executeQuery();
			
			if(rs.next()) {
				Fabricante fab= instantiateDepartment(rs);
				
				return fab;
			}
			return null;
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closePreparedStatement(st);
			DB.closeResultSet(rs);
		}
	}

	private Fabricante instantiateDepartment(ResultSet rs) throws SQLException {
		Fabricante fab= new Fabricante();
		fab.setId(rs.getInt("id"));
		fab.setNome(rs.getString("nome"));
		fab.setPaisOrigem(rs.getString("pais_origem"));
		return fab;
	}

	@Override
	public List<Fabricante> findAll() {
		PreparedStatement st= null;
		ResultSet rs= null;
		try {
			
			st= conn.prepareStatement("SELECT * FROM fabricante ORDER BY nome");
			rs= st.executeQuery();
			
			List<Fabricante> lista=  new ArrayList<>();
			
			while(rs.next()) {
				Fabricante fab= instantiateDepartment(rs);
				lista.add(fab);
			}
			
			return lista;
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closePreparedStatement(st);
			DB.closeResultSet(rs);
		}
	}

}
