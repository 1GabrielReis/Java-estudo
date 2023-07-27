package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import db.DB;

public class Program {

	public static void main(String[] args) {
		
		Connection conn= null; 
		PreparedStatement st= null;
		
		try {
			conn= DB.getConnection();// conectar ao banco de dados 
			
			
			//fazer varias inserção de uma vez
			st= conn.prepareStatement(
					"insert into department (Name) Values ('D1'), ('D2')",
					Statement.RETURN_GENERATED_KEYS);
			/*st= conn.prepareStatement: função entra no sql
			 * insert into department: inserir na tabela department
			 * (Name): no campo Name
			 * Values ('D1'), ('D2'): valor: D1, D2
			 */
			
			int rowsAffected= st.executeUpdate();
			
			if(rowsAffected != 0) {
				ResultSet rs= st.getGeneratedKeys();
				/* st.getGeneratedKeys(): serve para retorna o id 
				 * ResultSet rs: onde sera armazenado o id 
				 */
				while(rs.next()) { //caso seja feita mais de uma inserção
					int id= rs.getInt(1);// o 1 referencia a primeira coluna(id). vai grava o nove id
					System.out.println("Done! Id= "+id);
				}
			}
			else {
				System.out.println("No rown affected!");
			}
			
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		finally {
			DB.closeStatement(st);
			DB.closeconnection();
		}

	}

}
