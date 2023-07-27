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
import model.dao.CarroDao;
import model.entities.Carro;
import model.entities.Modelo;

public class CarroDaoJDBC implements CarroDao {
		
	private Connection conn= null;

	public CarroDaoJDBC(Connection conn) {
		this.conn= conn;
	}
	
	@Override
	public void insert(Carro car) {
		PreparedStatement st= null;
		try {
			st= conn.prepareStatement(
					 "INSERT INTO carro "
					+ "(placa, cor, modelo_id) "
					+ "VALUES "
					+ "(?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			
			st.setString(1, car.getPlaca());
			st.setString(2, car.getCor());
			st.setInt(3, car.getModelo().getId());
			
			int rowsAffected= st.executeUpdate();
			
			if( rowsAffected > 0) {
				ResultSet rs= st.getGeneratedKeys();
				if(rs.next()) {
					int id= rs.getInt(1);
					car.setId(id);
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
		finally {
			DB.closePreparedStatement(st);
		}
		
	}

	@Override
	public void update(Carro car) {
		PreparedStatement st= null;
		try {
			st= conn.prepareStatement(
					 "UPDATE carro "
					 + "SET placa = ?, cor = ?, modelo_id = ? "
					 + "WHERE id = ?");
			
			st.setString(1, car.getPlaca());
			st.setString(2, car.getCor());
			st.setInt(3, car.getModelo().getId());
			st.setInt(4, car.getId());
			
			st.executeUpdate();

		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closePreparedStatement(st);
		}
		
	}

	@Override
	public void deleteById(Integer id) {
		PreparedStatement st= null;
		try {
			st= conn.prepareStatement("DELETE FROM carro WHERE id = ? ");
			
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
	public Carro findById(Integer id) {
		PreparedStatement st= null;
		ResultSet rs= null;
		try{
			st= conn.prepareStatement(
					"SELECT carro.*,modelo.nome as modNome "
					+ "FROM carro INNER JOIN modelo "
					+ "ON carro.modelo_id = modelo.id "
					+ "WHERE modelo.id = ?");
			
			st.setInt(1, id);
			rs= st.executeQuery();
			if(rs.next()) {
				Modelo mod= instanciaModelo(rs);
				Carro car= instanciaCarro(rs, mod);
				return car;
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

	
	private Carro instanciaCarro(ResultSet rs, Modelo mod) throws SQLException {
		Carro car= new Carro();
		car.setId(rs.getInt("id"));
		car.setPlaca(rs.getString("placa"));
		car.setCor(rs.getString("cor"));
		car.setModelo(mod);
		return car;
	}

	private Modelo instanciaModelo(ResultSet rs) throws SQLException {
		Modelo mod= new Modelo();
		mod.setId(rs.getInt("modelo_id"));
		mod.setNome(rs.getString("modNome"));
		
		/*
		java.sql.Date data = rs.getDate("ano");
		if (data != null) {
            mod.setAno(data.toLocalDate().getYear());
        } else {
            mod.setAno(0); 
        }
        */
		
		return mod;
	}

	@Override
	public List<Carro> findAll() {
		PreparedStatement st= null;
		ResultSet rs= null;
		try {
			st= conn.prepareStatement(
				"SELECT carro.*,modelo.nome as modNome "
				+ "FROM carro INNER JOIN modelo "
				+ "ON carro.modelo_id = modelo.id "
				+ "ORDER BY nome");
			
			rs= st.executeQuery();
			
			
			List<Carro> lista= new ArrayList<>();
			Map<Integer, Modelo> map= new HashMap<>();
			
			while(rs.next()) {
				Modelo modelo= map.get(rs.getInt("modelo_id"));
				if(modelo == null) {
					modelo= instanciaModelo(rs);
					map.put(rs.getInt("modelo_id"), modelo);
				}
				
				Carro carro= instanciaCarro(rs, modelo);
				lista.add(carro);
			}
			return lista;
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally{
			DB.closePreparedStatement(st);
			DB.closeResultSet(rs);
		}
		
	}

	@Override
	public List<Carro> findByModel(Modelo mod) {
		PreparedStatement st= null;
		ResultSet rs= null;
		try {
			st=conn.prepareStatement(
					"SELECT carro.*,modelo.nome as modNome "
				+ "FROM carro INNER JOIN modelo "
				+ "ON carro.modelo_id = modelo.id "
				+ "WHERE modelo_id = ? "
				+ "ORDER BY nome");
			
			st.setInt(1, mod.getId());
			rs= st.executeQuery();
			
			List<Carro> lista= new ArrayList<>();
			Map<Integer, Modelo> map= new HashMap<>();
			
			while(rs.next()) {
				Modelo modelo= map.get(rs.getInt("modelo_id"));
				// essa estrutura empedi que seja gerado os mesmo modelo repedido
				if(modelo == null) {
					modelo= instanciaModelo(rs);
					map.put(rs.getInt("modelo_id"), modelo);
				}
				Carro carro= instanciaCarro(rs,modelo);
				lista.add(carro);
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
