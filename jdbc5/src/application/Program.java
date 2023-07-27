
package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;
import db.DbIntegrityException;

public class Program {

	public static void main(String[] args) {
		
		Connection conn= null;
		PreparedStatement st= null;
		
		try {
			conn= DB.getConnection();
			st= conn.prepareStatement(
					"DELETE FROM department "
					+"WHERE "
					+" Id = ?");
			
			st.setInt(1, 8);
					
					/*st= conn.prepareStatement( :para os comando do mysql
					 * "DELETE FROM department ": deletar na tabela department 
					 * "WHERE": NO QUAL (restri��o)
					 * " Id = ?" : Id seja = ? (valoor que sera mencioando)
					 * st.setInt(1, 5): apagar ide de valor 5
					 */
			int rowsAffected= st.executeUpdate();
			
			System.out.println("Done! Rows affected: "+rowsAffected);
		}
		catch(SQLException e) {
			throw new DbIntegrityException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}

}
