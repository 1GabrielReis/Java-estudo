package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;

public class Program {

	public static void main(String[] args) {
		
		Connection conn= null;
		PreparedStatement st= null;
		
		try {
			conn= DB.getConnection();
			
			st=conn.prepareStatement(	
				"UPDATE seller " 
				+"SET BaseSalary= BaseSalary + ? "
				+"WHERE "
				+"(DepartmentId = ?)");
					
				/* UPDATE seller = pegar a tabela  seller
				 * "SET BaseSalary= BaseSlarary + ? "= mudando o BaseSalary para BaseSalary mais
				 * o valor que sera infoamdo(?)
				 * WHERW = onde (codição para atulização) 
				 * "(DepartmentId = ?)" = o DepartmentId sera um valor que sera infoamdo (?)
				 */
			
			st.setDouble(1, 200.0); // primira interogação(?) 
			st.setInt(2, 2); // segun interogação(?)
			
			int rowsAffected= st.executeUpdate();
			
			System.out.println("Done! Rows affected: "+ rowsAffected);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}

	}

}
