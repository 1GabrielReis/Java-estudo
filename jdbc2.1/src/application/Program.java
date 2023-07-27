package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;

public class Program {

	public static void main(String[] args) {
		
		Connection conn= null;
		Statement st=  null; 
		ResultSet rs=null;
		
		try {
			
			conn= DB.getConnection();// conectar ao banco de dados 
			
			st= conn.createStatement();// posiblitar comando dentro banco de daddos 
			
			rs= st.executeQuery("select * from department");
			/*comando do banco de dados esta dentro da aspa ""
			 * o retorno do comando sera armaeado dentro de rs
			 *"selec * from department" : seleciona a tabela department 
			 */
			
			while(rs.next()) { 
				
				System.out.println(rs.getInt("Id")+", "+ rs.getString("Name"));
				
				
				/* while: percorra (next) a tabela iguanto ela for verdadeira 
				 * System.out.println: monstra informação do campos...
				 * rs.getInt("Id"): pega a informação do campo Id, sendo id do tipo int
				 * rs.getString("Name"): pega a informação do campo Name, sendo Name do tipo String 
				 */
				
			}
		}
			catch( SQLException e) {
				e.printStackTrace();
			}
		finally {
			DB.closeResultSet(rs); //desconetar do cResultSet
			DB.closeStatement(st); //desconetar de Statement 
			DB.closeConnection(); // desconetar do banco de dados 
		}
		
	}

}
