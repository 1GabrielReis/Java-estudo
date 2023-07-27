package application;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;
import db.DbException;

public class Program {

	public static void main(String[] args) {
		
		Connection conn= null;
		
		Statement st= null;
		
		try {
			conn= DB.getConnection();
			
			conn.setAutoCommit(false);
			/*serve para n�o confimar opera�oes automaticamente
			 * toda a programa��o vai ficar pendente para a confirma��o do programador 
			 */
			
			st= conn.createStatement();
			
			int rows1= st.executeUpdate("UPDATE seller SET BaseSalary = 2090  WHERE DepartmentId = 1");
			//fazer atualiza�o
			
			
			//condi��o de erro para teste 
			/*
			int x= 1;
			if(x < 2) {
				throw new SQLException("Erro falso para teste");
			}
			*/
			
			int rows2= st.executeUpdate("UPDATE seller SET BaseSalary = 3090  WHERE DepartmentId = 2");
			//fazer atualiza�o
			
			conn.commit();
			/*serve para confirma a opera��o 
			 * do setAutoCommit
			 */
			
			System.out.println("Rows1 "+ rows1);
			System.out.println("Rows2 "+ rows2);
		}
		catch(SQLException e) {
			try {
				conn.rollback();
				//para volta ao estado incial da programa��o para o catch seja asionado
				throw new DbException("Trasa��o n�o concluida! motivo: "+ e.getMessage());
			} catch (SQLException e1) {
				throw new DbException("Erro no rollback tamb�! Motivo: "+e1.getMessage());
			}
		}
		finally {
			DB.closeConnection();
			DB.closeStatement(st);
		}
		
	}

}
