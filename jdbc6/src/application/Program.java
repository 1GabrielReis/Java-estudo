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
			/*serve para não confimar operaçoes automaticamente
			 * toda a programação vai ficar pendente para a confirmação do programador 
			 */
			
			st= conn.createStatement();
			
			int rows1= st.executeUpdate("UPDATE seller SET BaseSalary = 2090  WHERE DepartmentId = 1");
			//fazer atualizaão
			
			
			//condição de erro para teste 
			/*
			int x= 1;
			if(x < 2) {
				throw new SQLException("Erro falso para teste");
			}
			*/
			
			int rows2= st.executeUpdate("UPDATE seller SET BaseSalary = 3090  WHERE DepartmentId = 2");
			//fazer atualizaão
			
			conn.commit();
			/*serve para confirma a operação 
			 * do setAutoCommit
			 */
			
			System.out.println("Rows1 "+ rows1);
			System.out.println("Rows2 "+ rows2);
		}
		catch(SQLException e) {
			try {
				conn.rollback();
				//para volta ao estado incial da programação para o catch seja asionado
				throw new DbException("Trasação não concluida! motivo: "+ e.getMessage());
			} catch (SQLException e1) {
				throw new DbException("Erro no rollback també! Motivo: "+e1.getMessage());
			}
		}
		finally {
			DB.closeConnection();
			DB.closeStatement(st);
		}
		
	}

}
