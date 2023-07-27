package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DB;
import db.DbException;
import model.dao.ModeloDao;
import model.entities.Fabricante;
import model.entities.Modelo;

public class ModeloDaoJDBC implements ModeloDao {
	
	private Connection conn= null;

	public ModeloDaoJDBC(Connection conn) {
		this.conn= conn;
	}

	@Override
	public void insert(Modelo mod) {
		PreparedStatement st= null;
		try {
			st= conn.prepareStatement(
					 "INSERT INTO modelo "
					+ "(nome, ano, fabricante_id) "
					+ "VALUES "
					+ "(?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			
			st.setString(1, mod.getNome());
			st.setDate(2, java.sql.Date.valueOf(LocalDate.of(mod.getAno(), 1, 1)));
			st.setInt(3, mod.getFabricante().getId());
			
			int rowsAffected= st.executeUpdate();
			
			if(rowsAffected > 0) {
				ResultSet rs= st.getGeneratedKeys();
				if(rs.next()) {
					int id= rs.getInt(1);
					mod.setId(id);
				}
				DB.closeResultSet(rs);
			}
			else {
				throw new DbException("Erro, não foi possivel inserir os dados");
			}
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally{
			DB.closePreparedStatement(st);
		}
	}

	@Override
	public void update(Modelo mod) {
		PreparedStatement st= null;
		try {
			st= conn.prepareStatement(
					 "UPDATE modelo "
					 + "SET nome = ?, ano = ?, fabricante_id = ? "
					 + "WHERE id = ?");
			
			st.setString(1, mod.getNome());
			st.setDate(2, java.sql.Date.valueOf(LocalDate.of(mod.getAno(), 1, 1)));
			st.setInt(3, mod.getFabricante().getId());
			st.setInt(4, mod.getId());
			
			st.executeUpdate();
			
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally{
			DB.closePreparedStatement(st);
		}
	}

	@Override
	public void deeleteById(Integer id) {
		PreparedStatement st= null;
		try {
			st=conn.prepareStatement("DELETE FROM modelo WHERE id = ?");
			
			st.setInt(1, id);
			
			int rows= st.executeUpdate();
			
			if(rows == 0) {
				throw new DbException("ID não encontrado");
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
	public Modelo findById(Integer id) {
		PreparedStatement st= null;
		ResultSet rs= null;
		try{
				st= conn.prepareStatement(
						"SELECT modelo.*,fabricante.nome as fabNome "
						+ "FROM modelo INNER JOIN fabricante "
						+ "ON modelo.fabricante_id = fabricante.id "
						+ "WHERE fabricante.id = ?");
				
				st.setInt(1, id);
				rs= st.executeQuery();
				
				if(rs.next()) {
					Fabricante fab= instanciaFabricante(rs);
					Modelo mod= instanciaModelo(rs,fab); 
					return mod;
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

	private Fabricante instanciaFabricante(ResultSet rs) throws SQLException {
		Fabricante mod= new Fabricante();
		mod.setId(rs.getInt("fabricante_id"));
		mod.setNome(rs.getString("fabNome"));
		return mod;
	}

	private Modelo instanciaModelo(ResultSet rs, Fabricante fab) throws SQLException {
		Modelo mod= new Modelo();
		mod.setId(rs.getInt("id"));
		mod.setNome(rs.getString("nome"));
		
		java.sql.Date data = rs.getDate("ano");
		if (data != null) {
            mod.setAno(data.toLocalDate().getYear());
        } else {
            mod.setAno(0); 
        }
		
		mod.setFabricante(fab);
		
		return mod;
	}

	@Override
	public List<Modelo> findAll() {
		PreparedStatement st= null;
		ResultSet rs= null;
		try {
			st= conn.prepareStatement(
				"SELECT modelo.*,fabricante.nome as fabNome "
				+ "FROM modelo INNER JOIN fabricante "
				+ "ON modelo.fabricante_id = fabricante.id "
				+ "ORDER BY nome");
			
			rs= st.executeQuery();
			
			List<Modelo> lista= new ArrayList<>();
			Map<Integer, Fabricante> map= new HashMap<>();
			
			while(rs.next()) {
				Fabricante fabricante= map.get(rs.getInt("fabricante_id"));
				if(fabricante == null) {
					fabricante= instanciaFabricante(rs);
					map.put(rs.getInt("fabricante_id"), fabricante);
				}
				
				Modelo modelo= instanciaModelo(rs,fabricante);
				lista.add(modelo);
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

	@Override
	public List<Modelo> findByFab(Fabricante fab) {
		PreparedStatement st= null;
		ResultSet rs= null;
		try {
			st= conn.prepareStatement(
				 "SELECT modelo.*,fabricante.nome as fabNome "
				+ "FROM modelo INNER JOIN fabricante "
				+ "ON modelo.fabricante_id = fabricante.id "
				+ "WHERE fabricante_id = ? "
				+ "ORDER BY nome");
			
			st.setInt(1, fab.getId());
			rs= st.executeQuery();
			
			List<Modelo> lista= new ArrayList<>();
			Map<Integer, Fabricante> map= new HashMap<>();
			
			while(rs.next()) {
				Fabricante fabricante= map.get(rs.getInt("fabricante_id"));
				// essa estrutura empedi que seja gerado os mesmo modelo repedido
				if(fabricante == null) {
					fabricante= instanciaFabricante(rs);
					map.put(rs.getInt("fabricante_id"), fabricante);
				}
				
				Modelo modelo= instanciaModelo(rs,fabricante);
				lista.add(modelo);
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
